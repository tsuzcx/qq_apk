package com.tribe.async.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class MainFreeJobScheduler$MainThreadScheduleHandler
  extends Handler
{
  public MainFreeJobScheduler$MainThreadScheduleHandler(MainFreeJobScheduler paramMainFreeJobScheduler)
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    Message.obtain(MainFreeJobScheduler.access$100(this.this$0), 2).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.MainFreeJobScheduler.MainThreadScheduleHandler
 * JD-Core Version:    0.7.0.1
 */