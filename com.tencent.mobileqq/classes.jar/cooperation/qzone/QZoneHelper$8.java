package cooperation.qzone;

import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

final class QZoneHelper$8
  implements Runnable
{
  QZoneHelper$8(AppRuntime paramAppRuntime, PreloadProcHitPluginSession paramPreloadProcHitPluginSession) {}
  
  public void run()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "PreloadQzoneProcessEnable", 1);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadInFriendProfileCard enable:");
      localStringBuilder.append(i);
      QLog.d("QZoneHelper", 2, localStringBuilder.toString());
    }
    if (i == 1)
    {
      long l = DeviceInfoUtil.a() / 1048576L;
      i = QzoneConfig.getInstance().getConfig("QZoneSetting", "PreloadQzoneProcessRamThreshold", 1024);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("preloadInFriendProfileCard totalMemSize:");
        localStringBuilder.append(l);
        localStringBuilder.append(",threshold:");
        localStringBuilder.append(i);
        QLog.d("QZoneHelper", 2, localStringBuilder.toString());
      }
      if (l >= i) {
        QZoneHelper.preloadQzone(this.val$app, "FriendProfileCardActivity", this.val$session, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.8
 * JD-Core Version:    0.7.0.1
 */