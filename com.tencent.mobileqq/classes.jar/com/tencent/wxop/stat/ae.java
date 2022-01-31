package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

final class ae
  implements Runnable
{
  ae(Context paramContext) {}
  
  public final void run()
  {
    try
    {
      new Thread(new ap(this.a, null, null), "NetworkMonitorTask").start();
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      StatServiceImpl.a(this.a, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.ae
 * JD-Core Version:    0.7.0.1
 */