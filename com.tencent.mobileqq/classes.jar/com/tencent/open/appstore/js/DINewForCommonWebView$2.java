package com.tencent.open.appstore.js;

import android.os.Build.VERSION;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class DINewForCommonWebView$2
  implements Runnable
{
  DINewForCommonWebView$2(DINewForCommonWebView paramDINewForCommonWebView, String paramString) {}
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 19)
      {
        DINewForCommonWebView.a(this.this$0).loadUrl(this.a);
        return;
      }
      DINewForCommonWebView.a(this.this$0).evaluateJavascript(this.a, new DINewForCommonWebView.2.1(this));
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a("DINewForCommonWebView", "[jsCallBack] e>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.js.DINewForCommonWebView.2
 * JD-Core Version:    0.7.0.1
 */