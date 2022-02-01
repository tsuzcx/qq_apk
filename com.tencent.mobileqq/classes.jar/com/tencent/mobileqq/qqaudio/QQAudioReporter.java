package com.tencent.mobileqq.qqaudio;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Random;

public class QQAudioReporter
{
  private static Random a;
  public static boolean a;
  public static boolean b;
  private static boolean c = false;
  private static boolean d = false;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    b = false;
    jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static void a(int paramInt)
  {
    if (!d)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_type", paramInt + "");
      localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
      localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actRPPttPlayerType", true, 0L, 0L, localHashMap, "");
      d = true;
    }
  }
  
  public static void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    HashMap localHashMap;
    if (Math.abs(jdField_a_of_type_JavaUtilRandom.nextInt() % 100) < 10)
    {
      int i = QQAudioSystemInfo.d();
      int j = QQAudioSystemInfo.c();
      long l1 = QQAudioSystemInfo.c();
      long l2 = DeviceInfoUtil.a() / 1048576L;
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
    for (boolean bool = b;; bool = jdField_a_of_type_Boolean)
    {
      localHashMap.put("v7so", String.valueOf(bool));
      localHashMap.put("type", String.valueOf(paramInt2));
      localHashMap.put("maxFrameCost", String.valueOf(paramLong2));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttProcessFrameCost", true, paramLong1, paramInt1, localHashMap, "");
      return;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    HashMap localHashMap;
    if (!c)
    {
      localHashMap = new HashMap();
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
      localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actRPSonicSoLoadStatus", true, 0L, 0L, localHashMap, "");
      c = true;
      return;
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttSoUpdate", false, 0L, 0L, paramString, "");
      return;
      jdField_a_of_type_Boolean = false;
      continue;
      if (paramBoolean)
      {
        b = true;
        i = 2;
      }
      else
      {
        i = 3;
        b = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.QQAudioReporter
 * JD-Core Version:    0.7.0.1
 */