package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleReport.StHeartbeatSignalRsp;

class QCircleReportHelper$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleReport.StHeartbeatSignalRsp>
{
  QCircleReportHelper$2(QCircleReportHelper paramQCircleReportHelper) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StHeartbeatSignalRsp paramStHeartbeatSignalRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStHeartbeatSignalRsp == null)) && (!TextUtils.isEmpty(paramString)))
    {
      int i = RFLog.USR;
      paramStHeartbeatSignalRsp = new StringBuilder();
      paramStHeartbeatSignalRsp.append("reportQCircleActiveIntervalTime error:");
      paramStHeartbeatSignalRsp.append(paramString);
      paramStHeartbeatSignalRsp.append(",traceId:");
      paramStHeartbeatSignalRsp.append(paramBaseRequest.getTraceId());
      RFLog.e("QCircleReportHelper", i, paramStHeartbeatSignalRsp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper.2
 * JD-Core Version:    0.7.0.1
 */