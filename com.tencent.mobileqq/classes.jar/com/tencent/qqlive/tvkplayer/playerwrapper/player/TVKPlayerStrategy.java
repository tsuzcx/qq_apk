package com.tencent.qqlive.tvkplayer.playerwrapper.player;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

public class TVKPlayerStrategy
{
  public static final String HARDWARE_ACCELERATE_CRASH = "hardware_accelerate_crash";
  public static final String HARDWARE_ACCELERATE_STATE = "hardware_accelerate_state";
  public static final String HA_CRASH_COUNT = "ha_crash_count";
  public static final String HA_TURN_OFF_COUNT = "ha_turn_off_count";
  public static final String SELFPLAYER_CRASH_COUNT = "qqlive_selfplayer_crash_count";
  public static final String SELFPLAYER_CRASH_STATE = "qqlive_selfplayer_crash_state";
  public static final String TAG = "MediaPlayerMgr[TVKPlayerStrategy.java]";
  private static int isInBlackListForSelfPlayer = -1;
  
  public static SharedPreferences getSharedPreferences(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName() + "_preferences";
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "getSharedPreferences, name = " + str);
      paramContext = paramContext.getSharedPreferences(str, 0);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKPlayerStrategy.java]", paramContext);
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[getSharedPreferences] Failed to get SharedPreferences");
    }
    return null;
  }
  
  public static boolean isBlackListForSelfPlayer(Context paramContext)
  {
    if (isInBlackListForSelfPlayer != -1) {
      return isInBlackListForSelfPlayer != 0;
    }
    isInBlackListForSelfPlayer = 0;
    return false;
  }
  
  public static boolean isBlackListForSelfPlayerByCrash(Context paramContext)
  {
    bool1 = true;
    if (isInBlackListForSelfPlayer != -1) {
      return isInBlackListForSelfPlayer != 0;
    }
    isInBlackListForSelfPlayer = 0;
    paramContext = getSharedPreferences(paramContext);
    if (paramContext == null)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isBlackListForSelfPlayerByCrash] Failed to get SharedPreferences");
      return false;
    }
    for (;;)
    {
      try
      {
        boolean bool2 = paramContext.getBoolean("qqlive_selfplayer_crash_state", false);
        int i = paramContext.getInt("qqlive_selfplayer_crash_state", 0);
        if (!bool2) {
          continue;
        }
        i += 1;
        if (i <= ((Integer)TVKMediaPlayerConfig.PlayerConfig.self_player_crash_count_to_switch.getValue()).intValue()) {
          continue;
        }
        isInBlackListForSelfPlayer = 1;
        TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "isBlackListForSelfPlayerByCrash, crashCountInt: " + i);
        i = 0;
        paramContext.edit().putInt("qqlive_selfplayer_crash_count", i).apply();
        paramContext.edit().putBoolean("qqlive_selfplayer_crash_state", false).apply();
      }
      catch (Exception paramContext)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKPlayerStrategy.java]", paramContext);
        continue;
        bool1 = false;
        continue;
      }
      if (isInBlackListForSelfPlayer == 0) {
        continue;
      }
      return bool1;
      isInBlackListForSelfPlayer = 0;
      continue;
      isInBlackListForSelfPlayer = 0;
      paramContext.edit().putInt("qqlive_selfplayer_crash_count", 0).apply();
    }
  }
  
  public static boolean isEnabledHWDec(Context paramContext)
  {
    boolean bool1 = false;
    int j = 0;
    paramContext = getSharedPreferences(paramContext);
    if (paramContext == null)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec] Failed to get SharedPreferences");
      return true;
    }
    for (;;)
    {
      int k;
      int i;
      try
      {
        if (!paramContext.getBoolean("hardware_accelerate_state", true))
        {
          TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec] HA user setting: false");
          return false;
        }
        boolean bool2 = paramContext.getBoolean("hardware_accelerate_crash", false);
        k = paramContext.getInt("ha_turn_off_count", 0);
        i = paramContext.getInt("ha_crash_count", 0);
        if (bool2)
        {
          k = ((Integer)TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_interval.getValue()).intValue();
          i += 1;
          if (i <= ((Integer)TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_count.getValue()).intValue()) {
            break label469;
          }
          if (Build.VERSION.SDK_INT >= 9)
          {
            paramContext.edit().putBoolean("hardware_accelerate_state", false).apply();
            i = 0;
            bool1 = false;
            if (Build.VERSION.SDK_INT >= 9)
            {
              paramContext.edit().putBoolean("hardware_accelerate_crash", false).apply();
              m = i;
              TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec]isCrash:" + bool2 + ", crashCount:" + m + ", turnOffCount:" + j + ", HA enabled:" + bool1 + ", ha_crash_retry_interval:" + TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_interval.getValue() + ", ha_crash_retry_count:" + TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_count.getValue() + ", ha_crash_reset_interval:" + TVKMediaPlayerConfig.PlayerConfig.ha_crash_reset_interval.getValue());
              if (Build.VERSION.SDK_INT < 9) {
                continue;
              }
              paramContext.edit().putInt("ha_crash_count", m).apply();
              paramContext.edit().putInt("ha_turn_off_count", j).apply();
              break label466;
            }
          }
          else
          {
            paramContext.edit().putBoolean("hardware_accelerate_state", false).commit();
            i = 0;
            bool1 = false;
            continue;
          }
          paramContext.edit().putBoolean("hardware_accelerate_crash", false).commit();
          m = i;
          continue;
        }
        else
        {
          k -= 1;
          if (k >= -((Integer)TVKMediaPlayerConfig.PlayerConfig.ha_crash_reset_interval.getValue()).intValue()) {
            break label463;
          }
          i = 0;
          k = 0;
          break label487;
        }
        paramContext.edit().putInt("ha_crash_count", m).commit();
        paramContext.edit().putInt("ha_turn_off_count", j).commit();
      }
      catch (Exception paramContext)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKPlayerStrategy.java]", paramContext);
        TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec] failed to get user setting: true by default");
        return true;
      }
      label463:
      break label487;
      label466:
      return bool1;
      label469:
      if (k <= 0) {}
      for (bool1 = true;; bool1 = false)
      {
        j = k;
        break;
      }
      label487:
      int m = i;
      j = k;
      if (k <= 0)
      {
        bool1 = true;
        m = i;
        j = k;
      }
    }
  }
  
  public static boolean isSelfPlayerAvailable(Context paramContext)
  {
    if (isBlackListForSelfPlayer(paramContext)) {}
    while (isBlackListForSelfPlayerByCrash(paramContext)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKPlayerStrategy
 * JD-Core Version:    0.7.0.1
 */