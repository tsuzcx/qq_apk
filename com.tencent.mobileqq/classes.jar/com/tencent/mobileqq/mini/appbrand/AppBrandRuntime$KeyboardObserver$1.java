package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AppBrandRuntime$KeyboardObserver$1
  implements Runnable
{
  AppBrandRuntime$KeyboardObserver$1(AppBrandRuntime.KeyboardObserver paramKeyboardObserver) {}
  
  public void run()
  {
    int i;
    if ((this.this$1.this$0.serviceRuntime != null) && (this.this$1.this$0.pageContainer != null) && (this.this$1.this$0.pageContainer.getCurrentPageWebview() != null))
    {
      if (this.this$1.this$0.jsPluginEngine == null) {
        break label158;
      }
      i = this.this$1.this$0.jsPluginEngine.getCurInputId();
    }
    try
    {
      for (;;)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("height", 0);
        localJSONObject.put("inputId", i);
        this.this$1.this$0.serviceRuntime.evaluateSubcribeJS("onKeyboardHeightChange", localJSONObject.toString(), this.this$1.this$0.pageContainer.getCurrentPageWebview().getPageWebViewId());
        if (this.this$1.this$0.jsPluginEngine != null) {
          this.this$1.this$0.jsPluginEngine.setCurInputId(-1);
        }
        return;
        label158:
        i = -1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AppBrandRuntime", 2, "KeyboardObserver error, ", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.KeyboardObserver.1
 * JD-Core Version:    0.7.0.1
 */