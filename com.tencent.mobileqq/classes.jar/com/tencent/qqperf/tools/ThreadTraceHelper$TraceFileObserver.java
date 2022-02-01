package com.tencent.qqperf.tools;

import android.os.FileObserver;
import com.tencent.qphone.base.util.QLog;

class ThreadTraceHelper$TraceFileObserver
  extends FileObserver
{
  public ThreadTraceHelper$TraceFileObserver(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public void onEvent(int paramInt, String arg2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dumpTraces onEvent ");
    localStringBuilder.append(???);
    QLog.e("UnifiedMonitor.Trace", 1, localStringBuilder.toString());
    synchronized (ThreadTraceHelper.c())
    {
      notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.tools.ThreadTraceHelper.TraceFileObserver
 * JD-Core Version:    0.7.0.1
 */