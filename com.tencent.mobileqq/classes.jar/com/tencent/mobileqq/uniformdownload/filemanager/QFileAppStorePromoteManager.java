package com.tencent.mobileqq.uniformdownload.filemanager;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class QFileAppStorePromoteManager
{
  private static long a = 0L;
  
  public static void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B00D", "0X800B00D", 0, 0, "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (System.currentTimeMillis() - a < 1000L) {
      QLog.i("QFileAppStorePromoteManager", 1, "startAppStoreByTmast: start app store limit.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.filemanager.QFileAppStorePromoteManager
 * JD-Core Version:    0.7.0.1
 */