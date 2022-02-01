package cooperation.qqcircle.report;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetSessionInfoRsp;

class QCircleReportHelper$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetSessionInfoRsp>
{
  QCircleReportHelper$1(QCircleReportHelper paramQCircleReportHelper, int paramInt) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetSessionInfoRsp paramStGetSessionInfoRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetSessionInfoRsp != null))
    {
      QCircleReportHelper.access$000(this.this$0, paramStGetSessionInfoRsp, this.val$scene);
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("requestReportSession success!scene:");
      paramBaseRequest.append(this.val$scene);
      QLog.d("QCircleReportHelper", 1, paramBaseRequest.toString());
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("requestReportSession scene:");
    paramBaseRequest.append(this.val$scene);
    paramBaseRequest.append(",retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(",error:");
    paramBaseRequest.append(paramString);
    QLog.e("QCircleReportHelper", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper.1
 * JD-Core Version:    0.7.0.1
 */