package cooperation.qqcircle.report;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;

class QCircleReporter$2
  implements Runnable
{
  QCircleReporter$2(QCircleReporter paramQCircleReporter) {}
  
  public void run()
  {
    RFLog.d("QCircleReportOutboxTaskQueue", RFLog.USR, "initOutbox...");
    QCircleReportOutboxTaskQueue.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.2
 * JD-Core Version:    0.7.0.1
 */