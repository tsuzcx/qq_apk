package com.tencent.mobileqq.minigame.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bhpc;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import org.json.JSONObject;

public class GameWnsUtils
{
  private static final String TAG = "GameWnsUtils";
  private static final boolean sLogEnable;
  
  static
  {
    boolean bool = true;
    if (QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameLogEnable", 1) == 1) {}
    for (;;)
    {
      sLogEnable = bool;
      return;
      bool = false;
    }
  }
  
  private static boolean buildModelEnable()
  {
    String str1 = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBlackList", "[GT-I9502]");
    try
    {
      String str2 = Build.MODEL;
      if (TextUtils.isEmpty(str2))
      {
        QZLog.e("GameWnsUtils", 2, new Object[] { "buildModelEnable model empty" });
        return false;
      }
      if (QZLog.isColorLevel()) {
        QZLog.d("GameWnsUtils", 2, "build model is " + str2);
      }
      if (!TextUtils.isEmpty(str1))
      {
        boolean bool = str1.contains("[" + str2 + "]");
        if (bool) {}
      }
      else
      {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public static String defaultPayShareImg()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDefaultPayShareImg", "https://sola.gtimg.cn/aoi/sola/20200615194538_YYA1zqPM8t.png");
  }
  
  public static String defaultPayShareTitle()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDefaultPayShareTitle", "亲爱的，拜托你帮我代付一笔订单～");
  }
  
  public static String defaultShareImg()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDefaultShareImg", "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png");
  }
  
  public static String downloaderPreConnectHost()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDownloaderPreConnectHost", "https://miniapp.gtimg.cn/miniapp.txt");
  }
  
  public static boolean enableDownloaderPreConnect()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDownloaderPreConnectEnable", 1) > 0;
  }
  
  public static boolean enableGameruntimePreload()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameRuntimePreload", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean enableGameruntimePreloadOnFirstFrame()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameRuntimePreloadOnFirstFrame", 1) > 0;
  }
  
  public static boolean enableHotReload()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniEnableHotReload", 1) > 0;
  }
  
  public static boolean enableHttp2()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameEnableHttp2", 1) > 0;
  }
  
  public static boolean enableInstructionsForMiniApp()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppEnableInstructions", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean enableOpengles3()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "enableOpengles3", 1) > 0;
  }
  
  public static boolean enablePersistentDebugVersion()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePersistentDebugVersionEnable", 1) > 0;
  }
  
  public static boolean enablePreloadGameBaseLib()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePreloadBaseLibEnable", 1) > 0;
  }
  
  public static boolean enableStorageExceedDialog()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameStorageExceedDialogEnable", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static int enableStorageExceedLimit()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameStorageExceedLimit", 3);
  }
  
  public static String gameDisableHint()
  {
    return QzoneConfig.getInstance().getConfig("QZoneTextSetting", "MiniGameDisableHint", "该小游戏正在升级中，先去玩玩其他小游戏吧");
  }
  
  public static boolean gameEnable()
  {
    return (suffixEnable()) && (buildModelEnable()) && (gameSysVersionAllowed());
  }
  
  public static boolean gameEnableDexLoader()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDexEnable", 1) == 1;
  }
  
  public static boolean gameEnableLog()
  {
    return sLogEnable;
  }
  
  private static boolean gameSysVersionAllowed()
  {
    int i = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameMinSysVersion", 18);
    return Build.VERSION.SDK_INT >= i;
  }
  
  public static String getBackPressHint()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBackPressHint", "再按一次返回键退出该程序");
  }
  
  public static int getBannerAdMinWidth()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBannerAdMinWidth", 300);
  }
  
  public static String getBattleGameShowAlertViewScenes()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappRetainAlterViewScene", "{\"2\": [\"2072\"],\"3\": [\"1037\"]}");
  }
  
  public static String getCacheFreeContent()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameCacheFreeDialogContent", "游戏存储异常,是否清缓存后重启游戏？");
  }
  
  public static int getDownloaderMode()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDownloaderMode", 2);
  }
  
  public static String getFakeFristFrameUrl()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameFakeFirstFrameUrl", "");
  }
  
  public static int getFrameNoChangeLimit()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameFrameNoChangeLimit", 5);
  }
  
  public static BaseLibInfo getGameBaseLibInfo()
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBaseLib", "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20190708174635_6988/lib-1.4.7.zip\",\"key2\":\"\",\"key3\":\"1.4.7\",\"key4\": {\"file_length\": 6336933},\"key5\":2}");
    QLog.i("minigame", 1, "MiniEng getWnsGameBaseLibInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("minigame", 1, "MiniEng getWnsGameBaseLibInfo failed", localException);
      }
    }
    return null;
  }
  
  public static String getGameEngineVersion(String paramString)
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameEngineVersion", paramString);
  }
  
  public static int getGameErrorBlackDetectInterval()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBlackDetectInterval", 3000);
  }
  
  public static String getGameErrorDialogContent()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameErrorDialogContent", "游戏异常停止, 是否需要重启游戏?");
  }
  
  public static boolean getGameErrorDialogEnable()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameErrorDialogEnable", 1) > 0;
  }
  
  public static boolean getGameErrorDialogIsBlack()
  {
    String str1 = Build.MANUFACTURER;
    if (TextUtils.isEmpty(str1)) {
      return true;
    }
    str1 = str1.toLowerCase();
    String str2 = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameErrorDialogBlack", "");
    if (TextUtils.isEmpty(str2)) {
      return false;
    }
    return str2.contains(str1);
  }
  
  public static int getGameJsErrorDetectInterval()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameJsErrorDetectInterval", 5000);
  }
  
  public static String getGameLaunchFailContent()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameLaunchFailDialogContent", "游戏加载异常，是否清缓存后重启游戏？");
  }
  
  public static long getGameOnShowReportInterval()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameOnShowReportInterval", 2000L);
  }
  
  public static int getGamePresentDetectInterval()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePresentDetectInterval", 1000);
  }
  
  public static String getGameRetainConfirmImageUrl()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_retain_confirm_animation_image_url", "https://sola.gtimg.cn/aoi/sola/20200610173326_9Y4cq17qBe.png");
  }
  
  public static int getMaxRangeNumber()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMaxRangeNumber", 4);
  }
  
  public static String getMiniGamePublicAccountGameStoreButtonUrl()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "publicAccountGameStoreButtonUrl", "https://sola.gtimg.cn/aoi/sola/20200713192038_XEvd27FTxi.png");
  }
  
  public static int getNoPresentDurationLimit()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameNoPresentDurationLimit", 5000);
  }
  
  public static int getNoPresentTouchLimit()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameNoPresentTouchLimit", 3);
  }
  
  public static String getPayForFriendUrl()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDefaultPayForFriendUrl", "https://h5.qzone.qq.com/miniapp/act/friendPay?appid={appid}&prepayId={prepayId}&_proxy=1");
  }
  
  public static String getPreConnectBlackAppIdList()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePreConnectBlackAppIdList", "1110244087");
  }
  
  public static int getPreConnectNum()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePreConnectNum", 5);
  }
  
  public static String getQQUpdateUrl()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
  }
  
  public static String getRangeModeNetworkLevel()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppRangeModeNetworkLevel", "1,2,3,6");
  }
  
  public static String getRangeModePerfLevel()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppRangeModePerfLevel", "1,2,3");
  }
  
  public static long getRangeSize()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppRangeSize", 524288L);
  }
  
  public static long getRecordDurationInterval()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniRecordDurationInterval", 5000L);
  }
  
  public static long getReportDelayCheckDB()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniReportDelayCheckDB", 1000L);
  }
  
  public static long getReportDelayWaiting()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniReportDelayWaiting", 2000L);
  }
  
  public static int getRetainConfirmInterval()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "retainConfirmInterval", 30);
  }
  
  public static int getRetainConfirmShowTimes()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "retainConfirmTimesLimit", 3);
  }
  
  public static long getShowTimeout()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniShowTimeout", 45000L);
  }
  
  public static String getTritonDownloadBackUpUrl()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameTritonBackupUrl", "https://d3g.qq.com/sngapp/app/update/20200608171442_7604/839triton_base_engine.zip|1.5.0.32.6c8a796|1591357374118");
  }
  
  public static String getWnsLogBlackList()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameAPILogBlackList");
  }
  
  public static String getWnsLogWhiteList()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameAPILogWhiteList");
  }
  
  public static boolean isCodeCacheEnable()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameCodeCacheEnable", 1) == 1;
  }
  
  public static boolean isDownloadOnRangeModeEnable()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppDownloadOnRangeMode", 1) == 1;
  }
  
  public static boolean isForceDownloadInMainProcess()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_force_download_in_mainprocess", 0) == 1;
  }
  
  public static boolean killAllGamesWhenDestroy()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillAllGamesWhenDestroy", 0) == 1;
  }
  
  public static boolean killAllGamesWhenReuse()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillAllGamesWhenReuse", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean needBackPressHint(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBackPressHintList", "1108292102");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = ((String)localObject).split(",");
        if (localObject != null)
        {
          int i = 0;
          while (i < localObject.length)
          {
            if (!TextUtils.isEmpty(localObject[i]))
            {
              boolean bool = localObject[i].equals(paramString);
              if (bool) {
                return true;
              }
            }
            i += 1;
          }
        }
        return false;
      }
      catch (Throwable paramString)
      {
        QZLog.e("GameWnsUtils", 2, new Object[] { "needBackPressHint exception", paramString });
      }
    }
  }
  
  public static int retryLoadSubpackageOnCompileCount()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameSubPackRetryOnCompileCount", 1);
  }
  
  private static boolean suffixEnable()
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameGaryRange", "0-100");
    int[] arrayOfInt = new int[2];
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("-");
        if ((localObject != null) && (localObject.length >= 2))
        {
          arrayOfInt[0] = Integer.parseInt(localObject[0]);
          arrayOfInt[1] = Integer.parseInt(localObject[1]);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        long l;
        localThrowable.printStackTrace();
      }
    }
    l = bhpc.a().a() % 100L;
    return (l >= arrayOfInt[0]) && (l < arrayOfInt[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.GameWnsUtils
 * JD-Core Version:    0.7.0.1
 */