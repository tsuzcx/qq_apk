package cooperation.qzone;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

final class QZoneHelper$10
  implements Runnable
{
  QZoneHelper$10(QQAppInterface paramQQAppInterface, PreloadProcHitPluginSession paramPreloadProcHitPluginSession) {}
  
  public void run()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "PreloadQzoneProcessEnable", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "preloadInFriendProfileCard enable:" + i);
    }
    if (i == 1)
    {
      long l = DeviceInfoUtil.a() / 1048576L;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.10
 * JD-Core Version:    0.7.0.1
 */