package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.concurrent.ConcurrentHashMap;

class MediaJsPlugin$6
  implements Runnable
{
  MediaJsPlugin$6(MediaJsPlugin paramMediaJsPlugin, int paramInt1, JsRuntime paramJsRuntime, String paramString, int paramInt2) {}
  
  public void run()
  {
    MediaJsPlugin.access$000(this.this$0).remove(Integer.valueOf(this.val$videoPlayerId));
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      localWebviewContainer.removeVideoPlayer(this.val$videoPlayerId);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */