package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import ackk;
import android.util.Log;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class AdJsPlugin$2
  implements MiniAppCmdInterface
{
  AdJsPlugin$2(AdJsPlugin paramAdJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int j = 0;
    if (paramBoolean)
    {
      MiniAppAd.StGetAdRsp localStGetAdRsp = (MiniAppAd.StGetAdRsp)paramJSONObject.opt("response");
      int k = paramJSONObject.optInt("retCode");
      String str1 = paramJSONObject.optString("errMsg");
      String str2 = localStGetAdRsp.strAdsJson.get();
      String str3 = localStGetAdRsp.strAdTemplateJson.get();
      paramJSONObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      QLog.d("AdJsPlugin", 2, "sendAdRequest. retCode = " + k);
      int i;
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniappadusetranscoding", 0) == 0)
      {
        i = 1;
        if ((k == 0) || (i == 0)) {
          break label256;
        }
        i = PluginConst.AdConst.getRetCodeByServerResult(k);
      }
      for (;;)
      {
        try
        {
          localJSONObject.put("ret", i);
          paramJSONObject.put("data", localJSONObject.toString());
          if (i != -1)
          {
            this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, paramJSONObject, (String)PluginConst.AdConst.CodeMsgMap.get(Integer.valueOf(i)), this.val$callBackId);
            return;
            i = 0;
          }
        }
        catch (JSONException localJSONException1)
        {
          QLog.e("AdJsPlugin", 2, "JSONException: " + Log.getStackTraceString(localJSONException1));
          continue;
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, paramJSONObject, str1, this.val$callBackId);
          return;
        }
        try
        {
          label256:
          localJSONObject.put("data", str2);
          localJSONObject.put("ret", k);
          localJSONObject.put("adClass", str3);
          paramJSONObject.put("data", localJSONObject.toString());
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, paramJSONObject, this.val$callBackId);
          AdJsPlugin.access$000(this.this$0, str2, this.val$adType);
          paramJSONObject = new GdtAd(AdJsPlugin.access$100(this.this$0, str2));
          ackk.a().a(paramJSONObject);
          if (localJSONException1 == null) {}
        }
        catch (JSONException localJSONException2)
        {
          try
          {
            if ((localJSONException1.vecAppInfo != null) && (localJSONException1.vecAppInfo.size() > 0) && (localJSONException1.iPreLoadLevel.get() == 2L))
            {
              i = j;
              while (i < localJSONException1.vecAppInfo.size())
              {
                GpkgManager.preloadGpkgByConfig(new MiniAppConfig(MiniAppInfo.from((INTERFACE.StApiAppInfo)localJSONException1.vecAppInfo.get(i))));
                i += 1;
              }
              localJSONException2 = localJSONException2;
              QLog.e("AdJsPlugin", 2, "");
              localJSONException2.printStackTrace();
            }
          }
          catch (Throwable paramJSONObject)
          {
            QLog.e("AdJsPlugin", 1, "preloadGpkgByConfig failed:" + paramJSONObject.getMessage());
            return;
          }
        }
      }
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callBackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AdJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */