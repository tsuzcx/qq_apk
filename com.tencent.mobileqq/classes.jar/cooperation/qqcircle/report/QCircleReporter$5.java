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
    if ((paramBoolean) && (paramLong == 0L) && (paramStDataReportRsp != null))
    {
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
        RFLog.d("QCircleReporter", RFLog.CLR, "performCommandReport success!");
      }
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      int i = RFLog.USR;
      paramStDataReportRsp = new StringBuilder();
      paramStDataReportRsp.append("performCommandReport error:");
      paramStDataReportRsp.append(paramString);
      paramStDataReportRsp.append(",traceId:");
      paramStDataReportRsp.append(paramBaseRequest.getTraceId());
      RFLog.e("QCircleReporter", i, paramStDataReportRsp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.5
 * JD-Core Version:    0.7.0.1
 */