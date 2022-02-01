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
  QCircleLpReportDc05494$1(QCircleTaskReportInfo paramQCircleTaskReportInfo) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("up_source", String.valueOf(this.val$reportInto.up_source)), QCircleReportHelper.newEntry("up_type", String.valueOf(this.val$reportInto.up_type)), QCircleReportHelper.newEntry("is_video", String.valueOf(this.val$reportInto.is_video)), QCircleReportHelper.newEntry("txtinfo", this.val$reportInto.txtinfo), QCircleReportHelper.newEntry("lloc", this.val$reportInto.lloc), QCircleReportHelper.newEntry("vid", this.val$reportInto.vid), QCircleReportHelper.newEntry("photocubage", String.valueOf(this.val$reportInto.clientCompressPicSize)), QCircleReportHelper.newEntry("feedid", this.val$reportInto.feedid), QCircleReportHelper.newEntry("total_upload_num", String.valueOf(this.val$reportInto.total_upload_num)), QCircleReportHelper.newEntry("device_maker", Build.BRAND), QCircleReportHelper.newEntry("device_model", Build.MODEL), QCircleReportHelper.newEntry("shooting_time", this.val$reportInto.shooting_time), QCircleReportHelper.newEntry("orig_photocubage", String.valueOf(this.val$reportInto.editedPicSize)), QCircleReportHelper.newEntry("place", this.val$reportInto.place), QCircleReportHelper.newEntry("up_place", this.val$reportInto.up_place), QCircleReportHelper.newEntry("shoot_product", this.val$reportInto.shoot_product), QCircleReportHelper.newEntry("shoot_model", this.val$reportInto.shoot_model), QCircleReportHelper.newEntry("width", String.valueOf(this.val$reportInto.clientCompressPicWidth)), QCircleReportHelper.newEntry("height", String.valueOf(this.val$reportInto.clientCompressPicHeight)), QCircleReportHelper.newEntry("orig_width", String.valueOf(this.val$reportInto.editedPicWidth)), QCircleReportHelper.newEntry("orig_height", String.valueOf(this.val$reportInto.editedPicHeight)), QCircleReportHelper.newEntry("picture_format", this.val$reportInto.picture_format), QCircleReportHelper.newEntry("feed_tag", this.val$reportInto.feed_tag), QCircleReportHelper.newEntry("author_uin", String.valueOf(this.val$reportInto.author_uin)), QCircleReportHelper.newEntry("shoot_place", this.val$reportInto.shoot_place) }));
    ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
    localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05494.access$000(), (List)localObject, null, QCircleReportHelper.getInstance().newSessionEntries(QCircleLpReportDc05494.access$100()));
    QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05494.1
 * JD-Core Version:    0.7.0.1
 */