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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSharedPreferences, name = ");
      localStringBuilder.append((String)localObject);
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", localStringBuilder.toString());
      paramContext = paramContext.getSharedPreferences((String)localObject, 0);
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
    int i = isInBlackListForSelfPlayer;
    if (i != -1) {
      return i != 0;
    }
    isInBlackListForSelfPlayer = 0;
    return false;
  }
  
  public static boolean isBlackListForSelfPlayerByCrash(Context paramContext)
  {
    int i = isInBlackListForSelfPlayer;
    if (i != -1) {
      return i != 0;
    }
    isInBlackListForSelfPlayer = 0;
    paramContext = getSharedPreferences(paramContext);
    if (paramContext == null)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isBlackListForSelfPlayerByCrash] Failed to get SharedPreferences");
      return false;
    }
    try
    {
      boolean bool = paramContext.getBoolean("qqlive_selfplayer_crash_state", false);
      i = paramContext.getInt("qqlive_selfplayer_crash_state", 0);
      if (bool)
      {
        i += 1;
        if (i > ((Integer)TVKMediaPlayerConfig.PlayerConfig.self_player_crash_count_to_switch.getValue()).intValue())
        {
          isInBlackListForSelfPlayer = 1;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isBlackListForSelfPlayerByCrash, crashCountInt: ");
          localStringBuilder.append(i);
          TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", localStringBuilder.toString());
          i = 0;
        }
        else
        {
          isInBlackListForSelfPlayer = 0;
        }
        paramContext.edit().putInt("qqlive_selfplayer_crash_count", i).apply();
      }
      else
      {
        isInBlackListForSelfPlayer = 0;
        paramContext.edit().putInt("qqlive_selfplayer_crash_count", 0).apply();
      }
      paramContext.edit().putBoolean("qqlive_selfplayer_crash_state", false).apply();
    }
    catch (Exception paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKPlayerStrategy.java]", paramContext);
    }
    return isInBlackListForSelfPlayer != 0;
  }
  
  public static boolean isEnabledHWDec(Context paramContext)
  {
    paramContext = getSharedPreferences(paramContext);
    if (paramContext == null)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec] Failed to get SharedPreferences");
      return true;
    }
    label533:
    for (;;)
    {
      int k;
      try
      {
        if (!paramContext.getBoolean("hardware_accelerate_state", true))
        {
          TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec] HA user setting: false");
          return false;
        }
        boolean bool2 = paramContext.getBoolean("hardware_accelerate_crash", false);
        j = paramContext.getInt("ha_turn_off_count", 0);
        i = paramContext.getInt("ha_crash_count", 0);
        if (bool2)
        {
          j = ((Integer)TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_interval.getValue()).intValue();
          k = i + 1;
          if (k <= ((Integer)TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_count.getValue()).intValue()) {
            break label509;
          }
          if (Build.VERSION.SDK_INT >= 9)
          {
            paramContext.edit().putBoolean("hardware_accelerate_state", false).apply();
            break label499;
          }
          paramContext.edit().putBoolean("hardware_accelerate_state", false).commit();
          break label499;
          if (Build.VERSION.SDK_INT >= 9)
          {
            paramContext.edit().putBoolean("hardware_accelerate_crash", false).apply();
            k = i;
            i = j;
          }
          else
          {
            paramContext.edit().putBoolean("hardware_accelerate_crash", false).commit();
            k = i;
            i = j;
          }
        }
        else
        {
          j -= 1;
          if (j >= -((Integer)TVKMediaPlayerConfig.PlayerConfig.ha_crash_reset_interval.getValue()).intValue()) {
            break label533;
          }
          j = 0;
          i = 0;
          break label533;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isEnabledHWDec]isCrash:");
        localStringBuilder.append(bool2);
        localStringBuilder.append(", crashCount:");
        localStringBuilder.append(i);
        localStringBuilder.append(", turnOffCount:");
        localStringBuilder.append(k);
        localStringBuilder.append(", HA enabled:");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", ha_crash_retry_interval:");
        localStringBuilder.append(TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_interval.getValue());
        localStringBuilder.append(", ha_crash_retry_count:");
        localStringBuilder.append(TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_count.getValue());
        localStringBuilder.append(", ha_crash_reset_interval:");
        localStringBuilder.append(TVKMediaPlayerConfig.PlayerConfig.ha_crash_reset_interval.getValue());
        TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", localStringBuilder.toString());
        if (Build.VERSION.SDK_INT >= 9)
        {
          paramContext.edit().putInt("ha_crash_count", i).apply();
          paramContext.edit().putInt("ha_turn_off_count", k).apply();
          return bool1;
        }
        paramContext.edit().putInt("ha_crash_count", i).commit();
        paramContext.edit().putInt("ha_turn_off_count", k).commit();
        return bool1;
      }
      catch (Exception paramContext)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKPlayerStrategy.java]", paramContext);
        TVKLogUtil.i("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec] failed to get user setting: true by default");
        return true;
      }
      label499:
      boolean bool1 = false;
      int i = 0;
      int j = 0;
      continue;
      label509:
      if (j <= 0)
      {
        bool1 = true;
        i = j;
        j = k;
      }
      else
      {
        bool1 = false;
        i = j;
        j = k;
        continue;
        if (j <= 0)
        {
          bool1 = true;
          k = j;
        }
        else
        {
          bool1 = false;
          k = j;
        }
      }
    }
  }
  
  public static boolean isSelfPlayerAvailable(Context paramContext)
  {
    if (isBlackListForSelfPlayer(paramContext)) {
      return false;
    }
    return !isBlackListForSelfPlayerByCrash(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKPlayerStrategy
 * JD-Core Version:    0.7.0.1
 */