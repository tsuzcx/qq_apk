package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;

class QCircleReporter$2
  implements Runnable
{
  QCircleReporter$2(QCircleReporter paramQCircleReporter) {}
  
  public void run()
  {
    QLog.d("QCircleReportOutboxTaskQueue", 1, "initOutbox...");
    QCircleReportOutboxTaskQueue.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.2
 * JD-Core Version:    0.7.0.1
 */