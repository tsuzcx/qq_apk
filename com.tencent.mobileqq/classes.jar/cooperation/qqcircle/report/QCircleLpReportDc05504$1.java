package cooperation.qqcircle.report;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc05504$1
  implements Runnable
{
  QCircleLpReportDc05504$1(QCircleLpReportDc05504.DataBuilder paramDataBuilder) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("touin", QCircleLpReportDc05504.DataBuilder.access$000(this.val$builder)), QCircleReportHelper.newEntry("actiontype", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$100(this.val$builder))), QCircleReportHelper.newEntry("subactiontype", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$200(this.val$builder))), QCircleReportHelper.newEntry("thr_action", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$300(this.val$builder))), QCircleReportHelper.newEntry("vid", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$400(this.val$builder))), QCircleReportHelper.newEntry("ext1", QCircleLpReportDc05504.DataBuilder.access$500(this.val$builder)), QCircleReportHelper.newEntry("ext2", QCircleLpReportDc05504.DataBuilder.access$600(this.val$builder)), QCircleReportHelper.newEntry("ext3", QCircleLpReportDc05504.DataBuilder.access$700(this.val$builder)), QCircleReportHelper.newEntry("ext4", QCircleLpReportDc05504.DataBuilder.access$800(this.val$builder)), QCircleReportHelper.newEntry("ext5", QCircleLpReportDc05504.DataBuilder.access$900(this.val$builder)), QCircleReportHelper.newEntry("ext6", QCircleLpReportDc05504.DataBuilder.access$1000(this.val$builder)), QCircleReportHelper.newEntry("ext7", QCircleLpReportDc05504.DataBuilder.access$1100(this.val$builder)), QCircleReportHelper.newEntry("ext8", QCircleLpReportDc05504.DataBuilder.access$1200(this.val$builder)), QCircleReportHelper.newEntry("ext9", QCircleLpReportDc05504.DataBuilder.access$1300(this.val$builder)), QCircleReportHelper.newEntry("ext10", QCircleLpReportDc05504.DataBuilder.access$1400(this.val$builder)), QCircleReportHelper.newEntry("ext11", QCircleLpReportDc05504.DataBuilder.access$1500(this.val$builder)), QCircleReportHelper.newEntry("ext12", QCircleLpReportDc05504.DataBuilder.access$1600(this.val$builder)), QCircleReportHelper.newEntry("ext13", QCircleLpReportDc05504.DataBuilder.access$1700(this.val$builder)), QCircleReportHelper.newEntry("ext14", QCircleLpReportDc05504.DataBuilder.access$1800(this.val$builder)) }));
    if (QCircleLpReportDc05504.DataBuilder.access$1900(this.val$builder) > -1)
    {
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$1900(this.val$builder))));
      if (QCircleLpReportDc05504.DataBuilder.access$2000(this.val$builder) <= -1) {
        break label546;
      }
      ((List)localObject).add(QCircleReportHelper.newEntry("fpage_id", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$2000(this.val$builder))));
      label392:
      if (QCircleLpReportDc05504.DataBuilder.access$2100(this.val$builder) <= -1) {
        break label563;
      }
      ((List)localObject).add(QCircleReportHelper.newEntry("ffpage_id", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$2100(this.val$builder))));
    }
    for (;;)
    {
      ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
      ((List)localObject).addAll(QCircleReportHelper.convertEntryList(QCircleLpReportDc05504.DataBuilder.access$2200(this.val$builder)));
      localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05504.access$2300(), (List)localObject, null, QCircleReportHelper.getInstance().newSessionEntries(QCircleLpReportDc05504.DataBuilder.access$1900(this.val$builder), QCircleLpReportDc05504.DataBuilder.access$2400(this.val$builder), QCircleLpReportDc05504.DataBuilder.access$2500(this.val$builder), QCircleLpReportDc05504.DataBuilder.access$2600(this.val$builder)));
      if ((!QCircleReportHelper.getInstance().hasValidSession()) && (!QCircleLpReportDc05504.access$2700(QCircleLpReportDc05504.DataBuilder.access$100(this.val$builder)))) {
        break label580;
      }
      QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, false);
      return;
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", "0"));
      break;
      label546:
      ((List)localObject).add(QCircleReportHelper.newEntry("fpage_id", "0"));
      break label392;
      label563:
      ((List)localObject).add(QCircleReportHelper.newEntry("ffpage_id", "0"));
    }
    label580:
    RFLog.w("QCircleReporter", RFLog.USR, "QCircleLpReportDc05504 report miss Session: actiontype:" + QCircleLpReportDc05504.DataBuilder.access$100(this.val$builder) + ",subActionType:" + QCircleLpReportDc05504.DataBuilder.access$200(this.val$builder) + ",thrActionType:" + QCircleLpReportDc05504.DataBuilder.access$300(this.val$builder) + ",add Miss Session report cache list");
    QCircleReporter.getInstance().addMissSessionReportDataCache((QQCircleReport.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05504.1
 * JD-Core Version:    0.7.0.1
 */