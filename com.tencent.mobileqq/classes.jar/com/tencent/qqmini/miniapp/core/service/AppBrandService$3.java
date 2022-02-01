package com.tencent.qqmini.miniapp.core.service;

import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.JsContext;

class AppBrandService$3
  implements Runnable
{
  AppBrandService$3(AppBrandService paramAppBrandService, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (this.this$0.mJsContext != null) {
      this.this$0.mJsContext.evaluateJavascript(this.val$js, this.val$valueCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandService.3
 * JD-Core Version:    0.7.0.1
 */