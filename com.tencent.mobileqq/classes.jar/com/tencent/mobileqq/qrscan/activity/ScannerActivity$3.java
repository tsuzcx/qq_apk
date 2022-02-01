package com.tencent.mobileqq.qrscan.activity;

import com.tencent.mobileqq.qrscan.IToolProcStart.Callback;
import com.tencent.qphone.base.util.QLog;

class ScannerActivity$3
  implements IToolProcStart.Callback
{
  ScannerActivity$3(ScannerActivity paramScannerActivity, long paramLong) {}
  
  public void a()
  {
    this.b.doLaunchAr();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchAr time end: ");
    localStringBuilder.append(System.currentTimeMillis() - this.a);
    QLog.d("IQRScanConst_ScannerActivity", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.ScannerActivity.3
 * JD-Core Version:    0.7.0.1
 */