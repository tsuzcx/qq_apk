package com.tencent.mobileqq.webprocess;

import android.os.Bundle;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class PreloadService
{
  public static long a;
  public static HashMap<Integer, PreloadService.ReportStat> a;
  public static HashMap<Integer, PreloadService.ReportStat> b;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    b = new HashMap();
    jdField_a_of_type_Long = 0L;
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
        StatisticCollector.getInstance(BaseApplication.getContext().getApplicationContext()).collectPerformance(null, "actPreloadWebview", true, 0L, 0L, localHashMap, null);
      }
      localIterator = b.values().iterator();
      while (localIterator.hasNext())
      {
        localReportStat = (PreloadService.ReportStat)localIterator.next();
        localHashMap = new HashMap(4);
        localHashMap.put("type", String.valueOf(localReportStat.a));
        localHashMap.put("totalNum", String.valueOf(localReportStat.b));
        localHashMap.put("hasProc", String.valueOf(localReportStat.c));
        localHashMap.put("noProc", String.valueOf(localReportStat.d));
        StatisticCollector.getInstance(BaseApplication.getContext().getApplicationContext()).collectPerformance(null, "actJumpWebview", true, 0L, 0L, localHashMap, null);
      }
      jdField_a_of_type_JavaUtilHashMap.clear();
      b.clear();
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
  
  public static void b(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.PreloadService
 * JD-Core Version:    0.7.0.1
 */