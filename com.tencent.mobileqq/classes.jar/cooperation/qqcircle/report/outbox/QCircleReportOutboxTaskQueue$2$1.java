package cooperation.qqcircle.report.outbox;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;

class QCircleReportOutboxTaskQueue$2$1
  implements QCircleNetDetectHelper.DetectListener
{
  QCircleReportOutboxTaskQueue$2$1(QCircleReportOutboxTaskQueue.2 param2) {}
  
  public void onDetectResult(boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramBoolean)
    {
      RFLog.d("QCircleReportOutboxTaskQueue", RFLog.USR, "detectQCirclenNetConnection available,resumeOutboxTasks");
      if (QCircleReportOutboxTaskQueue.access$100(this.this$1.this$0) != null)
      {
        QCircleReportOutboxTaskQueue.access$100(this.this$1.this$0).removeCallbacks(QCircleReportOutboxTaskQueue.access$200(this.this$1.this$0));
        QCircleReportOutboxTaskQueue.access$100(this.this$1.this$0).post(QCircleReportOutboxTaskQueue.access$200(this.this$1.this$0));
      }
      return;
    }
    if (QCircleReportOutboxTaskQueue.access$100(this.this$1.this$0) != null)
    {
      QCircleReportOutboxTaskQueue.access$100(this.this$1.this$0).removeCallbacks(QCircleReportOutboxTaskQueue.access$300(this.this$1.this$0));
      QCircleReportOutboxTaskQueue.access$100(this.this$1.this$0).postDelayed(QCircleReportOutboxTaskQueue.access$300(this.this$1.this$0), 10000L);
    }
    RFLog.d("QCircleReportOutboxTaskQueue", RFLog.USR, "detectQCirclenNetConnection blocked,retry again!retCode:" + paramLong + ",errMsg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.2.1
 * JD-Core Version:    0.7.0.1
 */