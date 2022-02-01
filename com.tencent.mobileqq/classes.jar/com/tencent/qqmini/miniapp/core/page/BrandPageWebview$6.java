package com.tencent.qqmini.miniapp.core.page;

import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.util.AppBrandUtil;

class BrandPageWebview$6
  implements Runnable
{
  BrandPageWebview$6(BrandPageWebview paramBrandPageWebview, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (BrandPageWebview.access$000(this.this$0) != null) {
      BrandPageWebview.access$000(this.this$0).evaluateJavascript(this.val$js, AppBrandUtil.convertValueCallback(this.val$valueCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.6
 * JD-Core Version:    0.7.0.1
 */