package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import ysx;

class DataJsPlugin$28
  implements MiniAppCmdInterface
{
  DataJsPlugin$28(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      Object localObject = (MiniAppAd.StGetAdRsp)paramJSONObject.opt("response");
      long l = paramJSONObject.optLong("retCode");
      paramJSONObject = ((MiniAppAd.StGetAdRsp)localObject).strAdsJson.get();
      String str = ((MiniAppAd.StGetAdRsp)localObject).strAdTemplateJson.get();
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("data", paramJSONObject);
        localJSONObject.put("ret", l);
        localJSONObject.put("adClass", str);
        ((JSONObject)localObject).put("data", localJSONObject.toString());
        QLog.d("[mini] DataJsPlugin", 2, "sendAdRequest. retCode = " + l);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, (JSONObject)localObject, this.val$callBackId);
        DataJsPlugin.access$600(this.this$0, paramJSONObject, this.val$adType);
        paramJSONObject = new GdtAd(DataJsPlugin.access$700(this.this$0, paramJSONObject));
        ysx.a().a(paramJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("[mini] DataJsPlugin", 2, "");
          localJSONException.printStackTrace();
        }
      }
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callBackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.28
 * JD-Core Version:    0.7.0.1
 */