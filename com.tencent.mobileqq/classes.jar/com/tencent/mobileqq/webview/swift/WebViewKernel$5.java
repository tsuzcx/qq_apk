package com.tencent.mobileqq.webview.swift;

import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class WebViewKernel$5
  implements Runnable
{
  WebViewKernel$5(WebViewKernel paramWebViewKernel, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("banner scroll to ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" !");
      QLog.d("WebViewKernel", 2, localStringBuilder.toString());
    }
    if (!WebViewKernel.c(this.this$0).isPaused) {
      WebViewKernel.c(this.this$0).getView().scrollTo(0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewKernel.5
 * JD-Core Version:    0.7.0.1
 */