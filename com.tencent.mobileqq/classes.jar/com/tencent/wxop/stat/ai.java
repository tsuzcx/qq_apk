package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

final class ai
  implements Runnable
{
  ai(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      StatServiceImpl.stopSession();
      StatServiceImpl.a(this.a, true, this.b);
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
 * Qualified Name:     com.tencent.wxop.stat.ai
 * JD-Core Version:    0.7.0.1
 */