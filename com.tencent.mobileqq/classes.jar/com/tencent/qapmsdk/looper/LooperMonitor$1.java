package com.tencent.qapmsdk.looper;

import android.os.Looper;

final class LooperMonitor$1
  implements IMonitorCallback
{
  public void onMonitorEnd()
  {
    Looper.getMainLooper().setMessageLogging(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.LooperMonitor.1
 * JD-Core Version:    0.7.0.1
 */