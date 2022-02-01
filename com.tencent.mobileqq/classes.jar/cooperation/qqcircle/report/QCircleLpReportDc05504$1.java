package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
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
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("touin", QCircleLpReportDc05504.DataBuilder.access$000(this.val$builder)), QCircleReportHelper.newEntry("actiontype", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$100(this.val$builder))), QCircleReportHelper.newEntry("subactiontype", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$200(this.val$builder))), QCircleReportHelper.newEntry("thr_action", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$300(this.val$builder))), QCircleReportHelper.newEntry("vid", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$400(this.val$builder))), QCircleReportHelper.newEntry("ext1", QCircleLpReportDc05504.DataBuilder.access$500(this.val$builder)), QCircleReportHelper.newEntry("ext2", QCircleLpReportDc05504.DataBuilder.access$600(this.val$builder)), QCircleReportHelper.newEntry("ext3", QCircleLpReportDc05504.DataBuilder.access$700(this.val$builder)), QCircleReportHelper.newEntry("ext4", QCircleLpReportDc05504.DataBuilder.access$800(this.val$builder)), QCircleReportHelper.newEntry("ext5", QCircleLpReportDc05504.DataBuilder.access$900(this.val$builder)), QCircleReportHelper.newEntry("ext6", QCircleLpReportDc05504.DataBuilder.access$1000(this.val$builder)), QCircleReportHelper.newEntry("ext7", QCircleLpReportDc05504.DataBuilder.access$1100(this.val$builder)), QCircleReportHelper.newEntry("ext8", QCircleLpReportDc05504.DataBuilder.access$1200(this.val$builder)), QCircleReportHelper.newEntry("ext9", QCircleLpReportDc05504.DataBuilder.access$1300(this.val$builder)), QCircleReportHelper.newEntry("ext10", QCircleLpReportDc05504.DataBuilder.access$1400(this.val$builder)), QCircleReportHelper.newEntry("ext11", QCircleLpReportDc05504.DataBuilder.access$1500(this.val$builder)), QCircleReportHelper.newEntry("ext12", QCircleLpReportDc05504.DataBuilder.access$1600(this.val$builder)), QCircleReportHelper.newEntry("ext13", QCircleLpReportDc05504.DataBuilder.access$1700(this.val$builder)), QCircleReportHelper.newEntry("ext14", QCircleLpReportDc05504.DataBuilder.access$1800(this.val$builder)), QCircleReportHelper.newEntry("ext15", QCircleLpReportDc05504.DataBuilder.access$1900(this.val$builder)), QCircleReportHelper.newEntry("ext16", QCircleLpReportDc05504.DataBuilder.access$2000(this.val$builder)), QCircleReportHelper.newEntry("ext17", QCircleLpReportDc05504.DataBuilder.access$2100(this.val$builder)), QCircleReportHelper.newEntry("ext18", QCircleLpReportDc05504.DataBuilder.access$2200(this.val$builder)) }));
    if (QCircleLpReportDc05504.DataBuilder.access$2300(this.val$builder) > -1) {
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$2300(this.val$builder))));
    } else {
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", "0"));
    }
    if (QCircleLpReportDc05504.DataBuilder.access$2400(this.val$builder) > -1) {
      ((List)localObject).add(QCircleReportHelper.newEntry("fpage_id", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$2400(this.val$builder))));
    } else {
      ((List)localObject).add(QCircleReportHelper.newEntry("fpage_id", "0"));
    }
    if (QCircleLpReportDc05504.DataBuilder.access$2500(this.val$builder) > -1) {
      ((List)localObject).add(QCircleReportHelper.newEntry("ffpage_id", String.valueOf(QCircleLpReportDc05504.DataBuilder.access$2500(this.val$builder))));
    } else {
      ((List)localObject).add(QCircleReportHelper.newEntry("ffpage_id", "0"));
    }
    ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
    ((List)localObject).addAll(QCircleReportHelper.convertEntryList(QCircleLpReportDc05504.DataBuilder.access$2600(this.val$builder)));
    localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05504.access$2700(), (List)localObject, null, QCircleReportHelper.getInstance().newSessionEntries(QCircleLpReportDc05504.DataBuilder.access$2300(this.val$builder), QCircleLpReportDc05504.DataBuilder.access$2800(this.val$builder), QCircleLpReportDc05504.DataBuilder.access$2900(this.val$builder), QCircleLpReportDc05504.DataBuilder.access$3000(this.val$builder)));
    if ((!QCircleReportHelper.getInstance().hasValidSession()) && (!QCircleLpReportDc05504.access$3100(QCircleLpReportDc05504.DataBuilder.access$100(this.val$builder))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleLpReportDc05504 report miss Session: actiontype:");
      localStringBuilder.append(QCircleLpReportDc05504.DataBuilder.access$100(this.val$builder));
      localStringBuilder.append(",subActionType:");
      localStringBuilder.append(QCircleLpReportDc05504.DataBuilder.access$200(this.val$builder));
      localStringBuilder.append(",thrActionType:");
      localStringBuilder.append(QCircleLpReportDc05504.DataBuilder.access$300(this.val$builder));
      localStringBuilder.append(",add Miss Session report cache list");
      QLog.w("QCircleReporter", 1, localStringBuilder.toString());
      QCircleReporter.getInstance().addMissSessionReportDataCache((QQCircleReport.SingleDcData)localObject);
      return;
    }
    QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05504.1
 * JD-Core Version:    0.7.0.1
 */