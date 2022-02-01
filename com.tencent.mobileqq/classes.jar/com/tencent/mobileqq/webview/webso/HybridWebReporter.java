package com.tencent.mobileqq.webview.webso;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Random;

public class HybridWebReporter
{
  public static String a;
  private static ArrayList<HybridWebReporter.HybridWebReportInfo> b = new ArrayList();
  private static long c = SystemClock.uptimeMillis();
  private static HybridWebReporter d = null;
  private static final Object e = new Object();
  private Random f = null;
  
  public static HybridWebReporter a()
  {
    if (d == null) {
      synchronized (e)
      {
        if (d == null) {
          d = new HybridWebReporter();
        }
      }
    }
    return d;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt <= 0) {
      return false;
    }
    if (this.f == null) {
      this.f = new Random(System.currentTimeMillis());
    }
    if (this.f.nextInt() % paramInt == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static void b()
  {
    if (b.isEmpty()) {
      return;
    }
    synchronized (b)
    {
      ArrayList localArrayList2 = new ArrayList(b);
      b.clear();
      c = SystemClock.uptimeMillis();
      ThreadManager.executeOnNetWorkThread(new HybridWebReporter.ReportRunnable(localArrayList2));
      return;
    }
  }
  
  private boolean b(HybridWebReporter.HybridWebReportInfo paramHybridWebReportInfo)
  {
    try
    {
      i = Integer.valueOf(paramHybridWebReportInfo.e).intValue();
    }
    catch (Exception localException)
    {
      int i;
      label14:
      break label14;
    }
    i = 200;
    return (QLog.isColorLevel()) || ((paramHybridWebReportInfo.m != 1000) && (paramHybridWebReportInfo.m != 0)) || (i < 100) || (i > 400);
  }
  
  private boolean c(HybridWebReporter.HybridWebReportInfo paramHybridWebReportInfo)
  {
    return (paramHybridWebReportInfo == null) || (paramHybridWebReportInfo.y == 0) || (paramHybridWebReportInfo.z);
  }
  
  public void a(HybridWebReporter.HybridWebReportInfo paramHybridWebReportInfo)
  {
    if (c(paramHybridWebReportInfo)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = c;
    int i = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchInterval", 600);
    int j = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchCount", 10);
    paramHybridWebReportInfo.z = true;
    if (paramHybridWebReportInfo.y < 0) {
      paramHybridWebReportInfo.y = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatDefaultSampling", 20);
    }
    if (b(paramHybridWebReportInfo)) {
      paramHybridWebReportInfo.y = 1;
    }
    if (a(paramHybridWebReportInfo.y)) {
      synchronized (b)
      {
        b.add(paramHybridWebReportInfo);
        if ((b.size() >= j) || ((l1 - l2 >= i * 1000) && (b.size() > 0)))
        {
          b();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HybridWebReporter
 * JD-Core Version:    0.7.0.1
 */