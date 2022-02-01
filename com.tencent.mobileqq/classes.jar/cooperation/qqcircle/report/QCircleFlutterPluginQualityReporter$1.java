package cooperation.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleFlutterPluginQualityReporter$1
  implements Runnable
{
  QCircleFlutterPluginQualityReporter$1(QCircleFlutterPluginQualityReporter.ReportData paramReportData) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(10007);
    localSingleDcData.report_data.addAll(QCircleFlutterPluginQualityReporter.access$000(this.val$data));
    QCircleReporter.getInstance().addQualityReportData(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleFlutterPluginQualityReporter.1
 * JD-Core Version:    0.7.0.1
 */