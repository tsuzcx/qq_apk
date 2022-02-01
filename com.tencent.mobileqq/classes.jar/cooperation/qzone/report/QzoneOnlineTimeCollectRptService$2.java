package cooperation.qzone.report;

import bngm;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import mqq.os.MqqHandler;

public class QzoneOnlineTimeCollectRptService$2
  implements Runnable
{
  public QzoneOnlineTimeCollectRptService$2(bngm parambngm) {}
  
  public void run()
  {
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "closeTrace isForeground:" + bngm.a(this.this$0));
    if (bngm.a(this.this$0))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(bngm.a(this.this$0));
      this.this$0.c();
      bngm.b(this.this$0);
      LocalMultiProcConfig.putBool("key_sp_qzone_isforeground", false);
      bngm.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService.2
 * JD-Core Version:    0.7.0.1
 */