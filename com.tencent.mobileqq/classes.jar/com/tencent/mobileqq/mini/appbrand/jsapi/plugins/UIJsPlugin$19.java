package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class UIJsPlugin$19
  implements Runnable
{
  UIJsPlugin$19(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2, boolean paramBoolean1, String paramString3, JSONObject paramJSONObject3, int paramInt3) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      localWebviewContainer.insertImageView(this.val$postionObj, this.val$data, this.val$parentId, this.val$viewId, this.val$iconPath, this.val$clickable, this.val$style, this.val$fixed);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "container is null", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.19
 * JD-Core Version:    0.7.0.1
 */