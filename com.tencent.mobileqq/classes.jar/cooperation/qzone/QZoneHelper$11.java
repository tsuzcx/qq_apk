package cooperation.qzone;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;

final class QZoneHelper$11
  implements Runnable
{
  QZoneHelper$11(long paramLong) {}
  
  public void run()
  {
    try
    {
      QLog.i("QZoneHelper", 2, "QQ清空缓存数据时的回调 onQQClearLocalCache,uin=" + this.val$uin);
      LocalMultiProcConfig.putBool("qzone_force_refresh", true);
      LocalMultiProcConfig.putBool("qzone_first_in", true);
      LocalMultiProcConfig.putBool("qzone_force_refresh_passive", true);
      LocalMultiProcConfig.putBool("qzone_first_in_passive", true);
      QzoneOfflineCacheHelper.updataSmallGameLastCacheFinishTime(this.val$uin, 0L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneHelper", 1, "QQ清空缓存数据时的回调 error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.11
 * JD-Core Version:    0.7.0.1
 */