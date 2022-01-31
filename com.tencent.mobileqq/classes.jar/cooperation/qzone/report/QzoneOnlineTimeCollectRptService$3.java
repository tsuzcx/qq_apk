package cooperation.qzone.report;

import bjmt;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QzoneOnlineTimeCollectRptService$3
  implements Runnable
{
  public QzoneOnlineTimeCollectRptService$3(bjmt parambjmt) {}
  
  public void run()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(bjmt.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("QzoneOnlineTimeCollectRptService", 2, "mOnlineTimeCheckTraceRunnable run");
    }
    this.this$0.d();
    ThreadManager.getSubThreadHandler().postDelayed(this, bjmt.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService.3
 * JD-Core Version:    0.7.0.1
 */