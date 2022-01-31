package common.config.service;

import beyb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import xgc;

public class QzoneConfig$2$1
  implements Runnable
{
  public QzoneConfig$2$1(beyb parambeyb, boolean paramBoolean) {}
  
  public void run()
  {
    String str = xgc.b();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneConfig", 2, "QZoneConfigService onChange from:" + str + " ,processName:" + BaseApplicationImpl.processName + " ,selfChange:" + this.jdField_a_of_type_Boolean);
    }
    if ((str != null) && (!str.equals(BaseApplicationImpl.processName)))
    {
      QzoneConfig.getInstance().clearConfigs();
      QzoneConfig.getInstance().loadAllConfigs();
    }
    QzoneConfig.access$000(this.jdField_a_of_type_Beyb.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     common.config.service.QzoneConfig.2.1
 * JD-Core Version:    0.7.0.1
 */