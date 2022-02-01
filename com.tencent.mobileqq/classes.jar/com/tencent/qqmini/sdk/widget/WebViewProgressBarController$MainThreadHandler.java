package com.tencent.qqmini.sdk.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class WebViewProgressBarController$MainThreadHandler
  extends Handler
{
  public WebViewProgressBarController$MainThreadHandler(WebViewProgressBarController paramWebViewProgressBarController)
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 200) {
      return;
    }
    this.this$0.refreshUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.WebViewProgressBarController.MainThreadHandler
 * JD-Core Version:    0.7.0.1
 */