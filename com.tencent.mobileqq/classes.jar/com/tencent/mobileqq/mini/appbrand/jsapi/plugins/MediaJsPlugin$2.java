package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import org.json.JSONObject;

class MediaJsPlugin$2
  implements Runnable
{
  MediaJsPlugin$2(MediaJsPlugin paramMediaJsPlugin, String paramString, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.appBrandRuntime.getCurWebviewContainer();
    if (localWebviewContainer != null) {
      localWebviewContainer.operateCamera(this.val$event, this.val$callbackId, this.val$jsonObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */