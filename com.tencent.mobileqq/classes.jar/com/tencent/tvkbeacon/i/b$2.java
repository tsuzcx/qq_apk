package com.tencent.tvkbeacon.i;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.tvkbeacon.core.c.c;
import java.util.concurrent.atomic.AtomicLong;

final class b$2
  implements Runnable
{
  private volatile long a = 0L;
  private volatile long b = 0L;
  
  b$2(b paramb) {}
  
  public final void run()
  {
    synchronized (this.c)
    {
      long l1 = b.a(this.c).get();
      long l2 = b.b(this.c).get();
      if ((this.a == l1) && (this.b == l2)) {
        return;
      }
      this.a = l1;
      this.b = l2;
      b.a(this.c, b.c(this.c)).edit().putString("on_ua_date", b.d(this.c)).putLong(b.c(), this.a).putLong(b.b(), this.b).apply();
      c.b("[stat] write serial to sp, date: %s ,realtime: %d, normalesn: %d", new Object[] { b.d(this.c), Long.valueOf(this.a), Long.valueOf(this.b) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.i.b.2
 * JD-Core Version:    0.7.0.1
 */