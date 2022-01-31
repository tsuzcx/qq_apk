package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class MediaJsPlugin$3
  implements Runnable
{
  MediaJsPlugin$3(MediaJsPlugin paramMediaJsPlugin, int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if ((MediaJsPlugin.access$100(this.this$0) != null) && (MediaJsPlugin.access$100(this.this$0).containsKey(Integer.valueOf(this.val$cameraId)))) {}
    for (WebviewContainer localWebviewContainer = (WebviewContainer)MediaJsPlugin.access$100(this.this$0).get(Integer.valueOf(this.val$cameraId));; localWebviewContainer = this.this$0.jsPluginEngine.appBrandRuntime.getCurWebviewContainer())
    {
      if (localWebviewContainer != null) {
        localWebviewContainer.operateCamera(this.val$event, this.val$callbackId, this.val$jsonObject);
      }
      if ("removeCamera".equals(this.val$event)) {
        MediaJsPlugin.access$100(this.this$0).remove(Integer.valueOf(this.val$cameraId));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */