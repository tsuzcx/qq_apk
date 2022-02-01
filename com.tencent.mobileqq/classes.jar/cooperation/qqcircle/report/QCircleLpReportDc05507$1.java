package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc05507$1
  implements Runnable
{
  QCircleLpReportDc05507$1(QCircleLpReportDc05507.DataBuilder paramDataBuilder) {}
  
  public void run()
  {
    Object localObject2 = QCircleReportHelper.newEntry("touin", QCircleLpReportDc05507.DataBuilder.access$300(this.val$builder));
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("actiontype", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$100(this.val$builder)));
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("subactiontype", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$200(this.val$builder)));
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("feedid", QCircleLpReportDc05507.DataBuilder.access$400(this.val$builder));
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("author_uin", QCircleLpReportDc05507.DataBuilder.access$500(this.val$builder));
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("play_scene", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$600(this.val$builder)));
    FeedCloudCommon.Entry localEntry6 = QCircleReportHelper.newEntry("position_id", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$700(this.val$builder) + 1));
    FeedCloudCommon.Entry localEntry7 = QCircleReportHelper.newEntry("feed_tag", QCircleLpReportDc05507.DataBuilder.access$800(this.val$builder));
    FeedCloudCommon.Entry localEntry8 = QCircleReportHelper.newEntry("play_url", QCircleLpReportDc05507.DataBuilder.access$900(this.val$builder));
    FeedCloudCommon.Entry localEntry9 = QCircleReportHelper.newEntry("video_tag", QCircleLpReportDc05507.DataBuilder.access$1000(this.val$builder));
    FeedCloudCommon.Entry localEntry10 = QCircleReportHelper.newEntry("pic_info", QCircleLpReportDc05507.DataBuilder.access$1100(this.val$builder));
    FeedCloudCommon.Entry localEntry11 = QCircleReportHelper.newEntry("item_detail", QCircleLpReportDc05507.DataBuilder.access$1200(this.val$builder));
    FeedCloudCommon.Entry localEntry12 = QCircleReportHelper.newEntry("acttime", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$1300(this.val$builder)));
    FeedCloudCommon.Entry localEntry13 = QCircleReportHelper.newEntry("vid", QCircleLpReportDc05507.DataBuilder.access$1400(this.val$builder));
    FeedCloudCommon.Entry localEntry14 = QCircleReportHelper.newEntry("lloc", QCircleLpReportDc05507.DataBuilder.access$1500(this.val$builder));
    FeedCloudCommon.Entry localEntry15 = QCircleReportHelper.newEntry("ext1", QCircleLpReportDc05507.DataBuilder.access$1600(this.val$builder));
    FeedCloudCommon.Entry localEntry16 = QCircleReportHelper.newEntry("ext2", QCircleLpReportDc05507.DataBuilder.access$1700(this.val$builder));
    FeedCloudCommon.Entry localEntry17 = QCircleReportHelper.newEntry("ext3", QCircleLpReportDc05507.DataBuilder.access$1800(this.val$builder));
    FeedCloudCommon.Entry localEntry18 = QCircleReportHelper.newEntry("ext4", QCircleLpReportDc05507.DataBuilder.access$1900(this.val$builder));
    FeedCloudCommon.Entry localEntry19 = QCircleReportHelper.newEntry("ext5", QCircleLpReportDc05507.DataBuilder.access$2000(this.val$builder));
    FeedCloudCommon.Entry localEntry20 = QCircleReportHelper.newEntry("ext6", QCircleLpReportDc05507.DataBuilder.access$2100(this.val$builder));
    FeedCloudCommon.Entry localEntry21 = QCircleReportHelper.newEntry("ext7", QCircleLpReportDc05507.DataBuilder.access$2200(this.val$builder));
    FeedCloudCommon.Entry localEntry22 = QCircleReportHelper.newEntry("ext8", QCircleLpReportDc05507.DataBuilder.access$2300(this.val$builder));
    FeedCloudCommon.Entry localEntry23 = QCircleReportHelper.newEntry("ext9", QCircleLpReportDc05507.DataBuilder.access$2400(this.val$builder));
    FeedCloudCommon.Entry localEntry24 = QCircleReportHelper.newEntry("ext10", QCircleLpReportDc05507.DataBuilder.access$2500(this.val$builder));
    FeedCloudCommon.Entry localEntry25 = QCircleReportHelper.newEntry("rule_id", QCircleLpReportDc05507.DataBuilder.access$2600(this.val$builder));
    FeedCloudCommon.Entry localEntry26 = QCircleReportHelper.newEntry("feeds_url", QCircleLpReportDc05507.DataBuilder.access$2700(this.val$builder));
    FeedCloudCommon.Entry localEntry27 = QCircleReportHelper.newEntry("requestid", QCircleLpReportDc05507.DataBuilder.access$2800(this.val$builder));
    FeedCloudCommon.Entry localEntry28 = QCircleReportHelper.newEntry("feedtype1", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$2900(this.val$builder)));
    FeedCloudCommon.Entry localEntry29 = QCircleReportHelper.newEntry("feedtype2", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$3000(this.val$builder)));
    FeedCloudCommon.Entry localEntry30 = QCircleReportHelper.newEntry("feedtype3", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$3100(this.val$builder)));
    FeedCloudCommon.Entry localEntry31 = QCircleReportHelper.newEntry("video_total_time", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$3200(this.val$builder)));
    FeedCloudCommon.Entry localEntry32 = QCircleReportHelper.newEntry("video_type", QCircleLpReportDc05507.DataBuilder.access$3300(this.val$builder));
    FeedCloudCommon.Entry localEntry33 = QCircleReportHelper.newEntry("cubage", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$3400(this.val$builder)));
    FeedCloudCommon.Entry localEntry34 = QCircleReportHelper.newEntry("width", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$3500(this.val$builder)));
    FeedCloudCommon.Entry localEntry35 = QCircleReportHelper.newEntry("height", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$3600(this.val$builder)));
    FeedCloudCommon.Entry localEntry36 = QCircleReportHelper.newEntry("clear", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$3700(this.val$builder)));
    FeedCloudCommon.Entry localEntry37 = QCircleReportHelper.newEntry("play_id", QCircleLpReportDc05507.DataBuilder.access$3800(this.val$builder));
    FeedCloudCommon.Entry localEntry38 = QCircleReportHelper.newEntry("video_play_time", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$3900(this.val$builder)));
    FeedCloudCommon.Entry localEntry39 = QCircleReportHelper.newEntry("video_solo_time", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$4000(this.val$builder)));
    if (QCircleLpReportDc05507.DataBuilder.access$4100(this.val$builder)) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    Object localObject1 = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { localObject2, localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, localEntry8, localEntry9, localEntry10, localEntry11, localEntry12, localEntry13, localEntry14, localEntry15, localEntry16, localEntry17, localEntry18, localEntry19, localEntry20, localEntry21, localEntry22, localEntry23, localEntry24, localEntry25, localEntry26, localEntry27, localEntry28, localEntry29, localEntry30, localEntry31, localEntry32, localEntry33, localEntry34, localEntry35, localEntry36, localEntry37, localEntry38, localEntry39, QCircleReportHelper.newEntry("is_auto_play", (String)localObject1), QCircleReportHelper.newEntry("errorcode", QCircleLpReportDc05507.DataBuilder.access$4200(this.val$builder)) }));
    if (QCircleLpReportDc05507.DataBuilder.access$000(this.val$builder) > -1) {
      ((List)localObject1).add(QCircleReportHelper.newEntry("page_id", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$000(this.val$builder))));
    } else {
      ((List)localObject1).add(QCircleReportHelper.newEntry("page_id", "0"));
    }
    if (QCircleLpReportDc05507.DataBuilder.access$4300(this.val$builder) > -1) {
      ((List)localObject1).add(QCircleReportHelper.newEntry("fpage_id", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$4300(this.val$builder))));
    } else {
      ((List)localObject1).add(QCircleReportHelper.newEntry("fpage_id", "0"));
    }
    if (QCircleLpReportDc05507.DataBuilder.access$4400(this.val$builder) > -1) {
      ((List)localObject1).add(QCircleReportHelper.newEntry("ffpage_id", String.valueOf(QCircleLpReportDc05507.DataBuilder.access$4400(this.val$builder))));
    } else {
      ((List)localObject1).add(QCircleReportHelper.newEntry("ffpage_id", "0"));
    }
    if (QCircleLpReportDc05507.DataBuilder.access$4500(this.val$builder) != null) {
      ((List)localObject1).addAll(QCircleReportHelper.convertEntryList(QCircleLpReportDc05507.DataBuilder.access$4500(this.val$builder)));
    }
    ((List)localObject1).addAll(QCircleReportHelper.getInstance().newBaseEntries());
    localObject1 = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05507.access$4600(), (List)localObject1, null, QCircleReportHelper.getInstance().newSessionEntries(QCircleLpReportDc05507.DataBuilder.access$000(this.val$builder), QCircleLpReportDc05507.DataBuilder.access$4700(this.val$builder)));
    if (QCircleReportHelper.getInstance().hasValidSession())
    {
      QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject1, QCircleLpReportDc05507.access$4800(QCircleLpReportDc05507.DataBuilder.access$100(this.val$builder), QCircleLpReportDc05507.DataBuilder.access$200(this.val$builder)));
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("QCircleLpReportDc05507 report miss Session: actiontype:");
    ((StringBuilder)localObject2).append(QCircleLpReportDc05507.DataBuilder.access$100(this.val$builder));
    ((StringBuilder)localObject2).append(",subActionType:");
    ((StringBuilder)localObject2).append(QCircleLpReportDc05507.DataBuilder.access$200(this.val$builder));
    ((StringBuilder)localObject2).append(",add Miss Session report cache list");
    QLog.w("QCircleReporter", 1, ((StringBuilder)localObject2).toString());
    QCircleReporter.getInstance().addMissSessionReportDataCache((QQCircleReport.SingleDcData)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05507.1
 * JD-Core Version:    0.7.0.1
 */