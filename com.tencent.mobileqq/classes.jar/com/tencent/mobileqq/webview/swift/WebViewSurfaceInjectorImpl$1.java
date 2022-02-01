package com.tencent.mobileqq.webview.swift;

import com.tencent.open.downloadnew.MyAppApi;

class WebViewSurfaceInjectorImpl$1
  implements Runnable
{
  WebViewSurfaceInjectorImpl$1(WebViewSurfaceInjectorImpl paramWebViewSurfaceInjectorImpl, WebViewProvider paramWebViewProvider) {}
  
  public void run()
  {
    if (MyAppApi.r()) {
      MyAppApi.l().a(this.a.getHostActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl.1
 * JD-Core Version:    0.7.0.1
 */