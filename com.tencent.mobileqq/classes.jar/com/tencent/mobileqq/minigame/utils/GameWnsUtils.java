package com.tencent.mobileqq.minigame.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bcxm;
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
  
  public static String defaultShareImg()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDefaultShareImg", "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png");
  }
  
  public static boolean enableHotReload()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniEnableHotReload", 1) > 0;
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
  
  public static int getCloseConfirmShowTimes()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_exit_confirm_animation_expoure_times_threshold", 3);
  }
  
  public static String getExitConfirmAnimationBlackList()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_exit_confirm_animation_scene_black_list", "");
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
  
  public static String getGameExitConfirmImageUrl()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_exit_confirm_animation_image_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191114160727_AqDlaIYOnx.gif");
  }
  
  public static int getGameJsErrorDetectInterval()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameJsErrorDetectInterval", 5000);
  }
  
  public static long getGameOnShowReportInterval()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameOnShowReportInterval", 2000L);
  }
  
  public static int getGamePresentDetectInterval()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePresentDetectInterval", 1000);
  }
  
  public static int getNoPresentDurationLimit()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameNoPresentDurationLimit", 5000);
  }
  
  public static int getNoPresentTouchLimit()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameNoPresentTouchLimit", 3);
  }
  
  public static String getQQUpdateUrl()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
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
  
  public static long getShowTimeout()
  {
    return QzoneConfig.getInstance().getConfig("qqtriton", "MiniShowTimeout", 45000L);
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
    l = bcxm.a().a() % 100L;
    return (l >= arrayOfInt[0]) && (l < arrayOfInt[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.GameWnsUtils
 * JD-Core Version:    0.7.0.1
 */