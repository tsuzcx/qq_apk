package com.tencent.qqmini.proxyimpl;

import aaon;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.InterstitialADLisener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class AdProxyImpl$SDKInterstitialAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKInterstitialAdView$1(AdProxyImpl.SDKInterstitialAdView paramSDKInterstitialAdView, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int j = 0;
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.this$1.mInterstitialAdListener != null) {
        this.this$1.mInterstitialAdListener.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
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
          localObject = paramJSONObject.getString("errMsg");
          paramJSONObject = paramJSONObject.getString("response");
          if ((i != 0) || (TextUtils.isEmpty(paramJSONObject))) {
            break label334;
          }
          localObject = new JSONObject(paramJSONObject).optJSONArray("pos_ads_info").getJSONObject(0);
          if (((JSONObject)localObject).optInt("ret", -1) == 0) {
            break label171;
          }
          if (this.this$1.mInterstitialAdListener != null)
          {
            this.this$1.mInterstitialAdListener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
            return;
          }
        }
        catch (JSONException paramJSONObject)
        {
          QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
        }
      }
    } while (this.this$1.mInterstitialAdListener == null);
    this.this$1.mInterstitialAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
    return;
    label171:
    Object localObject = ((JSONObject)localObject).getJSONArray("ads_info").getJSONObject(0);
    GdtInterstitialParams localGdtInterstitialParams = new GdtInterstitialParams();
    localGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options = AdProxyImpl.SDKInterstitialAdView.access$400(this.this$1, (JSONObject)localObject);
    if (this.this$1.mDeviceOrientation == 90) {}
    for (int i = j;; i = 1)
    {
      localGdtInterstitialParams.jdField_a_of_type_Int = i;
      localGdtInterstitialParams.jdField_a_of_type_Boolean = true;
      this.this$1.mInterstitialAdView = new aaon(this.val$activity, localGdtInterstitialParams);
      if (this.this$1.mInterstitialAdView != null)
      {
        if (this.this$1.mInterstitialAdListener != null) {
          this.this$1.mInterstitialAdListener.onLoad();
        }
        AdProxyImpl.access$200(this.this$1.this$0, paramJSONObject, this.this$1.mAdType);
        return;
      }
      if (this.this$1.mInterstitialAdListener == null) {
        break;
      }
      this.this$1.mInterstitialAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      return;
      label334:
      j = PluginConst.AdConst.getRetCodeByServerResult(i);
      if (j != -1) {
        i = j;
      }
      while (this.this$1.mInterstitialAdListener != null)
      {
        this.this$1.mInterstitialAdListener.onError(i, (String)localObject);
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKInterstitialAdView.1
 * JD-Core Version:    0.7.0.1
 */