package cooperation.qzone;

import bjar;
import bjat;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class QZoneStartupMonitor$2$1
  implements Runnable
{
  public QZoneStartupMonitor$2$1(bjat parambjat, int paramInt) {}
  
  public void run()
  {
    bjar.a(this.jdField_a_of_type_Bjat.a);
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "atuoRecoveryQzoneCount", 1) > this.jdField_a_of_type_Int)
    {
      QLog.i("QZoneStartupMonitor", 1, "oat 不合法，并且wns配置要自动修复，重新安装qzone=");
      bjar.b(this.jdField_a_of_type_Bjat.a);
      LocalMultiProcConfig.putInt("key_recovery_count", this.jdField_a_of_type_Int + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QZoneStartupMonitor.2.1
 * JD-Core Version:    0.7.0.1
 */