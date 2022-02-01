package com.tencent.mobileqq.qqguildsdk.engine;

import java.util.concurrent.ConcurrentHashMap;

class GPSAsynManagerEngine$MemberSearchThread
  extends Thread
{
  GPSAsynManagerEngine$MemberSearchThread(GPSAsynManagerEngine paramGPSAsynManagerEngine) {}
  
  public void run()
  {
    for (;;)
    {
      ((Runnable)GPSAsynManagerEngine.b(this.this$0).remove(GPSAsynManagerEngine.a(this.this$0))).run();
      try
      {
        Thread.sleep(1000L);
        boolean bool = GPSAsynManagerEngine.b(this.this$0).isEmpty();
        if (bool) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.MemberSearchThread
 * JD-Core Version:    0.7.0.1
 */