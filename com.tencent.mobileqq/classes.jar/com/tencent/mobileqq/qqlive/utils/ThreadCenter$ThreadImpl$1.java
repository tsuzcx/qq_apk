package com.tencent.mobileqq.qqlive.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadCenter$ThreadImpl$1
  implements Runnable
{
  public void run()
  {
    ThreadCenter.ThreadImpl.a(this.this$0).remove(this.a);
    ThreadCenter.ThreadImpl.b(this.this$0).execute(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.ThreadCenter.ThreadImpl.1
 * JD-Core Version:    0.7.0.1
 */