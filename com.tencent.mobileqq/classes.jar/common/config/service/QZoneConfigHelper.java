package common.config.service;

import android.os.Build.VERSION;
import android.text.TextUtils;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

public class QZoneConfigHelper
{
  public static int a = 180000;
  public static String b = "qapp://detail?param=";
  
  public static String A()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "CustomVipPreview", "https://h5.qzone.qq.com/personalVipStore/detail/{id}?_wv=2098179&qua={qua}&router=detail&id={id}&_proxy=1");
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPersonalizePreview:");
      localStringBuilder.append(str);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public static int B()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "DetailMaxPicShowNum", 18);
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPersonalizeSettingPage:");
      localStringBuilder.append(i);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static String C()
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "DressUpGroupUrl", "https://h5.qzone.qq.com/show/record/{uin}/{type}?_wv=2&_proxy=1");
  }
  
  public static boolean D()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "use_new_command", 1);
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("use_new_command:");
      localStringBuilder.append(i);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return i != 0;
  }
  
  public static int E()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "max_pending_report_task_num", 1000);
  }
  
  public static int F()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "max_report_task_pengding_day", 3);
  }
  
  public static boolean G()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("QZoneSetting", "can_report_task_run_at_front", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static int H()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "avatar_timeout", 1500);
  }
  
  public static int I()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedsShowPhotoBubble", 0);
  }
  
  public static int J()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedsShowMoodEntry", 0);
  }
  
  public static boolean K()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "passiveBannerSwitch", 1);
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIsBubbleStyle:");
      localStringBuilder.append(i);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return i == 1;
  }
  
  public static String L()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "passiveText", "消息");
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPassiveTabName:");
      localStringBuilder.append(str);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public static boolean M()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "enableExtendFeeds", 1) == 1;
  }
  
  public static boolean N()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localQzoneConfig.getConfig("K_QZKuolieEnterance", "SK_QZKuoliePartyEnteranceConfig", 0) == 1)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT > 20) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean O()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfigSync("QZoneSetting", "timecapsule_default_expand", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static int a()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportSamples", 10);
  }
  
  public static void a(QZoneConfigHelper.LoadIntConfigCallback paramLoadIntConfigCallback)
  {
    if (paramLoadIntConfigCallback != null) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneConfigHelper.1(paramLoadIntConfigCallback));
    }
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "famousWhiteList", "1696127668,536264505,622000659,622009484,1872005011");
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
    return false;
  }
  
  public static int b()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "ActivitySwitchAccReportSamples", 10);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
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
    return false;
  }
  
  public static int c()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportCount", 50);
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
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
    return false;
  }
  
  public static String d()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GdtCgiReportHost", "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com");
  }
  
  public static String e()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "YingyongbaoSwitchPrefix", b);
  }
  
  public static int f()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "AccReportInterval", 600) * 1000;
  }
  
  public static int g()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "DelayShowLoading", 200);
  }
  
  public static int h()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictBeginTime", 1170) * 60000;
  }
  
  public static int i()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictEndTime", 1440) * 60000;
  }
  
  public static int j()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FriendMaxSelectCount", 30)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 30;
  }
  
  public static int k()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedBannerDuration", 7000)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label22:
      break label22;
    }
    return 10000;
  }
  
  public static int l()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FeedBannerActiveMaxCount", 5)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 5;
  }
  
  public static int m()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "FriendMaxSelectCountComment", 10)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10;
  }
  
  public static int n()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", "QCircleFriendMaxSelectCountComment", 10)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10;
  }
  
  public static int o()
  {
    return QzoneConfig.getInstance().getConfig("PhotoView", "RestrictFlag", 0);
  }
  
  public static String[] p()
  {
    return QzoneConfig.getInstance().getConfig("QzoneCover", "UploadQuality", "70,70,70").split(",");
  }
  
  public static String[] q()
  {
    return QzoneConfig.getInstance().getConfig("QzoneCover", "UploadResolution", "640*640,640*640,640*640").replace("*", ",").split(",");
  }
  
  public static boolean r()
  {
    Object localObject = QzoneConfig.getInstance();
    boolean bool = false;
    int i = ((QzoneConfig)localObject).getConfig("QZoneSetting", "ShowFeedOpLayer", 0);
    if (QZLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ShowFeedOpLayer :");
      ((StringBuilder)localObject).append(Integer.toString(i));
      QZLog.d("config", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String s()
  {
    String str = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_schema", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&uin={UIN}&_proxy=1");
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUserhomeBarSchema:");
      localStringBuilder.append(str);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public static int t()
  {
    int i = QzoneConfig.getInstance().getConfig("HomepageBar", "bar_music_visiable", 0);
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUserhomeMusicBarShow:");
      localStringBuilder.append(i);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static String u()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "FeedLoveDiamond", "https://h5.vip.qq.com/p/pay/union?openType=webview&disableTitle=1&_wv=16781315&_wwv=13&sandbox=0&debug=0&type=!love&businessType=union&entranceId={entranceId}&disableAskFriend=0");
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFeedLoverIconUrl:");
      localStringBuilder.append(str);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public static int v()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextCount", 2000);
  }
  
  public static int w()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxCommentBubbleTextCount", 40);
  }
  
  public static int x()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextVisibleLineCount", 7);
  }
  
  public static String y()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "PersonalizeMainPage", "https://h5.qzone.qq.com/show/home?_wv=131072&_fv=0&_wwv=128&_proxy=1&reddot={reddot}");
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPersonalizeSettingPage:");
      localStringBuilder.append(str);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public static String z()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "CustomVipMall", "https://h5.qzone.qq.com/personalVipStore/index?_wv=2098179&refresh=1&qua={qua}&_proxy=1");
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPersonalizeVipHomePage:");
      localStringBuilder.append(str);
      QZLog.d("config", 2, localStringBuilder.toString());
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.config.service.QZoneConfigHelper
 * JD-Core Version:    0.7.0.1
 */