package cooperation.qzone.report;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import mqq.os.MqqHandler;

class QzoneOnlineTimeCollectRptService$2
  implements Runnable
{
  QzoneOnlineTimeCollectRptService$2(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService) {}
  
  public void run()
  {
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "closeTrace isForeground:" + QzoneOnlineTimeCollectRptService.access$000(this.this$0));
    if (QzoneOnlineTimeCollectRptService.access$000(this.this$0))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(QzoneOnlineTimeCollectRptService.access$300(this.this$0));
      this.this$0.closeRecord();
      QzoneOnlineTimeCollectRptService.access$400(this.this$0);
      LocalMultiProcConfig.putBool("key_sp_qzone_isforeground", false);
      QzoneOnlineTimeCollectRptService.access$002(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService.2
 * JD-Core Version:    0.7.0.1
 */