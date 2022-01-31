package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UIJsPlugin$18
  implements Runnable
{
  UIJsPlugin$18(UIJsPlugin paramUIJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        int i = new JSONObject(this.val$jsonParams).optInt("htmlId");
        Object localObject1 = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
        if (localObject1 != null)
        {
          localObject1 = ((AbsAppBrandPage)localObject1).getCurrentWebviewContainer();
          if (localObject1 != null)
          {
            ((WebviewContainer)localObject1).removeHTMLWebView(i);
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
            return;
          }
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
          throw new MiniAppException("removeHTMLWebView fail, can not find WebviewContainer, pageWebviewId=" + this.val$webview.getPageWebViewId());
        }
      }
      catch (Exception localException)
      {
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
        QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localException);
        return;
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.18
 * JD-Core Version:    0.7.0.1
 */