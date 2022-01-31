package com.tencent.mobileqq.msf.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.af;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class a
{
  private static String A = "k_no_net_time";
  private static String B = "k_no_net_exist_time";
  private static String C = "k_not_connected_time";
  private static String D = "k_not_connected_exist_time";
  private static String E = "k_offline_time";
  private static String F = "k_offline_exist_time";
  private static String G = "k_alive_time_off";
  private static String H = "k_exist_time_off";
  private static final String I = "k_not_exit_time_off";
  private static SharedPreferences J;
  public static final long a = 5000L;
  public static long b = 0L;
  public static long c = 0L;
  public static long d = 0L;
  public static long e = 0L;
  public static long f = 0L;
  public static long g = 0L;
  public static long h = 0L;
  public static long i = 0L;
  public static long j = 0L;
  public static long k = 0L;
  public static long l = 0L;
  public static long m = 0L;
  public static long n = 0L;
  public static long o = 0L;
  public static boolean p = false;
  public static String q = "msf_last_keep_alive_state";
  public static a r;
  public static volatile boolean s = true;
  public static final long t = 39600000L;
  private static j u;
  private static String v = "k_begin_time";
  private static String w = "k_end_time";
  private static String x = "k_boot_time";
  private static String y = "k_alive_time";
  private static String z = "k_exist_time";
  
  public static void a()
  {
    J = BaseApplication.getContext().getSharedPreferences(e.c, 0);
    b = J.getLong(v, 0L);
    c = J.getLong(w, 0L);
    d = J.getLong(x, 0L);
    e = J.getLong(y, 0L);
    f = J.getLong(z, 0L);
    g = J.getLong(A, 0L);
    h = J.getLong(B, 0L);
    i = J.getLong(C, 0L);
    j = J.getLong(D, 0L);
    k = J.getLong(E, 0L);
    l = J.getLong(F, 0L);
    m = J.getLong(G, 0L);
    n = J.getLong(H, 0L);
    o = J.getLong("k_not_exit_time_off", 0L);
    p = J.getBoolean(q, false);
    a("initSavedData");
  }
  
  static void a(j paramj)
  {
    if (r == null)
    {
      u = paramj;
      r = new a();
      r.start();
    }
  }
  
  public static void a(String paramString) {}
  
  public static void b()
  {
    J.edit().clear();
    b = 0L;
    c = 0L;
    d = 0L;
    e = 0L;
    f = 0L;
    g = 0L;
    h = 0L;
    i = 0L;
    j = 0L;
    k = 0L;
    l = 0L;
    m = 0L;
    n = 0L;
    o = 0L;
    p = false;
  }
  
  public static void b(j paramj)
  {
    boolean bool = true;
    a("reportAndClear");
    HashMap localHashMap = new HashMap();
    localHashMap.put("system_boot_time", "" + d);
    localHashMap.put("beginTime", "" + b);
    localHashMap.put("endTime", "" + c);
    localHashMap.put("noNetAlive", "" + g);
    localHashMap.put("noNetExist", "" + h);
    localHashMap.put("notConnectedAlive", "" + i);
    localHashMap.put("notConnectedExist", "" + j);
    localHashMap.put("offlineAlive", "" + k);
    localHashMap.put("offlineExist", "" + l);
    localHashMap.put("aliveTimeOff", "" + m);
    localHashMap.put("existTimeOff", "" + n);
    localHashMap.put("notExitTimeOff", "" + o);
    localHashMap.put("lastAliveOf", "" + p);
    if ((paramj != null) && (d > 0L) && (b > 0L) && (c > 0L) && (e >= 0L) && (m >= 0L) && (c > b)) {
      if (c - b > 0L) {
        paramj.a("msfAliveTime_new", bool, f, e, localHashMap, false, false);
      }
    }
    for (;;)
    {
      b();
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        QLog.d(e.c, 1, "report failed");
      }
    }
  }
  
  public static void c()
  {
    s = false;
  }
  
  public static class a
    extends Thread
  {
    private void a(long paramLong1, long paramLong2)
    {
      paramLong2 = paramLong1 - paramLong2;
      if ((paramLong2 <= 0L) || (paramLong2 > 39600000L))
      {
        a.b();
        return;
      }
      for (;;)
      {
        try
        {
          boolean bool1 = NetConnInfoCenter.isWifiOrMobileConn();
          boolean bool2 = MsfService.core.isOffline();
          boolean bool3 = MsfService.core.sender.a.o().b();
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
          a.p = e.d;
          if (a.p)
          {
            a.e += 5000L;
            a.f = paramLong2 + a.f;
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
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return;
        }
        a.m += 5000L;
        a.n = paramLong2 + a.n;
      }
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
          long l3 = e.b(l2);
          if ((a.d == 0L) && (l3 >= e.a))
          {
            a.d = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            a.b = l1;
            SharedPreferences.Editor localEditor = a.d().edit();
            localEditor.putLong(a.e(), a.b);
            localEditor.putLong(a.f(), a.d);
            localEditor.commit();
          }
          if (a.d <= 0L) {
            continue;
          }
          if (l3 > e.b) {
            break label141;
          }
          a(l2, l1);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        continue;
        label141:
        a.b(a.g());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.a
 * JD-Core Version:    0.7.0.1
 */