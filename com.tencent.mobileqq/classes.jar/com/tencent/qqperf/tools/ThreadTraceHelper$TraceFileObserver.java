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
    QLog.e("UnifiedMonitor.Trace", 1, "dumpTraces onEvent " + ???);
    synchronized (ThreadTraceHelper.a())
    {
      notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.tools.ThreadTraceHelper.TraceFileObserver
 * JD-Core Version:    0.7.0.1
 */