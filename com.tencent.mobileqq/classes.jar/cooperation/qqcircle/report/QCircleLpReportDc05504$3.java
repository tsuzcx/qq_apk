package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc05504$3
  implements Runnable
{
  QCircleLpReportDc05504$3(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("touin", this.val$toUin), QCircleReportHelper.newEntry("actiontype", String.valueOf(this.val$actiontype)), QCircleReportHelper.newEntry("subactiontype", String.valueOf(this.val$subactiontype)), QCircleReportHelper.newEntry("thr_action", String.valueOf(this.val$thrAction)) }));
    if (this.val$pageId > -1) {
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", String.valueOf(this.val$pageId)));
    }
    for (;;)
    {
      ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
      localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05504.access$000(), (List)localObject, null, QCircleReportHelper.getInstance().newSessionEntries(this.val$pageId, null, this.val$msgReportInfo));
      if ((!QCircleReportHelper.getInstance().hasValidSession()) && (!QCircleLpReportDc05504.access$100(this.val$actiontype))) {
        break;
      }
      QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, false);
      return;
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", "0"));
    }
    QLog.w("QCircleReporter", 1, "QCircleLpReportDc05504 report miss Session: actiontype:" + this.val$actiontype + ",subActionType:" + this.val$subactiontype + ",add Miss Session report cache list");
    QCircleReporter.getInstance().addMissSessionReportDataCache((QQCircleReport.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05504.3
 * JD-Core Version:    0.7.0.1
 */