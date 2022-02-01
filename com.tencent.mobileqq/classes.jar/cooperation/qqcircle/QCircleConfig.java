package cooperation.qqcircle;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.tencent.biz.qcircleshadow.local.requests.QCircleSetCircleSwitchRequest;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.GetFileListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.download.QCircleDownloadStrategy;
import mqq.app.AppRuntime;

public class QCircleConfig
{
  private static final String TAG = "QCircleConfig";
  private static QCircleDownloadStrategy mDownloadStrategy;
  private static volatile Uri mSplashVideoPath;
  private static volatile QCircleConfig sInstance;
  private int mFuelCount = -1;
  private RFWDownloader.GetFileListener mGetFileListener;
  private boolean mNeedShowConsumeToast;
  private boolean mNeedShowFirstGuide;
  private boolean mNeedShowSplash;
  private int mWidthPixels;
  
  public static QCircleDownloadStrategy getDownloadStrategy()
  {
    if (mDownloadStrategy == null) {
      mDownloadStrategy = new QCircleDownloadStrategy();
    }
    return mDownloadStrategy;
  }
  
  public static QCircleConfig getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleConfig();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static SharedPreferences getQCircleMultiProcessSp()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "sp_qqcirlce_business" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 4);
  }
  
  public static SharedPreferences getQCircleSp()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "sp_qqcirlce_business" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  private String getSlashVideoName()
  {
    int i = getWidthPixels();
    if (i > 720) {
      return "848splash-1080p-5s-L4-RF8-compressed.mp4";
    }
    if (i > 480) {
      return "848splash-720p-5s-L31-RF8-compressed.mp4";
    }
    return "848splash-480p-5s-L3-RF7-compressed.mp4";
  }
  
  private String getSlashVideoUrl()
  {
    String str1 = QzoneConfig.getQQCircleSplashGuideVideoDir();
    String str2 = getSlashVideoName();
    str2 = str1 + str2 + ".zip";
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "splashGuideVideoDir: " + str1);
    }
    return str2;
  }
  
  private int getWidthPixels()
  {
    if (this.mWidthPixels > 0) {
      return this.mWidthPixels;
    }
    this.mWidthPixels = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return this.mWidthPixels;
  }
  
  public static void release()
  {
    QLog.d("QCircleConfig", 4, "release");
    sInstance = null;
  }
  
  public boolean checkNeedShowSplash()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("show_splash_switch", true);
    }
    return bool;
  }
  
  public int getFuleCount()
  {
    if (this.mFuelCount != -1) {
      return this.mFuelCount;
    }
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt("qcircle_fuel_count", 2147483647);
    }
    return 0;
  }
  
  public boolean getNeedShowSplash()
  {
    return this.mNeedShowSplash;
  }
  
  public int getShowJumpDelayTime()
  {
    return QzoneConfig.getQcircleJumpDelayTime();
  }
  
  public String getSlashLogoTextUrl()
  {
    return QzoneConfig.getQCircleSplashLogoTextUrl();
  }
  
  public String getSlashLogoUrl()
  {
    return QzoneConfig.getQCircleSplashLogoUrl();
  }
  
  public Uri getSplashVideoPath()
  {
    return mSplashVideoPath;
  }
  
  public boolean isNeedShowPublishGuideBubble()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = getQCircleMultiProcessSp();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("qcircle_show_publish_feed_guide_bubble", true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "isNeedShowPublishGuideBubble: " + bool);
    }
    return bool;
  }
  
  public boolean isNeedShowPublishLabelGuideBubble()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = getQCircleMultiProcessSp();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("qcircle_show_publish_label_guide_bubble", true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "isNeedShowPublishLabelGuideBubble: " + bool);
    }
    return bool;
  }
  
  public void preloadSplash()
  {
    if ((checkNeedShowSplash()) && ("1".equals(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_splash_enable", "1")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mNeedShowSplash = bool;
      return;
    }
  }
  
  public void saveFuleCount(int paramInt)
  {
    this.mFuelCount = paramInt;
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("qcircle_fuel_count", paramInt).apply();
    }
  }
  
  public void setNeedShowPublishGuideBubble(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getQCircleMultiProcessSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("qcircle_show_publish_feed_guide_bubble", paramBoolean).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "setNeedShowPublishGuideBubble: " + paramBoolean);
    }
  }
  
  public void setNeedShowPublishLabelGuideBubble(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getQCircleMultiProcessSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("qcircle_show_publish_label_guide_bubble", paramBoolean).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleConfig", 1, "setNeedShowPublishLabelGuideBubble: " + paramBoolean);
    }
  }
  
  public void setSplashNotShowAgain()
  {
    Object localObject = getQCircleSp();
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("show_splash_switch", false).apply();
    }
    this.mNeedShowSplash = false;
    localObject = new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_splash_enable", "0");
    VSNetworkHelper.getInstance().sendRequest((VSBaseRequest)localObject, new QCircleConfig.2(this));
  }
  
  public void tryGetSplashVideoAsync()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("tryGetSplashVideoAsync ");
    if (mSplashVideoPath != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleConfig", 1, bool);
      if (mSplashVideoPath == null) {
        break;
      }
      return;
    }
    try
    {
      this.mGetFileListener = new QCircleConfig.1(this);
      RFWDownloaderFactory.getDownloader(getDownloadStrategy()).getZipFile(getSlashVideoUrl(), this.mGetFileListener);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleConfig", 1, "tryGetSplashVideoAsync error:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.QCircleConfig
 * JD-Core Version:    0.7.0.1
 */