package cooperation.qqcircle.report.outbox;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleReport.StDataReportRsp;

final class QCircleNetDetectHelper$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleReport.StDataReportRsp>
{
  QCircleNetDetectHelper$1(QCircleNetDetectHelper.DetectListener paramDetectListener) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StDataReportRsp paramStDataReportRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStDataReportRsp == null)) && (!TextUtils.isEmpty(paramString)))
    {
      paramStDataReportRsp = new StringBuilder();
      paramStDataReportRsp.append("detect net connection blocked retcode:");
      paramStDataReportRsp.append(paramLong);
      paramStDataReportRsp.append(",error:");
      paramStDataReportRsp.append(paramString);
      paramStDataReportRsp.append(",traceId:");
      paramStDataReportRsp.append(paramBaseRequest.getTraceId());
      QLog.e("QCircleNetCheckHelper", 1, paramStDataReportRsp.toString());
    }
    QLog.d("QCircleNetCheckHelper", 2, "detect net connection success!");
    paramBaseRequest = this.val$listener;
    if (paramBaseRequest != null) {
      paramBaseRequest.onDetectResult(paramBoolean, paramLong, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleNetDetectHelper.1
 * JD-Core Version:    0.7.0.1
 */