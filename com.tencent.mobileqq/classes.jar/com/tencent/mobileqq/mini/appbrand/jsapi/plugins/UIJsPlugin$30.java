package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class UIJsPlugin$30
  implements Runnable
{
  UIJsPlugin$30(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, JSONObject paramJSONObject, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    if (localObject != null) {}
    for (localObject = ((AbsAppBrandPage)localObject).getCurrentWebviewContainer();; localObject = null)
    {
      if (localObject != null)
      {
        ((WebviewContainer)localObject).insertTextView(this.val$jsonObject);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.30
 * JD-Core Version:    0.7.0.1
 */