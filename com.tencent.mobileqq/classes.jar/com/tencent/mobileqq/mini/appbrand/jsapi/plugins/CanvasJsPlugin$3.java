package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.concurrent.ConcurrentHashMap;

class CanvasJsPlugin$3
  implements Runnable
{
  CanvasJsPlugin$3(CanvasJsPlugin paramCanvasJsPlugin, int paramInt1, JsRuntime paramJsRuntime, String paramString, int paramInt2) {}
  
  public void run()
  {
    if ((CanvasJsPlugin.access$000(this.this$0) != null) && (CanvasJsPlugin.access$000(this.this$0).containsKey(Integer.valueOf(this.val$canvasId)))) {
      CanvasJsPlugin.access$000(this.this$0).remove(Integer.valueOf(this.val$canvasId));
    }
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      localWebviewContainer.removeCanvas(this.val$canvasId);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.CanvasJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */