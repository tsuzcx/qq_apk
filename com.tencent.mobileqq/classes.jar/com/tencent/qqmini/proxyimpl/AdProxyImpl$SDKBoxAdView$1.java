package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.qroute.QRoute;
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
    if ((paramBoolean) && (paramJSONObject != null)) {}
    label326:
    label327:
    for (;;)
    {
      try
      {
        int i = paramJSONObject.getInt("retCode");
        String str = paramJSONObject.getString("errMsg");
        paramJSONObject = paramJSONObject.getString("response");
        if ((i == 0) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          if (new JSONObject(paramJSONObject).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) != 0)
          {
            if (this.b.b == null) {
              break label326;
            }
            this.b.b.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
            return;
          }
          this.b.c = ((IGdtAPI)QRoute.api(IGdtAPI.class)).buildAdBox(this.a, paramJSONObject, "biz_src_miniapp", new AdProxyImpl.SDKBoxAdView.1.1(this));
          if (this.b.c != null)
          {
            if (this.b.b != null) {
              this.b.b.onLoad();
            }
            AdProxyImpl.a(this.b.o, paramJSONObject, this.b.h);
            return;
          }
          if (this.b.b != null) {
            this.b.b.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          }
        }
        else
        {
          int j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j == -1) {
            break label327;
          }
          i = j;
          if (this.b.b != null)
          {
            this.b.b.onError(i, str);
            return;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
        if (this.b.b != null) {
          this.b.b.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
      }
      return;
      if (this.b.b != null) {
        this.b.b.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
      return;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBoxAdView.1
 * JD-Core Version:    0.7.0.1
 */