package com.tencent.mobileqq.webview.webso;

import android.os.SystemClock;
import bchc;
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
  private static ArrayList<bchc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
      ThreadManager.executeOnNetWorkThread(new HybridWebReporter.ReportRunnable(localArrayList2));
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
  
  public void a(bchc parambchc)
  {
    if (parambchc == null) {}
    for (;;)
    {
      return;
      long l1 = SystemClock.uptimeMillis();
      long l2 = jdField_a_of_type_Long;
      int j = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchInterval", 600);
      int k = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchCount", 10);
      if (QLog.isColorLevel()) {
        QLog.d("HybridWebReporter", 2, "add report, isreported(" + parambchc.jdField_d_of_type_Boolean + "), url: " + parambchc.a);
      }
      if ((parambchc.f == 0) || (parambchc.jdField_d_of_type_Boolean)) {
        continue;
      }
      parambchc.jdField_d_of_type_Boolean = true;
      if (parambchc.f < 0) {
        parambchc.f = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatDefaultSampling", 20);
      }
      try
      {
        i = Integer.valueOf(parambchc.jdField_d_of_type_JavaLangString).intValue();
        if (((parambchc.b != 1000) && (parambchc.b != 0)) || (i < 100) || (i > 400)) {
          parambchc.f = 1;
        }
        if (QLog.isColorLevel()) {
          parambchc.f = 1;
        }
        if (!a(parambchc.f)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        synchronized (jdField_a_of_type_JavaUtilArrayList)
        {
          jdField_a_of_type_JavaUtilArrayList.add(parambchc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HybridWebReporter
 * JD-Core Version:    0.7.0.1
 */