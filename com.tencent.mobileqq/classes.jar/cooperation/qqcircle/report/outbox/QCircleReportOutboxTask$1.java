package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;

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
    paramString = new StringBuilder();
    paramString.append("doResend id:");
    paramString.append(this.this$0.getTaskId());
    paramString.append(" ,resultCode:");
    paramString.append(paramLong);
    paramString.append(" ,trace_id:");
    paramString.append(paramBaseRequest.getTraceId());
    QLog.i("QCircleReportOutboxTask", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTask.1
 * JD-Core Version:    0.7.0.1
 */