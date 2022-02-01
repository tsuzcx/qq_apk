package com.tencent.qqmini.sdk.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;

public class GameWnsUtils
{
  private static final int MINI_GAME_SHOW_RESTART_BTN = 1;
  private static final String TAG = "GameWnsUtils";
  private static final boolean sLogEnable = WnsConfig.getConfig("qqtriton", "MiniGameLogEnable", true);
  
  private static boolean buildModelEnable()
  {
    String str1 = WnsConfig.getConfig("QZoneSetting", "MiniGameBlackList", "[GT-I9502]");
    try
    {
      String str2 = Build.MODEL;
      if (TextUtils.isEmpty(str2))
      {
        QMLog.e("GameWnsUtils", "buildModelEnable model empty");
        return false;
      }
      QMLog.d("GameWnsUtils", "build model is " + str2);
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
    return WnsConfig.getConfig("qqtriton", "MiniGameDefaultPayShareImg", "https://sola.gtimg.cn/aoi/sola/20200615194538_YYA1zqPM8t.png");
  }
  
  public static String defaultPayShareTitle()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameDefaultPayShareTitle", "亲爱的，拜托你帮我代付一笔订单～");
  }
  
  public static boolean enableDownloaderInSDK()
  {
    return WnsConfig.getConfig("qqtriton", "minigamesdkenabledownloader", 1) > 0;
  }
  
  public static boolean enableHotReload()
  {
    return WnsConfig.getConfig("qqtriton", "MiniEnableHotReload", 1) > 0;
  }
  
  public static boolean enableInstructionsForMiniApp()
  {
    boolean bool = false;
    if (WnsConfig.getConfig("qqminiapp", "MiniAppEnableInstructions", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean enableOpengles3()
  {
    return WnsConfig.getConfig("qqtriton", "enableOpengles3", 1) > 0;
  }
  
  public static boolean enablePersistentDebugVersion()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGamePersistentDebugVersionEnable", 1) > 0;
  }
  
  public static boolean enablePreloadGameBaseLib()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGamePreloadBaseLibEnable", 1) > 0;
  }
  
  public static boolean enableStorageExceedDialog()
  {
    boolean bool = false;
    if (WnsConfig.getConfig("qqtriton", "MiniGameStorageExceedDialogEnable", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static int enableStorageExceedLimit()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameStorageExceedLimit", 3);
  }
  
  public static String gameDisableHint()
  {
    return WnsConfig.getConfig("QZoneTextSetting", "MiniGameDisableHint", "该小游戏正在升级中，先去玩玩其他小游戏吧");
  }
  
  public static boolean gameEnable()
  {
    return (suffixEnable()) && (buildModelEnable()) && (gameSysVersionAllowed());
  }
  
  public static boolean gameEnableDexLoader()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameDexEnable", true);
  }
  
  public static boolean gameEnableLog()
  {
    return sLogEnable;
  }
  
  private static boolean gameSysVersionAllowed()
  {
    int i = WnsConfig.getConfig("QZoneSetting", "MiniGameMinSysVersion", 18);
    return Build.VERSION.SDK_INT >= i;
  }
  
  public static String getBackPressHint()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameBackPressHint", "再按一次返回键退出该程序");
  }
  
  public static String getCacheFreeContent()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameCacheFreeDialogContent", "游戏存储异常,是否清缓存后重启游戏？");
  }
  
  public static int getCloseConfirmShowTimes()
  {
    return WnsConfig.getConfig("qqminiapp", "mini_game_exit_confirm_animation_expoure_times_threshold", 3);
  }
  
  public static String getFakeFristFrameUrl()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameFakeFirstFrameUrl", "");
  }
  
  public static int getFrameNoChangeLimit()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameFrameNoChangeLimit", 5);
  }
  
  public static int getGameErrorBlackDetectInterval()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameBlackDetectInterval", 3000);
  }
  
  public static String getGameErrorDialogContent()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameErrorDialogContent", "游戏异常停止, 是否需要重启游戏?");
  }
  
  public static boolean getGameErrorDialogEnable()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameErrorDialogEnable", 1) > 0;
  }
  
  public static boolean getGameErrorDialogIsBlack()
  {
    String str1 = Build.MANUFACTURER;
    if (TextUtils.isEmpty(str1)) {
      return true;
    }
    str1 = str1.toLowerCase();
    String str2 = WnsConfig.getConfig("qqtriton", "MiniGameErrorDialogBlack", "");
    if (TextUtils.isEmpty(str2)) {
      return false;
    }
    return str2.contains(str1);
  }
  
  public static int getGameJsErrorDetectInterval()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameJsErrorDetectInterval", 5000);
  }
  
  public static String getGameLaunchFailContent()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameLaunchFailDialogContent", "游戏加载异常，是否清缓存后重启游戏？");
  }
  
  public static long getGameOnShowReportInterval()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameOnShowReportInterval", 2000L);
  }
  
  public static int getGamePresentDetectInterval()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGamePresentDetectInterval", 1000);
  }
  
  public static int getNoPresentDurationLimit()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameNoPresentDurationLimit", 5000);
  }
  
  public static int getNoPresentTouchLimit()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameNoPresentTouchLimit", 3);
  }
  
  public static String getQQUpdateUrl()
  {
    return WnsConfig.getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
  }
  
  public static long getRecordDurationInterval()
  {
    return WnsConfig.getConfig("qqtriton", "MiniRecordDurationInterval", 5000L);
  }
  
  public static long getReportDelayCheckDB()
  {
    return WnsConfig.getConfig("qqtriton", "MiniReportDelayCheckDB", 1000L);
  }
  
  public static long getReportDelayWaiting()
  {
    return WnsConfig.getConfig("qqtriton", "MiniReportDelayWaiting", 2000L);
  }
  
  public static long getShowTimeout()
  {
    return WnsConfig.getConfig("qqtriton", "MiniShowTimeout", 45000L);
  }
  
  public static boolean killAllGamesWhenDestroy()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameKillAllGamesWhenDestroy", 0) == 1;
  }
  
  public static boolean killAllGamesWhenReuse()
  {
    boolean bool = false;
    if (WnsConfig.getConfig("qqtriton", "MiniGameKillAllGamesWhenReuse", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean needBackPressHint(String paramString)
  {
    boolean bool2 = false;
    Object localObject = WnsConfig.getConfig("qqtriton", "MiniGameBackPressHintList", "1108292102");
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = ((String)localObject).split(",");
      bool1 = bool2;
      int i;
      if (localObject != null) {
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < localObject.length)
        {
          if (!TextUtils.isEmpty(localObject[i]))
          {
            bool1 = localObject[i].equals(paramString);
            if (bool1) {
              bool1 = true;
            }
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      QMLog.e("GameWnsUtils", "needBackPressHint exception", paramString);
    }
  }
  
  public static int retryLoadSubpackageOnCompileCount()
  {
    return WnsConfig.getConfig("qqtriton", "MiniGameSubPackRetryOnCompileCount", 1);
  }
  
  public static boolean showRestartButton()
  {
    return WnsConfig.getConfig("qqminiapp", "mini_game_capsule_show_restart_btn", 1) == 1;
  }
  
  private static boolean suffixEnable()
  {
    Object localObject = WnsConfig.getConfig("QZoneSetting", "MiniGameGaryRange", "0-100");
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
        long l1;
        localThrowable.printStackTrace();
      }
    }
    l1 = 0L;
    try
    {
      long l2 = Long.parseLong(LoginManager.getInstance().getAccount());
      l1 = l2;
    }
    catch (Exception localException)
    {
      label84:
      break label84;
    }
    l1 %= 100L;
    return (l1 >= arrayOfInt[0]) && (l1 < arrayOfInt[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.GameWnsUtils
 * JD-Core Version:    0.7.0.1
 */