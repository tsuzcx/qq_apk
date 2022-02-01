package com.tencent.mobileqq.webprocess;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.WVSecurityConfBean;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PreloadService
{
  public static long a;
  public static WebViewPluginEngine a;
  public static final Object a;
  public static HashMap<Integer, PreloadService.ReportStat> a;
  public static volatile boolean a;
  public static WebViewPluginEngine b;
  public static HashMap<Integer, PreloadService.ReportStat> b;
  public static volatile boolean b;
  public static volatile boolean c;
  public static volatile boolean d;
  public static volatile boolean e;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    c = false;
    d = false;
    e = false;
    jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
    jdField_b_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static void a()
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long > 3600000L)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
      PreloadService.ReportStat localReportStat;
      HashMap localHashMap;
      while (localIterator.hasNext())
      {
        localReportStat = (PreloadService.ReportStat)localIterator.next();
        localHashMap = new HashMap(4);
        localHashMap.put("type", String.valueOf(localReportStat.a));
        localHashMap.put("totalNum", String.valueOf(localReportStat.b));
        localHashMap.put("hasProc", String.valueOf(localReportStat.c));
        localHashMap.put("noProc", String.valueOf(localReportStat.d));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "actPreloadWebview", true, 0L, 0L, localHashMap, null);
      }
      localIterator = jdField_b_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        localReportStat = (PreloadService.ReportStat)localIterator.next();
        localHashMap = new HashMap(4);
        localHashMap.put("type", String.valueOf(localReportStat.a));
        localHashMap.put("totalNum", String.valueOf(localReportStat.b));
        localHashMap.put("hasProc", String.valueOf(localReportStat.c));
        localHashMap.put("noProc", String.valueOf(localReportStat.d));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "actJumpWebview", true, 0L, 0L, localHashMap, null);
      }
      jdField_a_of_type_JavaUtilHashMap.clear();
      jdField_b_of_type_JavaUtilHashMap.clear();
      jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "reportInterval...");
      }
    }
  }
  
  public static void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_accelerator_mode_", 3);
    localBundle.putInt("from", paramInt);
    SwiftWebAccelerator.a().a(localBundle);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("ReaderRuntime");
  }
  
  public static void b(int paramInt)
  {
    int j = 0;
    Object localObject = (WVSecurityConfBean)QConfigManager.a().a(158);
    if ((localObject != null) && (((WVSecurityConfBean)localObject).b == 1)) {
      return;
    }
    boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
    if (!bool)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("from", 305);
      ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.preload_web_process");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "preloadWebview...");
      }
    }
    localObject = new PreloadService.ReportStat(paramInt);
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      localObject = (PreloadService.ReportStat)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    ((PreloadService.ReportStat)localObject).b += 1;
    int k = ((PreloadService.ReportStat)localObject).c;
    if (bool)
    {
      i = 1;
      label184:
      ((PreloadService.ReportStat)localObject).c = (i + k);
      k = ((PreloadService.ReportStat)localObject).d;
      if (!bool) {
        break label244;
      }
    }
    label244:
    for (int i = j;; i = 1)
    {
      ((PreloadService.ReportStat)localObject).d = (k + i);
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
      if (((PreloadService.ReportStat)localObject).b <= 3) {
        break;
      }
      a();
      return;
      i = 0;
      break label184;
    }
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("VipComicPluginRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.PreloadService
 * JD-Core Version:    0.7.0.1
 */