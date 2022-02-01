package com.tencent.mobileqq.mini.appbrand.utils;

import bhmi;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

class MiniAppFileManager$1
  implements Runnable
{
  MiniAppFileManager$1(MiniAppFileManager paramMiniAppFileManager) {}
  
  public void run()
  {
    String str = MiniAppFileManager.access$000(this.this$0, 2);
    try
    {
      MiniAppFileManager.access$100(this.this$0).set(bhmi.b(str));
      label23:
      MiniAppFileManager.access$200(this.this$0).countDown();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager.1
 * JD-Core Version:    0.7.0.1
 */