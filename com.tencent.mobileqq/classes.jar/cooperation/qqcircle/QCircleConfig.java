package cooperation.qqcircle;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.tencent.biz.qcircleshadow.delegateimpl.QCircleConfigImpl;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleConfig
{
  private static final String TAG = "QCircleConfig";
  private static volatile Uri mSplashVideoPath;
  private static volatile QCircleConfig sInstance;
  private final QCircleConfigImpl mConfigImpl = new QCircleConfigImpl();
  private int mFuelCount = -1;
  private RFWDownloader.RFWDownloadListener mGetFileListener;
  private boolean mNeedShowConsumeToast;
  private boolean mNeedShowFirstGuide;
  private boolean mNeedShowSplash;
  private int mWidthPixels = 0;
  
  public static QCircleConfig getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleConfig();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static SharedPreferences getQCircleMultiProcessSp()
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_qqcirlce_business");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    return MobileQQ.sMobileQQ.getSharedPreferences(str, 4);
  }
  
  public static SharedPreferences getQCircleSp()
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_qqcirlce_business");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    return MobileQQ.sMobileQQ.getSharedPreferences(str, 0);
  }
  
  public static long getQQCircleFollowTabUpdateNotificationShowInterval()
  {
    return getInstance().getConfigValue("qqcircle", "qqcircle_follow_tab_reddot_show_interval", Integer.valueOf(15)).intValue();
  }
  
  public static int getQQCircleQualityReportBufferLength()
  {
    return getInstance().getConfigValue("qqcircle", "quality_quality_report_buffer_length", Integer.valueOf(5)).intValue();
  }
  
  public static long getQQCircleQualityReportInterval()
  {
    return getInstance().getConfigValue("qqcircle", "qqcircle_quality_report_interval", Integer.valueOf(60)).intValue();
  }
  
  public static boolean getQQCircleQualitySampleSwitchOpen()
  {
    return getInstance().getConfigValue("qqcircle", "qqcircle_quality_sample_switch", Integer.valueOf(1)).intValue() == 1;
  }
  
  public static int getQQCircleReportBufferLength()
  {
    return getInstance().getConfigValue("qqcircle", "qqcircle_report_buffer_length", Integer.valueOf(10)).intValue();
  }
  
  public static long getQQCircleReportInterval()
  {
    return getInstance().getConfigValue("qqcircle", "qqcircle_report_interval", Integer.valueOf(10)).intValue();
  }
  
  public static boolean getQQCircleReportOutboxSwitchOpen()
  {
    QCircleConfig localQCircleConfig = getInstance();
    boolean bool = false;
    if (localQCircleConfig.getConfigValue("qqcircle", "qqcircle_report_outbox_switch", Integer.valueOf(0)).intValue() == 0) {
      bool = true;
    }
    return bool;
  }
  
  private String getSlashVideoUrl()
  {
    int i = getWidthPixels();
    if (i > 720)
    {
      if (QCircleCommonUtil.isInNightMode()) {
        return "https://wezone-theme.cdn-go.cn/url-resource/latest/darkmode/8417/invitation/native/invitation_splash_video_1080p.mp4";
      }
      return "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/8417/invitation/native/invitation_splash_video_1080p.mp4";
    }
    if (i > 480)
    {
      if (QCircleCommonUtil.isInNightMode()) {
        return "https://wezone-theme.cdn-go.cn/url-resource/latest/darkmode/8417/invitation/native/invitation_splash_video_720p.mp4";
      }
      return "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/8417/invitation/native/invitation_splash_video_720p.mp4";
    }
    if (QCircleCommonUtil.isInNightMode()) {
      return "https://wezone-theme.cdn-go.cn/url-resource/latest/darkmode/8417/invitation/native/invitation_splash_video_480p.mp4";
    }
    return "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/8417/invitation/native/invitation_splash_video_480p.mp4";
  }
  
  private int getWidthPixels()
  {
    int i = this.mWidthPixels;
    if (i > 0) {
      return i;
    }
    this.mWidthPixels = MobileQQ.sMobileQQ.waitAppRuntime(null).getApplication().getResources().getDisplayMetrics().widthPixels;
    return this.mWidthPixels;
  }
  
  public static boolean isQCirclePluginDisable()
  {
    Object localObject = getInstance();
    boolean bool = false;
    int i = ((QCircleConfig)localObject).getConfigValue("qqcircle", "qqcircle_disable_qcircle_plugin", Integer.valueOf(0)).intValue();
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SECONDARY_QQCIRCLE_DISABLE_PLUGIN:");
        ((StringBuilder)localObject).append(i);
        QLog.e("QCircleConfig", 1, ((StringBuilder)localObject).toString());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isQQCircleUseEeveeRedPoint()
  {
    return "1".equals(QZConfigProviderUtil.a("qqcircle", "qqcircle_use_eevee_red_point", "1"));
  }
  
  public static void release()
  {
    QLog.d("QCircleConfig", 4, "release");
    sInstance = null;
  }
  
  public static boolean useOkHttpDownLoadPic()
  {
    int i = getInstance().getConfigValue("qqcircle", "qqcircle_use_okhppt_download_pic", Integer.valueOf(1)).intValue();
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("useOkHttp downloadpic:");
        localStringBuilder.append(i);
        QLog.e("QCircleConfig", 1, localStringBuilder.toString());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return i == 1;
  }
  
  public boolean checkNeedShowDetailKuolieStickGuideBubble()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("qcircle_detail_kuolie_stick_guide_bubble", true);
    }
    return true;
  }
  
  public boolean checkNeedShowKuolieStickGuideBubble()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("qcircle_show_kuolie_stick_bubble", true);
    }
    return true;
  }
  
  public boolean checkNeedShowSplash()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("show_splash_switch", true);
    }
    return true;
  }
  
  public Boolean getConfigValue(String paramString1, String paramString2, Boolean paramBoolean)
  {
    return this.mConfigImpl.getConfigValue(paramString1, paramString2, paramBoolean);
  }
  
  public Float getConfigValue(String paramString1, String paramString2, Float paramFloat)
  {
    return this.mConfigImpl.getConfigValue(paramString1, paramString2, paramFloat);
  }
  
  public Integer getConfigValue(String paramString1, String paramString2, Integer paramInteger)
  {
    return this.mConfigImpl.getConfigValue(paramString1, paramString2, paramInteger);
  }
  
  public Long getConfigValue(String paramString1, String paramString2, Long paramLong)
  {
    return this.mConfigImpl.getConfigValue(paramString1, paramString2, paramLong);
  }
  
  public String getConfigValue(String paramString1, String paramString2)
  {
    return getConfigValue(paramString1, paramString2, "");
  }
  
  public String getConfigValue(String paramString1, String paramString2, String paramString3)
  {
    return this.mConfigImpl.getConfigValue(paramString1, paramString2, paramString3);
  }
  
  public int getFuleCount()
  {
    int i = this.mFuelCount;
    if (i != -1) {
      return i;
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
    return getInstance().getConfigValue("qqcircle", "qqcircle_splash_guide_jump_delay_time", Integer.valueOf(2000)).intValue();
  }
  
  public String getSlashLogoTextUrl()
  {
    return getInstance().getConfigValue("qqcircle", "qqcircle_splash_guide_logo_text_url", "");
  }
  
  public String getSlashLogoUrl()
  {
    return getInstance().getConfigValue("qqcircle", "qqcircle_splash_guide_logo_url", "");
  }
  
  public Uri getSplashVideoPath()
  {
    return mSplashVideoPath;
  }
  
  public boolean isEeveeSysTemPolling()
  {
    String str = QZConfigProviderUtil.a("qqcircle", "qqcircle_enable_eevee_polling", "1");
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isEeveeSysTemPolling:");
        localStringBuilder.append(str);
        QLog.e("QCircleConfig", 1, localStringBuilder.toString());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "1".equals(str);
  }
  
  public boolean isNeedShowPublishGuideBubble()
  {
    Object localObject = getQCircleMultiProcessSp();
    boolean bool;
    if (localObject != null) {
      bool = ((SharedPreferences)localObject).getBoolean("qcircle_show_publish_feed_guide_bubble_v2", true);
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedShowPublishGuideBubble: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("QCircleConfig", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean isNeedShowPublishLabelGuideBubble()
  {
    Object localObject = getQCircleMultiProcessSp();
    boolean bool;
    if (localObject != null) {
      bool = ((SharedPreferences)localObject).getBoolean("qcircle_show_publish_label_guide_bubble", true);
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedShowPublishLabelGuideBubble: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("QCircleConfig", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean isQQCircleShowLebaEntrance()
  {
    boolean bool2 = false;
    int i = getConfigValue("qqcircle", "qqcircle_show_entrance_on_recommend_tab", Integer.valueOf(0)).intValue();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQQCircleShowLebaEntrance:");
      localStringBuilder.append(i);
      QLog.e("QCircleConfig", 1, localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (!QCircleConfigHelper.a(((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void preloadSplash()
  {
    boolean bool;
    if ((checkNeedShowSplash()) && ("1".equals(getInstance().getConfigValue("qqcircle", "qqcircle_splash_enable", "1")))) {
      bool = true;
    } else {
      bool = false;
    }
    this.mNeedShowSplash = bool;
  }
  
  public void saveFuleCount(int paramInt)
  {
    this.mFuelCount = paramInt;
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("qcircle_fuel_count", paramInt).apply();
    }
  }
  
  public void saveNeedClientReportSuccessRateCmd(String paramString)
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("qcircle_need_client_report_success_rate_cmd", paramString).apply();
    }
  }
  
  public void setDetailKuolieStickGuideBubbleNotShowAgain()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("qcircle_detail_kuolie_stick_guide_bubble", false).apply();
    }
  }
  
  public void setKuolieStickGuideBubbleNotShowAgain()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("qcircle_show_kuolie_stick_bubble", false).apply();
    }
  }
  
  public void setNeedShowPublishGuideBubble(boolean paramBoolean)
  {
    Object localObject = getQCircleMultiProcessSp();
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("qcircle_show_publish_feed_guide_bubble_v2", paramBoolean).apply();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNeedShowPublishGuideBubble: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QCircleConfig", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setNeedShowPublishLabelGuideBubble(boolean paramBoolean)
  {
    Object localObject = getQCircleMultiProcessSp();
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("qcircle_show_publish_label_guide_bubble", paramBoolean).apply();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNeedShowPublishLabelGuideBubble: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QCircleConfig", 1, ((StringBuilder)localObject).toString());
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
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new QCircleConfig.2(this));
  }
  
  public void tryGetSplashVideoAsync()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryGetSplashVideoAsync ");
    boolean bool;
    if (mSplashVideoPath != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.d("QCircleConfig", 1, localStringBuilder.toString());
    try
    {
      this.mGetFileListener = new QCircleConfig.1(this);
      RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).download(getSlashVideoUrl(), this.mGetFileListener);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleConfig", 1, "tryGetSplashVideoAsync error:", localException);
    }
  }
  
  public void updateOneConfig(String paramString1, String paramString2, String paramString3)
  {
    this.mConfigImpl.updateOneConfig(paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.QCircleConfig
 * JD-Core Version:    0.7.0.1
 */