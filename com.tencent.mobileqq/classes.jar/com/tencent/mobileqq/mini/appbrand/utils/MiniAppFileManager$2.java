package com.tencent.mobileqq.mini.appbrand.utils;

import bgmg;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

class MiniAppFileManager$2
  implements Runnable
{
  MiniAppFileManager$2(MiniAppFileManager paramMiniAppFileManager) {}
  
  public void run()
  {
    String str = MiniAppFileManager.access$000(this.this$0, 1);
    try
    {
      MiniAppFileManager.access$300(this.this$0).set(bgmg.b(str));
      label23:
      MiniAppFileManager.access$400(this.this$0).countDown();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager.2
 * JD-Core Version:    0.7.0.1
 */