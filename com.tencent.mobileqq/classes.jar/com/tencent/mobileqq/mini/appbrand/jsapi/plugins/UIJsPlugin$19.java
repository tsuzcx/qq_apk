package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class UIJsPlugin$19
  implements Runnable
{
  UIJsPlugin$19(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2, String paramString1, JSONObject paramJSONObject1, String paramString2, JSONObject paramJSONObject2, int paramInt3, String paramString3, boolean paramBoolean, String paramString4) {}
  
  public void run()
  {
    AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    WebviewContainer localWebviewContainer = null;
    if (localAbsAppBrandPage != null) {
      localWebviewContainer = localAbsAppBrandPage.getCurrentWebviewContainer();
    }
    if (localWebviewContainer != null) {
      localWebviewContainer.insertCamera(this.val$cameraId, this.val$parentId, this.val$devicePosition, this.val$postionObj.optInt("left"), this.val$postionObj.optInt("top"), this.val$postionObj.optInt("width"), this.val$postionObj.optInt("height"), new UIJsPlugin.19.1(this), this.val$flashMode, this.val$fixed, this.val$mode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.19
 * JD-Core Version:    0.7.0.1
 */