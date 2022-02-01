package cooperation.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc010001$1
  implements Runnable
{
  QCircleLpReportDc010001$1(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt4) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("actiontype", String.valueOf(this.val$actiontype)), QCircleReportHelper.newEntry("subactiontype", String.valueOf(this.val$subactiontype)), QCircleReportHelper.newEntry("thr_action", String.valueOf(this.val$reserves)), QCircleReportHelper.newEntry("mainType", String.valueOf(this.val$mainType)), QCircleReportHelper.newEntry("subType", String.valueOf(this.val$subType)), QCircleReportHelper.newEntry("busiMsgId", this.val$busiMsgId), QCircleReportHelper.newEntry("eeveeMsgId", this.val$eeveeMsgId), QCircleReportHelper.newEntry("scene", String.valueOf(this.val$scene)), QCircleReportHelper.newEntry("app_id", String.valueOf(10000)) }));
    ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
    localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc010001.access$000(), (List)localObject, null, null);
    QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc010001.1
 * JD-Core Version:    0.7.0.1
 */