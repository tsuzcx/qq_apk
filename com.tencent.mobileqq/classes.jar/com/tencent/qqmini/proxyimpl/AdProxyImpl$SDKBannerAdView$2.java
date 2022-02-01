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
    label423:
    for (;;)
    {
      try
      {
        int i = paramJSONObject.getInt("retCode");
        String str = paramJSONObject.getString("errMsg");
        paramJSONObject = paramJSONObject.getString("response");
        if ((i == 0) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          str = AdProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, paramJSONObject);
          paramJSONObject = null;
          if (!TextUtils.isEmpty(str)) {
            paramJSONObject = AdProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, str);
          }
          if (paramJSONObject != null)
          {
            GdtAd localGdtAd = new GdtAd(paramJSONObject);
            GdtPreLoader.a().a(localGdtAd);
            this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.i = paramJSONObject.report_info.exposure_url.get();
            this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_Long = paramJSONObject.report_info.trace_info.aid.get();
          }
          else
          {
            QLog.e("AdProxyImpl", 1, "adInfo is null");
          }
          this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView = AdProxyImpl.SDKBannerAdView.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView, this.jdField_a_of_type_AndroidAppActivity, paramJSONObject, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.d, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.e, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext);
          this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramJSONObject;
          if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView != null)
          {
            if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null)
            {
              this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onADReceive();
              AdProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext, paramJSONObject, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_b_of_type_JavaLangString);
            }
            AdProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, str, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_b_of_type_Int);
            return;
          }
          if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null) {
            this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          }
        }
        else if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null)
        {
          int j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j == -1) {
            break label423;
          }
          i = j;
          this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onNoAD(i, str);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
        if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null) {
          this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
      }
      return;
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null) {
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.2
 * JD-Core Version:    0.7.0.1
 */