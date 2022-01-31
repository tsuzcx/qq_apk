package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class InternalJSPlugin$3
  implements MiniAppCmdInterface
{
  InternalJSPlugin$3(InternalJSPlugin paramInternalJSPlugin, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, String paramString3, String paramString4) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      String str1 = paramJSONObject.optString("appName");
      String str2 = paramJSONObject.optString("packageName");
      String str3 = paramJSONObject.optString("nativeAppId");
      String str4 = paramJSONObject.optString("downloadUrl");
      int i = paramJSONObject.optInt("onlyOpen");
      InternalJSPlugin.access$000(this.this$0, this.this$0.jsPluginEngine.getActivityContext(), str3, str2, str1, str4, i, this.val$appParameter, this.val$eventName, this.val$webview, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "jump check failed.", this.val$callbackId);
    QLog.w("InternalJSPlugin", 1, String.format("jump native app check failed, appid:%s, packageName:%s", new Object[] { this.val$appConnectId, this.val$packageName }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.3
 * JD-Core Version:    0.7.0.1
 */