package cooperation.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleQualityReporter$1
  implements Runnable
{
  QCircleQualityReporter$1(int paramInt, String paramString, List paramList) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(this.val$dcId);
    localSingleDcData.report_data.addAll(QCircleQualityReporter.createBaseEntries(this.val$eventId));
    List localList = this.val$reportData;
    if ((localList != null) && (!localList.isEmpty())) {
      localSingleDcData.report_data.addAll(this.val$reportData);
    }
    QCircleReporter.getInstance().addQualityReportData(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleQualityReporter.1
 * JD-Core Version:    0.7.0.1
 */