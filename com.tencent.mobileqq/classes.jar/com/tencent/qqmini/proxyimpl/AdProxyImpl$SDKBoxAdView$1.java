package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.api.adbox.GdtAdBox;
import com.tencent.gdtad.api.adbox.GdtAdBoxBuilder;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class AdProxyImpl$SDKBoxAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKBoxAdView$1(AdProxyImpl.SDKBoxAdView paramSDKBoxAdView, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener != null) {
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
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
          break label283;
        }
        if (new JSONObject(paramJSONObject).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) == 0) {
          break label164;
        }
        if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
      }
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener != null)
      {
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        return;
        label164:
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBox = GdtAdBox.a(this.jdField_a_of_type_AndroidAppActivity).a(new GdtAdBoxData(paramJSONObject)).a(new AdProxyImpl.SDKBoxAdView.1.1(this)).a();
        if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBox != null)
        {
          if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener != null) {
            this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener.onLoad();
          }
          AdProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, paramJSONObject, this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.b);
          return;
        }
        if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener != null)
        {
          this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          return;
          label283:
          int j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j != -1) {
            i = j;
          }
          while (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener != null)
          {
            this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBoxAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener.onError(i, str);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBoxAdView.1
 * JD-Core Version:    0.7.0.1
 */