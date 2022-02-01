package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleReport.StDataReportRsp;

class QCircleReporter$4
  implements VSDispatchObserver.onVSRspCallBack<QQCircleReport.StDataReportRsp>
{
  QCircleReporter$4(QCircleReporter paramQCircleReporter) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StDataReportRsp paramStDataReportRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDataReportRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QLog.e("QCircleReporter", 1, "performClientReport error:" + paramString + ",traceId:" + paramVSBaseRequest.getTraceId());
      }
      return;
    }
    QLog.d("QCircleReporter", 2, "performClientReport success!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.4
 * JD-Core Version:    0.7.0.1
 */