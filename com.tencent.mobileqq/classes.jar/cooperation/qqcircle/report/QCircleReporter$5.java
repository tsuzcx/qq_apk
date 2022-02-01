package cooperation.qqcircle.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;

class QCircleReporter$5
  implements VSDispatchObserver.onVSRspCallBack<APP_REPORT_TRANSFER.StDataReportRsp>
{
  QCircleReporter$5(QCircleReporter paramQCircleReporter) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, APP_REPORT_TRANSFER.StDataReportRsp paramStDataReportRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDataReportRsp == null)) {
      if (!TextUtils.isEmpty(paramString)) {
        RFLog.e("QCircleReporter", RFLog.USR, "performCommandReport error:" + paramString + ",traceId:" + paramBaseRequest.getTraceId());
      }
    }
    while (!((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
      return;
    }
    RFLog.d("QCircleReporter", RFLog.CLR, "performCommandReport success!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.5
 * JD-Core Version:    0.7.0.1
 */