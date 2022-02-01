package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class AdProxyImpl$SDKRewardedVideoAdView$1
  implements AdProxy.ICmdListener
{
  AdProxyImpl$SDKRewardedVideoAdView$1(AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onCmdListener: ");
    ((StringBuilder)localObject1).append(paramJSONObject);
    QLog.i("AdProxyImpl", 1, ((StringBuilder)localObject1).toString());
    if ((paramBoolean) && (paramJSONObject != null)) {}
    for (;;)
    {
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
            if (this.a.b == null) {
              break label536;
            }
            this.a.b.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
            return;
          }
          JSONArray localJSONArray = AdProxyImpl.a(this.a.r, paramJSONObject);
          Object localObject2 = null;
          if ((localJSONArray == null) || (localJSONArray.isNull(0))) {
            break label537;
          }
          paramJSONObject = localJSONArray.get(0).toString();
          this.a.c = AdProxyImpl.SDKRewardedVideoAdView.a(this.a, paramJSONObject);
          if (TextUtils.isEmpty(paramJSONObject)) {
            break label542;
          }
          localObject1 = AdProxyImpl.b(this.a.r, paramJSONObject);
          if ((this.a.c != null) && (localObject1 != null))
          {
            localObject1 = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
            if (this.a.b != null)
            {
              List localList = AdUtils.getExpParam((GdtAd)localObject1);
              this.a.b.onADLoad(localList);
            }
            AdProxyImpl.a(this.a.r, paramJSONObject, this.a.j);
            paramJSONObject = ((GdtAd)localObject1).getUrlForClick();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.a.c.adId);
            ((StringBuilder)localObject1).append("");
            MiniAdAntiSpamReportUtil.a(((StringBuilder)localObject1).toString(), paramJSONObject);
            paramJSONObject = new StringBuilder();
            paramJSONObject.append(this.a.c.adId);
            paramJSONObject.append("");
            MiniAdAntiSpamReportUtil.a(paramJSONObject.toString());
          }
          else
          {
            QLog.e("AdProxyImpl", 1, "first adInfo is null");
          }
          paramJSONObject = localObject2;
          if (localJSONArray != null)
          {
            paramJSONObject = localObject2;
            if (!localJSONArray.isNull(1)) {
              paramJSONObject = localJSONArray.get(1).toString();
            }
          }
          this.a.d = AdProxyImpl.SDKRewardedVideoAdView.a(this.a, paramJSONObject);
          return;
        }
        int j = PluginConst.AdConst.getRetCodeByServerResult(i);
        if (j != -1) {
          i = j;
        }
        if (this.a.b == null) {
          continue;
        }
        this.a.b.onError(i, (String)localObject1);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        continue;
      }
      if (this.a.b != null) {
        this.a.b.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
      if (this.a.b != null) {
        this.a.b.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
      return;
      label536:
      return;
      label537:
      paramJSONObject = null;
      continue;
      label542:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKRewardedVideoAdView.1
 * JD-Core Version:    0.7.0.1
 */