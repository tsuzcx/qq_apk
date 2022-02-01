package com.tencent.mobileqq.qmethodmonitor.monitor;

import android.os.SystemClock;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InvokeMonitor
{
  public static final String CLIPBOARD_MONITOR = "ClipboardMonitor";
  private static final boolean REPORT_SWITCH = false;
  private static final String TAG = "InvokeMonitor";
  private static final ConcurrentMap<String, InvokeMonitor.InvokeConfig> invokeCollector;
  private static final Map<String, Boolean> reportMap = new TreeMap();
  
  static
  {
    invokeCollector = new ConcurrentHashMap();
    InvokeMonitor.InvokeConfig localInvokeConfig = new InvokeMonitor.InvokeConfig();
    localInvokeConfig.jdField_a_of_type_JavaLangString = "ClipboardMonitor";
    localInvokeConfig.jdField_a_of_type_Int = 10000;
    localInvokeConfig.c = 30;
    localInvokeConfig.jdField_a_of_type_JavaUtilList = new ArrayList();
    localInvokeConfig.b = 0;
    invokeCollector.put("ClipboardMonitor", localInvokeConfig);
  }
  
  private static void doReport(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("] method: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString3);
    paramString1 = ((StringBuilder)localObject).toString();
    paramString2 = new Throwable(paramString1);
    paramString3 = paramString2.getStackTrace();
    localObject = new StringBuilder();
    int j = 3;
    int i = 0;
    while ((j < paramString3.length) && (i < 5))
    {
      ((StringBuilder)localObject).append(paramString3[j]);
      j += 1;
      i += 1;
    }
    paramString3 = ((StringBuilder)localObject).toString();
    localObject = (Boolean)reportMap.get(paramString3);
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      reportMap.put(paramString3, Boolean.valueOf(true));
      CaughtExceptionReport.a(paramString2, paramString1);
    }
  }
  
  private static long getCurMilTime()
  {
    return SystemClock.uptimeMillis();
  }
  
  public static void onMethodInvoke(String paramString1, String paramString2, String paramString3) {}
  
  private static void onOverFrequency(String paramString1, String paramString2, String paramString3)
  {
    doReport(paramString1, paramString2, paramString3);
    paramString1 = (InvokeMonitor.InvokeConfig)invokeCollector.get(paramString1);
    if (paramString1 != null) {
      paramString1.jdField_a_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.InvokeMonitor
 * JD-Core Version:    0.7.0.1
 */