package com.tencent.qqmini.miniapp.core.page;

import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.util.AppBrandUtil;

class BrandPageWebview$7
  implements Runnable
{
  BrandPageWebview$7(BrandPageWebview paramBrandPageWebview, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (BrandPageWebview.access$000(this.this$0) != null) {
      BrandPageWebview.access$000(this.this$0).evaluateJavascript(this.jdField_a_of_type_JavaLangString, AppBrandUtil.convertValueCallback(this.jdField_a_of_type_AndroidWebkitValueCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.7
 * JD-Core Version:    0.7.0.1
 */