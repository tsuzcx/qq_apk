package cooperation.qzone.util;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.component.cache.util.LocalConfig;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import java.io.File;

public class AnimatedWebpLoaderUtil
{
  public static final boolean IS_ENABLE_ANIMATE_WEBP;
  public static final String PREFERENCE_SO_MD5_KEY = "PREFERENCE_SO_MD5_KEY";
  public static final String TAG = "AnimatedWebpLoaderUtil";
  public static final String WEBP_SO_MD5 = QzoneConfig.getInstance().getConfig("QZoneSetting", "animatedWebpMD5", "4c8590a921c2722051416111dfd57122");
  private static boolean hasCheckSupportAnimWebp = false;
  private static boolean loadSoFail;
  private static boolean supportAnimWebp = false;
  
  static
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = true;
    if (localQzoneConfig.getConfig("QZoneSetting", "ENABLE_ANIMATED_WEBP", 1) != 1) {
      bool = false;
    }
    IS_ENABLE_ANIMATE_WEBP = bool;
    loadSoFail = false;
  }
  
  private static boolean doLoadSo()
  {
    try
    {
      String str = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath("animatedWebp.so");
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      System.load(str);
      return true;
    }
    catch (Throwable localThrowable)
    {
      loadSoFail = true;
      QZLog.e(TAG, "load webp so fail", localThrowable);
    }
    return false;
  }
  
  private static boolean isNeedUpdate()
  {
    String str = LocalConfig.a().getString("PREFERENCE_SO_MD5_KEY", null);
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return str.equalsIgnoreCase(WEBP_SO_MD5) ^ true;
  }
  
  public static boolean isSOExit()
  {
    String str = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath("animatedWebp.so");
    if (TextUtils.isEmpty(str))
    {
      QZLog.i(TAG, "isWebp SO path not exit");
      return false;
    }
    boolean bool = new File(str).exists();
    str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isWebp SO path exit : ");
    localStringBuilder.append(bool);
    QZLog.i(str, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean isSupportAnimWebp()
  {
    if (!hasCheckSupportAnimWebp)
    {
      boolean bool;
      if ((IS_ENABLE_ANIMATE_WEBP) && (!loadSoFail) && (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(2, 1))) {
        bool = true;
      } else {
        bool = false;
      }
      supportAnimWebp = bool;
      hasCheckSupportAnimWebp = true;
    }
    return supportAnimWebp;
  }
  
  public static boolean loadSo()
  {
    if (!isSupportAnimWebp())
    {
      QZLog.i(TAG, "enable animtedWebp false");
      return false;
    }
    if ((!isNeedUpdate()) && (isSOExit())) {
      return doLoadSo();
    }
    ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule("animatedWebp.so", new AnimatedWebpLoaderUtil.1());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.AnimatedWebpLoaderUtil
 * JD-Core Version:    0.7.0.1
 */