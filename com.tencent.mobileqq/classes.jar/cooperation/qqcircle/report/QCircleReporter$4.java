package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleReport.StDataReportRsp;

class QCircleReporter$4
  implements VSDispatchObserver.onVSRspCallBack<QQCircleReport.StDataReportRsp>
{
  QCircleReporter$4(QCircleReporter paramQCircleReporter) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StDataReportRsp paramStDataReportRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStDataReportRsp != null))
    {
      QLog.d("QCircleReporter", 2, "performClientReport success!");
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramStDataReportRsp = new StringBuilder();
      paramStDataReportRsp.append("performClientReport error:");
      paramStDataReportRsp.append(paramString);
      paramStDataReportRsp.append(",traceId:");
      paramStDataReportRsp.append(paramBaseRequest.getTraceId());
      QLog.e("QCircleReporter", 1, paramStDataReportRsp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.4
 * JD-Core Version:    0.7.0.1
 */