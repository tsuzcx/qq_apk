package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class QCircleReportOutboxTask$1
  implements VSDispatchObserver.onVSRspCallBack<Object>
{
  QCircleReportOutboxTask$1(QCircleReportOutboxTask paramQCircleReportOutboxTask) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    if (paramBoolean) {}
    for (paramObject = "0";; paramObject = paramLong + "")
    {
      QCircleQualityReporter.reportQualityEvent("outbox_task_resend_event", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ret_code", paramObject), QCircleReportHelper.newEntry("url", paramString), QCircleReportHelper.newEntry("refer", this.this$0.mCmdName + ""), QCircleReportHelper.newEntry("count", this.this$0.mRetryNum + ""), QCircleReportHelper.newEntry("attach_info", QCircleReportOutboxTask.access$000(this.this$0) + "_" + this.this$0.mResultCode + "_" + this.this$0.mResultMsg) }), false);
      this.this$0.setResultCode(paramLong);
      this.this$0.setResultMsg(paramString);
      QCircleReportOutboxTaskQueue.getInstance().completeTask(this.this$0, paramBoolean);
      QLog.i("QCircleReportOutboxTask", 1, "doResend id:" + this.this$0.getTaskId() + " ,resultCode:" + paramLong + " ,trace_id:" + paramVSBaseRequest.getTraceId());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTask.1
 * JD-Core Version:    0.7.0.1
 */