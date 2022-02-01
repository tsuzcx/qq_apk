package cooperation.qzone.report;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class QzoneOnlineTimeCollectRptService$1
  implements Runnable
{
  QzoneOnlineTimeCollectRptService$1(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService) {}
  
  public void run()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("beginTrace isForeground:");
    localStringBuilder1.append(QzoneOnlineTimeCollectRptService.access$000(this.this$0));
    QLog.d("QzoneOnlineTimeCollectRptService", 1, localStringBuilder1.toString());
    if (!QzoneOnlineTimeCollectRptService.access$000(this.this$0))
    {
      try
      {
        this.this$0.mUin = Long.parseLong(MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("beginTrace:");
        localStringBuilder2.append(localException.toString());
        QLog.e("QzoneOnlineTimeCollectRptService", 2, localStringBuilder2.toString());
      }
      QzoneOnlineTimeCollectRptService.access$102(this.this$0, QzoneConfig.getInstance().getConfig("ClientReport", "OnlineLocalSaveFrequency", 10000));
      this.this$0.beginRecord();
      if (!QZoneHelper.getSimpleQZoneUISwitch()) {
        QzoneOnlineTimeCollectRptService.access$200(this.this$0);
      } else {
        QLog.w("QzoneOnlineTimeCollectRptService", 1, "qzone is SimpleUI not to get updateTime");
      }
      QzoneOnlineTimeCollectRptService.access$002(this.this$0, true);
      LocalMultiProcConfig.putBool("key_sp_qzone_isforeground", true);
      if (QzoneOnlineTimeCollectRptService.access$100(this.this$0) != 0) {
        ThreadManager.getSubThreadHandler().post(QzoneOnlineTimeCollectRptService.access$300(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService.1
 * JD-Core Version:    0.7.0.1
 */