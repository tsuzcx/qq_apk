import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.gdtad.api.GdtAd;
import org.json.JSONObject;

public class spg
  implements aane
{
  public spg(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(GdtAd paramGdtAd)
  {
    Object localObject = oeg.a(paramGdtAd);
    paramGdtAd = new JSONObject();
    for (;;)
    {
      try
      {
        paramGdtAd.put("adInfo", localObject);
        if (localObject != null) {
          continue;
        }
        paramGdtAd.put("retCode", -1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramGdtAd);
      return;
      paramGdtAd.put("retCode", 0);
    }
  }
  
  public void a(GdtAd paramGdtAd, aand paramaand)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, paramaand.a());
  }
  
  public void b(GdtAd paramGdtAd) {}
  
  public void c(GdtAd paramGdtAd) {}
  
  public void d(GdtAd paramGdtAd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     spg
 * JD-Core Version:    0.7.0.1
 */