package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class MediaJsPlugin$4
  implements Runnable
{
  MediaJsPlugin$4(MediaJsPlugin paramMediaJsPlugin, JsRuntime paramJsRuntime, int paramInt1, JSONObject paramJSONObject1, String paramString, JSONObject paramJSONObject2, int paramInt2) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      MediaJsPlugin.access$000(this.this$0).put(Integer.valueOf(this.val$videoPlayerId), localWebviewContainer);
      localWebviewContainer.insertVideoPlayer(this.val$videoPlayerId, this.val$jsonObject);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */