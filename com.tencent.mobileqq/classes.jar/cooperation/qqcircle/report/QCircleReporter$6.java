package cooperation.qqcircle.report;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class QCircleReporter$6
  implements Runnable
{
  QCircleReporter$6(QCircleReporter paramQCircleReporter, boolean paramBoolean, QQCircleReport.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (this.val$isReportNow)
    {
      QCircleReporter.access$400(this.this$0).add(this.val$singleDcData);
      QCircleReporter.access$500(this.this$0);
      QCircleReporter.access$000(this.this$0);
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
      {
        localStringBuilder = new StringBuilder().append("QCircleReporter");
        if (!this.val$isReportNow) {
          break label137;
        }
      }
    }
    label137:
    for (String str = "_DoImmediate";; str = "_DoNormal")
    {
      RFLog.d(str, RFLog.CLR, "add one SingleDcData:" + QCircleReporter.access$700(this.val$singleDcData));
      return;
      QCircleReporter.access$600(this.this$0).add(this.val$singleDcData);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.6
 * JD-Core Version:    0.7.0.1
 */