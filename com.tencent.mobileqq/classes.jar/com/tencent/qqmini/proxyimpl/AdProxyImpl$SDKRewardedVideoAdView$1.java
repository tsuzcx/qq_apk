package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import org.json.JSONException;
import org.json.JSONObject;

class AdProxyImpl$SDKRewardedVideoAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKRewardedVideoAdView$1(AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int j = 1;
    QLog.i("AdProxyImpl", 1, "onCmdListener: " + paramJSONObject);
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
        this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
    }
    for (;;)
    {
      return;
      int i;
      String str;
      try
      {
        i = paramJSONObject.getInt("retCode");
        str = paramJSONObject.getString("errMsg");
        paramJSONObject = paramJSONObject.getString("response");
        if ((i != 0) || (TextUtils.isEmpty(paramJSONObject))) {
          break label431;
        }
        if (new JSONObject(paramJSONObject).optInt("ret", -1) != 102006) {
          break label184;
        }
        QLog.e("AdProxyImpl", 1, "mockAdJson failed ret == 102006");
        if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener == null) {
          continue;
        }
        this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null)
      {
        this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        return;
        label184:
        str = AdProxyImpl.a(this.a.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, paramJSONObject);
        paramJSONObject = null;
        if (!TextUtils.isEmpty(str)) {
          paramJSONObject = AdProxyImpl.a(this.a.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, str);
        }
        if (paramJSONObject != null)
        {
          paramJSONObject = new GdtAd(paramJSONObject);
          if (paramJSONObject.isValid())
          {
            GdtPreLoader.a().a(paramJSONObject);
            AdProxyImpl.SDKRewardedVideoAdView localSDKRewardedVideoAdView = this.a;
            i = j;
            if (this.a.c == 90) {
              i = 0;
            }
            localSDKRewardedVideoAdView.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData = RewardedVideoAdPlugin.a(paramJSONObject, str, i);
            if (this.a.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData != null)
            {
              i = AdUtils.getRewardVideoShowTimeFromExp(paramJSONObject);
              if (i > 0) {
                this.a.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.setVideoCountDown(i);
              }
              if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
                this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onADLoad();
              }
              AdProxyImpl.a(this.a.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, str, this.a.b);
              paramJSONObject = paramJSONObject.getUrlForClick();
              MiniAdAntiSpamReportUtil.a(this.a.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.adId + "", paramJSONObject);
              MiniAdAntiSpamReportUtil.a(this.a.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.adId + "");
            }
          }
        }
        else
        {
          QLog.e("AdProxyImpl", 1, "adInfo is null");
          return;
          label431:
          j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j != -1) {
            i = j;
          }
          while (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null)
          {
            this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(i, str);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKRewardedVideoAdView.1
 * JD-Core Version:    0.7.0.1
 */