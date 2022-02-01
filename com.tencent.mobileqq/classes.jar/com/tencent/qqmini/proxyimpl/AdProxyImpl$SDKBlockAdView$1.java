package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class AdProxyImpl$SDKBlockAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKBlockAdView$1(AdProxyImpl.SDKBlockAdView paramSDKBlockAdView, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {}
    label538:
    label544:
    label545:
    label546:
    for (;;)
    {
      String str1;
      try
      {
        int i = paramJSONObject.getInt("retCode");
        String str2 = paramJSONObject.getString("errMsg");
        str1 = paramJSONObject.getString("response");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBlockADInfo receive retCode= ");
        localStringBuilder.append(i);
        localStringBuilder.append(" adJson=");
        if ((str1 == null) || (str1.length() <= 1024)) {
          break label538;
        }
        paramJSONObject = str1.substring(0, 1024);
        localStringBuilder.append(paramJSONObject);
        QLog.i("AdProxyImpl", 1, localStringBuilder.toString());
        int j;
        if (i == 0)
        {
          paramBoolean = TextUtils.isEmpty(str1);
          if (!paramBoolean)
          {
            try
            {
              if (new JSONObject(str1).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) != 0)
              {
                if (this.b.b != null) {
                  this.b.b.onNoAD(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
                }
                return;
              }
              paramJSONObject = AdUtils.convertJson2GdtAds(str1);
              this.b.d.setAdMiniAppInfo(paramJSONObject);
              this.b.o = BlockAdManager.getInstance().getReportUrlList(paramJSONObject);
              this.b.c = BlockAdManager.getInstance().genarateBlockAdView(this.a, this.b.d);
              i = this.b.c.getRealAdNum();
              j = this.b.d.getRealWidth();
              int k = this.b.d.getRealHeight();
              if (i < 1)
              {
                if (this.b.b == null) {
                  break label544;
                }
                this.b.b.onNoAD(1009, PluginConst.AdConst.ERROR_MSG_INVALID_POSITION);
                return;
              }
              if (paramJSONObject != null)
              {
                if (this.b.b != null) {
                  this.b.b.onADReceive(i, j, k);
                }
                AdProxyImpl.a(this.b.p, str1, this.b.h);
                return;
              }
              if (this.b.b == null) {
                break label508;
              }
              this.b.b.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
              return;
            }
            catch (Throwable paramJSONObject)
            {
              QLog.e("AdProxyImpl", 1, "check adsJson exception:", paramJSONObject);
              if (this.b.b == null) {
                break label545;
              }
            }
            this.b.b.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
            return;
          }
        }
        if (this.b.b != null)
        {
          j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j == -1) {
            break label546;
          }
          i = j;
          this.b.b.onNoAD(i, str2);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
        if (this.b.b != null) {
          this.b.b.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
      }
      label508:
      return;
      if (this.b.b != null) {
        this.b.b.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
      return;
      paramJSONObject = str1;
      continue;
      return;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBlockAdView.1
 * JD-Core Version:    0.7.0.1
 */