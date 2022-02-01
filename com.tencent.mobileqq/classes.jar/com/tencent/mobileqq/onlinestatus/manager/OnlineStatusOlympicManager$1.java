package com.tencent.mobileqq.onlinestatus.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;

class OnlineStatusOlympicManager$1
  extends Handler
{
  OnlineStatusOlympicManager$1(OnlineStatusOlympicManager paramOnlineStatusOlympicManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      OnlineStatusOlympicManager.b(this.a);
      return;
    }
    ((OnlineStatusHandler)OnlineStatusOlympicManager.a(this.a).getBusinessHandler(OnlineStatusHandler.class.getName())).a(this.a.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusOlympicManager.1
 * JD-Core Version:    0.7.0.1
 */