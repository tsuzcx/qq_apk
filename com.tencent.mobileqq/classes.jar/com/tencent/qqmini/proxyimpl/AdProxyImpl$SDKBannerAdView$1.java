package com.tencent.qqmini.proxyimpl;

import aana;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.ICmdListener;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

class AdProxyImpl$SDKBannerAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKBannerAdView$1(AdProxyImpl.SDKBannerAdView paramSDKBannerAdView, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.this$1.mBannerListener != null) {
        this.this$1.mBannerListener.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
    }
    label284:
    label295:
    label324:
    do
    {
      do
      {
        return;
        for (;;)
        {
          try
          {
            int i = paramJSONObject.getInt("retCode");
            paramJSONObject = paramJSONObject.getString("response");
            if ((i != 0) || (TextUtils.isEmpty(paramJSONObject))) {
              break label324;
            }
            String str = AdProxyImpl.access$000(this.this$1.this$0, paramJSONObject);
            paramJSONObject = null;
            if (!TextUtils.isEmpty(str)) {
              paramJSONObject = AdProxyImpl.access$100(this.this$1.this$0, str);
            }
            if (paramJSONObject == null) {
              break label284;
            }
            GdtAd localGdtAd = new GdtAd(paramJSONObject);
            aana.a().a(localGdtAd);
            this.this$1.mReportUrl = paramJSONObject.report_info.exposure_url.get();
            this.this$1.mAdId = paramJSONObject.report_info.trace_info.aid.get();
            this.this$1.mGdtBannerView = AdProxyImpl.access$300(this.this$1.this$0, this.val$activity, paramJSONObject, this.this$1.mWidth, this.this$1.mHeight);
            if (this.this$1.mGdtBannerView == null) {
              break label295;
            }
            if (this.this$1.mBannerListener != null) {
              this.this$1.mBannerListener.onADReceive();
            }
            AdProxyImpl.access$200(this.this$1.this$0, str, this.this$1.mAdType);
            return;
          }
          catch (JSONException paramJSONObject)
          {
            QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
          }
          if (this.this$1.mBannerListener == null) {
            break;
          }
          this.this$1.mBannerListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          return;
          QLog.e("AdProxyImpl", 1, "adInfo is null");
        }
      } while (this.this$1.mBannerListener == null);
      this.this$1.mBannerListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      return;
    } while (this.this$1.mBannerListener == null);
    this.this$1.mBannerListener.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.1
 * JD-Core Version:    0.7.0.1
 */