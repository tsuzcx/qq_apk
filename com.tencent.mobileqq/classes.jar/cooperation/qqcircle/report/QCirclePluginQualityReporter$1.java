package cooperation.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCircleReport.SingleDcData;

final class QCirclePluginQualityReporter$1
  implements Runnable
{
  QCirclePluginQualityReporter$1(QCirclePluginQualityReporter.ReportData paramReportData) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(10004);
    localSingleDcData.report_data.addAll(QCirclePluginQualityReporter.access$000(this.val$data));
    QCircleReporter.getInstance().addQualityReportData(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCirclePluginQualityReporter.1
 * JD-Core Version:    0.7.0.1
 */