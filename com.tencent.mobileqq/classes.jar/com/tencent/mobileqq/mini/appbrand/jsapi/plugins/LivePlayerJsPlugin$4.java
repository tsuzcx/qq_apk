package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class LivePlayerJsPlugin$4
  implements Runnable
{
  LivePlayerJsPlugin$4(LivePlayerJsPlugin paramLivePlayerJsPlugin, JsRuntime paramJsRuntime, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      localWebviewContainer.removeLivePlayer(this.val$livePlayerId);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LivePlayerJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */