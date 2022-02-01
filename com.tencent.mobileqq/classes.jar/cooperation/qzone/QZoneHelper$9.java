package cooperation.qzone;

import avlg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

final class QZoneHelper$9
  implements Runnable
{
  QZoneHelper$9(QQAppInterface paramQQAppInterface, avlg paramavlg) {}
  
  public void run()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "PreloadQzoneProcessEnable", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "preloadInFriendProfileCard enable:" + i);
    }
    if (i == 1)
    {
      long l = DeviceInfoUtil.getSystemTotalMemory() / 1048576L;
      i = QzoneConfig.getInstance().getConfig("QZoneSetting", "PreloadQzoneProcessRamThreshold", 1024);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneHelper", 2, "preloadInFriendProfileCard totalMemSize:" + l + ",threshold:" + i);
      }
      if (l >= i) {
        QZoneHelper.preloadQzone(this.val$app, "FriendProfileCardActivity", this.val$session, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.9
 * JD-Core Version:    0.7.0.1
 */