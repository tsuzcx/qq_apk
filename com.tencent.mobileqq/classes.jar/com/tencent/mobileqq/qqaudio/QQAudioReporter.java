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
  public static boolean a = false;
  public static boolean b = false;
  private static boolean c = false;
  private static boolean d = false;
  
  static
  {
    jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static void a(int paramInt)
  {
    if (!d)
    {
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      localHashMap.put("param_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append("");
      localHashMap.put("param_version", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("_");
      localStringBuilder.append(Build.MODEL);
      localHashMap.put("param_deviceName", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actRPPttPlayerType", true, 0L, 0L, localHashMap, "");
      d = true;
    }
  }
  
  public static void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    if (Math.abs(jdField_a_of_type_JavaUtilRandom.nextInt() % 100) < 10)
    {
      int i = QQAudioSystemInfo.d();
      int j = QQAudioSystemInfo.c();
      long l1 = QQAudioSystemInfo.c();
      long l2 = DeviceInfoUtil.a() / 1048576L;
      HashMap localHashMap = new HashMap();
      localHashMap.put("cpuArch", String.valueOf(i));
      localHashMap.put("numCores", String.valueOf(j));
      localHashMap.put("maxFreq", String.valueOf(l1));
      localHashMap.put("memory", String.valueOf(l2));
      boolean bool;
      if (paramInt2 > 2) {
        bool = b;
      } else {
        bool = jdField_a_of_type_Boolean;
      }
      localHashMap.put("v7so", String.valueOf(bool));
      localHashMap.put("type", String.valueOf(paramInt2));
      localHashMap.put("maxFrameCost", String.valueOf(paramLong2));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttProcessFrameCost", true, paramLong1, paramInt1, localHashMap, "");
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!c)
    {
      HashMap localHashMap = new HashMap();
      if (paramBoolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("param_succ_flag", localObject);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject).append("");
      localHashMap.put("param_version", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(Build.MODEL);
      localHashMap.put("param_deviceName", ((StringBuilder)localObject).toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actRPSonicSoLoadStatus", true, 0L, 0L, localHashMap, "");
      c = true;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    boolean bool = paramString.equals("codecsilk");
    int i = 1;
    if (bool)
    {
      if (paramBoolean)
      {
        jdField_a_of_type_Boolean = true;
        i = 0;
      }
      else
      {
        jdField_a_of_type_Boolean = false;
      }
    }
    else if (paramBoolean)
    {
      b = true;
      i = 2;
    }
    else
    {
      i = 3;
      b = false;
    }
    paramString = new HashMap();
    paramString.put("param_FailCode", String.valueOf(i));
    paramString.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttSoUpdate", false, 0L, 0L, paramString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.QQAudioReporter
 * JD-Core Version:    0.7.0.1
 */