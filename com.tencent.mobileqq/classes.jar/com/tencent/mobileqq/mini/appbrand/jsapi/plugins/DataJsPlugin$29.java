package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import acoo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$29
  implements MiniAppCmdInterface
{
  DataJsPlugin$29(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      MiniAppAd.StGetAdRsp localStGetAdRsp = (MiniAppAd.StGetAdRsp)paramJSONObject.opt("response");
      long l = paramJSONObject.optLong("retCode");
      paramJSONObject = localStGetAdRsp.strAdsJson.get();
      String str = localStGetAdRsp.strAdTemplateJson.get();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("data", paramJSONObject);
        localJSONObject2.put("ret", l);
        localJSONObject2.put("adClass", str);
        localJSONObject1.put("data", localJSONObject2.toString());
        QLog.d("[mini] DataJsPlugin", 2, "sendAdRequest. retCode = " + l);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, localJSONObject1, this.val$callBackId);
        DataJsPlugin.access$600(this.this$0, paramJSONObject, this.val$adType);
        paramJSONObject = new GdtAd(DataJsPlugin.access$700(this.this$0, paramJSONObject));
        acoo.a().a(paramJSONObject);
        if (localStGetAdRsp == null) {}
      }
      catch (JSONException localJSONException)
      {
        try
        {
          if ((localStGetAdRsp.vecAppInfo != null) && (localStGetAdRsp.vecAppInfo.size() > 0) && (localStGetAdRsp.iPreLoadLevel.get() == 2L))
          {
            int i = 0;
            while (i < localStGetAdRsp.vecAppInfo.size())
            {
              GpkgManager.preloadGpkgByConfig(new MiniAppConfig(MiniAppInfo.from((INTERFACE.StApiAppInfo)localStGetAdRsp.vecAppInfo.get(i))));
              i += 1;
              continue;
              localJSONException = localJSONException;
              QLog.e("[mini] DataJsPlugin", 2, "");
              localJSONException.printStackTrace();
            }
          }
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("[mini] DataJsPlugin", 1, "preloadGpkgByConfig failed:" + paramJSONObject.getMessage());
        }
      }
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callBackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.29
 * JD-Core Version:    0.7.0.1
 */