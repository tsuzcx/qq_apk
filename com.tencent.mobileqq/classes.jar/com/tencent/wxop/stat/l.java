package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

final class l
  implements Runnable
{
  l(Context paramContext) {}
  
  public final void run()
  {
    a.a(StatServiceImpl.e()).h();
    com.tencent.wxop.stat.common.l.a(this.a, true);
    au.a(this.a);
    i.b(this.a);
    StatServiceImpl.a(Thread.getDefaultUncaughtExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new ao());
    if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH) {
      StatServiceImpl.commitEvents(this.a, -1);
    }
    if (StatConfig.isDebugEnable()) {
      StatServiceImpl.f().d("Init MTA StatService success.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.l
 * JD-Core Version:    0.7.0.1
 */