package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DataJsPlugin$28
  implements MiniAppCmdInterface
{
  DataJsPlugin$28(DataJsPlugin paramDataJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[mini] DataJsPlugin", 2, "call getUserInfo ： " + paramJSONObject.toString());
      }
      if ((!"webapi_getuserinfo_opendata".equals(this.val$apiName)) || (paramJSONObject == null)) {}
    }
    do
    {
      try
      {
        paramJSONObject.remove("signature");
        paramJSONObject.remove("encryptedData");
        paramJSONObject.remove("iv");
        paramJSONObject.remove("cloudID");
        if (paramJSONObject.has("data"))
        {
          JSONObject localJSONObject = new JSONObject(paramJSONObject.get("data").toString());
          localJSONObject.remove("signature");
          paramJSONObject.put("data", localJSONObject);
        }
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, paramJSONObject, this.val$callbackId);
        if ("webapi_plugin_getuserinfo".equals(this.val$apiName)) {
          AuthorizeCenter.setAllowPluginScopeName(null);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("[mini] DataJsPlugin", 1, "webapi_getuserinfo_opendata error, ", localThrowable);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[mini] DataJsPlugin", 2, "call getUserInfo failed. ");
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
    } while (!"webapi_plugin_getuserinfo".equals(this.val$apiName));
    AuthorizeCenter.setAllowPluginScopeName(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.28
 * JD-Core Version:    0.7.0.1
 */