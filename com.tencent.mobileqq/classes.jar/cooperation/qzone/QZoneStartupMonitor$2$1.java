package cooperation.qzone;

import bfqq;
import bfqs;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class QZoneStartupMonitor$2$1
  implements Runnable
{
  public QZoneStartupMonitor$2$1(bfqs parambfqs, int paramInt) {}
  
  public void run()
  {
    bfqq.a(this.jdField_a_of_type_Bfqs.a);
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "atuoRecoveryQzoneCount", 1) > this.jdField_a_of_type_Int)
    {
      QLog.i("QZoneStartupMonitor", 1, "oat 不合法，并且wns配置要自动修复，重新安装qzone=");
      bfqq.b(this.jdField_a_of_type_Bfqs.a);
      LocalMultiProcConfig.putInt("key_recovery_count", this.jdField_a_of_type_Int + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneStartupMonitor.2.1
 * JD-Core Version:    0.7.0.1
 */