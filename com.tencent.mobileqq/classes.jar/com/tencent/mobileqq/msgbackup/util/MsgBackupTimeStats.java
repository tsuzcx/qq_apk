package com.tencent.mobileqq.msgbackup.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MsgBackupTimeStats
{
  public static boolean a = true;
  public static String b = "MsgBackup_timeStats";
  public static long c = 0L;
  public static long d = 0L;
  public static long e = 0L;
  public static long f = 0L;
  public static boolean g = false;
  public static long h = 0L;
  public static long i = 0L;
  public static long j = 0L;
  public static long k = 0L;
  public static long l = 0L;
  public static long m = 0L;
  public static long n = 0L;
  public static long o = 0L;
  private static ConcurrentHashMap<String, Long> p = new ConcurrentHashMap(new HashMap(8));
  private static ConcurrentHashMap<String, Long> q = new ConcurrentHashMap(new HashMap(10));
  private static ConcurrentHashMap<Long, Long> r = new ConcurrentHashMap();
  
  public static void a()
  {
    MsgBackupReporter.a();
    MsgBackupReporter.a.e = f;
    MsgBackupReporter.a.w = j;
    if (MsgBackupTransportProcessor.a().i() == 2) {
      MsgBackupReporter.a.x = h;
    } else {
      MsgBackupReporter.a.x = i;
    }
    Object localObject;
    if (f > 0L)
    {
      localObject = MsgBackupReporter.a;
      double d1 = e;
      Double.isNaN(d1);
      double d2 = f;
      Double.isNaN(d2);
      ((MsgBackupReportData)localObject).f = (d1 * 1000.0D / d2);
    }
    if (a)
    {
      localObject = MsgBackupUtil.a(d);
      String str1 = MsgBackupUtil.a(c);
      if (f == 0L)
      {
        MsgBackupUtil.b(b, "transport speed error", new Object[0]);
        return;
      }
      MsgBackupUtil.b(b, "transport speed sSizeCache.size = %d, sLogs.size = %d", new Object[] { Integer.valueOf(r.size()), Integer.valueOf(p.size()) });
      long l1 = e;
      long l2 = 1000L * l1 / f;
      MsgBackupUtil.b(b, "transport speed totalLength = %d B, totalElipse = %d ms", new Object[] { Long.valueOf(l1), Long.valueOf(f) });
      String str2 = MsgBackupUtil.a(l2);
      MsgBackupUtil.b(b, "transport speed max = %s, min = %s, average = %s", new Object[] { localObject, str1, str2 });
      if (MsgBackupTransportProcessor.a().i() == 2) {
        MsgBackupUtil.b(b, HardCodeUtil.a(2131904796), new Object[] { Long.valueOf(h) });
      }
    }
  }
  
  public static void a(long paramLong)
  {
    if (r.containsKey(Long.valueOf(paramLong)))
    {
      Long localLong = (Long)r.get(Long.valueOf(paramLong));
      if (localLong != null)
      {
        MsgBackupUtil.b(b, "transport complete complete = %d", new Object[] { localLong });
        e += localLong.longValue();
      }
      r.remove(Long.valueOf(paramLong));
    }
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    r.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
  
  public static void a(String paramString)
  {
    q.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a)
    {
      long l1 = SystemClock.uptimeMillis();
      if (paramString1 != null)
      {
        Long localLong = (Long)p.remove(paramString1);
        if (localLong != null)
        {
          if (TextUtils.equals("total_transport_cost", paramString1)) {
            f = l1 - localLong.longValue();
          }
          if (TextUtils.equals("single_uin_cost", paramString1)) {
            h += l1 - localLong.longValue();
          }
          if (TextUtils.equals("total_daoru_cost", paramString1)) {
            i += l1 - localLong.longValue();
          }
          if (TextUtils.equals("cost_connect_total", paramString1)) {
            j += l1 - localLong.longValue();
          }
          String str;
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            str = b;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append(", cost=");
            localStringBuilder.append(l1 - localLong.longValue());
            QLog.i(str, 2, localStringBuilder.toString());
          }
          else
          {
            str = b;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append(", cost=");
            localStringBuilder.append(l1 - localLong.longValue());
            Log.i(str, localStringBuilder.toString());
          }
        }
      }
      if (paramString2 != null) {
        p.put(paramString2, Long.valueOf(l1));
      }
    }
  }
  
  public static void b()
  {
    MsgBackupUtil.b(b, "transport reset", new Object[0]);
    g = false;
    e = 0L;
    c = 0L;
    d = 0L;
    r.clear();
  }
  
  public static void b(long paramLong1, long paramLong2)
  {
    if (!g)
    {
      c = paramLong2;
      g = true;
    }
    MsgBackupUtil.b(b, "transport increment = %d sMaxSpeed = %d, sMinSpeed = %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(d), Long.valueOf(c) });
    MsgBackupUtil.b(b, "transport storeSpeed increment = %s", new Object[] { MsgBackupUtil.a(paramLong2) });
    if (paramLong2 >= d) {
      d = paramLong2;
    }
    if (paramLong2 <= c) {
      c = paramLong2;
    }
  }
  
  public static void c()
  {
    k = 0L;
    l = 0L;
    m = 0L;
    n = 0L;
    o = 0L;
    q.clear();
  }
  
  public static void d()
  {
    if ((q.containsKey("statis_qianchums_start")) && (q.containsKey("statis_qianchums_end")))
    {
      long l1 = ((Long)q.get("statis_qianchums_start")).longValue();
      k = ((Long)q.get("statis_qianchums_end")).longValue() - l1;
      MsgBackupUtil.b(b, "pure qianchu time cost = %d,pb_pack cost time = %d ", new Object[] { Long.valueOf(k), Long.valueOf(l) });
    }
  }
  
  public static void e()
  {
    if ((q.containsKey("statis_qianchums_start")) && (q.containsKey("statis_qianchums_end")))
    {
      long l1 = ((Long)q.get("statis_qianchums_start")).longValue();
      long l2 = ((Long)q.get("statis_qianchums_end")).longValue();
      o += l2 - l1;
    }
  }
  
  public static void f()
  {
    if ((q.containsKey("statis_qianchums_start")) && (q.containsKey("statis_qianchums_end")))
    {
      long l1 = ((Long)q.get("statis_qianchums_start")).longValue();
      m = ((Long)q.get("statis_qianchums_end")).longValue() - l1;
      MsgBackupUtil.b(b, "pure qianru time cost = %d ", new Object[] { Long.valueOf(o) });
      MsgBackupUtil.b(b, "pure daoru time cost = %d,pb_unpack cost time = %d ", new Object[] { Long.valueOf(m), Long.valueOf(n) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats
 * JD-Core Version:    0.7.0.1
 */