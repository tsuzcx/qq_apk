package com.tencent.mobileqq.msf.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
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
  public static a.a r;
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
    J = BaseApplication.getContext().getSharedPreferences(k.c, 0);
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
      r = new a.a();
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
    a("reportAndClear");
    HashMap localHashMap = new HashMap(32);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(d);
    localHashMap.put("system_boot_time", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b);
    localHashMap.put("beginTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c);
    localHashMap.put("endTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(g);
    localHashMap.put("noNetAlive", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(h);
    localHashMap.put("noNetExist", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    localHashMap.put("notConnectedAlive", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(j);
    localHashMap.put("notConnectedExist", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(k);
    localHashMap.put("offlineAlive", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l);
    localHashMap.put("offlineExist", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(m);
    localHashMap.put("aliveTimeOff", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(n);
    localHashMap.put("existTimeOff", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(o);
    localHashMap.put("notExitTimeOff", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(p);
    localHashMap.put("lastAliveOf", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(k.g);
    localHashMap.put("jobschedulerAB", localStringBuilder.toString());
    if (d > 0L)
    {
      long l1 = b;
      if (l1 > 0L)
      {
        long l2 = c;
        if ((l2 > 0L) && (e >= 0L) && (m >= 0L) && (l2 > l1))
        {
          if (paramj != null)
          {
            boolean bool;
            if (l2 - l1 > 0L) {
              bool = true;
            } else {
              bool = false;
            }
            paramj.a("msfAliveTime_new", bool, f, e, localHashMap, false, false);
          }
          try
          {
            if ((MsfCore.sCore == null) || (!MsfService.core.sender.b.l().c())) {
              break label749;
            }
            com.tencent.mobileqq.msf.core.d.a.a(MsfCore.sCore, "alive_rate", "", "", "", 1, "", String.valueOf(c - b), String.valueOf(n), "", "", "", "", "");
          }
          catch (Exception paramj)
          {
            paramj.printStackTrace();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(k.c, 1, "report failed");
    }
    label749:
    b();
  }
  
  public static void c()
  {
    s = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.a
 * JD-Core Version:    0.7.0.1
 */