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
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localWebViewProgressBarController.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBarController.MainThreadHandler
 * JD-Core Version:    0.7.0.1
 */