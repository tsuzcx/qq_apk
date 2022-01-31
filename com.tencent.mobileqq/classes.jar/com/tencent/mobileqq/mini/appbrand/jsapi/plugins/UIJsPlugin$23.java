package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class UIJsPlugin$23
  implements Runnable
{
  UIJsPlugin$23(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, int paramInt1, JSONObject paramJSONObject1, boolean paramBoolean, String paramString, JSONObject paramJSONObject2, int paramInt2) {}
  
  public void run()
  {
    AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    WebviewContainer localWebviewContainer = null;
    if (localAbsAppBrandPage != null) {
      localWebviewContainer = localAbsAppBrandPage.getCurrentWebviewContainer();
    }
    if (localWebviewContainer != null)
    {
      localWebviewContainer.updateCanvas(this.val$canvasId, this.val$postionObj, this.val$hide);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.23
 * JD-Core Version:    0.7.0.1
 */