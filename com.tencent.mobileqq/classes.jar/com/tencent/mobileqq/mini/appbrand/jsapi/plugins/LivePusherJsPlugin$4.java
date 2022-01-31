package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import org.json.JSONObject;

class LivePusherJsPlugin$4
  implements Runnable
{
  LivePusherJsPlugin$4(LivePusherJsPlugin paramLivePusherJsPlugin, int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.appBrandRuntime.getCurWebviewContainer();
    if (localWebviewContainer != null) {
      localWebviewContainer.operateLivePusher(this.val$livePusherId, this.val$type, this.val$callbackId, this.val$jsonObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LivePusherJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */