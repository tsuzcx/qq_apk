package cooperation.qqcircle.report;

import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class QCircleReporter$5
  implements Runnable
{
  QCircleReporter$5(QCircleReporter paramQCircleReporter, boolean paramBoolean, QQCircleReport.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.val$isReportNow)
    {
      QCircleReporter.access$400(this.this$0).add(this.val$singleDcData);
      QCircleReporter.access$500(this.this$0);
    }
    for (;;)
    {
      QCircleReporter.access$000(this.this$0);
      return;
      QCircleReporter.access$600(this.this$0).add(this.val$singleDcData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.5
 * JD-Core Version:    0.7.0.1
 */