package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.smtt.sdk.QbSdk;

class WebViewPool$1
  implements Runnable
{
  WebViewPool$1(WebViewPool paramWebViewPool) {}
  
  public void run()
  {
    QbSdk.preInit(BaseApplicationImpl.getContext(), new WebViewPool.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool.1
 * JD-Core Version:    0.7.0.1
 */