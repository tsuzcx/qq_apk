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
    QCircleReporter.access$800(this.this$0).add(this.val$singleDcData);
    QCircleReporter.access$000(this.this$0);
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
      RFLog.d("QCircleReporter_DoQuality", RFLog.CLR, "add one SingleDcData:" + QCircleReporter.access$700(this.val$singleDcData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.7
 * JD-Core Version:    0.7.0.1
 */