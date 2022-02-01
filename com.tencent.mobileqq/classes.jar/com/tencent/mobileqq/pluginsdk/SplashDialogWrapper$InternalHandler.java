package com.tencent.mobileqq.pluginsdk;

import android.os.Handler;
import android.os.Message;

class SplashDialogWrapper$InternalHandler
  extends Handler
{
  public static final int MSG_DISMISS = 0;
  private SplashDialogWrapper mWrapper = null;
  
  public SplashDialogWrapper$InternalHandler(SplashDialogWrapper paramSplashDialogWrapper)
  {
    this.mWrapper = paramSplashDialogWrapper;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    this.mWrapper.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.SplashDialogWrapper.InternalHandler
 * JD-Core Version:    0.7.0.1
 */