package com.tencent.mobileqq.qrscan.minicode;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qrscan.IQRScanReportConst;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class MiniScanReport
  implements IQRScanReportConst
{
  private static MiniScanReport.ScanInfoReport a;
  private static long b = 0L;
  private static int c = 0;
  private static int d = -1;
  
  public static long a(String paramString, long paramLong)
  {
    return MobileQQ.sMobileQQ.getSharedPreferences("sp_mini_scan_report", 4).getLong(paramString, paramLong);
  }
  
  public static void a()
  {
    a = new MiniScanReport.ScanInfoReport(null);
    a.a = System.currentTimeMillis();
  }
  
  public static void a(int paramInt)
  {
    MiniScanReport.ScanInfoReport localScanInfoReport = a;
    if (localScanInfoReport == null) {
      return;
    }
    a = null;
    long l = System.currentTimeMillis() - localScanInfoReport.a;
    if (l <= 600000L)
    {
      if (localScanInfoReport.b <= 0) {
        return;
      }
      int k = localScanInfoReport.b;
      int m = localScanInfoReport.c;
      int n = localScanInfoReport.d;
      int i1 = localScanInfoReport.e / k;
      int i;
      if (m <= 0) {
        i = 0;
      } else {
        i = localScanInfoReport.f / m;
      }
      int j;
      if (n <= 0) {
        j = 0;
      } else {
        j = localScanInfoReport.g / n;
      }
      ThreadManager.post(new MiniScanReport.1(i1, l, k, paramInt, m, i, n, j), 5, null, false);
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    MiniScanReport.ScanInfoReport localScanInfoReport = a;
    if ((localScanInfoReport != null) && (paramInt1 > 1))
    {
      if (paramInt1 > 15000) {
        return;
      }
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2) {
            return;
          }
          localScanInfoReport.d += 1;
          localScanInfoReport = a;
          localScanInfoReport.g += paramInt1;
          return;
        }
        localScanInfoReport.c += 1;
        localScanInfoReport = a;
        localScanInfoReport.f += paramInt1;
        return;
      }
      localScanInfoReport.b += 1;
      localScanInfoReport = a;
      localScanInfoReport.e += paramInt1;
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ThreadManager.post(new MiniScanReport.2(paramBoolean, paramInt, paramString), 5, null, false);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.post(new MiniScanReport.5(paramBoolean1, paramBoolean2), 5, null, false);
  }
  
  public static void b(int paramInt)
  {
    ThreadManager.post(new MiniScanReport.6(paramInt), 5, null, false);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MiniScanReport.3(paramInt1, paramInt2), 5, null, false);
  }
  
  public static void b(String paramString, long paramLong)
  {
    MobileQQ.sMobileQQ.getSharedPreferences("sp_mini_scan_report", 4).edit().putLong(paramString, paramLong).apply();
  }
  
  private static void b(HashMap<String, String> paramHashMap)
  {
    String str2 = Build.MODEL;
    int i = Build.VERSION.SDK_INT;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramHashMap.put("report_key_device_model", str1);
    paramHashMap.put("report_key_device_sdk", String.valueOf(i));
  }
  
  public static boolean b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void c()
  {
    if (b == 0L) {
      b = SystemClock.uptimeMillis();
    }
    c += 1;
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MiniScanReport.4(paramInt2, paramInt1), 5, null, false);
  }
  
  public static int d()
  {
    Object localObject = MobileQQ.processName.split(":");
    if (localObject.length > 1)
    {
      localObject = localObject[1];
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return 0;
      }
      if (((String)localObject).equalsIgnoreCase("peak")) {
        return 1;
      }
      if (((String)localObject).equalsIgnoreCase("tool")) {
        return 2;
      }
      if (((String)localObject).equalsIgnoreCase("web")) {
        return 3;
      }
      if (((String)localObject).equalsIgnoreCase("qzone")) {
        return 4;
      }
      return 5;
    }
    return 0;
  }
  
  public static void d(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      if (paramInt2 > 180000) {
        return;
      }
      ThreadManager.post(new MiniScanReport.7(paramInt1, paramInt2), 5, null, false);
    }
  }
  
  public static void e(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MiniScanReport.8(paramInt1, paramInt2), 5, null, false);
  }
  
  public static void f(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      if (paramInt2 > 180000) {
        return;
      }
      ThreadManager.post(new MiniScanReport.9(paramInt1, paramInt2), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniScanReport
 * JD-Core Version:    0.7.0.1
 */