package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import org.json.JSONObject;

public class WnsUtil
{
  private static final String TAG = "WnsUtil";
  private static volatile int maxTopNum = -1;
  private static volatile MiniAppProxy sMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  private static volatile int showFullScreen = -1;
  
  public static String defaultShareImg()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameDefaultShareImg", "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png");
  }
  
  public static int getBannerAdMinWidth()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameBannerAdMinWidth", 300);
  }
  
  public static BaseLibInfo getGameBaseLibInfo()
  {
    Object localObject = WnsConfig.getConfig("qqtriton", "MiniGameBaseLib", "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20200323171054_1567/lib_1.13.0.00014.zip\",\"key2\":\"\",\"key3\":\"1.4.8\",\"key4\": {\"file_length\": 5591276},\"key5\":2}");
    QMLog.i("minigame", "MiniEng getWnsGameBaseLibInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        QMLog.e("minigame", "MiniEng getWnsGameBaseLibInfo failed", localException);
      }
    }
    return null;
  }
  
  public static String getGameEngineVersion(String paramString)
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameEngineVersion", paramString);
  }
  
  public static int getMaxTopNum()
  {
    if (maxTopNum == -1)
    {
      maxTopNum = WnsConfig.getConfig("qqminiapp", "miniappfullscreenminedatamaxnum", 50);
      QMLog.d("WnsUtil", "[MiniAppUserAppInfoListManager].maxtopnum = " + maxTopNum);
    }
    return maxTopNum;
  }
  
  public static boolean needShowMiniAppFullScreen()
  {
    if (showFullScreen == -1) {}
    try
    {
      String str = LoginManager.getInstance().getAccount();
      showFullScreen = AppLoaderFactory.g().getContext().getSharedPreferences(sMiniAppProxy.getAppName(), 4).getInt(str + "_" + "miniappshowfullscreen", 1);
      QMLog.d("WnsUtil", "[DesktopDataManager].needShowMiniAppFullScreen, showFullScreen = " + showFullScreen);
      if (showFullScreen == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        showFullScreen = 1;
        QMLog.d("WnsUtil", "[DesktopDataManager]. needShowMiniAppFullScreen Exception");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.WnsUtil
 * JD-Core Version:    0.7.0.1
 */