package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import java.util.Map;

final class w
  implements Runnable
{
  w(String paramString, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      synchronized ()
      {
        if (StatServiceImpl.h().size() >= StatConfig.getMaxParallelTimmingEvents())
        {
          StatServiceImpl.f().error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
          return;
        }
        StatServiceImpl.b(this.a);
        if (StatServiceImpl.h().containsKey(StatServiceImpl.i()))
        {
          StatServiceImpl.f().e("Duplicate PageID : " + StatServiceImpl.i() + ", onResume() repeated?");
          return;
        }
      }
      StatServiceImpl.h().put(StatServiceImpl.i(), Long.valueOf(System.currentTimeMillis()));
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      StatServiceImpl.a(this.b, localThrowable);
      return;
    }
    StatServiceImpl.a(this.b, true, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.w
 * JD-Core Version:    0.7.0.1
 */