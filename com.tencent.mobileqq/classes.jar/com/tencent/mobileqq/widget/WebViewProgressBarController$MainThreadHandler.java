package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class WebViewProgressBarController$MainThreadHandler
  extends Handler
{
  final WeakReference<WebViewProgressBarController> a;
  
  public WebViewProgressBarController$MainThreadHandler(WebViewProgressBarController paramWebViewProgressBarController)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramWebViewProgressBarController);
  }
  
  public void handleMessage(Message paramMessage)
  {
    WebViewProgressBarController localWebViewProgressBarController = (WebViewProgressBarController)this.a.get();
    if (localWebViewProgressBarController == null) {
      return;
    }
    if (paramMessage.what != 200) {
      return;
    }
    localWebViewProgressBarController.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBarController.MainThreadHandler
 * JD-Core Version:    0.7.0.1
 */