package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class PttInfoCollector
{
  static int jdField_a_of_type_Int;
  public static long a;
  static PhantomReference jdField_a_of_type_JavaLangRefPhantomReference;
  static ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  public static ConcurrentHashMap a;
  public static boolean a;
  static int jdField_b_of_type_Int;
  static long jdField_b_of_type_Long;
  public static boolean b;
  static int jdField_c_of_type_Int;
  static long jdField_c_of_type_Long;
  static boolean jdField_c_of_type_Boolean;
  static long d;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static final int a(int paramInt1, int paramInt2)
  {
    return (paramInt2 & 0xF) + paramInt1 * 100;
  }
  
  public static void a()
  {
    int i = VcSystemInfo.f();
    int j = VcSystemInfo.e();
    long l1 = VcSystemInfo.c();
    long l2 = DeviceInfoUtil.e() / 1048576L;
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("cpuArch", String.valueOf(i));
    localHashMap.put("numCores", String.valueOf(j));
    localHashMap.put("maxFreq", String.valueOf(l1));
    localHashMap.put("memory", String.valueOf(l2));
    localHashMap.put("param_FailCode", String.valueOf(i));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttCpuArch", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttLongPressFate2", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    if (jdField_b_of_type_Int != 0) {}
    for (long l1 = jdField_c_of_type_Long / jdField_b_of_type_Int;; l1 = 0L)
    {
      if (jdField_c_of_type_Int != 0) {}
      for (long l2 = d / jdField_c_of_type_Int;; l2 = 0L)
      {
        localHashMap.put("consumePerFrame", String.valueOf(l1));
        localHashMap.put("releasePerGc", String.valueOf(l2));
        localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        if (QLog.isColorLevel())
        {
          QLog.e("PttInfoCollector", 2, "reportSoundProcessCost gcCount=" + jdField_a_of_type_Int + " type=" + paramInt1 + " time" + paramInt2);
          QLog.e("PttInfoCollector", 2, "reportSoundProcessCost consume=" + l1 + " release=" + l2);
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttGcCount", true, paramInt2, jdField_a_of_type_Int, localHashMap, "");
        jdField_a_of_type_Int = 0;
        jdField_c_of_type_Boolean = false;
        jdField_a_of_type_JavaLangRefReferenceQueue.poll();
        jdField_b_of_type_Long = 0L;
        jdField_c_of_type_Long = 0L;
        d = 0L;
        jdField_b_of_type_Int = 0;
        jdField_c_of_type_Int = 0;
        return;
      }
    }
  }
  
  public static void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    HashMap localHashMap;
    if (Math.abs(jdField_a_of_type_JavaUtilRandom.nextInt() % 100) < 10)
    {
      int i = VcSystemInfo.f();
      int j = VcSystemInfo.e();
      long l1 = VcSystemInfo.c();
      long l2 = DeviceInfoUtil.e() / 1048576L;
      localHashMap = new HashMap();
      localHashMap.put("cpuArch", String.valueOf(i));
      localHashMap.put("numCores", String.valueOf(j));
      localHashMap.put("maxFreq", String.valueOf(l1));
      localHashMap.put("memory", String.valueOf(l2));
      if (paramInt2 <= 2) {
        break label172;
      }
    }
    label172:
    for (boolean bool = jdField_b_of_type_Boolean;; bool = jdField_a_of_type_Boolean)
    {
      localHashMap.put("v7so", String.valueOf(bool));
      localHashMap.put("type", String.valueOf(paramInt2));
      localHashMap.put("maxFrameCost", String.valueOf(paramLong2));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttProcessFrameCost", true, paramLong1, paramInt1, localHashMap, "");
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80059B1", "0X80059B1", paramInt, 0, "", "", "", "7.6.3");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      paramInt1 = 9999;
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1D", "0X8005C1D", paramInt1, paramInt2, "", "", "", "7.6.3");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 1;
    if (!(paramMessageRecord instanceof MessageForPtt)) {}
    for (;;)
    {
      return;
      if (paramMessageRecord.getPttStreamFlag() != 10001)
      {
        if (!paramMessageRecord.isSend()) {
          break;
        }
        if (((MessageForPtt)paramMessageRecord).voiceChangeFlag == 1) {}
        while ((i != 0) && (paramInt == 1001))
        {
          a(paramQQAppInterface, 4);
          return;
          i = 0;
        }
      }
    }
    switch (paramInt)
    {
    case 2002: 
    case 2004: 
    default: 
      return;
    case 2001: 
      a(paramQQAppInterface, 2);
      return;
    case 2003: 
      a(paramQQAppInterface, 1);
      return;
    }
    a(paramQQAppInterface, 3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1C", "0X8005C1C", i * 10 + paramInt1 * 100 + paramInt2, 0, "", "", "", "7.6.3");
      return;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        localObject = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if ((localObject == null) || (((Long)localObject).longValue() <= 0L)) {
          continue;
        }
        if (!paramBoolean1) {
          continue;
        }
        str = "pttSendTotalCost";
      }
      catch (Exception paramString)
      {
        Object localObject;
        String str;
        long l1;
        long l2;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("PttInfoCollector", 2, "report sendcost error" + paramString);
        return;
        if (!paramBoolean1) {
          continue;
        }
        continue;
      }
      l1 = SystemClock.uptimeMillis();
      l2 = ((Long)localObject).longValue();
      localObject = new HashMap();
      ((HashMap)localObject).put("isVoiceChange", String.valueOf(paramInt));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, paramBoolean2, l1 - l2, paramLong, (HashMap)localObject, "");
      if ((!paramBoolean1) || (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
        return;
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return;
      str = "offlinePttHandleCost";
      continue;
      paramBoolean2 = true;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttDownloadStream2Offline", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == 1000L) || (paramLong1 == 1001L) || (paramLong1 == 10002L) || (paramLong1 == 10004L) || (paramLong1 == 1002L) || (paramLong1 == 1003L) || (paramLong1 == 1004L) || (paramLong1 == 1005L) || (paramLong1 == 1006L) || (paramLong1 == 1008L) || (paramLong1 == 1009L) || (paramLong1 == 1010L) || (paramLong1 == 1011L) || (paramLong1 == 1020L) || (paramLong1 == 1021L) || (paramLong1 == 1022L) || (paramLong1 == 1029L) || (paramLong1 == 1023L) || (paramLong1 == 1024L) || (paramLong1 == 1025L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramLong1));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actAllC2CPttUp", paramBoolean, paramLong2, paramLong3, localHashMap, "");
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    int i = 1;
    if (paramString.equals("codecsilk")) {
      if (paramBoolean)
      {
        jdField_a_of_type_Boolean = true;
        i = 0;
      }
    }
    for (;;)
    {
      paramString = new HashMap();
      paramString.put("param_FailCode", String.valueOf(i));
      paramString.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttSoUpdate", false, 0L, 0L, paramString, "");
      return;
      jdField_a_of_type_Boolean = false;
      continue;
      if (paramBoolean)
      {
        jdField_b_of_type_Boolean = true;
        i = 2;
      }
      else
      {
        i = 3;
        jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public static void b()
  {
    c();
    d();
  }
  
  public static void b(int paramInt)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    long l = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
    if (l > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localStatisticCollector.a("", "PTTCostUntilPrepare", true, l, paramInt, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.d("PttInfoCollector", 2, "COST : " + l + " from : " + paramInt);
      }
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttNoRangeFailed", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  private static void c()
  {
    if (jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null)
    {
      jdField_a_of_type_Int += 1;
      jdField_c_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.e("PttInfoCollector", 2, "gc occurred:" + jdField_a_of_type_Int);
      }
    }
    if (!jdField_c_of_type_Boolean)
    {
      jdField_a_of_type_JavaLangRefPhantomReference = new PhantomReference(new Object(), jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.e("PttInfoCollector", 2, "add object enqueue to detect gc");
      }
    }
  }
  
  public static void c(int paramInt)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localStatisticCollector.a("", "PTTStraightRecordCount", false, 0L, 0L, localHashMap, "");
    if (QLog.isDevelopLevel()) {
      QLog.d("PttInfoCollector", 4, "pttStraightRecordCount " + paramInt);
    }
  }
  
  private static void d()
  {
    try
    {
      Runtime localRuntime = Runtime.getRuntime();
      long l1 = localRuntime.freeMemory();
      long l2 = localRuntime.totalMemory();
      if (jdField_b_of_type_Long != 0L)
      {
        if (l2 - l1 <= jdField_b_of_type_Long) {
          break label64;
        }
        jdField_c_of_type_Long += l2 - l1 - jdField_b_of_type_Long;
        jdField_b_of_type_Int += 1;
      }
      for (;;)
      {
        jdField_b_of_type_Long = l2 - l1;
        return;
        label64:
        d += jdField_b_of_type_Long - (l2 - l1);
        jdField_c_of_type_Int += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PttInfoCollector
 * JD-Core Version:    0.7.0.1
 */