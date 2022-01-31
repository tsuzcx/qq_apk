package com.tencent.mobileqq.webview.webso;

import akrd;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Random;

public class HybridWebReporter
{
  private static long jdField_a_of_type_Long = SystemClock.uptimeMillis();
  private static HybridWebReporter jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static String a;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Random jdField_a_of_type_JavaUtilRandom;
  
  public static HybridWebReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter == null) {
        jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter = new HybridWebReporter();
      }
      return jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter;
    }
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
      ThreadManager.executeOnNetWorkThread(new akrd(localArrayList2));
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt <= 0) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_JavaUtilRandom == null) {
        this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
      }
    } while (this.jdField_a_of_type_JavaUtilRandom.nextInt() % paramInt != 0);
    return true;
  }
  
  public void a(HybridWebReporter.HybridWebReportInfo paramHybridWebReportInfo)
  {
    if (paramHybridWebReportInfo == null) {}
    for (;;)
    {
      return;
      long l1 = SystemClock.uptimeMillis();
      long l2 = jdField_a_of_type_Long;
      int j = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchInterval", 600);
      int k = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchCount", 10);
      if (QLog.isColorLevel()) {
        QLog.d("HybridWebReporter", 2, "add report, isreported(" + paramHybridWebReportInfo.jdField_d_of_type_Boolean + "), url: " + paramHybridWebReportInfo.a);
      }
      if ((paramHybridWebReportInfo.e == 0) || (paramHybridWebReportInfo.jdField_d_of_type_Boolean)) {
        continue;
      }
      paramHybridWebReportInfo.jdField_d_of_type_Boolean = true;
      if (paramHybridWebReportInfo.e < 0) {
        paramHybridWebReportInfo.e = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatDefaultSampling", 20);
      }
      try
      {
        i = Integer.valueOf(paramHybridWebReportInfo.jdField_d_of_type_JavaLangString).intValue();
        if (((paramHybridWebReportInfo.b != 1000) && (paramHybridWebReportInfo.b != 0)) || (i < 100) || (i > 400)) {
          paramHybridWebReportInfo.e = 1;
        }
        if (QLog.isColorLevel()) {
          paramHybridWebReportInfo.e = 1;
        }
        if (!a(paramHybridWebReportInfo.e)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        synchronized (jdField_a_of_type_JavaUtilArrayList)
        {
          jdField_a_of_type_JavaUtilArrayList.add(paramHybridWebReportInfo);
          if ((jdField_a_of_type_JavaUtilArrayList.size() < k) && ((l1 - l2 < j * 1000) || (jdField_a_of_type_JavaUtilArrayList.size() <= 0))) {
            continue;
          }
          a();
          return;
          localException = localException;
          int i = 200;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HybridWebReporter
 * JD-Core Version:    0.7.0.1
 */