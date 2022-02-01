package cooperation.qzone.util;

import android.content.SharedPreferences;
import android.text.TextUtils;
import bibn;
import common.config.service.QzoneConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

public class AnimatedWebpLoaderUtil
{
  public static final boolean IS_ENABLE_ANIMATE_WEBP;
  public static final String PREFERENCE_SO_MD5_KEY = "PREFERENCE_SO_MD5_KEY";
  public static final String TAG;
  public static final String WEBP_SO_MD5;
  private static boolean hasCheckSupportAnimWebp;
  private static boolean loadSoFail;
  private static boolean supportAnimWebp;
  
  static
  {
    boolean bool = true;
    TAG = AnimatedWebpLoaderUtil.class.getSimpleName();
    WEBP_SO_MD5 = QzoneConfig.getInstance().getConfig("QZoneSetting", "animatedWebpMD5", "4c8590a921c2722051416111dfd57122");
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "ENABLE_ANIMATED_WEBP", 1) == 1) {}
    for (;;)
    {
      IS_ENABLE_ANIMATE_WEBP = bool;
      return;
      bool = false;
    }
  }
  
  private static boolean doLoadSo()
  {
    try
    {
      String str = QzoneModuleManager.getInstance().getModuleFilePath("animatedWebp.so");
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
    String str = bibn.a().getString("PREFERENCE_SO_MD5_KEY", null);
    if (TextUtils.isEmpty(str)) {}
    while (!str.equalsIgnoreCase(WEBP_SO_MD5)) {
      return true;
    }
    return false;
  }
  
  public static boolean isSOExit()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("animatedWebp.so");
    if (TextUtils.isEmpty(str))
    {
      QZLog.i(TAG, "isWebp SO path not exit");
      return false;
    }
    boolean bool = new File(str).exists();
    QZLog.i(TAG, "isWebp SO path exit : " + bool);
    return bool;
  }
  
  public static boolean isSupportAnimWebp()
  {
    if (!hasCheckSupportAnimWebp) {
      if ((!IS_ENABLE_ANIMATE_WEBP) || (loadSoFail) || (!QzoneHardwareRestriction.meetHardwareRestriction(2, 1))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      supportAnimWebp = bool;
      hasCheckSupportAnimWebp = true;
      return supportAnimWebp;
    }
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
    QzoneModuleManager.getInstance().downloadModule("animatedWebp.so", new AnimatedWebpLoaderUtil.1());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.AnimatedWebpLoaderUtil
 * JD-Core Version:    0.7.0.1
 */