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
  private static volatile boolean a = false;
  private static long b;
  private static volatile int c;
  private static volatile int d;
  private static volatile int e;
  private static volatile int f;
  private static volatile int g;
  private static volatile int h;
  private static volatile int i;
  private static volatile int j;
  private static volatile int k;
  private static volatile int l;
  private static volatile int m;
  private static volatile int n;
  private static HashMap<String, Long> o = new HashMap();
  private static boolean p = false;
  private static boolean q = true;
  
  private static String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return String.format("%d_%s_%d_%s", new Object[] { Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString1 });
  }
  
  public static void a()
  {
    if (!a) {
      c();
    }
    if (!p) {
      return;
    }
    if (System.currentTimeMillis() - b > 86400000L)
    {
      if (q)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("report.value:");
        localStringBuilder.append(String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(p), Integer.valueOf(d), Integer.valueOf(c), Integer.valueOf(g), Integer.valueOf(f), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(l), Long.valueOf(b) }));
        QLog.d("FightMsgReporter", 1, localStringBuilder.toString());
      }
      ReportController.a(null, "dc00898", "", "", "0X800A95A", "0X800A95A", 0, d, "", "", "", "");
      ReportController.a(null, "dc00898", "", "", "0X800A95A", "0X800A95A", 0, c, "", "", "", "");
      int i1 = j;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(m);
      ReportController.a(null, "dc00898", "", "", "0X800A95A", "0X800A95B", 0, i1, localStringBuilder.toString(), "", "", "");
      i1 = i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l);
      ReportController.a(null, "dc00898", "", "", "0X800A95A", "0X800A95B", 0, i1, localStringBuilder.toString(), "", "", "");
      d = 0;
      c = 0;
      e = 0;
      g = 0;
      f = 0;
      h = 0;
      j = 0;
      i = 0;
      k = 0;
      m = 0;
      l = 0;
      n = 0;
      b = System.currentTimeMillis();
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
        e += paramInt2;
        return;
      }
      c += paramInt2;
      return;
    }
    d += paramInt2;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (p)
    {
      if (!a) {
        return;
      }
      int i1;
      if (paramInt3 != 0)
      {
        if (paramInt3 != 1) {
          i1 = 2;
        } else {
          i1 = 1;
        }
      }
      else {
        i1 = 0;
      }
      if (paramInt1 == 0) {
        if (paramInt2 == 0) {
          b(i1, paramInt4);
        } else if (paramInt2 == 1) {
          a(i1, paramInt4);
        }
      }
      if (paramInt1 == 1) {
        if (paramInt2 == 0) {
          d(i1, paramInt4);
        } else if (paramInt2 == 1) {
          c(i1, paramInt4);
        }
      }
      if (q)
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
    o.put(paramString, Long.valueOf(paramLong));
    SharedPreUtils.a(localBaseApplication, "f_msg_report_preference", str, false, paramString, Long.valueOf(paramLong));
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2)
  {
    if (!p) {
      return;
    }
    if (!a) {
      c();
    }
    long l1 = b(0, paramString, 1, paramLong2);
    int i1 = (int)(paramLong1 - Math.max(l1, paramLong2));
    a(0, 1, 1, i1);
    a(0, paramString, 1, paramLong1);
    if (q)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("computeTroopMsgNew.value:");
      localStringBuilder.append(String.format("%s_%d_%d_%d_%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l1), Integer.valueOf(i1) }));
      QLog.d("FightMsgReporter", 1, localStringBuilder.toString());
    }
  }
  
  private static long b(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    paramString = a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramInt1, paramString, paramInt2);
    if (o.containsKey(paramString)) {
      paramLong = ((Long)o.get(paramString)).longValue();
    }
    return paramLong;
  }
  
  public static void b()
  {
    if (p)
    {
      if (!a) {
        return;
      }
      Object localObject = BaseApplicationImpl.getContext();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_friend", Integer.valueOf(d));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_troop", Integer.valueOf(c));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_other", Integer.valueOf(e));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_friend_aio", Integer.valueOf(g));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_troop_aio", Integer.valueOf(f));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_other_aio", Integer.valueOf(h));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_friend", Integer.valueOf(j));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_troop", Integer.valueOf(i));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_other", Integer.valueOf(k));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_friend_aio", Integer.valueOf(m));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_troop_aio", Integer.valueOf(l));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_other_aio", Integer.valueOf(n));
      SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, false, "key_msg_report_time", Long.valueOf(b));
      if (q)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveToSp.value:");
        ((StringBuilder)localObject).append(String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(p), Integer.valueOf(d), Integer.valueOf(c), Integer.valueOf(g), Integer.valueOf(f), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(l), Long.valueOf(b) }));
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
        h += paramInt2;
        return;
      }
      f += paramInt2;
      return;
    }
    g += paramInt2;
  }
  
  private static void c()
  {
    Object localObject = (MsgReporterSwitchConfigProcessor.Config)QConfigManager.b().b(577);
    if (localObject != null) {
      p = ((MsgReporterSwitchConfigProcessor.Config)localObject).a;
    }
    localObject = BaseApplicationImpl.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    d = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_friend", Integer.valueOf(0))).intValue();
    c = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_troop", Integer.valueOf(0))).intValue();
    e = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_other", Integer.valueOf(0))).intValue();
    g = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_friend_aio", Integer.valueOf(0))).intValue();
    f = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_troop_aio", Integer.valueOf(0))).intValue();
    h = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_new_other_aio", Integer.valueOf(0))).intValue();
    j = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_friend", Integer.valueOf(0))).intValue();
    i = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_troop", Integer.valueOf(0))).intValue();
    k = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_other", Integer.valueOf(0))).intValue();
    m = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_friend_aio", Integer.valueOf(0))).intValue();
    l = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_troop_aio", Integer.valueOf(0))).intValue();
    n = ((Integer)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_funnel_report_readed_other_aio", Integer.valueOf(0))).intValue();
    b = ((Long)SharedPreUtils.a((Context)localObject, "f_msg_report_preference", str, "key_msg_report_time", Long.valueOf(System.currentTimeMillis()))).longValue();
    if (q)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init.value:");
      ((StringBuilder)localObject).append(String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(p), Integer.valueOf(d), Integer.valueOf(c), Integer.valueOf(g), Integer.valueOf(f), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(l), Long.valueOf(b) }));
      QLog.d("FightMsgReporter", 1, ((StringBuilder)localObject).toString());
    }
    a = true;
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
        k += paramInt2;
        return;
      }
      i += paramInt2;
      return;
    }
    j += paramInt2;
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
        n += paramInt2;
        return;
      }
      l += paramInt2;
      return;
    }
    m += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FightMsgReporter
 * JD-Core Version:    0.7.0.1
 */