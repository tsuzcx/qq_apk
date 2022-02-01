package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;

class WebView$1
  extends X5ProxyWebViewClientExtension
{
  WebView$1(WebView paramWebView, IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    super(paramIX5WebViewClientExtension);
  }
  
  public void invalidate() {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    WebView.a(this.a, paramInt3, paramInt4, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.1
 * JD-Core Version:    0.7.0.1
 */