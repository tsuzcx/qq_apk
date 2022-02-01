package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;

class AntiphingToast$1
  extends Handler
{
  AntiphingToast$1(AntiphingToast paramAntiphingToast, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      AntiphingToast localAntiphingToast = this.a;
      localAntiphingToast.a(0.0F, 0 - AntiphingToast.a(localAntiphingToast).getHeight(), true);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AntiphingToast.1
 * JD-Core Version:    0.7.0.1
 */