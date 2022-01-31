package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UIJsPlugin$31
  implements Runnable
{
  UIJsPlugin$31(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, JSONObject paramJSONObject, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((AbsAppBrandPage)localObject1).getCurrentWebviewContainer();; localObject2 = null)
    {
      if (localObject1 != null) {}
      try
      {
        ((WebviewContainer)localObject1).updateTextView(this.val$jsonObject);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.31
 * JD-Core Version:    0.7.0.1
 */