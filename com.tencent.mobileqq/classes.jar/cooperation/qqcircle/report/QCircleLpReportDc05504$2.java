package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc05504$2
  implements Runnable
{
  QCircleLpReportDc05504$2(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, int paramInt5, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("touin", this.val$toUin), QCircleReportHelper.newEntry("actiontype", String.valueOf(this.val$actiontype)), QCircleReportHelper.newEntry("subactiontype", String.valueOf(this.val$subactiontype)), QCircleReportHelper.newEntry("thr_action", String.valueOf(this.val$thrAction)), QCircleReportHelper.newEntry("ext1", this.val$ext1), QCircleReportHelper.newEntry("ext2", this.val$ext2), QCircleReportHelper.newEntry("ext5", this.val$ext5), QCircleReportHelper.newEntry("ext6", this.val$ext6), QCircleReportHelper.newEntry("ext7", this.val$ext7), QCircleReportHelper.newEntry("vid", this.val$vid) }));
    if (this.val$pageId > -1)
    {
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", String.valueOf(this.val$pageId)));
      if (this.val$fPageId <= -1) {
        break label284;
      }
      ((List)localObject).add(QCircleReportHelper.newEntry("fpage_id", String.valueOf(this.val$fPageId)));
    }
    for (;;)
    {
      ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
      localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05504.access$000(), (List)localObject, null, QCircleReportHelper.getInstance().newSessionEntries(this.val$pageId, this.val$reportInfo));
      if ((!QCircleReportHelper.getInstance().hasValidSession()) && (!QCircleLpReportDc05504.access$100(this.val$actiontype))) {
        break label301;
      }
      QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, false);
      return;
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", "0"));
      break;
      label284:
      ((List)localObject).add(QCircleReportHelper.newEntry("fpage_id", "0"));
    }
    label301:
    QLog.w("QCircleReporter", 1, "QCircleLpReportDc05504 report miss Session: actiontype:" + this.val$actiontype + ",subActionType:" + this.val$subactiontype + ",add Miss Session report cache list");
    QCircleReporter.getInstance().addMissSessionReportDataCache((QQCircleReport.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05504.2
 * JD-Core Version:    0.7.0.1
 */