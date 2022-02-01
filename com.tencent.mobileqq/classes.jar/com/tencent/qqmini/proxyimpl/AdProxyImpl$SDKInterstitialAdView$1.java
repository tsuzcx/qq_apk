package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
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
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener != null) {
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          i = paramJSONObject.getInt("retCode");
          localObject1 = paramJSONObject.getString("errMsg");
          paramJSONObject = paramJSONObject.getString("response");
          if ((i != 0) || (TextUtils.isEmpty(paramJSONObject))) {
            break label385;
          }
          localObject1 = new JSONObject(paramJSONObject).optJSONArray("pos_ads_info").getJSONObject(0);
          if (((JSONObject)localObject1).optInt("ret", -1) == 0) {
            break label168;
          }
          if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener != null)
          {
            this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
            return;
          }
        }
        catch (JSONException paramJSONObject)
        {
          QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
        }
      }
    } while (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener == null);
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
    return;
    label168:
    Object localObject2 = ((JSONObject)localObject1).getJSONArray("ads_info").getJSONObject(0);
    Object localObject1 = new GdtInterstitialParams();
    localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject2));
    paramBoolean = AdUtils.isHitInterstitialAdNewStyle(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject2));
    label242:
    int j;
    if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.c == 90)
    {
      i = 1;
      break label429;
      ((GdtInterstitialParams)localObject1).b = j;
      ((GdtInterstitialParams)localObject1).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options = AdProxyImpl.SDKInterstitialAdView.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView, (qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
      if ((!paramBoolean) || (i != 0)) {
        break label450;
      }
    }
    label385:
    label429:
    label444:
    label450:
    for (int i = 1;; i = 0)
    {
      ((GdtInterstitialParams)localObject1).jdField_a_of_type_Int = i;
      ((GdtInterstitialParams)localObject1).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialAd = new GdtInterstitialAd(this.jdField_a_of_type_AndroidAppActivity, (GdtInterstitialParams)localObject1);
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialAd != null)
      {
        if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener != null) {
          this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener.onLoad();
        }
        AdProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, paramJSONObject, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.b);
        return;
      }
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      return;
      j = PluginConst.AdConst.getRetCodeByServerResult(i);
      if (j != -1) {
        i = j;
      }
      while (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener != null)
      {
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKInterstitialAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener.onError(i, (String)localObject1);
        return;
      }
      break;
      for (;;)
      {
        if (i == 0) {
          break label444;
        }
        j = 0;
        break;
        i = 0;
      }
      j = 1;
      break label242;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKInterstitialAdView.1
 * JD-Core Version:    0.7.0.1
 */