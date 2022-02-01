package com.tencent.mobileqq.onlinestatus.music;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class OnlineStatusHandler$4
  extends Handler
{
  OnlineStatusHandler$4(OnlineStatusHandler paramOnlineStatusHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.b(((Boolean)paramMessage.obj).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.4
 * JD-Core Version:    0.7.0.1
 */