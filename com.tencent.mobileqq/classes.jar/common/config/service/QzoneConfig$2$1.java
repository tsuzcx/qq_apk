package common.config.service;

import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class QzoneConfig$2$1
  implements Runnable
{
  QzoneConfig$2$1(QzoneConfig.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    String str = QzoneConfig.getLastUpdate();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QZoneConfigService onChange from:");
      localStringBuilder.append(str);
      localStringBuilder.append(" ,processName:");
      localStringBuilder.append(MobileQQ.processName);
      localStringBuilder.append(" ,selfChange:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("QzoneConfig", 2, localStringBuilder.toString());
    }
    if ((str != null) && (!str.equals(MobileQQ.processName)))
    {
      QzoneConfig.getInstance().clearConfigs();
      QzoneConfig.getInstance().loadAllConfigs();
      return;
    }
    QzoneConfig.access$000(this.jdField_a_of_type_CommonConfigServiceQzoneConfig$2.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.config.service.QzoneConfig.2.1
 * JD-Core Version:    0.7.0.1
 */