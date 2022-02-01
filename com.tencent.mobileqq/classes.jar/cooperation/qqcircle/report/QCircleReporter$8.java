package cooperation.qqcircle.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

class QCircleReporter$8
  implements Runnable
{
  QCircleReporter$8(QCircleReporter paramQCircleReporter, APP_REPORT_TRANSFER.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    QCircleReporter.access$1000(this.this$0).add(this.val$singleDcData);
    QCircleReporter.access$000(this.this$0);
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
    {
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add one SingleDcData:");
      localStringBuilder.append(QCircleReporter.access$1100(this.val$singleDcData));
      RFLog.d("QCircleReporter_DoCommandReport", i, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.8
 * JD-Core Version:    0.7.0.1
 */