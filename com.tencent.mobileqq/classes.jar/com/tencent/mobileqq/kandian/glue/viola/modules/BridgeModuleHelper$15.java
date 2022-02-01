package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

final class BridgeModuleHelper$15
  implements GdtAdListener
{
  BridgeModuleHelper$15(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(GdtAd paramGdtAd)
  {
    Object localObject = ((IRIJAdService)QRoute.api(IRIJAdService.class)).getMotiveAdInfo(paramGdtAd);
    paramGdtAd = new JSONObject();
    try
    {
      paramGdtAd.put("adInfo", localObject);
      if (localObject == null) {
        paramGdtAd.put("retCode", -1);
      } else {
        paramGdtAd.put("retCode", 0);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramGdtAd);
  }
  
  public void a(GdtAd paramGdtAd, GdtAdError paramGdtAdError)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, paramGdtAdError.a());
  }
  
  public void b(GdtAd paramGdtAd) {}
  
  public void c(GdtAd paramGdtAd) {}
  
  public void d(GdtAd paramGdtAd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.15
 * JD-Core Version:    0.7.0.1
 */