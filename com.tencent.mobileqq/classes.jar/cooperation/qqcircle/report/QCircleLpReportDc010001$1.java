package cooperation.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc010001$1
  implements Runnable
{
  QCircleLpReportDc010001$1(QCircleLpReportDc010001.DataBuilder paramDataBuilder) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("actiontype", String.valueOf(QCircleLpReportDc010001.DataBuilder.access$000(this.val$builder))), QCircleReportHelper.newEntry("subactiontype", String.valueOf(QCircleLpReportDc010001.DataBuilder.access$100(this.val$builder))), QCircleReportHelper.newEntry("thr_action", String.valueOf(QCircleLpReportDc010001.DataBuilder.access$200(this.val$builder))), QCircleReportHelper.newEntry("mainType", String.valueOf(QCircleLpReportDc010001.DataBuilder.access$300(this.val$builder))), QCircleReportHelper.newEntry("subType", String.valueOf(QCircleLpReportDc010001.DataBuilder.access$400(this.val$builder))), QCircleReportHelper.newEntry("busiMsgId", QCircleLpReportDc010001.DataBuilder.access$500(this.val$builder)), QCircleReportHelper.newEntry("eeveeMsgId", QCircleLpReportDc010001.DataBuilder.access$600(this.val$builder)), QCircleReportHelper.newEntry("scene", String.valueOf(QCircleLpReportDc010001.DataBuilder.access$700(this.val$builder))), QCircleReportHelper.newEntry("app_id", String.valueOf(10000)) }));
    ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
    localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc010001.access$800(), (List)localObject, null, null);
    QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc010001.1
 * JD-Core Version:    0.7.0.1
 */