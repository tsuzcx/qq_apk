package com.tencent.qqmini.sdk.runtime.core.page;

import android.webkit.ValueCallback;
import bdux;
import bdxf;

public class BrandPageWebview$5
  implements Runnable
{
  public BrandPageWebview$5(bdux parambdux, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (bdux.a(this.this$0) != null) {
      bdux.a(this.this$0).evaluateJavascript(this.jdField_a_of_type_JavaLangString, bdxf.a(this.jdField_a_of_type_AndroidWebkitValueCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.BrandPageWebview.5
 * JD-Core Version:    0.7.0.1
 */