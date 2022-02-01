package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.app.ThreadManager;

class WebViewKernel$2
  implements Runnable
{
  WebViewKernel$2(WebViewKernel paramWebViewKernel) {}
  
  public void run()
  {
    ThreadManager.postImmediately(new WebViewKernel.2.1(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewKernel.2
 * JD-Core Version:    0.7.0.1
 */