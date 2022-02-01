package cooperation.qzone;

import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class QZoneStartupMonitor$2$1
  implements Runnable
{
  QZoneStartupMonitor$2$1(QZoneStartupMonitor.2 param2, int paramInt) {}
  
  public void run()
  {
    QZoneStartupMonitor.access$400(this.this$1.this$0);
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "atuoRecoveryQzoneCount", 1) > this.val$recoveryCount)
    {
      QLog.i("QZoneStartupMonitor", 1, "oat 不合法，并且wns配置要自动修复，重新安装qzone=");
      QZoneStartupMonitor.access$500(this.this$1.this$0);
      LocalMultiProcConfig.putInt("key_recovery_count", this.val$recoveryCount + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneStartupMonitor.2.1
 * JD-Core Version:    0.7.0.1
 */