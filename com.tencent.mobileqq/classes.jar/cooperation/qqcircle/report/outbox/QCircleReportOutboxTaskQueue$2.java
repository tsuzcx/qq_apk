package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import cooperation.qqcircle.utils.NetworkState;

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
    RFLog.d("QCircleReportOutboxTaskQueue", RFLog.USR, "no outbox tasks left,direct return!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.2
 * JD-Core Version:    0.7.0.1
 */