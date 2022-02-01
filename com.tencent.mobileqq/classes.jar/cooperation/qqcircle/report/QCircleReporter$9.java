package cooperation.qqcircle.report;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class QCircleReporter$9
  implements Runnable
{
  QCircleReporter$9(QCircleReporter paramQCircleReporter, QQCircleReport.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    QCircleReporter.access$200(this.this$0).add(this.val$singleDcData);
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add one SingleDcData:");
      localStringBuilder.append(QCircleReporter.access$800(this.val$singleDcData));
      QLog.d("QCircleReporter_DoCacheFirst", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.9
 * JD-Core Version:    0.7.0.1
 */