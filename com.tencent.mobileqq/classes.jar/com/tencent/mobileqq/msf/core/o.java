package com.tencent.mobileqq.msf.core;

import com.tencent.msf.boot.config.NativeConfigStore;

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