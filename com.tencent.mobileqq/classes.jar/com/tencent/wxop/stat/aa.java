package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.g;

final class aa
  implements Runnable
{
  aa(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, StatAppMonitor paramStatAppMonitor) {}
  
  public final void run()
  {
    try
    {
      new aq(new g(this.a, StatServiceImpl.a(this.a, false, this.b), this.c, this.b)).a();
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
 * Qualified Name:     com.tencent.wxop.stat.aa
 * JD-Core Version:    0.7.0.1
 */