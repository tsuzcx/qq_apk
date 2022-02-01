package com.tencent.qqlive.module.videoreport.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class EventStatisticsManager$1
  extends Handler
{
  EventStatisticsManager$1(EventStatisticsManager paramEventStatisticsManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      EventStatisticsManager.access$000(this.a);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.EventStatisticsManager.1
 * JD-Core Version:    0.7.0.1
 */