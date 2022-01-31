package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IBoxADLisener;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.ICmdListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ytb;
import ytc;

class AdProxyImpl$SDKBoxAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKBoxAdView$1(AdProxyImpl.SDKBoxAdView paramSDKBoxAdView, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.this$1.mBoxListener != null) {
        this.this$1.mBoxListener.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
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
        if (this.this$1.mBoxListener == null) {
          continue;
        }
        this.this$1.mBoxListener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
      }
      if (this.this$1.mBoxListener != null)
      {
        this.this$1.mBoxListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        return;
        label164:
        this.this$1.mGdtBoxView = ytb.a(this.val$activity).a(new GdtAdBoxData(paramJSONObject)).a(new AdProxyImpl.SDKBoxAdView.1.1(this)).a();
        if (this.this$1.mGdtBoxView != null)
        {
          if (this.this$1.mBoxListener != null) {
            this.this$1.mBoxListener.onLoad();
          }
          AdProxyImpl.access$200(this.this$1.this$0, paramJSONObject, this.this$1.mAdType);
          return;
        }
        if (this.this$1.mBoxListener != null)
        {
          this.this$1.mBoxListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          return;
          label283:
          int j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j != -1) {
            i = j;
          }
          while (this.this$1.mBoxListener != null)
          {
            this.this$1.mBoxListener.onError(i, str);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBoxAdView.1
 * JD-Core Version:    0.7.0.1
 */