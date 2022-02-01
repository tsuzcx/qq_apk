package cooperation.qqcircle.report.outbox;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;

class QCircleReportOutboxTaskQueue$2
  implements Runnable
{
  QCircleReportOutboxTaskQueue$2(QCircleReportOutboxTaskQueue paramQCircleReportOutboxTaskQueue) {}
  
  public void run()
  {
    if (!NetworkState.isNetSupport()) {
      return;
    }
    if (this.this$0.getTaskCount() > 0)
    {
      QCircleNetDetectHelper.detectQCircleNetConnection(new QCircleReportOutboxTaskQueue.2.1(this));
      return;
    }
    QLog.d("QCircleReportOutboxTaskQueue", 1, "no outbox tasks left,direct return!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.2
 * JD-Core Version:    0.7.0.1
 */