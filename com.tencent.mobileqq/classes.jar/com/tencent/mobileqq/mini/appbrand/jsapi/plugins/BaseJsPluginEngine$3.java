package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class BaseJsPluginEngine$3
  implements MiniAppCmdInterface
{
  BaseJsPluginEngine$3(BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("BaseJsPluginEngine", 2, "setAuthorize() onCmdListener isSuccess: " + paramBoolean + "   ; ret: " + paramJSONObject);
    }
    if (paramJSONObject != null)
    {
      if (paramJSONObject.optLong("retCode") == -101510007L) {
        this.this$0.callbackJsEventFail(this.val$webview, "subscribeAppMsg", paramJSONObject, "no login", this.val$callbackId);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.this$0.callbackJsEventOK(this.val$webview, "subscribeAppMsg", null, this.val$callbackId);
      return;
    }
    this.this$0.callbackJsEventFail(this.val$webview, "subscribeAppMsg", paramJSONObject, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.3
 * JD-Core Version:    0.7.0.1
 */