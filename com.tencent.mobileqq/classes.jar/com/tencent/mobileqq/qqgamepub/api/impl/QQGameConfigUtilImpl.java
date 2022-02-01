package com.tencent.mobileqq.qqgamepub.api.impl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.config.QQGameConfBean;
import com.tencent.mobileqq.qqgamepub.config.QQGameConfProcessor;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreloadConfBean;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreloadConfProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.URLUtil;
import java.util.ArrayList;
import java.util.List;

public class QQGameConfigUtilImpl
  implements IQQGameConfigUtil
{
  public static final String DEBUG_FEED_URL = "https://hao.gamecenter.qq.com/sgame-official-account";
  public static final int SWITCH_OFF = 0;
  public static final int SWITCH_ON = 1;
  private static final String TAG = "QQGamePub_QQGameConfigUtilImpl";
  public static List<String> sFloadWindowShowedGames = new ArrayList(3);
  
  private boolean isDebugMode()
  {
    return false;
  }
  
  private boolean isDebugSwitchByGamePubType(String paramString)
  {
    String str = ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getDebugGamePubAccountType();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GamePubAccount debug mode type=");
      localStringBuilder.append(str);
      QLog.d("QQGamePub_QQGameConfigUtilImpl", 4, localStringBuilder.toString());
    }
    return str.equals(paramString);
  }
  
  public boolean canShowFloatWindow(String paramString)
  {
    if (sFloadWindowShowedGames == null) {
      sFloadWindowShowedGames = new ArrayList(3);
    }
    return (sFloadWindowShowedGames.size() < 3) && (!sFloadWindowShowedGames.contains(paramString));
  }
  
  public boolean checkGamePubAccountConfig()
  {
    boolean bool = isPubFeedByWeb();
    IQQGameHelper localIQQGameHelper = (IQQGameHelper)QRoute.api(IQQGameHelper.class);
    int i = localIQQGameHelper.canOpenHippyByModuleName(localIQQGameHelper.getGamePaHippyModuleName());
    if ((!bool) && (i != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    if (!bool) {
      QLog.d("QQGamePub_QQGameConfigUtilImpl", 1, "checkGamePubAccountConfig false,so enter aio gamepubaccount !!!!!");
    }
    return bool;
  }
  
  public String getFeedWebUrl()
  {
    if (isDebugMode()) {
      return "https://hao.gamecenter.qq.com/sgame-official-account";
    }
    String str2 = QQGameConfProcessor.a().jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  public String getGamePubUrl()
  {
    String str = QQGameConfProcessor.a().jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty(str)) {
      return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393";
    }
    if ((!TextUtils.isEmpty(str)) && ((str.startsWith("http://")) || (str.startsWith("https://")))) {
      return str;
    }
    return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393";
  }
  
  public boolean getHippySoDownload()
  {
    QQGameConfBean localQQGameConfBean = QQGameConfProcessor.a();
    return (localQQGameConfBean != null) && (localQQGameConfBean.jdField_b_of_type_Boolean);
  }
  
  public boolean getHippySwitch()
  {
    QQGameConfBean localQQGameConfBean = QQGameConfProcessor.a();
    return (localQQGameConfBean != null) && (localQQGameConfBean.jdField_a_of_type_Boolean);
  }
  
  public List<String> getInterceptAdIdList()
  {
    QQGamePreloadConfBean localQQGamePreloadConfBean = QQGamePreloadConfProcessor.a();
    if (localQQGamePreloadConfBean.jdField_a_of_type_JavaUtilList != null) {
      return localQQGamePreloadConfBean.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public boolean getNewPAHippySwitch()
  {
    if (isDebugMode()) {
      return isDebugSwitchByGamePubType("2");
    }
    return QQGamePreloadConfProcessor.a().jdField_a_of_type_Int == 1;
  }
  
  public boolean getNewPAHippyV2Switch()
  {
    if (isDebugMode()) {
      return isDebugSwitchByGamePubType("3");
    }
    return QQGamePreloadConfProcessor.a().b == 1;
  }
  
  public int getPreloadFeedsLoadAll()
  {
    QQGamePreloadConfBean localQQGamePreloadConfBean = QQGamePreloadConfProcessor.a();
    if (localQQGamePreloadConfBean != null) {
      return localQQGamePreloadConfBean.g;
    }
    return 0;
  }
  
  public boolean getPreloadFeedsSwitch()
  {
    QQGamePreloadConfBean localQQGamePreloadConfBean = QQGamePreloadConfProcessor.a();
    return (localQQGamePreloadConfBean != null) && (localQQGamePreloadConfBean.f == 1);
  }
  
  public String getPreloadFeedsUrl()
  {
    QQGamePreloadConfBean localQQGamePreloadConfBean = QQGamePreloadConfProcessor.a();
    if ((localQQGamePreloadConfBean != null) && (!TextUtils.isEmpty(localQQGamePreloadConfBean.jdField_a_of_type_JavaLangString))) {
      return localQQGamePreloadConfBean.jdField_a_of_type_JavaLangString;
    }
    return "https://hao.gamecenter.qq.com/sgame-official-account/cgi-bin/gamedatalist";
  }
  
  public int getPreloadIntervalDay()
  {
    return QQGamePreloadConfProcessor.a().d;
  }
  
  public String getPreloadUrl()
  {
    return "https://imgcache.qq.com/ogame/sgame-official-account/precache.html";
  }
  
  public boolean isFlutterPreLoad()
  {
    return QQGamePreloadConfProcessor.a().e == 1;
  }
  
  public boolean isGameCenterPreloadByTab()
  {
    QQGameConfBean localQQGameConfBean = QQGameConfProcessor.a();
    return (localQQGameConfBean != null) && (localQQGameConfBean.e == 1);
  }
  
  public boolean isNeedPreloadByInterval()
  {
    long l1 = GameCenterSpUtils.a("key_game_pa_hippy_preload_time");
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    long l3 = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getPreloadIntervalDay() * 24 * 60 * 60 * 1000;
    if (QLog.isColorLevel()) {
      QLog.i("QQGamePub_QQGameConfigUtilImpl", 2, String.format("lastPreloadTs: %1$s currentTs: %2$s preloadIntervalTs: %3$s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) }));
    }
    return Math.abs(l2 - l1) >= l3;
  }
  
  public boolean isPreloadSwitch()
  {
    QQGamePreloadConfBean localQQGamePreloadConfBean = QQGamePreloadConfProcessor.a();
    if ((localQQGamePreloadConfBean != null) && (localQQGamePreloadConfBean.c > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_QQGameConfigUtilImpl", 2, "isPreloadSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQGameConfigUtilImpl", 2, "isPreloadSwitch = false");
    }
    return false;
  }
  
  public boolean isPubAccountSwitch()
  {
    QQGameConfBean localQQGameConfBean = QQGameConfProcessor.a();
    if ((localQQGameConfBean != null) && (localQQGameConfBean.jdField_a_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_QQGameConfigUtilImpl", 2, "isPubAccountSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQGameConfigUtilImpl", 2, "isPubAccountSwitch = false");
    }
    return false;
  }
  
  public boolean isPubFeedByWeb()
  {
    if (isDebugMode()) {
      return isDebugSwitchByGamePubType("1");
    }
    Object localObject = QQGameConfProcessor.a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((QQGameConfBean)localObject).c == 1)
      {
        localObject = ((QQGameConfBean)localObject).jdField_a_of_type_JavaLangString;
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bool1 = bool2;
          if (URLUtil.isValidUrl((String)localObject)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isUpdateHippyJsBundleByHttp()
  {
    QQGameConfBean localQQGameConfBean = QQGameConfProcessor.a();
    return (localQQGameConfBean != null) && (localQQGameConfBean.d == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameConfigUtilImpl
 * JD-Core Version:    0.7.0.1
 */