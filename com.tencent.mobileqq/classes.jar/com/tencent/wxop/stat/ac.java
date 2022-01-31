package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.b;
import com.tencent.wxop.stat.event.c;

final class ac
  implements Runnable
{
  ac(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, c paramc, int paramInt) {}
  
  public final void run()
  {
    try
    {
      b localb = new b(this.a, StatServiceImpl.a(this.a, false, this.b), this.c.a, this.b);
      localb.b().c = this.c.c;
      Long localLong = Long.valueOf(this.d);
      if (localLong.longValue() <= 0L) {}
      for (long l = 1L;; l = localLong.longValue())
      {
        localb.a(Long.valueOf(l).longValue());
        new aq(localb).a();
        return;
      }
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
 * Qualified Name:     com.tencent.wxop.stat.ac
 * JD-Core Version:    0.7.0.1
 */