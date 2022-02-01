package cooperation.qqcircle.report;

import android.os.Build;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc05494$1
  implements Runnable
{
  QCircleLpReportDc05494$1(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, int paramInt4, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString10, String paramString11, long paramLong3, String paramString12) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("up_source", String.valueOf(this.val$upSource)), QCircleReportHelper.newEntry("up_type", String.valueOf(this.val$upType)), QCircleReportHelper.newEntry("is_video", String.valueOf(this.val$isVideo)), QCircleReportHelper.newEntry("txtinfo", this.val$txtinfo), QCircleReportHelper.newEntry("lloc", this.val$lloc), QCircleReportHelper.newEntry("vid", this.val$vid), QCircleReportHelper.newEntry("photocubage", String.valueOf(this.val$photocubage)), QCircleReportHelper.newEntry("feedid", this.val$feedid), QCircleReportHelper.newEntry("total_upload_num", String.valueOf(this.val$totalUploadNum)), QCircleReportHelper.newEntry("device_maker", Build.BRAND), QCircleReportHelper.newEntry("device_model", Build.MODEL), QCircleReportHelper.newEntry("shooting_time", this.val$shootingTime), QCircleReportHelper.newEntry("orig_photocubage", String.valueOf(this.val$origPhotocubage)), QCircleReportHelper.newEntry("place", this.val$place), QCircleReportHelper.newEntry("up_place", this.val$upPlace), QCircleReportHelper.newEntry("shoot_product", this.val$shootProduct), QCircleReportHelper.newEntry("shoot_model", this.val$shootModel), QCircleReportHelper.newEntry("width", String.valueOf(this.val$width)), QCircleReportHelper.newEntry("height", String.valueOf(this.val$height)), QCircleReportHelper.newEntry("orig_width", String.valueOf(this.val$origWidth)), QCircleReportHelper.newEntry("orig_height", String.valueOf(this.val$origHeight)), QCircleReportHelper.newEntry("picture_format", this.val$pictureFormat), QCircleReportHelper.newEntry("feed_tag", this.val$feedTag), QCircleReportHelper.newEntry("author_uin", String.valueOf(this.val$authorUin)), QCircleReportHelper.newEntry("shoot_place", this.val$shootPlace) }));
    ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
    localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05494.access$000(), (List)localObject, null, QCircleReportHelper.getInstance().newSessionEntries(QCircleLpReportDc05494.access$100()));
    QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05494.1
 * JD-Core Version:    0.7.0.1
 */