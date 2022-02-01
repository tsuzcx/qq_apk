package com.tencent.mobileqq.statistics;

import android.content.Context;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class FightMsgReporter
{
  private static volatile int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = 0L;
  private static HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static volatile int jdField_b_of_type_Int;
  private static boolean jdField_b_of_type_Boolean = false;
  private static volatile int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean = true;
  private static volatile int d;
  private static volatile int e;
  private static volatile int f;
  private static volatile int g;
  private static volatile int h;
  private static volatile int i;
  private static volatile int j;
  private static volatile int k;
  private static volatile int l;
  
  private static long a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    paramString = a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramInt1, paramString, paramInt2);
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      paramLong = ((Long)jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
    }
    return paramLong;
  }
  
  private static String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return String.format("%d_%s_%d_%s", new Object[] { Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString1 });
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {
      c();
    }
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    if (System.currentTimeMillis() - jdField_a_of_type_Long > 86400000L)
    {
      if (jdField_c_of_type_Boolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("report.value:");
        localStringBuilder.append(String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(jdField_b_of_type_Boolean), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(e), Integer.valueOf(d), Integer.valueOf(h), Integer.valueOf(g), Integer.valueOf(k), Integer.valueOf(j), Long.valueOf(jdField_a_of_type_Long) }));
        QLog.d("FightMsgReporter", 1, localStringBuilder.toString());
      }
      ReportController.a(null, "dc00898", "", "", "0X800A95A", "0X800A95A", 0, jdField_b_of_type_Int, "", "", "", "");
      ReportController.a(null, "dc00898", "", "", "0X800A95A", "0X800A95A", 0, jdField_a_of_type_Int, "", "", "", "");
      int m = h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(k);
      ReportController.a(null, "dc00898", "", "", "0X800A95A", "0X800A95B", 0, m, localStringBuilder.toString(), "", "", "");
      m = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(j);
      ReportController.a(null, "dc00898", "", "", "0X800A95A", "0X800A95B", 0, m, localStringBuilder.toString(), "", "", "");
      jdField_b_of_type_Int = 0;
      jdField_a_of_type_Int = 0;
      jdField_c_of_type_Int = 0;
      e = 0;
      d = 0;
      f = 0;
      h = 0;
      g = 0;
      i = 0;
      k = 0;
      j = 0;
      l = 0;
      jdField_a_of_type_Long = System.currentTimeMillis();
      b();
    }
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return;
        }
        jdField_c_of_type_Int += paramInt2;
        return;
      }
      jdField_a_of_type_Int += paramInt2;
      return;
    }
    jdField_b_of_type_Int += paramInt2;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (jdField_b_of_type_Boolean)
    {
      if (!jdField_a_of_type_Boolean) {
        return;
      }
      int m;
      if (paramInt3 != 0)
      {
        if (paramInt3 != 1) {
          m = 2;
        } else {
          m = 1;
        }
      }
      else {
        m = 0;
      }
      if (paramInt1 == 0) {
        if (paramInt2 == 0) {
          b(m, paramInt4);
        } else if (paramInt2 == 1) {
          a(m, paramInt4);
        }
      }
      if (paramInt1 == 1) {
        if (paramInt2 == 0) {
          d(m, paramInt4);
        } else if (paramInt2 == 1) {
          c(m, paramInt4);
        }
      }
      if (jdField_c_of_type_Boolean)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add count = ");
        localStringBuilder.append(paramInt4);
        localStringBuilder.append(",uinType = ");
        localStringBuilder.append(paramInt3);
        QLog.d("FightMsgReporter", 1, localStringBuilder.toString());
      }
    }
  }
  
  private static void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramString = a(str, paramInt1, paramString, paramInt2);
    jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(paramLong));
    SharedPreUtils.a(localBaseApplication, "f_msg_report_preference", str, false, paramString, Long.valueOf(paramLong));
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2)
  {
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    if (!jdField_a_of_type_Boolean) {
      c();
    }
    long l1 = a(0, paramString, 1, paramLong2);
    int m = (int)(paramLong1 - Math.max(l1, paramLong2));
    a(0, 1, 1, m);
    a(0, paramString, 1, paramLong1);
    if (jdField_c_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("computeTroopMsgNew.value:");
      localStringBuilder.append(String.format("%s_%d_%d_%d_%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l1), Integer.valueOf(m) }));
      QLog.d("FightMsgReporter", 1, localStringBuilder.toString());
    }
  }
  
  public static void b()
  {
    if (jdField_b_of_type_Boolean)
    {
      if (!jdField_a_of_type_Boolean) {
        return;
      }
      Object localObject = BaseApplicationImpl.getContext();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_friend", Integer.valueOf(jdField_b_of_type_Int));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_troop", Integer.valueOf(jdField_a_of_type_Int));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_other", Integer.valueOf(jdField_c_of_type_Int));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_friend_aio", Integer.valueOf(e));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_troop_aio", Integer.valueOf(d));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_other_aio", Integer.valueOf(f));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_friend", Integer.valueOf(h));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_troop", Integer.valueOf(g));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_other", Integer.valueOf(i));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_friend_aio", Integer.valueOf(k));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_troop_aio", Integer.valueOf(j));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_other_aio", Integer.valueOf(l));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_report_time", Long.valueOf(jdField_a_of_type_Long));
      if (jdField_c_of_type_Boolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveToSp.value:");
        ((StringBuilder)localObject).append(String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(jdField_b_of_type_Boolean), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(e), Integer.valueOf(d), Integer.valueOf(h), Integer.valueOf(g), Integer.valueOf(k), Integer.valueOf(j), Long.valueOf(jdField_a_of_type_Long) }));
        QLog.d("FightMsgReporter", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return;
        }
        f += paramInt2;
        return;
      }
      d += paramInt2;
      return;
    }
    e += paramInt2;
  }
  
  private static void c()
  {
    Object localObject = (MsgReporterSwitchConfigProcessor.Config)QConfigManager.a().a(577);
    if (localObject != null) {
      jdField_b_of_type_Boolean = ((MsgReporterSwitchConfigProcessor.Config)localObject).jdField_a_of_type_Boolean;
    }
    localObject = BaseApplicationImpl.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    jdField_b_of_type_Int = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_friend", Integer.valueOf(0))).intValue();
    jdField_a_of_type_Int = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_troop", Integer.valueOf(0))).intValue();
    jdField_c_of_type_Int = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_other", Integer.valueOf(0))).intValue();
    e = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_friend_aio", Integer.valueOf(0))).intValue();
    d = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_troop_aio", Integer.valueOf(0))).intValue();
    f = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_other_aio", Integer.valueOf(0))).intValue();
    h = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_friend", Integer.valueOf(0))).intValue();
    g = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_troop", Integer.valueOf(0))).intValue();
    i = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_other", Integer.valueOf(0))).intValue();
    k = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_friend_aio", Integer.valueOf(0))).intValue();
    j = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_troop_aio", Integer.valueOf(0))).intValue();
    l = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_other_aio", Integer.valueOf(0))).intValue();
    jdField_a_of_type_Long = ((Long)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_report_time", Long.valueOf(System.currentTimeMillis()))).longValue();
    if (jdField_c_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init.value:");
      ((StringBuilder)localObject).append(String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(jdField_b_of_type_Boolean), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(e), Integer.valueOf(d), Integer.valueOf(h), Integer.valueOf(g), Integer.valueOf(k), Integer.valueOf(j), Long.valueOf(jdField_a_of_type_Long) }));
      QLog.d("FightMsgReporter", 1, ((StringBuilder)localObject).toString());
    }
    jdField_a_of_type_Boolean = true;
  }
  
  private static void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return;
        }
        i += paramInt2;
        return;
      }
      g += paramInt2;
      return;
    }
    h += paramInt2;
  }
  
  private static void d(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return;
        }
        l += paramInt2;
        return;
      }
      j += paramInt2;
      return;
    }
    k += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FightMsgReporter
 * JD-Core Version:    0.7.0.1
 */