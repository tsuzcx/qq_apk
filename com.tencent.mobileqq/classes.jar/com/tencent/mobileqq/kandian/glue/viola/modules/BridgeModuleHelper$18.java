package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

final class BridgeModuleHelper$18
  implements GdtAdListener
{
  BridgeModuleHelper$18(BridgeModule paramBridgeModule, String paramString) {}
  
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
    this.a.invokeCallJS(this.b, paramGdtAd);
  }
  
  public void a(GdtAd paramGdtAd, GdtAdError paramGdtAdError)
  {
    this.a.invokeErrorCallJS(this.b, paramGdtAdError.b());
  }
  
  public void b(GdtAd paramGdtAd) {}
  
  public void c(GdtAd paramGdtAd) {}
  
  public void d(GdtAd paramGdtAd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.18
 * JD-Core Version:    0.7.0.1
 */