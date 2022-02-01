package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleReport.StDataReportRsp;

class QCircleReporter$4
  implements VSDispatchObserver.onVSRspCallBack<QQCircleReport.StDataReportRsp>
{
  QCircleReporter$4(QCircleReporter paramQCircleReporter) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StDataReportRsp paramStDataReportRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStDataReportRsp != null))
    {
      RFLog.d("QCircleReporter", RFLog.CLR, "performClientReport success!");
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      int i = RFLog.USR;
      paramStDataReportRsp = new StringBuilder();
      paramStDataReportRsp.append("performClientReport error:");
      paramStDataReportRsp.append(paramString);
      paramStDataReportRsp.append(",traceId:");
      paramStDataReportRsp.append(paramBaseRequest.getTraceId());
      RFLog.e("QCircleReporter", i, paramStDataReportRsp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.4
 * JD-Core Version:    0.7.0.1
 */