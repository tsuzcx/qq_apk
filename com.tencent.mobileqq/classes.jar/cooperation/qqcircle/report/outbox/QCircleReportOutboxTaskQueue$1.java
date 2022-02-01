package cooperation.qqcircle.report.outbox;

import com.tencent.mobileqq.qcircle.api.db.util.Singleton;

final class QCircleReportOutboxTaskQueue$1
  extends Singleton<QCircleReportOutboxTaskQueue, Void>
{
  protected QCircleReportOutboxTaskQueue create(Void paramVoid)
  {
    paramVoid = new QCircleReportOutboxTaskQueue(null);
    paramVoid.restore();
    return paramVoid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.1
 * JD-Core Version:    0.7.0.1
 */