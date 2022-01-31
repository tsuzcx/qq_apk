package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class UIJsPlugin$21
  implements Runnable
{
  UIJsPlugin$21(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, JSONObject paramJSONObject1, String paramString1, int paramInt1, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2, String paramString3, JSONObject paramJSONObject3, int paramInt2) {}
  
  public void run()
  {
    AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    WebviewContainer localWebviewContainer = null;
    if (localAbsAppBrandPage != null) {
      localWebviewContainer = localAbsAppBrandPage.getCurrentWebviewContainer();
    }
    if (localWebviewContainer != null)
    {
      localWebviewContainer.updateImageView(this.val$postionObj, this.val$data, this.val$viewId, this.val$iconPath, this.val$clickable, this.val$style);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.21
 * JD-Core Version:    0.7.0.1
 */