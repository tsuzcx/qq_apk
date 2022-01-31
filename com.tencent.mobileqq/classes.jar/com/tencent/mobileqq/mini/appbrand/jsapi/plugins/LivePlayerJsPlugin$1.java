package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class LivePlayerJsPlugin$1
  implements Runnable
{
  LivePlayerJsPlugin$1(LivePlayerJsPlugin paramLivePlayerJsPlugin, JsRuntime paramJsRuntime, int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null) {
      localWebviewContainer.operateLivePlayer(this.val$livePlayerId, this.val$type, this.val$callbackId, this.val$jsonObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LivePlayerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */