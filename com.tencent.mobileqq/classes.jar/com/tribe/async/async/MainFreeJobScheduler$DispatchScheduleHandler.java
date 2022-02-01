package com.tribe.async.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class MainFreeJobScheduler$DispatchScheduleHandler
  extends Handler
{
  public MainFreeJobScheduler$DispatchScheduleHandler(MainFreeJobScheduler paramMainFreeJobScheduler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.this$0.doSchedule();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.async.MainFreeJobScheduler.DispatchScheduleHandler
 * JD-Core Version:    0.7.0.1
 */