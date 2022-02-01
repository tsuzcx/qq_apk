package cooperation.qqcircle.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

class QCircleReporter$5
  implements VSDispatchObserver.onVSRspCallBack<APP_REPORT_TRANSFER.StDataReportRsp>
{
  QCircleReporter$5(QCircleReporter paramQCircleReporter) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, APP_REPORT_TRANSFER.StDataReportRsp paramStDataReportRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStDataReportRsp == null)) && (!TextUtils.isEmpty(paramString))) {
      QLog.e("QCircleReporter", 1, "performCommandReport error:" + paramString + ",traceId:" + paramVSBaseRequest.getTraceId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.5
 * JD-Core Version:    0.7.0.1
 */