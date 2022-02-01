package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class MediaJsPlugin$2
  implements Runnable
{
  MediaJsPlugin$2(MediaJsPlugin paramMediaJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2, String paramString1, JSONObject paramJSONObject1, String paramString2, JSONObject paramJSONObject2, int paramInt3, String paramString3, boolean paramBoolean, String paramString4) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      MediaJsPlugin.access$100(this.this$0).put(Integer.valueOf(this.val$cameraId), localWebviewContainer);
      localWebviewContainer.insertCamera(this.val$cameraId, this.val$parentId, this.val$devicePosition, this.val$postionObj.optInt("left"), this.val$postionObj.optInt("top"), this.val$postionObj.optInt("width"), this.val$postionObj.optInt("height"), new MediaJsPlugin.2.1(this), this.val$flashMode, this.val$fixed, this.val$mode);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "container is null", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */