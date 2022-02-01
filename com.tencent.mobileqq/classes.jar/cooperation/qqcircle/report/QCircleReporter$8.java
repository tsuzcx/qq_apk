package cooperation.qqcircle.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import java.util.List;

class QCircleReporter$8
  implements Runnable
{
  QCircleReporter$8(QCircleReporter paramQCircleReporter, APP_REPORT_TRANSFER.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    QCircleReporter.access$800(this.this$0).add(this.val$singleDcData);
    QCircleReporter.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.8
 * JD-Core Version:    0.7.0.1
 */