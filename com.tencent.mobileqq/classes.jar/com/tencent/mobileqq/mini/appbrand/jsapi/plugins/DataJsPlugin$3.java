package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DataJsPlugin$3
  implements MiniAppCmdInterface
{
  DataJsPlugin$3(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QLog.d("[mini] DataJsPlugin", 2, "call API_LOGIN  code:" + paramJSONObject.toString());
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, paramJSONObject, this.val$callbackId);
      return;
    }
    QLog.e("[mini] DataJsPlugin", 2, "call API_LOGIN failed ");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */