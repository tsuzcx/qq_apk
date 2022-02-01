package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleReport.StHeartbeatSignalRsp;

class QCircleReportHelper$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleReport.StHeartbeatSignalRsp>
{
  QCircleReportHelper$2(QCircleReportHelper paramQCircleReportHelper) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StHeartbeatSignalRsp paramStHeartbeatSignalRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStHeartbeatSignalRsp == null)) && (!TextUtils.isEmpty(paramString))) {
      QLog.e("QCircleReportHelper", 1, "reportQCircleActiveIntervalTime error:" + paramString + ",traceId:" + paramVSBaseRequest.getTraceId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper.2
 * JD-Core Version:    0.7.0.1
 */