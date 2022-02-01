package cooperation.qzone.report;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class QzoneOnlineTimeCollectRptService$3
  implements Runnable
{
  QzoneOnlineTimeCollectRptService$3(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService) {}
  
  public void run()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(QzoneOnlineTimeCollectRptService.access$300(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("QzoneOnlineTimeCollectRptService", 2, "mOnlineTimeCheckTraceRunnable run");
    }
    this.this$0.updateRecord();
    ThreadManager.getSubThreadHandler().postDelayed(this, QzoneOnlineTimeCollectRptService.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService.3
 * JD-Core Version:    0.7.0.1
 */