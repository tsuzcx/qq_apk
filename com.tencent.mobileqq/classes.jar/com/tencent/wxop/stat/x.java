package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.b;
import com.tencent.wxop.stat.event.c;
import java.util.Map;

final class x
  implements Runnable
{
  x(String paramString, c paramc, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    for (;;)
    {
      Long localLong;
      try
      {
        if (StatServiceImpl.a(this.a))
        {
          StatServiceImpl.f().error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
          return;
        }
        localLong = (Long)StatServiceImpl.k().remove(this.b);
        if (localLong == null) {
          break;
        }
        b localb = new b(this.c, StatServiceImpl.a(this.c, false, this.d), this.b.a, this.d);
        localb.b().b = this.b.b;
        localLong = Long.valueOf((System.currentTimeMillis() - localLong.longValue()) / 1000L);
        if (localLong.longValue() == 0L)
        {
          l = 1L;
          localb.a(Long.valueOf(l).longValue());
          new aq(localb).a();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        StatServiceImpl.f().e(localThrowable);
        StatServiceImpl.a(this.c, localThrowable);
        return;
      }
      long l = localLong.longValue();
    }
    StatServiceImpl.f().error("No start time found for custom event: " + this.b.toString() + ", lost trackCustomBeginEvent()?");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.x
 * JD-Core Version:    0.7.0.1
 */