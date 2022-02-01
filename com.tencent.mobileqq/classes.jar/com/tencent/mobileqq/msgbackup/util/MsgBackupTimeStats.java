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
  public static long a = 0L;
  public static String a = "MsgBackup_timeStats";
  private static ConcurrentHashMap<String, Long> a;
  public static boolean a = true;
  public static long b;
  private static ConcurrentHashMap<String, Long> b;
  public static boolean b;
  public static long c;
  private static ConcurrentHashMap<Long, Long> c;
  public static long d;
  public static long e;
  public static long f;
  public static long g;
  public static long h;
  public static long i;
  public static long j;
  public static long k;
  public static long l;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(10));
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
    d = 0L;
    jdField_b_of_type_Boolean = false;
    e = 0L;
    f = 0L;
    g = 0L;
    h = 0L;
    i = 0L;
    j = 0L;
    k = 0L;
    l = 0L;
    jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static void a()
  {
    MsgBackupReporter.a();
    MsgBackupReporter.a.jdField_a_of_type_Long = d;
    MsgBackupReporter.a.p = g;
    if (MsgBackupTransportProcessor.a().e() == 2) {
      MsgBackupReporter.a.q = e;
    } else {
      MsgBackupReporter.a.q = f;
    }
    Object localObject;
    if (d > 0L)
    {
      localObject = MsgBackupReporter.a;
      double d1 = jdField_c_of_type_Long;
      Double.isNaN(d1);
      double d2 = d;
      Double.isNaN(d2);
      ((MsgBackupReportData)localObject).jdField_a_of_type_Double = (d1 * 1000.0D / d2);
    }
    if (jdField_a_of_type_Boolean)
    {
      localObject = MsgBackupUtil.a(jdField_b_of_type_Long);
      String str1 = MsgBackupUtil.a(jdField_a_of_type_Long);
      if (d == 0L)
      {
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "transport speed error", new Object[0]);
        return;
      }
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "transport speed sSizeCache.size = %d, sLogs.size = %d", new Object[] { Integer.valueOf(jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size()), Integer.valueOf(jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
      long l1 = jdField_c_of_type_Long;
      long l2 = 1000L * l1 / d;
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "transport speed totalLength = %d B, totalElipse = %d ms", new Object[] { Long.valueOf(l1), Long.valueOf(d) });
      String str2 = MsgBackupUtil.a(l2);
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "transport speed max = %s, min = %s, average = %s", new Object[] { localObject, str1, str2 });
      if (MsgBackupTransportProcessor.a().e() == 2) {
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131706953), new Object[] { Long.valueOf(e) });
      }
    }
  }
  
  public static void a(long paramLong)
  {
    if (jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      Long localLong = (Long)jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localLong != null)
      {
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "transport complete complete = %d", new Object[] { localLong });
        jdField_c_of_type_Long += localLong.longValue();
      }
      jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    }
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
  
  public static void a(String paramString)
  {
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Boolean)
    {
      long l1 = SystemClock.uptimeMillis();
      if (paramString1 != null)
      {
        Long localLong = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
        if (localLong != null)
        {
          if (TextUtils.equals("total_transport_cost", paramString1)) {
            d = l1 - localLong.longValue();
          }
          if (TextUtils.equals("single_uin_cost", paramString1)) {
            e += l1 - localLong.longValue();
          }
          if (TextUtils.equals("total_daoru_cost", paramString1)) {
            f += l1 - localLong.longValue();
          }
          if (TextUtils.equals("cost_connect_total", paramString1)) {
            g += l1 - localLong.longValue();
          }
          String str;
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            str = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append(", cost=");
            localStringBuilder.append(l1 - localLong.longValue());
            QLog.i(str, 2, localStringBuilder.toString());
          }
          else
          {
            str = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append(", cost=");
            localStringBuilder.append(l1 - localLong.longValue());
            Log.i(str, localStringBuilder.toString());
          }
        }
      }
      if (paramString2 != null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, Long.valueOf(l1));
      }
    }
  }
  
  public static void b()
  {
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "transport reset", new Object[0]);
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Long = 0L;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public static void b(long paramLong1, long paramLong2)
  {
    if (!jdField_b_of_type_Boolean)
    {
      jdField_a_of_type_Long = paramLong2;
      jdField_b_of_type_Boolean = true;
    }
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "transport increment = %d sMaxSpeed = %d, sMinSpeed = %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(jdField_b_of_type_Long), Long.valueOf(jdField_a_of_type_Long) });
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "transport storeSpeed increment = %s", new Object[] { MsgBackupUtil.a(paramLong2) });
    if (paramLong2 >= jdField_b_of_type_Long) {
      jdField_b_of_type_Long = paramLong2;
    }
    if (paramLong2 <= jdField_a_of_type_Long) {
      jdField_a_of_type_Long = paramLong2;
    }
  }
  
  public static void c()
  {
    h = 0L;
    i = 0L;
    j = 0L;
    k = 0L;
    l = 0L;
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public static void d()
  {
    if ((jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_start")) && (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_end")))
    {
      long l1 = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_start")).longValue();
      h = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_end")).longValue() - l1;
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "pure qianchu time cost = %d,pb_pack cost time = %d ", new Object[] { Long.valueOf(h), Long.valueOf(i) });
    }
  }
  
  public static void e()
  {
    if ((jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_start")) && (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_end")))
    {
      long l1 = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_start")).longValue();
      long l2 = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_end")).longValue();
      l += l2 - l1;
    }
  }
  
  public static void f()
  {
    if ((jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_start")) && (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_end")))
    {
      long l1 = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_start")).longValue();
      j = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_end")).longValue() - l1;
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "pure qianru time cost = %d ", new Object[] { Long.valueOf(l) });
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "pure daoru time cost = %d,pb_unpack cost time = %d ", new Object[] { Long.valueOf(j), Long.valueOf(k) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats
 * JD-Core Version:    0.7.0.1
 */