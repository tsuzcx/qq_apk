package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class AdProxyImpl$SDKRewardedVideoAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKRewardedVideoAdView$1(AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onCmdListener: ");
    ((StringBuilder)localObject1).append(paramJSONObject);
    localObject1 = ((StringBuilder)localObject1).toString();
    int j = 1;
    QLog.i("AdProxyImpl", 1, (String)localObject1);
    if ((paramBoolean) && (paramJSONObject != null)) {}
    try
    {
      int i = paramJSONObject.getInt("retCode");
      localObject1 = paramJSONObject.getString("errMsg");
      paramJSONObject = paramJSONObject.getString("response");
      if ((i == 0) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        if (new JSONObject(paramJSONObject).optInt("ret", -1) == 102006)
        {
          QLog.e("AdProxyImpl", 1, "mockAdJson failed ret == 102006");
          if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener == null) {
            return;
          }
          this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
          return;
        }
        localObject1 = AdProxyImpl.a(this.a.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, paramJSONObject);
        paramJSONObject = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramJSONObject = AdProxyImpl.a(this.a.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, (String)localObject1);
        }
        if (paramJSONObject != null)
        {
          paramJSONObject = new GdtAd(paramJSONObject);
          if (!paramJSONObject.isValid()) {
            break label482;
          }
          GdtPreLoader.a().a(paramJSONObject);
          Object localObject2 = this.a;
          i = j;
          if (this.a.c == 90) {
            i = 0;
          }
          ((AdProxyImpl.SDKRewardedVideoAdView)localObject2).jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData = RewardedVideoAdPlugin.a(paramJSONObject, (String)localObject1, i);
          if (this.a.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData == null) {
            break label482;
          }
          i = AdUtils.getRewardVideoShowTimeFromExp(paramJSONObject);
          if (i > 0) {
            this.a.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData.setVideoCountDown(i);
          }
          if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null)
          {
            localObject2 = AdUtils.getExpParam(paramJSONObject);
            this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onADLoad((List)localObject2);
          }
          AdProxyImpl.a(this.a.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, (String)localObject1, this.a.b);
          paramJSONObject = paramJSONObject.getUrlForClick();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData.adId);
          ((StringBuilder)localObject1).append("");
          MiniAdAntiSpamReportUtil.a(((StringBuilder)localObject1).toString(), paramJSONObject);
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(this.a.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData.adId);
          paramJSONObject.append("");
          MiniAdAntiSpamReportUtil.a(paramJSONObject.toString());
          return;
        }
        QLog.e("AdProxyImpl", 1, "adInfo is null");
        return;
      }
      j = PluginConst.AdConst.getRetCodeByServerResult(i);
      if (j != -1) {
        i = j;
      }
      if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener == null) {
        break label482;
      }
      this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(i, (String)localObject1);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label454:
      break label454;
    }
    if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
      this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
    }
    label482:
    return;
    if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
      this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKRewardedVideoAdView.1
 * JD-Core Version:    0.7.0.1
 */