package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class AdProxyImpl$SDKInterstitialAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKInterstitialAdView$1(AdProxyImpl.SDKInterstitialAdView paramSDKInterstitialAdView, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {}
    label415:
    label416:
    label418:
    label433:
    for (;;)
    {
      int j;
      try
      {
        i = paramJSONObject.getInt("retCode");
        Object localObject1 = paramJSONObject.getString("errMsg");
        paramJSONObject = paramJSONObject.getString("response");
        if ((i == 0) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          localObject1 = new JSONObject(paramJSONObject).optJSONArray("pos_ads_info");
          j = 0;
          localObject1 = ((JSONArray)localObject1).getJSONObject(0);
          if (((JSONObject)localObject1).optInt("ret", -1) != 0)
          {
            if (this.b.b == null) {
              break label415;
            }
            this.b.b.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
            return;
          }
          Object localObject2 = ((JSONObject)localObject1).getJSONArray("ads_info").getJSONObject(0);
          localObject1 = new GdtInterstitialParams();
          localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject2));
          if (this.b.i != 90) {
            break label416;
          }
          i = 1;
          break label418;
          ((GdtInterstitialParams)localObject1).e = i;
          ((GdtInterstitialParams)localObject1).d = AdProxyImpl.SDKInterstitialAdView.a(this.b, (qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
          ((GdtInterstitialParams)localObject1).f = true;
          this.b.c = ((IGdtInterstitialAPI)QRoute.api(IGdtInterstitialAPI.class)).build(this.a, (GdtInterstitialParams)localObject1);
          if (this.b.c != null)
          {
            if (this.b.b != null) {
              this.b.b.onLoad();
            }
            AdProxyImpl.a(this.b.q, paramJSONObject, this.b.h);
            return;
          }
          if (this.b.b != null) {
            this.b.b.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          }
        }
        else
        {
          j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j == -1) {
            break label433;
          }
          i = j;
          if (this.b.b != null)
          {
            this.b.b.onError(i, (String)localObject1);
            return;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
        if (this.b.b != null) {
          this.b.b.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
      }
      return;
      if (this.b.b != null) {
        this.b.b.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
      return;
      return;
      int i = 0;
      if (i != 0) {
        i = j;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKInterstitialAdView.1
 * JD-Core Version:    0.7.0.1
 */