package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.d;

final class r
  implements Runnable
{
  r(Throwable paramThrowable, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    if (this.a == null)
    {
      StatServiceImpl.f().error("The Throwable error message of StatService.reportException() can not be null!");
      return;
    }
    new aq(new d(this.b, StatServiceImpl.a(this.b, false, this.c), 1, this.a, this.c)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.r
 * JD-Core Version:    0.7.0.1
 */