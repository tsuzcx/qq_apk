package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.b;
import com.tencent.wxop.stat.event.c;

final class s
  implements Runnable
{
  s(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, c paramc) {}
  
  public final void run()
  {
    try
    {
      b localb = new b(this.a, StatServiceImpl.a(this.a, false, this.b), this.c.a, this.b);
      localb.b().b = this.c.b;
      new aq(localb).a();
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
 * Qualified Name:     com.tencent.wxop.stat.s
 * JD-Core Version:    0.7.0.1
 */