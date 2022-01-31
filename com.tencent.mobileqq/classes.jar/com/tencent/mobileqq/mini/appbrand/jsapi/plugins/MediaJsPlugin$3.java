package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class MediaJsPlugin$3
  implements Runnable
{
  MediaJsPlugin$3(MediaJsPlugin paramMediaJsPlugin, JsRuntime paramJsRuntime, int paramInt1, JSONObject paramJSONObject1, String paramString, JSONObject paramJSONObject2, int paramInt2) {}
  
  public void run()
  {
    AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    WebviewContainer localWebviewContainer = null;
    if (localAbsAppBrandPage != null) {
      localWebviewContainer = localAbsAppBrandPage.getCurrentWebviewContainer();
    }
    if (localWebviewContainer != null)
    {
      localWebviewContainer.insertVideoPlayer(this.val$videoPlayerId, this.val$jsonObject);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */