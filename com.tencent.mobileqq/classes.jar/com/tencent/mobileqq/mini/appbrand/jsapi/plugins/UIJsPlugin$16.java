package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UIJsPlugin$16
  implements Runnable
{
  UIJsPlugin$16(UIJsPlugin paramUIJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(this.val$jsonParams);
        int i = ((JSONObject)localObject1).optInt("htmlId");
        localObject1 = ((JSONObject)localObject1).optJSONObject("position");
        if (localObject1 == null) {
          break label295;
        }
        int j = ((JSONObject)localObject1).optInt("left");
        int k = ((JSONObject)localObject1).optInt("top");
        int m = ((JSONObject)localObject1).optInt("width");
        int n = ((JSONObject)localObject1).optInt("height");
        localObject1 = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
        if (localObject1 == null) {
          break label328;
        }
        localObject1 = ((AbsAppBrandPage)localObject1).getCurrentWebviewContainer();
        if (localObject1 != null)
        {
          if (((WebviewContainer)localObject1).insertHTMLWebView(i, j, k, m, n))
          {
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
            return;
          }
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "create webview failed.", this.val$callbackId);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localException);
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
        return;
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      throw new MiniAppException("insertHtmlWebView fail, can not find WebviewContainer, pageWebviewId=" + this.val$webview.getPageWebViewId());
      label295:
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      throw new MiniAppException("insertHtmlWebView fail, position is empty");
      label328:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */