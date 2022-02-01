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
    if ((paramMap1 == null) || (paramMap2 == null)) {
      return 0L;
    }
    if ((!paramMap1.containsKey(paramString)) || (!paramMap2.containsKey(paramString)))
    {
      QLog.d("QFlutter.Reporter", 1, String.format("%s not contains", new Object[] { paramString }));
      return 0L;
    }
    long l = ((Integer)paramMap1.get(paramString)).intValue();
    return ((Integer)paramMap2.get(paramString)).intValue() - l;
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
    HashMap localHashMap;
    if (a())
    {
      localHashMap = a();
      localHashMap.put("errCode", String.valueOf(paramInt));
      localHashMap.put("launchCost", String.valueOf(paramLong1));
      localHashMap.put("installCost", String.valueOf(paramLong2));
      localHashMap.put("loadAssetCost", String.valueOf(paramLong3));
      localHashMap.put("loadEngineCost", String.valueOf(paramLong4));
      if (!paramBoolean1) {
        break label300;
      }
      str = "1";
      localHashMap.put("isPreloadProcess", str);
      if (!paramBoolean2) {
        break label307;
      }
      str = "1";
      label101:
      localHashMap.put("isLocalEngineExist", str);
      if (!paramBoolean3) {
        break label314;
      }
      str = "1";
      label120:
      localHashMap.put("isLocalAppExist", str);
      if ((!paramBoolean3) && (!paramBoolean2)) {
        break label321;
      }
      str = "1";
      label144:
      localHashMap.put("isLocalExist", str);
      if (!paramBoolean4) {
        break label328;
      }
    }
    label300:
    label307:
    label314:
    label321:
    label328:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isQuickInstall", str);
      localHashMap.put("flutterUin", b());
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_launch_result_v2", true, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.Reporter", 2, String.format("reportLaunchResult, errCode: %s, launchCost: %s, installCost: %s,loadAssetCost: %s, loadEngineCost: %s, isPreloadProcess: %s, isLocalEngineExist: %s, isLocalAppExist: %s, isQuickInstall: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }));
      }
      return;
      str = "0";
      break;
      str = "0";
      break label101;
      str = "0";
      break label120;
      str = "0";
      break label144;
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
    if (paramBoolean1)
    {
      str = "1";
      label20:
      localHashMap.put("errCode", str);
      localHashMap.put("cost", String.valueOf(paramLong));
      if (!paramBoolean2) {
        break label146;
      }
      str = "1";
      label50:
      localHashMap.put("isLocalEngineExist", str);
      if (!paramBoolean3) {
        break label153;
      }
    }
    label146:
    label153:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isLocalAppExist", str);
      localHashMap.put("downloadType", paramString);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_download_cost", true, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QFlutter.Reporter", 1, String.format("reportDownloadCost: %s", new Object[] { Long.valueOf(paramLong) }));
      return;
      str = "0";
      break label20;
      str = "0";
      break label50;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, LaunchTrace paramLaunchTrace, String paramString)
  {
    if ((paramBoolean2) && (paramLaunchTrace == null))
    {
      QLog.d("QFlutter.Reporter", 1, "is first launch but trace is null");
      return;
    }
    HashMap localHashMap = a();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "unknown";
    }
    localHashMap.put("pageUrl", str);
    label75:
    boolean bool1;
    label101:
    label110:
    long l4;
    long l5;
    long l6;
    long l2;
    boolean bool2;
    long l1;
    if (paramBoolean1)
    {
      paramString = "1";
      localHashMap.put("isPreloadProcess", paramString);
      if (!paramBoolean2) {
        break label571;
      }
      paramString = "1";
      localHashMap.put("isFirstLaunch", paramString);
      if ((paramLaunchTrace != null) && (!paramLaunchTrace.a())) {
        break label578;
      }
      bool1 = true;
      if (!bool1) {
        break label584;
      }
      paramString = "1";
      localHashMap.put("isLocalResExist", paramString);
      l4 = paramLong4 - paramLong1;
      l5 = paramLong2 - paramLong1;
      l6 = paramLong3 - paramLong2;
      if (paramLaunchTrace == null) {
        break label603;
      }
      l2 = paramLaunchTrace.jdField_a_of_type_Long;
      bool2 = paramLaunchTrace.jdField_a_of_type_Boolean;
      l1 = paramLaunchTrace.b;
      paramLong1 = paramLaunchTrace.d;
      long l3 = paramLaunchTrace.e - l2 - l1 - paramLong1;
      paramLong2 = paramLong1;
      paramLong1 = l3;
    }
    for (;;)
    {
      paramLong3 = paramLong4 - paramLong3;
      localHashMap.put("totalCost", String.valueOf(l4));
      localHashMap.put("loadProcessCost", String.valueOf(l5));
      localHashMap.put("launchCost", String.valueOf(l6));
      localHashMap.put("installCost", String.valueOf(l2));
      localHashMap.put("loadAssetCost", String.valueOf(l1));
      localHashMap.put("loadEngineCost", String.valueOf(paramLong2));
      localHashMap.put("otherCost", String.valueOf(paramLong1));
      localHashMap.put("openPageCost", String.valueOf(paramLong3));
      localHashMap.put("flutterUin", b());
      localHashMap.put("pageUrl", str);
      if (bool2)
      {
        paramString = "1";
        label332:
        localHashMap.put("isQuickInstall", paramString);
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_first_frame", true, 0L, 0L, localHashMap, "", false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QFlutter.Reporter", 2, "reportFirstFrameCost,isPreloadProcess: " + paramBoolean1 + ",isFirstLaunch: " + paramBoolean2 + ",isLocalResExist: " + bool1 + ",totalCost: " + l4 + ",loadProcessCost: " + l5 + ",launchCost: " + l6 + ",installCost: " + l2 + ",loadAssetCost: " + l1 + ",loadEngineCost: " + paramLong2 + ",otherCost: " + paramLong1 + ",openPageCost: " + paramLong3 + ",setupEngineCost: " + paramLong5 + ",isQuickInstall: " + bool2 + ",openUrl: " + str);
        paramString = new StringBuilder().append("reportFirstFrameCost: launchTrace.launchCost ");
        if (paramLaunchTrace == null) {
          break label598;
        }
      }
      label571:
      label578:
      label584:
      label598:
      for (paramLong1 = paramLaunchTrace.e;; paramLong1 = 0L)
      {
        QLog.d("QFlutter.Reporter", 2, paramLong1);
        return;
        paramString = "0";
        break;
        paramString = "0";
        break label75;
        bool1 = false;
        break label101;
        paramString = "0";
        break label110;
        paramString = "0";
        break label332;
      }
      label603:
      paramLong1 = 0L;
      paramLong2 = 0L;
      l1 = 0L;
      l2 = 0L;
      bool2 = false;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Map<String, Integer> paramMap, String paramString)
  {
    if ((!a()) || (paramMap == null))
    {
      QLog.d("QFlutter.Reporter", 1, "reportMemoryIncrement, don't need report or mBeforeMemoryInfo == null");
      return;
    }
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
    if (paramBoolean1) {}
    for (paramMap = "1";; paramMap = "0")
    {
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
      if (!paramBoolean2) {
        break;
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_enter_memory_increment", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_exit_memory_increment", true, 0L, 0L, localHashMap, "", false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.report.QFlutterReporter
 * JD-Core Version:    0.7.0.1
 */