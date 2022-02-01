package cooperation.qqcircle.report.outbox;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleReport.StDataReportRsp;

final class QCircleNetDetectHelper$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleReport.StDataReportRsp>
{
  QCircleNetDetectHelper$1(QCircleNetDetectHelper.DetectListener paramDetectListener) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StDataReportRsp paramStDataReportRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStDataReportRsp == null)) && (!TextUtils.isEmpty(paramString))) {
      RFLog.e("QCircleNetCheckHelper", RFLog.USR, "detect net connection blocked retcode:" + paramLong + ",error:" + paramString + ",traceId:" + paramBaseRequest.getTraceId());
    }
    RFLog.d("QCircleNetCheckHelper", RFLog.CLR, "detect net connection success!");
    if (this.val$listener != null) {
      this.val$listener.onDetectResult(paramBoolean, paramLong, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleNetDetectHelper.1
 * JD-Core Version:    0.7.0.1
 */