package cooperation.qzone.report;

import bdfk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class QzoneOnlineTimeCollectRptService$1
  implements Runnable
{
  QzoneOnlineTimeCollectRptService$1(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService) {}
  
  public void run()
  {
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "beginTrace isForeground:" + QzoneOnlineTimeCollectRptService.access$000(this.this$0));
    if (!QzoneOnlineTimeCollectRptService.access$000(this.this$0)) {}
    try
    {
      this.this$0.mUin = Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      QzoneOnlineTimeCollectRptService.access$102(this.this$0, QzoneConfig.getInstance().getConfig("ClientReport", "OnlineLocalSaveFrequency", 10000));
      this.this$0.beginRecord();
      if (!bdfk.c())
      {
        QzoneOnlineTimeCollectRptService.access$200(this.this$0);
        QzoneOnlineTimeCollectRptService.access$002(this.this$0, true);
        LocalMultiProcConfig.putBool("key_sp_qzone_isforeground", true);
        if (QzoneOnlineTimeCollectRptService.access$100(this.this$0) != 0) {
          ThreadManager.getSubThreadHandler().post(QzoneOnlineTimeCollectRptService.access$300(this.this$0));
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzoneOnlineTimeCollectRptService", 2, "beginTrace:" + localException.toString());
        continue;
        QLog.w("QzoneOnlineTimeCollectRptService", 1, "qzone is SimpleUI not to get updateTime");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService.1
 * JD-Core Version:    0.7.0.1
 */