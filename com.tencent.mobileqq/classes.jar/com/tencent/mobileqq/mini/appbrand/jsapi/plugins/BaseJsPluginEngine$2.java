package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class BaseJsPluginEngine$2
  implements MiniAppCmdInterface
{
  BaseJsPluginEngine$2(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    BaseJsPluginEngine.access$200(this.this$0, this.val$eventName, this.val$jsonParams, this.val$webview, this.val$callbackId, paramBoolean, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.2
 * JD-Core Version:    0.7.0.1
 */