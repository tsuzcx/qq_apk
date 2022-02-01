package com.tencent.mobileqq.flutter.report;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.flutter.config.QFlutterDPC;
import com.tencent.mobileqq.flutter.launch.LaunchTrace;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class QFlutterReporter
{
  private static String a = "local-version";
  
  private static long a(String paramString, Map<String, Integer> paramMap1, Map<String, Integer> paramMap2)
  {
    if (paramMap1 != null)
    {
      if (paramMap2 == null) {
        return 0L;
      }
      if ((paramMap1.containsKey(paramString)) && (paramMap2.containsKey(paramString)))
      {
        long l = ((Integer)paramMap1.get(paramString)).intValue();
        return ((Integer)paramMap2.get(paramString)).intValue() - l;
      }
      QLog.d("QFlutter.Reporter", 1, String.format("%s not contains", new Object[] { paramString }));
    }
    return 0L;
  }
  
  public static String a()
  {
    return a;
  }
  
  private static HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qflutterVersion", a);
    return localHashMap;
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (a())
    {
      HashMap localHashMap = a();
      localHashMap.put("errCode", String.valueOf(paramInt));
      localHashMap.put("launchCost", String.valueOf(paramLong1));
      localHashMap.put("installCost", String.valueOf(paramLong2));
      localHashMap.put("loadAssetCost", String.valueOf(paramLong3));
      localHashMap.put("loadEngineCost", String.valueOf(paramLong4));
      String str2 = "1";
      String str1;
      if (paramBoolean1) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      localHashMap.put("isPreloadProcess", str1);
      if (paramBoolean2) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      localHashMap.put("isLocalEngineExist", str1);
      if (paramBoolean3) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      localHashMap.put("isLocalAppExist", str1);
      if ((!paramBoolean3) && (!paramBoolean2)) {
        str1 = "0";
      } else {
        str1 = "1";
      }
      localHashMap.put("isLocalExist", str1);
      if (paramBoolean4) {
        str1 = str2;
      } else {
        str1 = "0";
      }
      localHashMap.put("isQuickInstall", str1);
      localHashMap.put("flutterUin", b());
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_launch_result_v2", true, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.Reporter", 2, String.format("reportLaunchResult, errCode: %s, launchCost: %s, installCost: %s,loadAssetCost: %s, loadEngineCost: %s, isPreloadProcess: %s, isLocalEngineExist: %s, isLocalAppExist: %s, isQuickInstall: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }));
      }
    }
  }
  
  public static void a(String paramString)
  {
    a = paramString;
  }
  
  public static void a(String paramString, int paramInt, double paramDouble)
  {
    if (a())
    {
      HashMap localHashMap = a();
      localHashMap.put("pagePath", paramString);
      localHashMap.put("fps", String.valueOf(paramInt));
      localHashMap.put("dropRate", String.valueOf(paramDouble));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_fps", true, 0L, 0L, localHashMap, "", false);
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (a())
    {
      HashMap localHashMap = a();
      localHashMap.put("pagePath", paramString);
      localHashMap.put("cost", String.valueOf(paramLong));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_page_render_cost", true, 0L, 0L, localHashMap, "", false);
    }
  }
  
  public static void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (!a()) {
      return;
    }
    HashMap localHashMap = a();
    String str2 = "1";
    String str1;
    if (paramBoolean1) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("errCode", str1);
    localHashMap.put("cost", String.valueOf(paramLong));
    if (paramBoolean2) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("isLocalEngineExist", str1);
    if (paramBoolean3) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localHashMap.put("isLocalAppExist", str1);
    localHashMap.put("downloadType", paramString);
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_download_cost", true, 0L, 0L, localHashMap, "", false);
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 1, String.format("reportDownloadCost: %s", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, LaunchTrace paramLaunchTrace, String paramString)
  {
    boolean bool2 = true;
    if ((paramBoolean2) && (paramLaunchTrace == null))
    {
      QLog.d("QFlutter.Reporter", 1, "is first launch but trace is null");
      return;
    }
    HashMap localHashMap = a();
    if (TextUtils.isEmpty(paramString)) {
      paramString = "unknown";
    }
    localHashMap.put("pageUrl", paramString);
    if (paramBoolean1) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("isPreloadProcess", str);
    if (paramBoolean2) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("isFirstLaunch", str);
    boolean bool1 = bool2;
    if (paramLaunchTrace != null) {
      if (paramLaunchTrace.a()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    if (bool1) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("isLocalResExist", str);
    long l4 = paramLong4 - paramLong1;
    long l5 = paramLong2 - paramLong1;
    long l6 = paramLong3 - paramLong2;
    long l1;
    long l2;
    if (paramLaunchTrace != null)
    {
      paramLong1 = paramLaunchTrace.jdField_a_of_type_Long;
      bool2 = paramLaunchTrace.jdField_a_of_type_Boolean;
      paramLong2 = paramLaunchTrace.b;
      l1 = paramLaunchTrace.d;
      l2 = paramLaunchTrace.e - paramLong1 - paramLong2 - l1;
    }
    else
    {
      long l3 = 0L;
      paramLong1 = l3;
      paramLong2 = paramLong1;
      l2 = paramLong2;
      bool2 = false;
      l1 = paramLong2;
      paramLong2 = paramLong1;
      paramLong1 = l3;
    }
    String str = paramString;
    paramLong3 = paramLong4 - paramLong3;
    localHashMap.put("totalCost", String.valueOf(l4));
    localHashMap.put("loadProcessCost", String.valueOf(l5));
    localHashMap.put("launchCost", String.valueOf(l6));
    localHashMap.put("installCost", String.valueOf(paramLong1));
    localHashMap.put("loadAssetCost", String.valueOf(paramLong2));
    localHashMap.put("loadEngineCost", String.valueOf(l1));
    localHashMap.put("otherCost", String.valueOf(l2));
    localHashMap.put("openPageCost", String.valueOf(paramLong3));
    localHashMap.put("flutterUin", b());
    localHashMap.put("pageUrl", str);
    if (bool2) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    localHashMap.put("isQuickInstall", paramString);
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_first_frame", true, 0L, 0L, localHashMap, "", false);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("reportFirstFrameCost,isPreloadProcess: ");
      paramString.append(paramBoolean1);
      paramString.append(",isFirstLaunch: ");
      paramString.append(paramBoolean2);
      paramString.append(",isLocalResExist: ");
      paramString.append(bool1);
      paramString.append(",totalCost: ");
      paramString.append(l4);
      paramString.append(",loadProcessCost: ");
      paramString.append(l5);
      paramString.append(",launchCost: ");
      paramString.append(l6);
      paramString.append(",installCost: ");
      paramString.append(paramLong1);
      paramString.append(",loadAssetCost: ");
      paramString.append(paramLong2);
      paramString.append(",loadEngineCost: ");
      paramString.append(l1);
      paramString.append(",otherCost: ");
      paramString.append(l2);
      paramString.append(",openPageCost: ");
      paramString.append(paramLong3);
      paramString.append(",setupEngineCost: ");
      paramString.append(paramLong5);
      paramString.append(",isQuickInstall: ");
      paramString.append(bool2);
      paramString.append(",openUrl: ");
      paramString.append(str);
      QLog.d("QFlutter.Reporter", 2, paramString.toString());
      paramString = new StringBuilder();
      paramString.append("reportFirstFrameCost: launchTrace.launchCost ");
      if (paramLaunchTrace != null) {
        paramLong1 = paramLaunchTrace.e;
      } else {
        paramLong1 = 0L;
      }
      paramString.append(paramLong1);
      QLog.d("QFlutter.Reporter", 2, paramString.toString());
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Map<String, Integer> paramMap, String paramString)
  {
    if ((a()) && (paramMap != null))
    {
      int i = Build.VERSION.SDK_INT;
      long l1 = DeviceInfoUtil.a() / 1024L / 1024L;
      float f = (float)Runtime.getRuntime().maxMemory() / 1024.0F / 1024.0F;
      Object localObject = DeviceInfoUtil.a(BaseApplicationImpl.getContext());
      long l2 = a("summary.total-pss", paramMap, (Map)localObject);
      long l3 = a("summary.java-heap", paramMap, (Map)localObject);
      long l4 = a("summary.native-heap", paramMap, (Map)localObject);
      long l5 = a("summary.graphics", paramMap, (Map)localObject);
      long l6 = a("summary.code", paramMap, (Map)localObject);
      long l7 = a("summary.private-other", paramMap, (Map)localObject);
      localObject = DeviceInfoUtil.l();
      HashMap localHashMap = a();
      if (paramBoolean1) {
        paramMap = "1";
      } else {
        paramMap = "0";
      }
      localHashMap.put("isFirstLoad", paramMap);
      localHashMap.put("sdkVersion", String.valueOf(i));
      localHashMap.put("resolution", localObject);
      localHashMap.put("totalMemory", String.valueOf(l1));
      localHashMap.put("maxMemory", String.valueOf(f));
      localHashMap.put("totalPss", String.valueOf(l2));
      localHashMap.put("javaPss", String.valueOf(l3));
      localHashMap.put("nativePss", String.valueOf(l4));
      localHashMap.put("graphicsPss", String.valueOf(l5));
      localHashMap.put("codePss", String.valueOf(l6));
      localHashMap.put("otherPss", String.valueOf(l7));
      localHashMap.put("pageUrl", paramString);
      if (paramBoolean2)
      {
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_enter_memory_increment", true, 0L, 0L, localHashMap, "", false);
        return;
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_exit_memory_increment", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    QLog.d("QFlutter.Reporter", 1, "reportMemoryIncrement, don't need report or mBeforeMemoryInfo == null");
  }
  
  public static boolean a()
  {
    return QFlutterDPC.a().c();
  }
  
  private static String b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return "";
  }
  
  public static void b(String paramString)
  {
    if (a())
    {
      HashMap localHashMap = a();
      localHashMap.put("pagePath", paramString);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_exception", true, 0L, 0L, localHashMap, "", false);
    }
  }
  
  public static void c(String paramString)
  {
    if (a())
    {
      HashMap localHashMap = a();
      localHashMap.put("pagePath", paramString);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_pv", true, 0L, 0L, localHashMap, "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.report.QFlutterReporter
 * JD-Core Version:    0.7.0.1
 */