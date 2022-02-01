package com.tencent.qqmini.miniapp.core.service;

import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.util.AppBrandUtil;
import com.tencent.smtt.sdk.WebView;

class AppBrandWebviewService$2
  implements Runnable
{
  AppBrandWebviewService$2(AppBrandWebviewService paramAppBrandWebviewService, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (AppBrandWebviewService.access$100(this.this$0) != null) {
      AppBrandWebviewService.access$100(this.this$0).evaluateJavascript(this.val$js, AppBrandUtil.convertValueCallback(this.val$valueCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService.2
 * JD-Core Version:    0.7.0.1
 */