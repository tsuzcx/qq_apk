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
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetSessionInfoRsp == null))
    {
      RFLog.e("QCircleReportHelper", RFLog.USR, "requestReportSession scene:" + this.val$scene + ",retCode:" + paramLong + ",error:" + paramString);
      return;
    }
    QCircleReportHelper.access$000(this.this$0, paramStGetSessionInfoRsp, this.val$scene);
    RFLog.d("QCircleReportHelper", RFLog.USR, "requestReportSession success!scene:" + this.val$scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper.1
 * JD-Core Version:    0.7.0.1
 */