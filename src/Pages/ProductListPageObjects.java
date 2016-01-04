package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Test.TestCaseConfiguration;
import Tools.ExtentManager;
import Tools.Utilities;

public class ProductListPageObjects {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(xpath = "//div[@id='id_scfContent_searchpage']/div[1]/div[6]")
	WebElement plpSearchRsName;

	@FindBy(xpath = "//div[@class='llbFilterResTxt' and contains(text(), 'Filter Results')]")
	WebElement  plpFilterRst;

	@FindBy(xpath ="//div[@class='selectFacetName']")
	List<WebElement> filterCount;
	
	
//--------------------------------Size Filter-------------------------------//
	
	@FindBy(xpath = "//div/div[@name='Size Range']")
	WebElement  plpFLSizeRng;

	@FindBy(xpath = "//div/div[@name='Regular']/div[1]")
	WebElement  plpFLSizeRngReg;

	//--------------------------------Feature Filter-------------------------------//

	@FindBy(xpath = "//div/div[@name='Features']")
	WebElement  plpFLFeature;

	@FindBy(xpath = "//div/div[@name='Fade-Resistant']/div[1]")
	WebElement  plpFLFeatureAbrasionRstnt;

	//--------------------------------Fabric Filter-------------------------------//

	@FindBy(xpath = "//div/div[@name='Fabric']")
	WebElement  plpFLFabric;

	@FindBy(xpath = "//div/div[1][@name='Cotton']")
	WebElement  plpFabricCtnBlend;

	@FindBy(xpath = "//div[@class='facetCatWFiltersResetAllTxt' and contains(text(), 'Reset All')]")
	WebElement  plpResetAllFilter;
	
	//--------------------------------FilterResultsVerification-------------------------------//

	@FindBy(xpath = "//div[@name='Regular']")
	WebElement regular;
	
	@FindBy(xpath = "//div[@name='Fade-Resistant']")
	WebElement Fade;
	
	@FindBy(xpath = "//div[@name='Cotton']")
	WebElement Cotton;
	

	public ProductListPageObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public void PLPVerification() {

		
		Assert.assertTrue(plpSearchRsName.getText().contains("PO"));
		
	}
	
	
	public void SearchTermVerification()
	 {
		
		Assert.assertTrue(plpSearchRsName.getText().contains("sweat pants"));

		
		 
	 }
	
	public void ApplyFilters()
	{
		plpFilterRst.click();
		Utilities.explicitlyWait(3000);

		plpFLSizeRng.click();
		Utilities.explicitlyWait(3000);

		plpFLSizeRngReg.click();
		Utilities.explicitlyWait(3000);
		String text1 = regular.getText();
        Assert.assertTrue(text1.equals("Regular"));	
        System.out.println(filterCount.size());
        
        
		plpFilterRst.click();
		Utilities.explicitlyWait(3000);

		plpFLFeature.click();
		Utilities.explicitlyWait(3000);

		plpFLFeatureAbrasionRstnt.click();
		Utilities.explicitlyWait(3000);
		String text2 = Fade.getText();
        Assert.assertTrue(text2.equals("Fade-Resistant"));		
		Utilities.explicitlyWait(3000);
        System.out.println(filterCount.size());


        plpFilterRst.click();
		Utilities.explicitlyWait(3000);

        plpFLFabric.click();
		Utilities.explicitlyWait(3000);

        plpFabricCtnBlend.click();
		Utilities.explicitlyWait(3000);
		String text3 = Cotton.getText();
        Assert.assertTrue(text3.equals("Cotton"));
        System.out.println(filterCount.size());

		plpFilterRst.click();
		Utilities.explicitlyWait(5000);
		plpResetAllFilter.click();
		
		Utilities.explicitlyWait(3000);
		
		Assert.assertEquals(0, filterCount.size());

        System.out.println(filterCount.size());

		
		String text4= plpSearchRsName.getText();
        Assert.assertTrue(text4.contains("Shirts"));	
        
        
	
	}
}