package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;

final class j
  implements Runnable
{
  j(Context paramContext) {}
  
  public void run()
  {
    NetworkManager.getInstance(StatServiceImpl.e()).registerBroadcast();
    StatCommonHelper.getDiffTime(this.a, true);
    af.a(this.a);
    g.b(this.a);
    StatServiceImpl.a(Thread.getDefaultUncaughtExceptionHandler());
    if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH) {
      StatServiceImpl.commitEvents(this.a, -1);
    }
    if (StatConfig.isDebugEnable()) {
      StatServiceImpl.f().d("Init MTA StatService success, sdk version:2.2.4");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.j
 * JD-Core Version:    0.7.0.1
 */