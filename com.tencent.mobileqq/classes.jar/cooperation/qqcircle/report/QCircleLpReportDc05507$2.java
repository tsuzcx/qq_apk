package cooperation.qqcircle.report;

import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

final class QCircleLpReportDc05507$2
  implements Runnable
{
  QCircleLpReportDc05507$2(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QQToast.a(MobileQQ.sMobileQQ.getApplicationContext(), "QCircleLpReportDc05507report invalid pageId,actionType:" + this.val$actiontype + ",subActionType:" + this.val$subactiontype, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05507.2
 * JD-Core Version:    0.7.0.1
 */