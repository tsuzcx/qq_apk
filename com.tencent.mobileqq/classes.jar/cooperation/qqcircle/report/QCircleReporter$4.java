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
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDataReportRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        RFLog.e("QCircleReporter", RFLog.USR, "performClientReport error:" + paramString + ",traceId:" + paramBaseRequest.getTraceId());
      }
      return;
    }
    RFLog.d("QCircleReporter", RFLog.CLR, "performClientReport success!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.4
 * JD-Core Version:    0.7.0.1
 */