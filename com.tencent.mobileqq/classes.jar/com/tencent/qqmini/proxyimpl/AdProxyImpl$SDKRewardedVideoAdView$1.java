package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IRewardVideoAdListener;
import org.json.JSONException;
import org.json.JSONObject;
import yju;

class AdProxyImpl$SDKRewardedVideoAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKRewardedVideoAdView$1(AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int j = 1;
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.this$1.mRewardedListener != null) {
        this.this$1.mRewardedListener.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
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
          break label318;
        }
        if (new JSONObject(paramJSONObject).optInt("ret", -1) != 102006) {
          break label159;
        }
        QLog.e("AdProxyImpl", 1, "mockAdJson failed ret == 102006");
        if (this.this$1.mRewardedListener == null) {
          continue;
        }
        this.this$1.mRewardedListener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (this.this$1.mRewardedListener != null)
      {
        this.this$1.mRewardedListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        return;
        label159:
        str = AdProxyImpl.access$000(this.this$1.this$0, paramJSONObject);
        paramJSONObject = null;
        if (!TextUtils.isEmpty(str)) {
          paramJSONObject = AdProxyImpl.access$100(this.this$1.this$0, str);
        }
        if (paramJSONObject != null)
        {
          paramJSONObject = new GdtAd(paramJSONObject);
          if (paramJSONObject.isValid())
          {
            yju.a().a(paramJSONObject);
            AdProxyImpl.SDKRewardedVideoAdView localSDKRewardedVideoAdView = this.this$1;
            i = j;
            if (this.this$1.mDeviceOrientation == 90) {
              i = 0;
            }
            localSDKRewardedVideoAdView.mGdtMotiveVideoPageData = RewardedVideoAdPlugin.mockMVPageData(paramJSONObject, str, i);
            if (this.this$1.mGdtMotiveVideoPageData != null)
            {
              if (this.this$1.mRewardedListener != null) {
                this.this$1.mRewardedListener.onADLoad();
              }
              AdProxyImpl.access$200(this.this$1.this$0, str, this.this$1.mAdType);
            }
          }
        }
        else
        {
          QLog.e("AdProxyImpl", 1, "adInfo is null");
          return;
          label318:
          j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j != -1) {
            i = j;
          }
          while (this.this$1.mRewardedListener != null)
          {
            this.this$1.mRewardedListener.onError(i, str);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKRewardedVideoAdView.1
 * JD-Core Version:    0.7.0.1
 */