package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class CanvasJsPlugin$1
  implements Runnable
{
  CanvasJsPlugin$1(CanvasJsPlugin paramCanvasJsPlugin, JsRuntime paramJsRuntime, int paramInt1, JSONObject paramJSONObject1, int paramInt2, JSONObject paramJSONObject2, String paramString1, String paramString2, JSONObject paramJSONObject3, int paramInt3) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      CanvasJsPlugin.access$000(this.this$0).put(Integer.valueOf(this.val$canvasId), localWebviewContainer);
      if (this.val$jsonObject.opt("disableScroll") == null) {
        break label164;
      }
    }
    label164:
    for (Boolean localBoolean = Boolean.valueOf(this.val$jsonObject.optBoolean("disableScroll"));; localBoolean = null)
    {
      localWebviewContainer.insertCanvas(this.val$canvasId, this.val$parentId, this.val$postionObj, this.val$data, this.val$jsonObject.optBoolean("hide"), this.val$jsonObject.optBoolean("useHardwareAccelerate"), localBoolean, this.val$jsonObject.optBoolean("gesture"));
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
      return;
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "container is null", this.val$callbackId);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.CanvasJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */