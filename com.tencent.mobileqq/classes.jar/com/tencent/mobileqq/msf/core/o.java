package com.tencent.mobileqq.msf.core;

import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.QLog;

final class o
  extends Thread
{
  public void run()
  {
    try
    {
      Thread.sleep(180000L);
      MsfStore.getNativeConfigStore().removeConfig("LOGLEVEL_");
      MsfStore.getNativeConfigStore().removeConfig("LOGLEVELTIME");
      QLog.d(h.b, 1, "LogLevel and time has removed");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.o
 * JD-Core Version:    0.7.0.1
 */