package com.tencent.mobileqq.qmethodmonitor.monitor;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InvokeMonitor
{
  public static final String CLIPBOARD_MONITOR = "ClipboardMonitor";
  public static final String KEY_BGLOCATION = "privacy_bg_location_invoke";
  public static final int REPORT_INTERVAL = 5;
  private static final boolean REPORT_SWITCH = false;
  public static final int STACK_DEPTH = 5;
  public static final int STACK_INDEX_FROM = 3;
  public static final String SUB_KEY_API = "sub_key_api";
  public static final String SUB_KEY_INVOKE_TIMES = "sub_key_invoke_times";
  public static final String SUB_KEY_STACK_STRING = "sub_key_stack_string";
  public static final String TAG = "InvokeMonitor";
  private static final ConcurrentMap<String, InvokeMonitor.InvokeConfig> invokeCollector;
  private static final Map<String, Boolean> reportMap = new TreeMap();
  private static final Map<String, Integer> reportTimes = new TreeMap();
  
  static
  {
    invokeCollector = new ConcurrentHashMap();
    invokeCollector.put("ClipboardMonitor", new InvokeMonitor.InvokeConfig("ClipboardMonitor", 10000, 30));
    invokeCollector.put("LocationMonitor.getLastKnownLocation", new InvokeMonitor.InvokeConfig("LocationMonitor.getLastKnownLocation", 10000, 30));
    invokeCollector.put("LocationMonitor.requestLocationUpdates(SLFL)", new InvokeMonitor.InvokeConfig("LocationMonitor.requestLocationUpdates(SLFL)", 10000, 30));
    invokeCollector.put("LocationMonitor.requestLocationUpdates(SLFLL)", new InvokeMonitor.InvokeConfig("LocationMonitor.requestLocationUpdates(SLFLL)", 10000, 30));
    invokeCollector.put("LocationMonitor.requestLocationUpdates(LFCLL)", new InvokeMonitor.InvokeConfig("LocationMonitor.requestLocationUpdates(LFCLL)", 10000, 30));
    invokeCollector.put("LocationMonitor.requestLocationUpdates(SLFP)", new InvokeMonitor.InvokeConfig("LocationMonitor.requestLocationUpdates(SLFP)", 10000, 30));
    invokeCollector.put("LocationMonitor.requestLocationUpdates(LFCP)", new InvokeMonitor.InvokeConfig("LocationMonitor.requestLocationUpdates(LFCP)", 10000, 30));
    invokeCollector.put("LocationMonitor.requestSingleUpdate(LSLL)", new InvokeMonitor.InvokeConfig("LocationMonitor.requestSingleUpdate(LSLL)", 10000, 30));
    invokeCollector.put("LocationMonitor.requestSingleUpdate(LCLL)", new InvokeMonitor.InvokeConfig("LocationMonitor.requestSingleUpdate(LCLL)", 10000, 30));
    invokeCollector.put("LocationMonitor.requestSingleUpdate(LSP)", new InvokeMonitor.InvokeConfig("LocationMonitor.requestSingleUpdate(LSP)", 10000, 30));
    invokeCollector.put("LocationMonitor.requestSingleUpdate(LCP)", new InvokeMonitor.InvokeConfig("LocationMonitor.requestSingleUpdate(LCP)", 10000, 30));
    invokeCollector.put("NetworkMonitor.getConnectionInfo", new InvokeMonitor.InvokeConfig("NetworkMonitor.getConnectionInfo", 10000, 30));
    invokeCollector.put("NetworkMonitor.getNetworkInterfaces", new InvokeMonitor.InvokeConfig("NetworkMonitor.getNetworkInterfaces", 10000, 30));
    invokeCollector.put("PhoneInfoMonitor.getDeviceId", new InvokeMonitor.InvokeConfig("PhoneInfoMonitor.getDeviceId", 10000, 20));
    invokeCollector.put("PhoneInfoMonitor.getImei", new InvokeMonitor.InvokeConfig("PhoneInfoMonitor.getImei", 10000, 20));
    invokeCollector.put("PhoneInfoMonitor.getLine1Number", new InvokeMonitor.InvokeConfig("PhoneInfoMonitor.getLine1Number", 10000, 20));
    invokeCollector.put("PhoneInfoMonitor.getSimSerialNumber", new InvokeMonitor.InvokeConfig("PhoneInfoMonitor.getSimSerialNumber", 10000, 20));
    invokeCollector.put("PhoneInfoMonitor.getSubscriberId", new InvokeMonitor.InvokeConfig("PhoneInfoMonitor.getSubscriberId", 10000, 20));
    invokeCollector.put("PhoneInfoMonitor.getSimState", new InvokeMonitor.InvokeConfig("PhoneInfoMonitor.getSimState", 10000, 20));
    invokeCollector.put("PhoneInfoMonitor.getCellLocation", new InvokeMonitor.InvokeConfig("PhoneInfoMonitor.getCellLocation", 10000, 20));
    invokeCollector.put("PhoneInfoMonitor.getAllCellInfo", new InvokeMonitor.InvokeConfig("PhoneInfoMonitor.getAllCellInfo", 10000, 20));
  }
  
  private static void doReportAtIntervals(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("] method: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString3);
    localObject = new Throwable(((StringBuilder)localObject).toString());
    paramString1 = ((Throwable)localObject).getStackTrace();
    paramString3 = new StringBuilder();
    int j = 3;
    int i = 0;
    int k;
    for (;;)
    {
      int m = paramString1.length;
      k = 5;
      if ((j >= m) || (i >= 5)) {
        break;
      }
      paramString3.append(paramString1[j]);
      j += 1;
      i += 1;
    }
    String str = paramString3.toString();
    paramString3 = (Integer)reportTimes.get(str);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = Integer.valueOf(0);
    }
    paramString1 = Integer.valueOf(paramString1.intValue() + 1);
    reportTimes.put(str, paramString1);
    if ((paramString1.intValue() == 1) || (paramString1.intValue() % 5 == 0))
    {
      if (paramString1.intValue() == 1)
      {
        i = 1;
      }
      else
      {
        i = k;
        if (paramString1.intValue() == 5) {
          i = 4;
        }
      }
      reportBeacon(paramString2, str, i);
    }
    QLog.e("InvokeMonitor", 1, (Throwable)localObject, new Object[] { "invoke times: ", paramString1 });
  }
  
  private static void doReportOnce(String paramString1, String paramString2, String paramString3)
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
    doReportOnce(paramString1, paramString2, paramString3);
    paramString1 = (InvokeMonitor.InvokeConfig)invokeCollector.get(paramString1);
    if (paramString1 != null) {
      paramString1.b.clear();
    }
  }
  
  private static void reportBeacon(String paramString1, String paramString2, int paramInt)
  {
    ThreadManagerV2.excute(new InvokeMonitor.1(paramString2, paramInt, paramString1), 16, null, false);
  }
  
  public static void reportNotAllowedInvoke(String paramString1, String paramString2, String paramString3)
  {
    doReportAtIntervals(paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.InvokeMonitor
 * JD-Core Version:    0.7.0.1
 */