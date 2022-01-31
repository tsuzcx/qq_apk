package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import java.util.Map;

final class af
  implements Runnable
{
  af(Context paramContext, Map paramMap, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      new Thread(new ap(this.a, this.b, this.c), "NetworkMonitorTask").start();
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
 * Qualified Name:     com.tencent.wxop.stat.af
 * JD-Core Version:    0.7.0.1
 */