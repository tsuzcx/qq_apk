package com.tencent.mobileqq.webview.webso;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Random;

public class HybridWebReporter
{
  private static long jdField_a_of_type_Long = SystemClock.uptimeMillis();
  private static HybridWebReporter jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static String a;
  private static ArrayList<HybridWebReporter.HybridWebReportInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Random jdField_a_of_type_JavaUtilRandom = null;
  
  public static HybridWebReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter == null) {
          jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter = new HybridWebReporter();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      ArrayList localArrayList2 = new ArrayList(jdField_a_of_type_JavaUtilArrayList);
      jdField_a_of_type_JavaUtilArrayList.clear();
      jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ThreadManager.executeOnNetWorkThread(new HybridWebReporter.ReportRunnable(localArrayList2));
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt <= 0) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilRandom == null) {
      this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_JavaUtilRandom.nextInt() % paramInt == 0) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(HybridWebReporter.HybridWebReportInfo paramHybridWebReportInfo)
  {
    try
    {
      i = Integer.valueOf(paramHybridWebReportInfo.jdField_d_of_type_JavaLangString).intValue();
    }
    catch (Exception localException)
    {
      int i;
      label14:
      break label14;
    }
    i = 200;
    return (QLog.isColorLevel()) || ((paramHybridWebReportInfo.b != 1000) && (paramHybridWebReportInfo.b != 0)) || (i < 100) || (i > 400);
  }
  
  private boolean b(HybridWebReporter.HybridWebReportInfo paramHybridWebReportInfo)
  {
    return (paramHybridWebReportInfo == null) || (paramHybridWebReportInfo.f == 0) || (paramHybridWebReportInfo.jdField_d_of_type_Boolean);
  }
  
  public void a(HybridWebReporter.HybridWebReportInfo paramHybridWebReportInfo)
  {
    if (b(paramHybridWebReportInfo)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = jdField_a_of_type_Long;
    int i = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchInterval", 600);
    int j = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchCount", 10);
    paramHybridWebReportInfo.jdField_d_of_type_Boolean = true;
    if (paramHybridWebReportInfo.f < 0) {
      paramHybridWebReportInfo.f = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatDefaultSampling", 20);
    }
    if (a(paramHybridWebReportInfo)) {
      paramHybridWebReportInfo.f = 1;
    }
    if (a(paramHybridWebReportInfo.f)) {
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        jdField_a_of_type_JavaUtilArrayList.add(paramHybridWebReportInfo);
        if ((jdField_a_of_type_JavaUtilArrayList.size() >= j) || ((l1 - l2 >= i * 1000) && (jdField_a_of_type_JavaUtilArrayList.size() > 0)))
        {
          a();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HybridWebReporter
 * JD-Core Version:    0.7.0.1
 */