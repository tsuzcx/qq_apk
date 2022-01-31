package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.d;

final class p
  implements Runnable
{
  p(String paramString, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      if (StatServiceImpl.a(this.a))
      {
        StatServiceImpl.f().error("Error message in StatService.reportError() is empty.");
        return;
      }
      new aq(new d(this.b, StatServiceImpl.a(this.b, false, this.c), this.a, 0, StatConfig.getMaxReportEventLength(), null, this.c)).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      StatServiceImpl.a(this.b, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.p
 * JD-Core Version:    0.7.0.1
 */