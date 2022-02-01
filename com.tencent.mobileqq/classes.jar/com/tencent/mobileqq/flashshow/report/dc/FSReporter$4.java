package com.tencent.mobileqq.flashshow.report.dc;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class FSReporter$4
  implements VSDispatchObserver.onVSRspCallBack<APP_REPORT_TRANSFER.StDataReportRsp>
{
  FSReporter$4(FSReporter paramFSReporter) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, APP_REPORT_TRANSFER.StDataReportRsp paramStDataReportRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStDataReportRsp != null))
    {
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
        QLog.d("FSReporter", 2, "performCommandReport success!");
      }
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramStDataReportRsp = new StringBuilder();
      paramStDataReportRsp.append("performCommandReport error:");
      paramStDataReportRsp.append(paramString);
      paramStDataReportRsp.append(",traceId:");
      paramStDataReportRsp.append(paramBaseRequest.getTraceId());
      QLog.e("FSReporter", 1, paramStDataReportRsp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSReporter.4
 * JD-Core Version:    0.7.0.1
 */