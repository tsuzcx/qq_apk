package cooperation.qqcircle;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.tencent.biz.qcircleshadow.delegateimpl.QCircleConfigImpl;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleConfig
{
  private static final String TAG = "QCircleConfig";
  private static volatile Uri mSplashVideoPath = null;
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
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    str = "sp_qqcirlce_business" + str;
    return MobileQQ.sMobileQQ.getSharedPreferences(str, 4);
  }
  
  public static SharedPreferences getQCircleSp()
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    str = "sp_qqcirlce_business" + str;
    return MobileQQ.sMobileQQ.getSharedPreferences(str, 0);
  }
  
  public static long getQQCircleFollowTabUpdateNotificationShowInterval()
  {
    return getInstance().getConfigValue("qqcircle", "qqcircle_follow_tab_reddot_show_interval", Integer.valueOf(15)).intValue();
  }
  
  public static long getQQCircleGetFollowUserInternal()
  {
    return getInstance().getConfigValue("qqcircle", "qqcircle_getfollowuser_internal", Long.valueOf(43200000L)).longValue();
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
    boolean bool = false;
    if (getInstance().getConfigValue("qqcircle", "qqcircle_report_outbox_switch", Integer.valueOf(0)).intValue() == 0) {
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
    if (this.mWidthPixels > 0) {
      return this.mWidthPixels;
    }
    this.mWidthPixels = MobileQQ.sMobileQQ.waitAppRuntime(null).getApplication().getResources().getDisplayMetrics().widthPixels;
    return this.mWidthPixels;
  }
  
  public static boolean isQCirclePluginDisable()
  {
    int i = getInstance().getConfigValue("qqcircle", "qqcircle_disable_qcircle_plugin", Integer.valueOf(0)).intValue();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("QCircleConfig", 1, "SECONDARY_QQCIRCLE_DISABLE_PLUGIN:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isQQCircleUseEeveeRedPoint()
  {
    IQZoneService localIQZoneService = QCircleServiceImpl.getQZoneService();
    if (localIQZoneService == null) {
      return true;
    }
    return "1".equals(localIQZoneService.getHighPriorityConfig("qqcircle", "qqcircle_use_eevee_red_point", "1"));
  }
  
  public static boolean isShowQQCircleMainTabEntrance()
  {
    int i;
    if (QCircleServiceImpl.getStudyModeMgr().getStudyModeSwitch()) {
      i = getInstance().getConfigValue("qqcircle", "qqcircle_show_entrance_on_main_tab_on_children_mode", Integer.valueOf(0)).intValue();
    }
    try
    {
      for (;;)
      {
        RFLog.e("QCircleConfig", RFLog.USR, "initQCircleTab isQQCircleMainTabEntrance:" + i);
        if (i != 1) {
          break;
        }
        return true;
        i = getInstance().getConfigValue("qqcircle", "qqcircle_show_entrance_on_main_tab", Integer.valueOf(0)).intValue();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static void release()
  {
    RFLog.d("QCircleConfig", RFLog.DEV, "release");
    sInstance = null;
  }
  
  public static boolean useOkHttpDownLoadPic()
  {
    int i = getInstance().getConfigValue("qqcircle", "qqcircle_use_okhppt_download_pic", Integer.valueOf(1)).intValue();
    try
    {
      if (RFLog.isColorLevel()) {
        RFLog.e("QCircleConfig", RFLog.USR, "useOkHttp downloadpic:" + i);
      }
      if (i == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean checkNeedShowDetailKuolieStickGuideBubble()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("qcircle_detail_kuolie_stick_guide_bubble", true);
    }
    return bool;
  }
  
  public boolean checkNeedShowKuolieStickGuideBubble()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("qcircle_show_kuolie_stick_bubble", true);
    }
    return bool;
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
    if (this.mFuelCount != -1) {
      return this.mFuelCount;
    }
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt("qcircle_fuel_count", 2147483647);
    }
    return 0;
  }
  
  public String getNeedClientReportSuccessRateCmd()
  {
    String str = null;
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("qcircle_need_client_report_success_rate_cmd", null);
    }
    return str;
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
    if (QCircleServiceImpl.getQZoneService() == null) {
      return false;
    }
    String str = QCircleServiceImpl.getQZoneService().getHighPriorityConfig("qqcircle", "qqcircle_enable_eevee_polling", "1");
    try
    {
      if (RFLog.isColorLevel()) {
        RFLog.e("QCircleConfig", RFLog.USR, "isEeveeSysTemPolling:" + str);
      }
      return "1".equals(str);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean isNeedShowPublishGuideBubble()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = getQCircleMultiProcessSp();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("qcircle_show_publish_feed_guide_bubble_v2", true);
    }
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleConfig", RFLog.USR, "isNeedShowPublishGuideBubble: " + bool);
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
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleConfig", RFLog.USR, "isNeedShowPublishLabelGuideBubble: " + bool);
    }
    return bool;
  }
  
  public boolean isQQCircleShowLebaEntrance()
  {
    int i = getConfigValue("qqcircle", "qqcircle_show_entrance_on_recommend_tab", Integer.valueOf(0)).intValue();
    try
    {
      RFLog.e("QCircleConfig", RFLog.USR, "isQQCircleShowLebaEntrance:" + i);
      if ((i == 1) && (!isShowQQCircleMainTabEntrance())) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public void preloadSplash()
  {
    if ((checkNeedShowSplash()) && ("1".equals(getInstance().getConfigValue("qqcircle", "qqcircle_splash_enable", "1")))) {}
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
    SharedPreferences localSharedPreferences = getQCircleMultiProcessSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("qcircle_show_publish_feed_guide_bubble_v2", paramBoolean).apply();
    }
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleConfig", RFLog.USR, "setNeedShowPublishGuideBubble: " + paramBoolean);
    }
  }
  
  public void setNeedShowPublishLabelGuideBubble(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getQCircleMultiProcessSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("qcircle_show_publish_label_guide_bubble", paramBoolean).apply();
    }
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleConfig", RFLog.USR, "setNeedShowPublishLabelGuideBubble: " + paramBoolean);
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
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder().append("tryGetSplashVideoAsync ");
    if (mSplashVideoPath != null) {}
    for (boolean bool = true;; bool = false)
    {
      RFLog.d("QCircleConfig", i, bool);
      try
      {
        this.mGetFileListener = new QCircleConfig.1(this);
        RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).download(getSlashVideoUrl(), this.mGetFileListener);
        return;
      }
      catch (Exception localException)
      {
        RFLog.e("QCircleConfig", RFLog.USR, new Object[] { "tryGetSplashVideoAsync error:", localException });
      }
    }
  }
  
  public void updateOneConfig(String paramString1, String paramString2, String paramString3)
  {
    this.mConfigImpl.updateOneConfig(paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.QCircleConfig
 * JD-Core Version:    0.7.0.1
 */