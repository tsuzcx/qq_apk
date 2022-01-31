package common.config.service;

import bihh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import zds;

public class QzoneConfig$2$1
  implements Runnable
{
  public QzoneConfig$2$1(bihh parambihh, boolean paramBoolean) {}
  
  public void run()
  {
    String str = zds.b();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneConfig", 2, "QZoneConfigService onChange from:" + str + " ,processName:" + BaseApplicationImpl.processName + " ,selfChange:" + this.jdField_a_of_type_Boolean);
    }
    if ((str != null) && (!str.equals(BaseApplicationImpl.processName)))
    {
      QzoneConfig.getInstance().clearConfigs();
      QzoneConfig.getInstance().loadAllConfigs();
    }
    QzoneConfig.access$000(this.jdField_a_of_type_Bihh.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     common.config.service.QzoneConfig.2.1
 * JD-Core Version:    0.7.0.1
 */