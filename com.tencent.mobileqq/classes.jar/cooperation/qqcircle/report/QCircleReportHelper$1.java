package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetSessionInfoRsp;

class QCircleReportHelper$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetSessionInfoRsp>
{
  QCircleReportHelper$1(QCircleReportHelper paramQCircleReportHelper, int paramInt) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetSessionInfoRsp paramStGetSessionInfoRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetSessionInfoRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QLog.e("QCircleReportHelper", 1, "requestReportSession error:" + paramString);
      }
      return;
    }
    QCircleReportHelper.access$000(this.this$0, paramStGetSessionInfoRsp, this.val$scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper.1
 * JD-Core Version:    0.7.0.1
 */