package com.tencent.mobileqq.webview.swift;

import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class WebViewFragment$14
  implements Runnable
{
  WebViewFragment$14(WebViewFragment paramWebViewFragment, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "banner scroll to " + this.a + " !");
    }
    if (!this.this$0.webView.isPaused) {
      this.this$0.webView.getView().scrollTo(0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.14
 * JD-Core Version:    0.7.0.1
 */