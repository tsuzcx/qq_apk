package cooperation.qqcircle.report;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class QCircleReporter$6
  implements Runnable
{
  QCircleReporter$6(QCircleReporter paramQCircleReporter, QQCircleReport.SingleDcData paramSingleDcData, boolean paramBoolean) {}
  
  public void run()
  {
    if (QCircleReporter.access$400(this.this$0) != null) {
      QCircleReporter.access$400(this.this$0).onAddReportData(this.val$singleDcData.dcid.get(), this.val$singleDcData.report_data.get());
    }
    if (this.val$isReportNow)
    {
      QCircleReporter.access$500(this.this$0).add(this.val$singleDcData);
      QCircleReporter.access$600(this.this$0);
    }
    else
    {
      QCircleReporter.access$700(this.this$0).add(this.val$singleDcData);
    }
    QCircleReporter.access$000(this.this$0);
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleReporter");
      if (this.val$isReportNow) {
        str = "_DoImmediate";
      } else {
        str = "_DoNormal";
      }
      localStringBuilder.append(str);
      String str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("add one SingleDcData:");
      localStringBuilder.append(QCircleReporter.access$800(this.val$singleDcData));
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.6
 * JD-Core Version:    0.7.0.1
 */