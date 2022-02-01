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
    }
    else
    {
      if (QCircleReportOutboxTaskQueue.access$100(this.this$1.this$0) != null)
      {
        QCircleReportOutboxTaskQueue.access$100(this.this$1.this$0).removeCallbacks(QCircleReportOutboxTaskQueue.access$300(this.this$1.this$0));
        QCircleReportOutboxTaskQueue.access$100(this.this$1.this$0).postDelayed(QCircleReportOutboxTaskQueue.access$300(this.this$1.this$0), 10000L);
      }
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detectQCirclenNetConnection blocked,retry again!retCode:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",errMsg:");
      localStringBuilder.append(paramString);
      RFLog.d("QCircleReportOutboxTaskQueue", i, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.2.1
 * JD-Core Version:    0.7.0.1
 */