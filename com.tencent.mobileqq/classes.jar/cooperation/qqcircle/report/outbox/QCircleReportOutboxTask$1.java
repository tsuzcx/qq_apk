package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;

class QCircleReportOutboxTask$1
  implements VSDispatchObserver.onVSRspCallBack<Object>
{
  QCircleReportOutboxTask$1(QCircleReportOutboxTask paramQCircleReportOutboxTask) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    QCircleReportOutboxTask.access$000(this.this$0, paramBoolean, paramLong, paramString);
    this.this$0.setResultCode(paramLong);
    this.this$0.setResultMsg(paramString);
    QCircleReportOutboxTaskQueue.getInstance().completeTask(this.this$0, paramBoolean);
    RFLog.i("QCircleReportOutboxTask", RFLog.USR, "doResend id:" + this.this$0.getTaskId() + " ,resultCode:" + paramLong + " ,trace_id:" + paramBaseRequest.getTraceId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTask.1
 * JD-Core Version:    0.7.0.1
 */