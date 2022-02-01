package com.tencent.mobileqq.qwallet.report.impl;

import com.tencent.qphone.base.util.QLog;

class VACDReportServiceImpl$1
  implements Runnable
{
  VACDReportServiceImpl$1(VACDReportServiceImpl paramVACDReportServiceImpl) {}
  
  public void run()
  {
    synchronized ()
    {
      VACDReportServiceImpl.access$200(this.this$0).a(VACDReportServiceImpl.access$100(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "loadAllLocalInfos finished.");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */