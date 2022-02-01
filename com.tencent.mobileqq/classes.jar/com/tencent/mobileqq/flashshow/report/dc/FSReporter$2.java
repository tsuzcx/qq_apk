package com.tencent.mobileqq.flashshow.report.dc;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;

class FSReporter$2
  implements Runnable
{
  FSReporter$2(FSReporter paramFSReporter) {}
  
  public void run()
  {
    QLog.d("QCircleReportOutboxTaskQueue", 1, "initOutbox...");
    QCircleReportOutboxTaskQueue.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSReporter.2
 * JD-Core Version:    0.7.0.1
 */