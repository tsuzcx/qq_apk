package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class LivePusherJsPlugin$1
  implements Runnable
{
  LivePusherJsPlugin$1(LivePusherJsPlugin paramLivePusherJsPlugin, JsRuntime paramJsRuntime, int paramInt1, JSONObject paramJSONObject1, String paramString, JSONObject paramJSONObject2, int paramInt2) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      localWebviewContainer.insertLivePusher(this.val$livePusherId, this.val$jsonObject);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LivePusherJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */