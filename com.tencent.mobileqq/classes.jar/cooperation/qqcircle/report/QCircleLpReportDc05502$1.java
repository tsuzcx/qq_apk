package cooperation.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc05502$1
  implements Runnable
{
  QCircleLpReportDc05502$1(QCircleLpReportDc05502.DataBuilder paramDataBuilder) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("touin", QCircleLpReportDc05502.DataBuilder.access$200(this.val$builder)), QCircleReportHelper.newEntry("index", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$300(this.val$builder) + 1)), QCircleReportHelper.newEntry("feedid", QCircleLpReportDc05502.DataBuilder.access$400(this.val$builder)), QCircleReportHelper.newEntry("feed_tag", QCircleLpReportDc05502.DataBuilder.access$500(this.val$builder)), QCircleReportHelper.newEntry("isreaded", "1"), QCircleReportHelper.newEntry("page_id", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$000(this.val$builder))), QCircleReportHelper.newEntry("fpage_id", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$100(this.val$builder))), QCircleReportHelper.newEntry("ffpage_id", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$600(this.val$builder))), QCircleReportHelper.newEntry("requestid", QCircleLpReportDc05502.DataBuilder.access$700(this.val$builder)), QCircleReportHelper.newEntry("rule_id", QCircleLpReportDc05502.DataBuilder.access$800(this.val$builder)), QCircleReportHelper.newEntry("containerseq", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$900(this.val$builder))), QCircleReportHelper.newEntry("begin_time", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$1000(this.val$builder))), QCircleReportHelper.newEntry("end_time", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$1100(this.val$builder))), QCircleReportHelper.newEntry("stay_time", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$1200(this.val$builder))), QCircleReportHelper.newEntry("author_uin", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$1300(this.val$builder))), QCircleReportHelper.newEntry("feedtype1", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$1400(this.val$builder))), QCircleReportHelper.newEntry("feedtype2", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$1500(this.val$builder))), QCircleReportHelper.newEntry("feedtype3", String.valueOf(QCircleLpReportDc05502.DataBuilder.access$1600(this.val$builder))), QCircleReportHelper.newEntry("ext1", QCircleLpReportDc05502.DataBuilder.access$1700(this.val$builder)), QCircleReportHelper.newEntry("ext2", QCircleLpReportDc05502.DataBuilder.access$1800(this.val$builder)), QCircleReportHelper.newEntry("ext3", QCircleLpReportDc05502.DataBuilder.access$1900(this.val$builder)), QCircleReportHelper.newEntry("ext4", QCircleLpReportDc05502.DataBuilder.access$2000(this.val$builder)), QCircleReportHelper.newEntry("ext5", QCircleLpReportDc05502.DataBuilder.access$2100(this.val$builder)), QCircleReportHelper.newEntry("ext6", QCircleLpReportDc05502.DataBuilder.access$2200(this.val$builder)), QCircleReportHelper.newEntry("ext7", QCircleLpReportDc05502.DataBuilder.access$2300(this.val$builder)), QCircleReportHelper.newEntry("ext8", QCircleLpReportDc05502.DataBuilder.access$2400(this.val$builder)) }));
    if (QCircleLpReportDc05502.DataBuilder.access$2500(this.val$builder) != null) {
      ((List)localObject).addAll(QCircleReportHelper.convertEntryList(QCircleLpReportDc05502.DataBuilder.access$2500(this.val$builder)));
    }
    ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
    localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05502.access$2600(), (List)localObject, null, QCircleReportHelper.getInstance().newSessionEntries(QCircleLpReportDc05502.DataBuilder.access$000(this.val$builder), QCircleLpReportDc05502.DataBuilder.access$2700(this.val$builder)));
    QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05502.1
 * JD-Core Version:    0.7.0.1
 */