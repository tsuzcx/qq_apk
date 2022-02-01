package com.tencent.mobileqq.flashshow.report.dc;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleReport.StDataReportRsp;

class FSReporter$3
  implements VSDispatchObserver.onVSRspCallBack<QQCircleReport.StDataReportRsp>
{
  FSReporter$3(FSReporter paramFSReporter) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StDataReportRsp paramStDataReportRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStDataReportRsp != null))
    {
      QLog.d("FSReporter", 2, "performClientReport success!");
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramStDataReportRsp = new StringBuilder();
      paramStDataReportRsp.append("performClientReport error:");
      paramStDataReportRsp.append(paramString);
      paramStDataReportRsp.append(",traceId:");
      paramStDataReportRsp.append(paramBaseRequest.getTraceId());
      QLog.e("FSReporter", 1, paramStDataReportRsp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSReporter.3
 * JD-Core Version:    0.7.0.1
 */