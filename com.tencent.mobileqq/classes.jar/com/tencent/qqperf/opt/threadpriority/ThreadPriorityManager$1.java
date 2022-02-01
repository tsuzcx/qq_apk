package com.tencent.qqperf.opt.threadpriority;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ThreadPriorityManager$1
  extends Handler
{
  ThreadPriorityManager$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      ThreadPriorityManager.b();
      return;
    }
    ThreadPriorityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager.1
 * JD-Core Version:    0.7.0.1
 */