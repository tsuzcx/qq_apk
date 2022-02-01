package cooperation.qqcircle.report;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class QCircleReporter$7
  implements Runnable
{
  QCircleReporter$7(QCircleReporter paramQCircleReporter, QQCircleReport.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    QCircleReporter.access$900(this.this$0).add(this.val$singleDcData);
    QCircleReporter.access$000(this.this$0);
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
    {
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add one SingleDcData:");
      localStringBuilder.append(QCircleReporter.access$800(this.val$singleDcData));
      RFLog.d("QCircleReporter_DoQuality", i, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.7
 * JD-Core Version:    0.7.0.1
 */