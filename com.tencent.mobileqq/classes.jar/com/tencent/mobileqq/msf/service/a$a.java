package com.tencent.mobileqq.msf.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;

public class a$a
  extends Thread
{
  private void a(long paramLong1, long paramLong2)
  {
    paramLong2 = paramLong1 - paramLong2;
    if ((paramLong2 > 0L) && (paramLong2 <= 39600000L)) {
      try
      {
        boolean bool1 = NetConnInfoCenter.isWifiOrMobileConn();
        boolean bool2 = MsfService.core.isOffline();
        boolean bool3 = MsfService.core.sender.b.l().c();
        if (!bool1)
        {
          a.g += 5000L;
          a.h += paramLong2;
        }
        if (!bool3)
        {
          a.i += 5000L;
          a.j += paramLong2;
        }
        if (bool2)
        {
          a.k += 5000L;
          a.l += paramLong2;
        }
        a.p = k.d;
        if (a.p)
        {
          a.e += 5000L;
          a.f += paramLong2;
        }
        else
        {
          a.m += 5000L;
          a.n += paramLong2;
        }
        a.c = paramLong1;
        a.a("writeDownOneDayEndAndTotalTime");
        SharedPreferences.Editor localEditor = a.d().edit();
        localEditor.putLong(a.h(), a.c);
        localEditor.putLong(a.i(), a.e);
        localEditor.putLong(a.j(), a.f);
        localEditor.putLong(a.k(), a.g);
        localEditor.putLong(a.l(), a.h);
        localEditor.putLong(a.m(), a.i);
        localEditor.putLong(a.n(), a.j);
        localEditor.putLong(a.o(), a.k);
        localEditor.putLong(a.p(), a.l);
        localEditor.putLong(a.q(), a.m);
        localEditor.putLong(a.r(), a.n);
        localEditor.putLong("k_not_exit_time_off", a.o);
        localEditor.putBoolean(a.q, a.p);
        localEditor.commit();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
    }
    a.b();
  }
  
  public void run()
  {
    while (a.s)
    {
      long l1 = System.currentTimeMillis();
      try
      {
        sleep(5000L);
        long l2 = System.currentTimeMillis();
        long l3 = k.b(l2);
        if ((a.d == 0L) && (l3 >= k.a))
        {
          a.d = System.currentTimeMillis() - SystemClock.elapsedRealtime();
          a.b = l1;
          SharedPreferences.Editor localEditor = a.d().edit();
          localEditor.putLong(a.e(), a.b);
          localEditor.putLong(a.f(), a.d);
          localEditor.commit();
        }
        if (a.d > 0L) {
          if (l3 <= k.b)
          {
            a(l2, l1);
          }
          else
          {
            a.b(a.g());
            return;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.a.a
 * JD-Core Version:    0.7.0.1
 */