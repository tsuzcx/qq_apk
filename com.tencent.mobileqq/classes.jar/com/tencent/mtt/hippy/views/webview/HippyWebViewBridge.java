package com.tencent.mtt.hippy.views.webview;

import android.webkit.JavascriptInterface;

class HippyWebViewBridge
{
  private HippyWebView hippyView;
  
  public HippyWebViewBridge(HippyWebView paramHippyWebView)
  {
    this.hippyView = paramHippyWebView;
  }
  
  @JavascriptInterface
  public void postMessage(String paramString)
  {
    HippyWebView localHippyWebView = this.hippyView;
    if (localHippyWebView != null) {
      localHippyWebView.postMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.webview.HippyWebViewBridge
 * JD-Core Version:    0.7.0.1
 */