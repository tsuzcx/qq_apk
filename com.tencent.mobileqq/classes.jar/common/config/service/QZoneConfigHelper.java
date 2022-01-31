package common.config.service;

import ampv;
import android.text.TextUtils;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

public class QZoneConfigHelper
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_Int = 180000;
    jdField_a_of_type_JavaLangString = "qapp://detail?param=";
  }
  
  public static String A()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "MyWeishiForMale", "他的微视");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiTextV2:" + str);
    }
    return str;
  }
  
  public static String B()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "MyWeishiForFemale", "她的微视");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiTextV2:" + str);
    }
    return str;
  }
  
  public static String C()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "schema_url_weishi", "https://h5.qzone.qq.com/weishi/recommend?_proxy=1&_wv=1025&_wwv=4&from=discovery&uin={uin}&hostuin={hostuin}&style=light");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiJumpUrl:" + str);
    }
    return str;
  }
  
  public static int a()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportSamples", 10);
  }
  
  public static String a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GdtCgiReportHost", "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com");
  }
  
  public static void a(QZoneConfigHelper.LoadIntConfigCallback paramLoadIntConfigCallback)
  {
    if (paramLoadIntConfigCallback != null) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new ampv(paramLoadIntConfigCallback));
    }
  }
  
  public static boolean a()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "ShowFeedOpLayer", 0);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "ShowFeedOpLayer :" + Integer.toString(i));
    }
    return i == 1;
  }
  
  public static boolean a(String paramString)
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
  
  public static String[] a()
  {
    return QzoneConfig.getInstance().getConfig("QzoneCover", "UploadQuality", "70,70,70").split(",");
  }
  
  public static int b()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "ActivitySwitchAccReportSamples", 10);
  }
  
  public static String b()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "YingyongbaoSwitchPrefix", jdField_a_of_type_JavaLangString);
  }
  
  public static boolean b()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "use_new_command", 1);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "use_new_command:" + i);
    }
    return i != 0;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "sharewhitelist", "100733645,1101218289,100497308,1103394134,1106611629,1105705811");
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
  
  public static String[] b()
  {
    return QzoneConfig.getInstance().getConfig("QzoneCover", "UploadResolution", "640*640,640*640,640*640").replace("*", ",").split(",");
  }
  
  public static int c()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportCount", 50);
  }
  
  public static String c()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_name", "好友生日");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarName:" + str);
    }
    return str;
  }
  
  public static boolean c()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "can_report_task_run_at_front", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static int d()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "PermitPreDownload", 0);
  }
  
  public static String d()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_schema", "https://h5.qzone.qq.com/gift/index?_proxy=1&_wv=2098179&_proxy=1&uin={UIN}");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarSchema:" + str);
    }
    return str;
  }
  
  public static boolean d()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "passiveBannerSwitch", 1);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getIsBubbleStyle:" + i);
    }
    return i == 1;
  }
  
  public static int e()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportInterval", 600) * 1000;
  }
  
  public static String e()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_visiable", "1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarShow:" + str);
    }
    return str;
  }
  
  public static int f()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "DelayShowLoading", 200);
  }
  
  public static String f()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_personalize_name", "个性化中心");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarPersonalizeName:" + str);
    }
    return str;
  }
  
  public static int g()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictBeginTime", 1170) * 60000;
  }
  
  public static String g()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_personalize_schema", "mqzone://arouse/persionsetting");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarPersonalizeSchema:" + str);
    }
    return str;
  }
  
  public static int h()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictEndTime", 1440) * 60000;
  }
  
  public static String h()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_personalize_visiable", "1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarPersonalizeShow:" + str);
    }
    return str;
  }
  
  public static int i()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FriendMaxSelectCount", 30)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 30;
  }
  
  @Deprecated
  public static String i()
  {
    return QzoneConfig.getInstance().getConfig("HomepageBar", "bar_loversspace_iconurl", "");
  }
  
  public static int j()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedBannerDuration", 15000)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10000;
  }
  
  public static String j()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_loversspace_name", "情侣空间");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarLoverZoneName:" + str);
    }
    return str;
  }
  
  public static int k()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedBannerActiveMaxCount", 5)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 5;
  }
  
  public static String k()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_loversspace_schema", "https://h5.qzone.qq.com/mood/lover/{uin}?_wv=16777219&from={from}&uin={uin}&ask_vip={ask_vip}&qua={qua}&qzUseTransparentNavBar=1&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarLoverZoneSchema:" + str);
    }
    return str;
  }
  
  public static int l()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FriendMaxSelectCountComment", 10)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10;
  }
  
  public static String l()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "FeedLoveDiamond", "https://h5.qzone.qq.com/lover/vipDialog?_wv=16777219&_proxy=1&qzUseTransparentNavBar=1&friendUin={friendUin}");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getFeedLoverIconUrl:" + str);
    }
    return str;
  }
  
  public static int m()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictFlag", 0);
  }
  
  public static String m()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_famouszone_schema", "https://h5.qzone.qq.com/vpage/list/index?qua={qua}&_proxy=1&_wv=2102275&_ws=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarFamousZoneSchema:" + str);
    }
    return str;
  }
  
  public static int n()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_personalize_countid", 13);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarPersonalizeID:" + i);
    }
    return i;
  }
  
  public static String n()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_campuszone_schema", "http://h5.qzone.qq.com/young/home?_proxy=1&_wv=1027");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarCampusZoneSchema:" + str);
    }
    return str;
  }
  
  public static int o()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_music_visiable", 0);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeMusicBarShow:" + i);
    }
    return i;
  }
  
  public static String o()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "bar_vip_jumpurl", "https://h5.qzone.qq.com/vip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source={aid}&qua={qua}&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarYellowDiamondSchema:" + str);
    }
    return str;
  }
  
  public static int p()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_loversspace_visible", 1);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarLoverZoneVisible:" + i);
    }
    return i;
  }
  
  public static String p()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_vip_visible", "0");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarYellowDiamondVisible:" + str);
    }
    return str;
  }
  
  public static int q()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_famouszone_visible", 0);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarFamousZoneVisible:" + i);
    }
    return i;
  }
  
  public static String q()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_vip_name", "我的黄钻");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserhomeBarYellowDiamondName:" + str);
    }
    return str;
  }
  
  public static int r()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextCount", 2000);
  }
  
  public static String r()
  {
    return QzoneConfig.getInstance().getConfig("HomepageBar", "bar_vip_iconurl", "");
  }
  
  public static int s()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxCommentBubbleTextCount", 40);
  }
  
  public static String s()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "PersonalizeMainPage", "https://h5.qzone.qq.com/show/index?_wv=16778243&_proxy=1&_ws=32&_wwv=1&&reddot={reddot}&idlist={idlist}");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizeSettingPage:" + str);
    }
    return str;
  }
  
  public static int t()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "DetailMaxPicShowNum", 18);
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizeSettingPage:" + i);
    }
    return i;
  }
  
  public static String t()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "CustomVipMall", "https://h5.qzone.qq.com/personalVipStore/index?_wv=2098179&refresh=1&qua={qua}&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizeVipHomePage:" + str);
    }
    return str;
  }
  
  public static int u()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "max_pending_report_task_num", 1000);
  }
  
  public static String u()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "CustomVipPreview", "https://h5.qzone.qq.com/personalVipStore/detail/{id}?_wv=2098179&qua={qua}&router=detail&id={id}&_proxy=1");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizePreview:" + str);
    }
    return str;
  }
  
  public static int v()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "max_report_task_pengding_day", 3);
  }
  
  public static String v()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "PassivePraisePreview", "https://h5.qzone.qq.com/show/passivelike/preview?id={id}&prevPath=mall&_proxy=1&_wv=2098179");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPersonalizePreview:" + str);
    }
    return str;
  }
  
  public static int w()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "avatar_timeout", 1500);
  }
  
  public static String w()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "passiveText", "消息");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getPassiveTabName:" + str);
    }
    return str;
  }
  
  public static int x()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedsShowPhotoBubble", 0);
  }
  
  public static String x()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "icon_url_myfans", "http://qzonestyle.gtimg.cn/aoi/sola/20170313120214_mkFCtOS6xJ.png");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarFansIconUrl:" + str);
    }
    return str;
  }
  
  public static int y()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedsShowMoodEntry", 0);
  }
  
  public static String y()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "icon_url_weishi", "https://qzonestyle.gtimg.cn/aoi/sola/20180228200706_ZQIIiwaz2c.png");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiIconUrl:" + str);
    }
    return str;
  }
  
  public static String z()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "MyWeishi", "我的微视");
    if (QZLog.isColorLevel()) {
      QZLog.d("config", 2, "getUserHomeBarWeishiText:" + str);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     common.config.service.QZoneConfigHelper
 * JD-Core Version:    0.7.0.1
 */