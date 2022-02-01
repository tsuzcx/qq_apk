package common.config.service;

import android.os.Build.VERSION;
import android.text.TextUtils;
import awzb;
import blpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

public class QZoneConfigHelper
{
  public static final int BIG_LEVEL = 4;
  private static final int DEFAULT_CRASH_DURATION_AFTER_LAUNCH = 15;
  private static final int DEFAULT_CRASH_MAX_COUNT = 3;
  private static final int DEFAULT_FEEDSPRE_RESTRICTFLAG = 0;
  public static int DEFAULT_FEED_ALERT_TIMEINTERVAL = 180000;
  private static final String DEFAULT_GDT_CGI_HOST = "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com";
  private static final int DEFAULT_REPORT_COUNT = 50;
  private static final int DEFAULT_REPORT_INTERVAL = 600;
  private static final int DEFAULT_REPORT_SAMPLES = 10;
  public static String DEFAULT_YINGYONGBAO_SWITCH_PREFIX = "qapp://detail?param=";
  public static final String SCHEMA_PREFIX_LOVER_ZONE = "https://h5.qzone.qq.com/mood/lover/{uin}?_wv=16777219&from={from}&uin={uin}&ask_vip={ask_vip}&qua={qua}&qzUseTransparentNavBar=1&_proxy=1";
  public static final String SCHEMA_PREFIX_PERSONSETTING = "mqzone://arouse/persionsetting";
  public static final int SMALL_LEVEL = 2;
  
  public static boolean canReportTaskAtFront()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "can_report_task_run_at_front", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean canShareStructLongMessage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "canShareStructLongMessage", "qzone.qq.com");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.endsWith(localObject[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static int canShowMoodEntry()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedsShowMoodEntry", 0);
  }
  
  public static int canShowPhotoBubble()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedsShowPhotoBubble", 0);
  }
  
  public static boolean capsuleTimeDefaultExpand()
  {
    return QzoneConfig.getInstance().getConfigSync("QZoneSetting", "timecapsule_default_expand", 0) == 1;
  }
  
  public static boolean enableExtendFeeds()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "enableExtendFeeds", 1) == 1;
  }
  
  public static boolean enableExtendFeedsLive()
  {
    return (QzoneConfig.getInstance().getConfig("K_QZKuolieEnterance", "SK_QZKuoliePartyEnteranceConfig", 0) == 1) && (Build.VERSION.SDK_INT > 20);
  }
  
  public static long enableQZoneContentBoxMiniProgram()
  {
    return blpl.a().a("contentboxlaunch", "gocontentboxminiprogram", 0);
  }
  
  public static boolean enableQZoneContextBox(QQAppInterface paramQQAppInterface)
  {
    try
    {
      boolean bool = ((awzb)paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER)).b();
      return bool;
    }
    catch (Throwable paramQQAppInterface)
    {
      QZLog.e("QZoneMsgManager.enableQZoneContextBox", 2, paramQQAppInterface, new Object[0]);
    }
    return false;
  }
  
  public static int getAccReportCount()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportCount", 50);
  }
  
  public static int getAccReportInterval()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportInterval", 600) * 1000;
  }
  
  public static int getAccReportSamples()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportSamples", 10);
  }
  
  public static int getActivitySwitchAccReportSamples()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "ActivitySwitchAccReportSamples", 10);
  }
  
  public static int getAtUserInteractiveMaxConfig()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FriendMaxSelectCountComment", 10)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10;
  }
  
  public static int getAtUserPublishUgcMaxConfig()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FriendMaxSelectCount", 30)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 30;
  }
  
  public static int getAvatarTimeOut()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "avatar_timeout", 1500);
  }
  
  public static String[] getCoverUploadQuality()
  {
    return QzoneConfig.getInstance().getConfig("QzoneCover", "UploadQuality", "70,70,70").split(",");
  }
  
  public static String[] getCoverUploadResolution()
  {
    return QzoneConfig.getInstance().getConfig("QzoneCover", "UploadResolution", "640*640,640*640,640*640").replace("*", ",").split(",");
  }
  
  public static int getDetailMaxPicShowNum()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "DetailMaxPicShowNum", 18);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizeSettingPage:" + i);
    }
    return i;
  }
  
  public static int getFeedBannerActiveMaxCount()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedBannerActiveMaxCount", 5)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 5;
  }
  
  public static int getFeedBannerDuration()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedBannerDuration", 7000)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10000;
  }
  
  public static String getFeedLoverIconUrl()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "FeedLoveDiamond", "https://h5.qzone.qq.com/lover/vipDialog?_wv=16777219&_proxy=1&qzUseTransparentNavBar=1&friendUin={friendUin}");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getFeedLoverIconUrl:" + str);
    }
    return str;
  }
  
  public static boolean getFeedOperationLayer()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "ShowFeedOpLayer", 0);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "ShowFeedOpLayer :" + Integer.toString(i));
    }
    return i == 1;
  }
  
  public static String getGdtCgiReportHost()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GdtCgiReportHost", "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com");
  }
  
  public static boolean getIsBubbleStyle()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "passiveBannerSwitch", 1);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getIsBubbleStyle:" + i);
    }
    return i == 1;
  }
  
  public static int getMaxCommentBubbleTextCount()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxCommentBubbleTextCount", 40);
  }
  
  public static int getMaxReportTaskPengdingDay()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "max_report_task_pengding_day", 3);
  }
  
  public static int getMaxUgcTextCount()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextCount", 2000);
  }
  
  public static int getMaxUgcVisibleLineCount()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextVisibleLineCount", 7);
  }
  
  public static String getNavigatorBarItemAttribute()
  {
    String str = QzoneConfig.getInstance().getConfig("NavigationBar", "ItemAttribute", "reportValue&name&iconUrl&schema");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "NavigationBar ItemAttribute :" + str);
    }
    return str;
  }
  
  public static int getNavigatorBarItemCount()
  {
    int i = QzoneConfig.getInstance().getConfig("NavigationBar", "ItemCount", 5);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "NavigationBar ItemCount :" + Integer.toString(i));
    }
    return i;
  }
  
  public static String getNavigatorBarItemOrder()
  {
    String str = QzoneConfig.getInstance().getConfig("NavigationBar", "ItemOrder", "2&1&6&3&7");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "NavigationBar order :" + str);
    }
    return str;
  }
  
  public static String getNavigatorBarItemURLPrefix()
  {
    String str = QzoneConfig.getInstance().getConfig("NavigationBar", "ItemDownURLPrefix", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "NavigationBar URLPrefix :" + str);
    }
    return str;
  }
  
  public static String getPassivePraisePreview()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "PassivePraisePreview", "https://h5.qzone.qq.com/show/passivelike/preview?id={id}&prevPath=mall&_proxy=1&_wv=2098179");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizePreview:" + str);
    }
    return str;
  }
  
  public static String getPassiveTabName()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "passiveText", "消息");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPassiveTabName:" + str);
    }
    return str;
  }
  
  public static int getPendingMaxReportTaskCount()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "max_pending_report_task_num", 1000);
  }
  
  public static String getPersonalizePreview()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "CustomVipPreview", "https://h5.qzone.qq.com/personalVipStore/detail/{id}?_wv=2098179&qua={qua}&router=detail&id={id}&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizePreview:" + str);
    }
    return str;
  }
  
  public static String getPersonalizeSettingPage()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "PersonalizeMainPage", "https://h5.qzone.qq.com/show/home?_wv=131072&_fv=0&_wwv=128&_proxy=1&reddot={reddot}");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizeSettingPage:" + str);
    }
    return str;
  }
  
  public static String getPersonalizeVipHomePage()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "CustomVipMall", "https://h5.qzone.qq.com/personalVipStore/index?_wv=2098179&refresh=1&qua={qua}&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizeVipHomePage:" + str);
    }
    return str;
  }
  
  public static void getPhotoOpUIDelay(QZoneConfigHelper.LoadIntConfigCallback paramLoadIntConfigCallback)
  {
    if (paramLoadIntConfigCallback != null) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneConfigHelper.1(paramLoadIntConfigCallback));
    }
  }
  
  public static int getPhotoRestrictBeginTime()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictBeginTime", 1170) * 60000;
  }
  
  public static int getPhotoRestrictEndTime()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictEndTime", 1440) * 60000;
  }
  
  public static int getPhotoRestrictFlag()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictFlag", 0);
  }
  
  public static int getPreDwonLoadVideoConfig()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "PermitPreDownload", 0);
  }
  
  public static int getQCircleAtUserMaxConfig()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "QCircleFriendMaxSelectCountComment", 10)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10;
  }
  
  public static String getQzoneDressUpGroupPageUrl()
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "DressUpGroupUrl", "https://h5.qzone.qq.com/show/record/{uin}/{type}?_wv=2&_proxy=1");
  }
  
  public static int getShowLoadingDelay()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "DelayShowLoading", 200);
  }
  
  public static String getTravelingBottomPhoto()
  {
    String str = QzoneConfig.getInstance().getConfig("PhotoAlbum", "TravelingBottomPhoto", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_skin_album_photolist_travel_tail_photo.jpg");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarIconUrl:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarCampusZoneSchema()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_campuszone_schema", "https://h5.qzone.qq.com/young/home?_proxy=1&_wv=1027");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarCampusZoneSchema:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarFamilyIconUrl()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "icon_url_family", "https://qzonestyle.gtimg.cn/aoi/sola/20180906170914_eL2SexEwpz.png");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarFamilyIconUrl:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarFamilyText()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "HomePageBarFamilyText", "空间家族");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarFamilyText:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarFamousZoneSchema()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_famouszone_schema", "https://h5.qzone.qq.com/vpage/list/index?qua={qua}&_proxy=1&_wv=2102275&_ws=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarFamousZoneSchema:" + str);
    }
    return str;
  }
  
  public static int getUserHomeBarFamousZoneShow()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_famouszone_visible", 0);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarFamousZoneVisible:" + i);
    }
    return i;
  }
  
  public static String getUserHomeBarFansIconUrl()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "icon_url_myfans", "https://qzonestyle.gtimg.cn/aoi/sola/20170313120214_mkFCtOS6xJ.png");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarFansIconUrl:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarLoverZoneSchema()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_loversspace_schema", "https://h5.qzone.qq.com/mood/lover/{uin}?_wv=16777219&from={from}&uin={uin}&ask_vip={ask_vip}&qua={qua}&qzUseTransparentNavBar=1&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarLoverZoneSchema:" + str);
    }
    return str;
  }
  
  public static int getUserHomeBarLoverZoneShow()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_loversspace_visible", 1);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarLoverZoneVisible:" + i);
    }
    return i;
  }
  
  public static String getUserHomeBarMyFriendsText()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "HomePageBarMyFriendsText", "我的好友");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarMyFriendsText:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarWeishiIconUrl()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "icon_url_weishi", "https://qzonestyle.gtimg.cn/aoi/sola/20180228200706_ZQIIiwaz2c.png");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiIconUrl:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarWeishiJumpUrl()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "schema_url_weishi", "https://h5.qzone.qq.com/weishi/recommend?_proxy=1&_wv=1025&_wwv=4&from=discovery&uin={uin}&hostuin={hostuin}&style=light");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiJumpUrl:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarWeishiText()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "MyWeishi", "我的微视");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiText:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarWeishiText4Female()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "MyWeishiForFemale", "她的微视");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiTextV2:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarWeishiText4Male()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "MyWeishiForMale", "他的微视");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiTextV2:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarYellowDiamondSchema()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "bar_vip_jumpurl", "https://h5.qzone.qq.com/vip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source={aid}&qua={qua}&_proxy=1&trace_detail=%7B%22appid%22:%22MoreAN%22%7D");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarYellowDiamondSchema:" + str);
    }
    return str;
  }
  
  public static String getUserHomeBarYellowDiamondShow()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_vip_visible", "0");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarYellowDiamondVisible:" + str);
    }
    return str;
  }
  
  public static String getUserhomeBarIconUrl()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_iconurl", "https://qzonestyle.gtimg.cn/aoi/sola/20150305211800_JRTtcp4gkY.png");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarIconUrl:" + str);
    }
    return str;
  }
  
  @Deprecated
  public static String getUserhomeBarLoverZoneIconUrl()
  {
    return QzoneConfig.getInstance().getConfig("HomepageBar", "bar_loversspace_iconurl", "");
  }
  
  public static String getUserhomeBarLoverZoneName()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_loversspace_name", "情侣空间");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarLoverZoneName:" + str);
    }
    return str;
  }
  
  public static String getUserhomeBarName()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_name", "好友生日");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarName:" + str);
    }
    return str;
  }
  
  public static int getUserhomeBarPersonalizeID()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_personalize_countid", 13);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarPersonalizeID:" + i);
    }
    return i;
  }
  
  @Deprecated
  public static String getUserhomeBarPersonalizeIconUrl()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_personalize_iconurl", "");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarPersonalizeIconUrl:" + str);
    }
    return str;
  }
  
  public static String getUserhomeBarPersonalizeName()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_personalize_name", "个性化");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarPersonalizeName:" + str);
    }
    return str;
  }
  
  public static String getUserhomeBarPersonalizeSchema()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_personalize_schema", "mqzone://arouse/persionsetting");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarPersonalizeSchema:" + str);
    }
    return str;
  }
  
  public static String getUserhomeBarPersonalizeShow()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_personalize_visiable", "1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarPersonalizeShow:" + str);
    }
    return str;
  }
  
  public static String getUserhomeBarSchema()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_schema", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&uin={UIN}&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarSchema:" + str);
    }
    return str;
  }
  
  public static String getUserhomeBarShow()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_visiable", "1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarShow:" + str);
    }
    return str;
  }
  
  public static String getUserhomeBarYellowDiamondIconUrl()
  {
    return QzoneConfig.getInstance().getConfig("HomepageBar", "bar_vip_iconurl", "");
  }
  
  public static String getUserhomeBarYellowDiamondName()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_vip_name", "我的黄钻");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarYellowDiamondName:" + str);
    }
    return str;
  }
  
  public static int getUserhomeMusicBarShow()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_music_visiable", 0);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeMusicBarShow:" + i);
    }
    return i;
  }
  
  public static String getYingyongbaoSwithPrefix()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "YingyongbaoSwitchPrefix", DEFAULT_YINGYONGBAO_SWITCH_PREFIX);
  }
  
  public static boolean isFamousUserHomeWhite(String paramString)
  {
    boolean bool2 = false;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "famousWhiteList", "1696127668,536264505,622000659,622009484,1872005011");
    boolean bool1 = bool2;
    int j;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (localObject[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isQzoneShareWhite(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "sharewhitelist", "100733645,1101218289,100497308,1103394134,1106611629,1105705811,1104466820");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].equals(paramString)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean useNewCommand()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "use_new_command", 1);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "use_new_command:" + i);
    }
    return i != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     common.config.service.QZoneConfigHelper
 * JD-Core Version:    0.7.0.1
 */