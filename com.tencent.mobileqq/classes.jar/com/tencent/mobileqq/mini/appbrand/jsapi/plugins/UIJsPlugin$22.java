package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class UIJsPlugin$22
  implements Runnable
{
  UIJsPlugin$22(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, JSONObject paramJSONObject1, int paramInt1, int paramInt2, JSONObject paramJSONObject2, String paramString1, String paramString2, JSONObject paramJSONObject3, int paramInt3) {}
  
  public void run()
  {
    Boolean localBoolean = null;
    Object localObject = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    if (localObject != null) {}
    for (localObject = ((AbsAppBrandPage)localObject).getCurrentWebviewContainer();; localObject = null)
    {
      if (localObject != null)
      {
        if (this.val$jsonObject.opt("disableScroll") != null) {
          localBoolean = Boolean.valueOf(this.val$jsonObject.optBoolean("disableScroll"));
        }
        ((WebviewContainer)localObject).insertCanvas(this.val$canvasId, this.val$parentId, this.val$postionObj, this.val$data, this.val$jsonObject.optBoolean("hide"), this.val$jsonObject.optBoolean("useHardwareAccelerate"), localBoolean, this.val$jsonObject.optBoolean("gesture"));
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.22
 * JD-Core Version:    0.7.0.1
 */