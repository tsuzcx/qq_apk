package cooperation.qqcircle.report;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
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
      i = RFLog.USR;
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("requestReportSession success!scene:");
      paramBaseRequest.append(this.val$scene);
      RFLog.d("QCircleReportHelper", i, paramBaseRequest.toString());
      return;
    }
    int i = RFLog.USR;
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("requestReportSession scene:");
    paramBaseRequest.append(this.val$scene);
    paramBaseRequest.append(",retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(",error:");
    paramBaseRequest.append(paramString);
    RFLog.e("QCircleReportHelper", i, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper.1
 * JD-Core Version:    0.7.0.1
 */