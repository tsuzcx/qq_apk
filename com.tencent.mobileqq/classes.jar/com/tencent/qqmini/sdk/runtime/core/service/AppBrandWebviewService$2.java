package com.tencent.qqmini.sdk.runtime.core.service;

import android.webkit.ValueCallback;
import bfdk;
import bfen;
import com.tencent.smtt.sdk.WebView;

public class AppBrandWebviewService$2
  implements Runnable
{
  public AppBrandWebviewService$2(bfdk parambfdk, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (bfdk.a(this.this$0) != null) {
      bfdk.a(this.this$0).evaluateJavascript(this.jdField_a_of_type_JavaLangString, bfen.a(this.jdField_a_of_type_AndroidWebkitValueCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.service.AppBrandWebviewService.2
 * JD-Core Version:    0.7.0.1
 */