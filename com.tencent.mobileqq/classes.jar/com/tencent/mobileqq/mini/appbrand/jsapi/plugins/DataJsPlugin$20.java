package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DataJsPlugin$20
  implements MiniAppCmdInterface
{
  DataJsPlugin$20(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder;
      if (QLog.isDebugVersion())
      {
        localStringBuilder = new StringBuilder().append("verifyPlugin : ");
        if (paramJSONObject == null) {
          break label72;
        }
      }
      label72:
      for (String str = paramJSONObject.toString();; str = "")
      {
        QLog.e("[mini] DataJsPlugin", 1, str);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, paramJSONObject, this.val$callbackId);
        return;
      }
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "verifyPlugin failed.", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.20
 * JD-Core Version:    0.7.0.1
 */