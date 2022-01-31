package com.tencent.qqmini.sdk.runtime.core.page;

import android.webkit.ValueCallback;
import bfbw;
import bfen;

public class BrandPageWebview$5
  implements Runnable
{
  public BrandPageWebview$5(bfbw parambfbw, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (bfbw.a(this.this$0) != null) {
      bfbw.a(this.this$0).evaluateJavascript(this.jdField_a_of_type_JavaLangString, bfen.a(this.jdField_a_of_type_AndroidWebkitValueCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.BrandPageWebview.5
 * JD-Core Version:    0.7.0.1
 */