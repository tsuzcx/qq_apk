package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc05501$1
  implements Runnable
{
  QCircleLpReportDc05501$1(QCircleLpReportDc05501.DataBuilder paramDataBuilder) {}
  
  public void run()
  {
    Object localObject1 = QCircleReportHelper.newEntry("touin", QCircleLpReportDc05501.DataBuilder.access$300(this.val$builder));
    Object localObject2 = QCircleReportHelper.newEntry("actiontype", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$100(this.val$builder)));
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("subactiontype", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$200(this.val$builder)));
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("feedid", QCircleLpReportDc05501.DataBuilder.access$400(this.val$builder));
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("feed_tag", QCircleLpReportDc05501.DataBuilder.access$500(this.val$builder));
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("isreaded", "1");
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("page_id", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$000(this.val$builder)));
    FeedCloudCommon.Entry localEntry6 = QCircleReportHelper.newEntry("author_uin", QCircleLpReportDc05501.DataBuilder.access$600(this.val$builder));
    long l;
    if (QCircleLpReportDc05501.DataBuilder.access$700(this.val$builder) == 0L)
    {
      l = System.currentTimeMillis();
      localObject2 = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { localObject1, localObject2, localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, QCircleReportHelper.newEntry("acttime", String.valueOf(l)), QCircleReportHelper.newEntry("rule_id", QCircleLpReportDc05501.DataBuilder.access$800(this.val$builder)), QCircleReportHelper.newEntry("requestid", QCircleLpReportDc05501.DataBuilder.access$900(this.val$builder)) }));
      if (QCircleLpReportDc05501.DataBuilder.access$1000(this.val$builder) > -1) {
        ((List)localObject2).add(QCircleReportHelper.newEntry("index", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$1000(this.val$builder) + 1)));
      }
      if (QCircleLpReportDc05501.DataBuilder.access$1100(this.val$builder) > -1) {
        ((List)localObject2).add(QCircleReportHelper.newEntry("containerseq", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$1100(this.val$builder) + 1)));
      }
      if (QCircleLpReportDc05501.DataBuilder.access$1200(this.val$builder) <= -1) {
        break label722;
      }
      ((List)localObject2).add(QCircleReportHelper.newEntry("fpage_id", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$1200(this.val$builder))));
      label340:
      if (QCircleLpReportDc05501.DataBuilder.access$1300(this.val$builder) <= -1) {
        break label740;
      }
      ((List)localObject2).add(QCircleReportHelper.newEntry("ffpage_id", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$1300(this.val$builder))));
      label374:
      ((List)localObject2).add(QCircleReportHelper.newEntry("feedtype1", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$1400(this.val$builder))));
      ((List)localObject2).add(QCircleReportHelper.newEntry("feedtype2", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$1500(this.val$builder))));
      ((List)localObject2).add(QCircleReportHelper.newEntry("feedtype3", String.valueOf(QCircleLpReportDc05501.DataBuilder.access$1600(this.val$builder))));
      ((List)localObject2).add(QCircleReportHelper.newEntry("ext1", QCircleLpReportDc05501.DataBuilder.access$1700(this.val$builder)));
      ((List)localObject2).add(QCircleReportHelper.newEntry("ext2", QCircleLpReportDc05501.DataBuilder.access$1800(this.val$builder)));
      ((List)localObject2).add(QCircleReportHelper.newEntry("ext3", QCircleLpReportDc05501.DataBuilder.access$1900(this.val$builder)));
      ((List)localObject2).add(QCircleReportHelper.newEntry("ext4", QCircleLpReportDc05501.DataBuilder.access$2000(this.val$builder)));
      ((List)localObject2).add(QCircleReportHelper.newEntry("ext5", QCircleLpReportDc05501.DataBuilder.access$2100(this.val$builder)));
      ((List)localObject2).add(QCircleReportHelper.newEntry("ext6", QCircleLpReportDc05501.DataBuilder.access$2200(this.val$builder)));
      ((List)localObject2).add(QCircleReportHelper.newEntry("ext7", QCircleLpReportDc05501.DataBuilder.access$2300(this.val$builder)));
      ((List)localObject2).add(QCircleReportHelper.newEntry("ext8", QCircleLpReportDc05501.DataBuilder.access$2400(this.val$builder)));
      ((List)localObject2).addAll(QCircleReportHelper.getInstance().newBaseEntries());
      ((List)localObject2).addAll(QCircleReportHelper.convertEntryList(QCircleLpReportDc05501.DataBuilder.access$2500(this.val$builder)));
      if (QCircleLpReportDc05501.DataBuilder.access$2600(this.val$builder) == null) {
        break label758;
      }
    }
    label722:
    label740:
    label758:
    for (localObject1 = QCircleReportHelper.getInstance().newSessionEntries(QCircleLpReportDc05501.DataBuilder.access$000(this.val$builder), QCircleLpReportDc05501.DataBuilder.access$2600(this.val$builder));; localObject1 = QCircleReportHelper.getInstance().newSessionEntries(QCircleLpReportDc05501.DataBuilder.access$000(this.val$builder)))
    {
      localObject1 = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05501.access$2700(), (List)localObject2, null, (List)localObject1);
      if (!QCircleReportHelper.getInstance().hasValidSession()) {
        break label775;
      }
      QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject1, QCircleLpReportDc05501.access$2800(QCircleLpReportDc05501.DataBuilder.access$100(this.val$builder), QCircleLpReportDc05501.DataBuilder.access$200(this.val$builder)));
      return;
      l = QCircleLpReportDc05501.DataBuilder.access$700(this.val$builder);
      break;
      ((List)localObject2).add(QCircleReportHelper.newEntry("fpage_id", "0"));
      break label340;
      ((List)localObject2).add(QCircleReportHelper.newEntry("ffpage_id", "0"));
      break label374;
    }
    label775:
    QLog.w("QCircleReporter", 1, "QCircleLpReportDc05501 report miss Session: actiontype:" + QCircleLpReportDc05501.DataBuilder.access$100(this.val$builder) + ",subActionType:" + QCircleLpReportDc05501.DataBuilder.access$200(this.val$builder) + ",add Miss Session report cache list");
    QCircleReporter.getInstance().addMissSessionReportDataCache((QQCircleReport.SingleDcData)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05501.1
 * JD-Core Version:    0.7.0.1
 */