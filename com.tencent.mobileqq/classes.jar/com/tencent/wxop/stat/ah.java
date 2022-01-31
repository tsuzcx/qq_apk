package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.e;
import com.tencent.wxop.stat.event.j;
import java.util.Map;

final class ah
  implements Runnable
{
  ah(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      StatServiceImpl.flushDataToDB(this.a);
      synchronized (StatServiceImpl.h())
      {
        Object localObject2 = (Long)StatServiceImpl.h().remove(this.b);
        if (localObject2 != null)
        {
          localObject2 = Long.valueOf((System.currentTimeMillis() - ((Long)localObject2).longValue()) / 1000L);
          ??? = localObject2;
          if (((Long)localObject2).longValue() <= 0L) {
            ??? = Long.valueOf(1L);
          }
          String str = StatServiceImpl.j();
          localObject2 = str;
          if (str != null)
          {
            localObject2 = str;
            if (str.equals(this.b) == true) {
              localObject2 = "-";
            }
          }
          ??? = new j(this.a, (String)localObject2, this.b, StatServiceImpl.a(this.a, false, this.c), (Long)???, this.c);
          if (!this.b.equals(StatServiceImpl.i())) {
            StatServiceImpl.f().warn("Invalid invocation since previous onResume on diff page.");
          }
          new aq((e)???).a();
          StatServiceImpl.c(this.b);
          return;
        }
      }
      StatServiceImpl.f().e("Starttime for PageID:" + this.b + " not found, lost onResume()?");
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      StatServiceImpl.a(this.a, localThrowable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.ah
 * JD-Core Version:    0.7.0.1
 */