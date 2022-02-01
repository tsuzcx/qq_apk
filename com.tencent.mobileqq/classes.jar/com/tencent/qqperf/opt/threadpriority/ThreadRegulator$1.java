package com.tencent.qqperf.opt.threadpriority;

import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ThreadRegulator$1
  extends MqqHandler
{
  ThreadRegulator$1(ThreadRegulator paramThreadRegulator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (ThreadRegulator.CpuBusyness)paramMessage.obj;
    if (paramMessage != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessage.a);
        localStringBuilder.append(" cost ");
        localStringBuilder.append(paramMessage.c - paramMessage.b);
        localStringBuilder.append(", paused ");
        localStringBuilder.append(paramMessage.d);
        QLog.d("ThreadManager.Regulaotr", 2, localStringBuilder.toString());
      }
      paramMessage.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadRegulator.1
 * JD-Core Version:    0.7.0.1
 */