package cooperation.qzone;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper;

final class QZoneHelper$9
  implements Runnable
{
  QZoneHelper$9(long paramLong) {}
  
  public void run()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQ清空缓存数据时的回调 onQQClearLocalCache,uin=");
      localStringBuilder.append(this.val$uin);
      QLog.i("QZoneHelper", 2, localStringBuilder.toString());
      LocalMultiProcConfig.putBool("qzone_force_refresh", true);
      LocalMultiProcConfig.putBool("qzone_first_in", true);
      LocalMultiProcConfig.putBool("qzone_force_refresh_passive", true);
      LocalMultiProcConfig.putBool("qzone_first_in_passive", true);
      ((IQzoneOfflineCacheHelper)QRoute.api(IQzoneOfflineCacheHelper.class)).updataSmallGameLastCacheFinishTime(this.val$uin, 0L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneHelper", 1, "QQ清空缓存数据时的回调 error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.9
 * JD-Core Version:    0.7.0.1
 */