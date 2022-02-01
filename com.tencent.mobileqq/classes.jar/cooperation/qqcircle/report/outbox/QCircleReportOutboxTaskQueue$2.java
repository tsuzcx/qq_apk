package cooperation.qqcircle.report.outbox;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qzone.util.NetworkState;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

class QCircleReportOutboxTaskQueue$2
  implements Runnable
{
  QCircleReportOutboxTaskQueue$2(QCircleReportOutboxTaskQueue paramQCircleReportOutboxTaskQueue) {}
  
  public void run()
  {
    if (!NetworkState.isNetSupport()) {}
    CopyOnWriteArrayList localCopyOnWriteArrayList;
    do
    {
      return;
      localCopyOnWriteArrayList = this.this$0.getTaskList();
    } while (localCopyOnWriteArrayList == null);
    int j = localCopyOnWriteArrayList.size();
    QLog.i("QCircleReportOutboxTaskQueue", 1, "checkRetry taskList size:" + j);
    int i = 0;
    label51:
    QCircleReportOutboxTask localQCircleReportOutboxTask;
    if (i < j)
    {
      localQCircleReportOutboxTask = (QCircleReportOutboxTask)localCopyOnWriteArrayList.get(i);
      localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskQueue", "checkRetry");
      if (localQCircleReportOutboxTask.getState() != 1) {
        break label91;
      }
    }
    for (;;)
    {
      i += 1;
      break label51;
      break;
      label91:
      if (QCircleReportOutboxTaskQueue.access$100(this.this$0, localQCircleReportOutboxTask))
      {
        QLog.d("QCircleReportOutboxTaskQueue", 1, "retryTask id:" + localQCircleReportOutboxTask.getTaskId() + " ,state:" + localQCircleReportOutboxTask.getState() + " ,cmd:" + localQCircleReportOutboxTask.mCmdName + " ,curRetryNum:" + localQCircleReportOutboxTask.getRetryNum());
        this.this$0.resumeTask(localQCircleReportOutboxTask);
      }
      else
      {
        QCircleQualityReporter.reportQualityEvent("outbox_task_retry_failed_event", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ret_code", localQCircleReportOutboxTask.getResultCode() + ""), QCircleReportHelper.newEntry("url", localQCircleReportOutboxTask.getResultMsg()), QCircleReportHelper.newEntry("refer", localQCircleReportOutboxTask.mCmdName + ""), QCircleReportHelper.newEntry("count", localQCircleReportOutboxTask.getRetryNum() + ""), QCircleReportHelper.newEntry("attach_info", localQCircleReportOutboxTask.getTaskId() + "_" + localQCircleReportOutboxTask.getResultCode() + "_" + localQCircleReportOutboxTask.getResultMsg()) }), false);
        QLog.d("QCircleReportOutboxTaskQueue", 1, "removeTask id:" + localQCircleReportOutboxTask.getTaskId() + " ,state:" + localQCircleReportOutboxTask.getState() + " ,cmd:" + localQCircleReportOutboxTask.mCmdName + " ,curRetryNum:" + localQCircleReportOutboxTask.getRetryNum() + " ,resultCode:" + localQCircleReportOutboxTask.getResultCode());
        this.this$0.removeTask(localQCircleReportOutboxTask);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.2
 * JD-Core Version:    0.7.0.1
 */