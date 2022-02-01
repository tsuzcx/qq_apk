package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class WebviewWrapper$1
  implements LiteLiveSdkWebViewBaseBuilder.WebviewStatusListener
{
  WebviewWrapper$1(WebviewWrapper paramWebviewWrapper, IWebviewListener paramIWebviewListener) {}
  
  public void a()
  {
    if (this.b.b == null) {
      return;
    }
    if (this.b.b.getVisibility() != 0) {
      this.b.b.setVisibility(0);
    }
    IWebviewListener localIWebviewListener = this.a;
    if (localIWebviewListener != null) {
      localIWebviewListener.onPageFinished();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    IWebviewListener localIWebviewListener = this.a;
    if (localIWebviewListener != null) {
      localIWebviewListener.onReceiveError(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper.1
 * JD-Core Version:    0.7.0.1
 */