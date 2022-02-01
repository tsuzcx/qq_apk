package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import java.util.List;

class WebViewPool$1$1
  implements QbSdk.PreInitCallback
{
  WebViewPool$1$1(WebViewPool.1 param1) {}
  
  public void onCoreInitFinished()
  {
    LogFactory.a().c("WebViewPool", "-------preload------onCoreInitFinished");
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    LogFactory.a().c("WebViewPool", "-------preload------onViewInitFinished");
    if (WebViewPool.a(this.a.this$0).size() == 0) {
      WebViewPool.a(this.a.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool.1.1
 * JD-Core Version:    0.7.0.1
 */