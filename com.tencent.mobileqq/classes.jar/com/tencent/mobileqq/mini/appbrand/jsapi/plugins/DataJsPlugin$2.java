package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DataJsPlugin$2
  implements MiniAppCmdInterface
{
  DataJsPlugin$2(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("[mini] DataJsPlugin", 2, new Object[] { "onCmdListener", paramJSONObject });
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject.remove("countryCode");
      paramJSONObject.remove("purePhoneNumber");
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, ApiUtil.wrapCallbackOk(this.val$event, paramJSONObject), this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, paramJSONObject), this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */