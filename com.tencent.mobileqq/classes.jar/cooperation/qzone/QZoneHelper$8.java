package cooperation.qzone;

import avsk;
import bhlo;
import bmtd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public final class QZoneHelper$8
  implements Runnable
{
  public QZoneHelper$8(QQAppInterface paramQQAppInterface, avsk paramavsk) {}
  
  public void run()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "PreloadQzoneProcessEnable", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "preloadInFriendProfileCard enable:" + i);
    }
    if (i == 1)
    {
      long l = bhlo.d() / 1048576L;
      i = QzoneConfig.getInstance().getConfig("QZoneSetting", "PreloadQzoneProcessRamThreshold", 1024);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneHelper", 2, "preloadInFriendProfileCard totalMemSize:" + l + ",threshold:" + i);
      }
      if (l >= i) {
        bmtd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "FriendProfileCardActivity", this.jdField_a_of_type_Avsk, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.8
 * JD-Core Version:    0.7.0.1
 */