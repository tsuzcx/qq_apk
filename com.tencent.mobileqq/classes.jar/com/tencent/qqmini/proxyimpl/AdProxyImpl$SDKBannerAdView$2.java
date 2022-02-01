package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

class AdProxyImpl$SDKBannerAdView$2
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKBannerAdView$2(AdProxyImpl.SDKBannerAdView paramSDKBannerAdView, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {}
    label444:
    label449:
    for (;;)
    {
      try
      {
        int i = paramJSONObject.getInt("retCode");
        Object localObject = paramJSONObject.getString("errMsg");
        paramJSONObject = paramJSONObject.getString("response");
        if ((i == 0) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          paramJSONObject = AdProxyImpl.a(this.b.z, paramJSONObject);
          localObject = null;
          if (paramJSONObject == null) {
            break label444;
          }
          paramJSONObject = paramJSONObject.get(0).toString();
          if (!TextUtils.isEmpty(paramJSONObject)) {
            localObject = AdProxyImpl.b(this.b.z, paramJSONObject);
          }
          if (localObject != null)
          {
            GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
            GdtPreLoader.a().a(localGdtAd);
            this.b.t = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.exposure_url.get();
            this.b.u = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.trace_info.aid.get();
          }
          else
          {
            QLog.e("AdProxyImpl", 1, "adInfo is null");
          }
          this.b.c = AdProxyImpl.SDKBannerAdView.a(this.b, this.a, (qq_ad_get.QQAdGetRsp.AdInfo)localObject, this.b.i, this.b.r, this.b.s, this.b.v);
          this.b.f = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
          if (this.b.c != null)
          {
            if (this.b.b != null)
            {
              this.b.b.onADReceive();
              AdProxyImpl.a(this.b.z, this.b.v, (qq_ad_get.QQAdGetRsp.AdInfo)localObject, this.b.i);
            }
            AdProxyImpl.a(this.b.z, paramJSONObject, this.b.k);
            return;
          }
          if (this.b.b != null) {
            this.b.b.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          }
        }
        else if (this.b.b != null)
        {
          int j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j == -1) {
            break label449;
          }
          i = j;
          this.b.b.onNoAD(i, (String)localObject);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
        if (this.b.b != null) {
          this.b.b.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
      }
      return;
      if (this.b.b != null) {
        this.b.b.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
      return;
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.2
 * JD-Core Version:    0.7.0.1
 */