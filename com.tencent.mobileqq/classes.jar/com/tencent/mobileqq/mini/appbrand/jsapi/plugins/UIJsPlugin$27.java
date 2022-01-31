package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UIJsPlugin$27
  implements Runnable
{
  UIJsPlugin$27(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, int paramInt1, JSONObject paramJSONObject1, String paramString, JSONObject paramJSONObject2, int paramInt2) {}
  
  public void run()
  {
    try
    {
      AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
      WebviewContainer localWebviewContainer = null;
      if (localAbsAppBrandPage != null) {
        localWebviewContainer = localAbsAppBrandPage.getCurrentWebviewContainer();
      }
      if (localWebviewContainer != null)
      {
        localWebviewContainer.insertTextArea(this.val$inputId, this.val$jsonObject);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
        localWebviewContainer.callbackLineChange(this.val$inputId);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.27
 * JD-Core Version:    0.7.0.1
 */