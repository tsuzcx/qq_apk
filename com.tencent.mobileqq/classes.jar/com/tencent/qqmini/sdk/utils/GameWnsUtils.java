package com.tencent.qqmini.sdk.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bgpx;
import bgxl;
import com.tencent.qqmini.sdk.log.QMLog;

public class GameWnsUtils
{
  private static final int MINI_GAME_SHOW_RESTART_BTN = 1;
  private static final String TAG = "GameWnsUtils";
  private static final boolean sLogEnable = bgpx.a("qqtriton", "MiniGameLogEnable", true);
  
  private static boolean buildModelEnable()
  {
    String str1 = bgpx.a("QZoneSetting", "MiniGameBlackList", "[GT-I9502]");
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
  
  public static boolean enableHotReload()
  {
    return bgpx.a("qqtriton", "MiniEnableHotReload", 1) > 0;
  }
  
  public static boolean enableOpengles3()
  {
    return bgpx.a("qqtriton", "enableOpengles3", 1) > 0;
  }
  
  public static boolean enablePersistentDebugVersion()
  {
    return bgpx.a("qqtriton", "MiniGamePersistentDebugVersionEnable", 1) > 0;
  }
  
  public static boolean enablePreloadGameBaseLib()
  {
    return bgpx.a("qqtriton", "MiniGamePreloadBaseLibEnable", 1) > 0;
  }
  
  public static boolean enableStorageExceedDialog()
  {
    return bgpx.a("qqtriton", "MiniGameStorageExceedDialogEnable", 1) > 0;
  }
  
  public static int enableStorageExceedLimit()
  {
    return bgpx.a("qqtriton", "MiniGameStorageExceedLimit", 3);
  }
  
  public static String gameDisableHint()
  {
    return bgpx.a("QZoneTextSetting", "MiniGameDisableHint", "该小游戏正在升级中，先去玩玩其他小游戏吧");
  }
  
  public static boolean gameEnable()
  {
    return (suffixEnable()) && (buildModelEnable()) && (gameSysVersionAllowed());
  }
  
  public static boolean gameEnableDexLoader()
  {
    return bgpx.a("qqtriton", "MiniGameDexEnable", true);
  }
  
  public static boolean gameEnableLog()
  {
    return sLogEnable;
  }
  
  private static boolean gameSysVersionAllowed()
  {
    int i = bgpx.a("QZoneSetting", "MiniGameMinSysVersion", 18);
    return Build.VERSION.SDK_INT >= i;
  }
  
  public static String getBackPressHint()
  {
    return bgpx.a("qqtriton", "MiniGameBackPressHint", "再按一次返回键退出该程序");
  }
  
  public static String getCacheFreeContent()
  {
    return bgpx.a("qqtriton", "MiniGameCacheFreeDialogContent", "游戏存储异常,是否清缓存后重启游戏？");
  }
  
  public static int getCloseConfirmShowTimes()
  {
    return bgpx.a("qqminiapp", "mini_game_exit_confirm_animation_expoure_times_threshold", 3);
  }
  
  public static String getFakeFristFrameUrl()
  {
    return bgpx.a("qqtriton", "MiniGameFakeFirstFrameUrl", "");
  }
  
  public static int getFrameNoChangeLimit()
  {
    return bgpx.a("qqtriton", "MiniGameFrameNoChangeLimit", 5);
  }
  
  public static int getGameErrorBlackDetectInterval()
  {
    return bgpx.a("qqtriton", "MiniGameBlackDetectInterval", 3000);
  }
  
  public static String getGameErrorDialogContent()
  {
    return bgpx.a("qqtriton", "MiniGameErrorDialogContent", "游戏异常停止, 是否需要重启游戏?");
  }
  
  public static boolean getGameErrorDialogEnable()
  {
    return bgpx.a("qqtriton", "MiniGameErrorDialogEnable", 1) > 0;
  }
  
  public static boolean getGameErrorDialogIsBlack()
  {
    String str1 = Build.MANUFACTURER;
    if (TextUtils.isEmpty(str1)) {
      return true;
    }
    str1 = str1.toLowerCase();
    String str2 = bgpx.a("qqtriton", "MiniGameErrorDialogBlack", "");
    if (TextUtils.isEmpty(str2)) {
      return false;
    }
    return str2.contains(str1);
  }
  
  public static int getGameJsErrorDetectInterval()
  {
    return bgpx.a("qqtriton", "MiniGameJsErrorDetectInterval", 5000);
  }
  
  public static String getGameLaunchFailContent()
  {
    return bgpx.a("qqtriton", "MiniGameLaunchFailDialogContent", "游戏加载异常，是否清缓存后重启游戏？");
  }
  
  public static long getGameOnShowReportInterval()
  {
    return bgpx.a("qqtriton", "MiniGameOnShowReportInterval", 2000L);
  }
  
  public static int getGamePresentDetectInterval()
  {
    return bgpx.a("qqtriton", "MiniGamePresentDetectInterval", 1000);
  }
  
  public static int getNoPresentDurationLimit()
  {
    return bgpx.a("qqtriton", "MiniGameNoPresentDurationLimit", 5000);
  }
  
  public static int getNoPresentTouchLimit()
  {
    return bgpx.a("qqtriton", "MiniGameNoPresentTouchLimit", 3);
  }
  
  public static String getQQUpdateUrl()
  {
    return bgpx.a("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
  }
  
  public static long getRecordDurationInterval()
  {
    return bgpx.a("qqtriton", "MiniRecordDurationInterval", 5000L);
  }
  
  public static long getReportDelayCheckDB()
  {
    return bgpx.a("qqtriton", "MiniReportDelayCheckDB", 1000L);
  }
  
  public static long getReportDelayWaiting()
  {
    return bgpx.a("qqtriton", "MiniReportDelayWaiting", 2000L);
  }
  
  public static long getShowTimeout()
  {
    return bgpx.a("qqtriton", "MiniShowTimeout", 45000L);
  }
  
  public static boolean killAllGamesWhenDestroy()
  {
    return bgpx.a("qqtriton", "MiniGameKillAllGamesWhenDestroy", 0) == 1;
  }
  
  public static boolean killAllGamesWhenReuse()
  {
    boolean bool = false;
    if (bgpx.a("qqtriton", "MiniGameKillAllGamesWhenReuse", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean needBackPressHint(String paramString)
  {
    boolean bool2 = false;
    Object localObject = bgpx.a("qqtriton", "MiniGameBackPressHintList", "1108292102");
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
  
  public static boolean showRestartButton()
  {
    return bgpx.a("qqminiapp", "mini_game_capsule_show_restart_btn", 1) == 1;
  }
  
  private static boolean suffixEnable()
  {
    Object localObject = bgpx.a("QZoneSetting", "MiniGameGaryRange", "0-100");
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
      long l2 = Long.parseLong(bgxl.a().a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.GameWnsUtils
 * JD-Core Version:    0.7.0.1
 */