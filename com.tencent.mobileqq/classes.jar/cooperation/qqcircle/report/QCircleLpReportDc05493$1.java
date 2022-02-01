package cooperation.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc05493$1
  implements Runnable
{
  QCircleLpReportDc05493$1(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("touin", this.val$toUin), QCircleReportHelper.newEntry("login_time", String.valueOf(this.val$launchTimeStamp)), QCircleReportHelper.newEntry("login_entrance", String.valueOf(this.val$loginEntrance)), QCircleReportHelper.newEntry("sub_entrance", String.valueOf(this.val$subEntrance)), QCircleReportHelper.newEntry("thr_entrance", String.valueOf(this.val$thrEntrance)), QCircleReportHelper.newEntry("report_from", "1"), QCircleReportHelper.newEntry("ext1", this.val$ext1), QCircleReportHelper.newEntry("ext2", this.val$ext2), QCircleReportHelper.newEntry("ext3", this.val$ext3), QCircleReportHelper.newEntry("ext4", this.val$ext4), QCircleReportHelper.newEntry("ext5", this.val$ext5), QCircleReportHelper.newEntry("ext6", this.val$ext6) }));
    ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
    localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05493.access$000(), (List)localObject, null, QCircleReportHelper.getInstance().newSessionEntries(this.val$scene));
    QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05493.1
 * JD-Core Version:    0.7.0.1
 */