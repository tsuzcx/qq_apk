package com.tencent.tvkbeacon.core.strategy;

import android.content.Context;
import com.tencent.tvkbeacon.core.a.a.c;
import com.tencent.tvkbeacon.core.c.a;
import java.util.Date;

final class d$2
  implements Runnable
{
  d$2(d paramd, String paramString1, String paramString2, Context paramContext) {}
  
  public final void run()
  {
    String str = this.a;
    try
    {
      l1 = a.a(this.b).getTime() / 1000L;
      long l2 = l1;
      if (l1 == 0L) {
        l2 = new Date().getTime() / 1000L + 86400L;
      }
      c.a(this.c, "sid", new Object[] { str, Long.valueOf(l2) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.strategy.d.2
 * JD-Core Version:    0.7.0.1
 */