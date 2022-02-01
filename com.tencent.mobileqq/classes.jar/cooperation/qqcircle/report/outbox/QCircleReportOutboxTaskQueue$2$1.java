package cooperation.qqcircle.report.outbox;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class QCircleReportOutboxTaskQueue$2$1
  implements QCircleNetDetectHelper.DetectListener
{
  QCircleReportOutboxTaskQueue$2$1(QCircleReportOutboxTaskQueue.2 param2) {}
  
  public void onDetectResult(boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramBoolean)
    {
      QLog.d("QCircleReportOutboxTaskQueue", 1, "detectQCirclenNetConnection available,resumeOutboxTasks");
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detectQCirclenNetConnection blocked,retry again!retCode:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",errMsg:");
      localStringBuilder.append(paramString);
      QLog.d("QCircleReportOutboxTaskQueue", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.2.1
 * JD-Core Version:    0.7.0.1
 */