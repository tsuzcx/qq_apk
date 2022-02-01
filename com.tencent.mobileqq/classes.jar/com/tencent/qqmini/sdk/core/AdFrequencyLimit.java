package com.tencent.qqmini.sdk.core;

import com.tencent.qqmini.sdk.core.utils.WnsConfig;

public class AdFrequencyLimit
{
  public static int ERROR_CODE_2001 = 2001;
  public static int ERROR_CODE_2002 = 2002;
  public static int ERROR_CODE_2003 = 2003;
  private static int GAME_START_LIMIT = WnsConfig.getConfig("qqminiapp", "MiniAppGameStartLimit", 30) * 1000;
  private static int LAST_SHOW_LIMIT = WnsConfig.getConfig("qqminiapp", "MiniAppLastShowLimit", 60) * 1000;
  private static long sGameStartTime = -1L;
  private static long sInterstitialAdLastShowedTime = -1L;
  private static boolean sInterstitialAdShowing;
  private static long sRewardVideoAdLastShowedTime;
  private static boolean sRewardVideoAdShowing = false;
  
  static
  {
    sRewardVideoAdLastShowedTime = -1L;
    sInterstitialAdShowing = false;
  }
  
  public static int canShowInterstitialAdNow()
  {
    long l = System.currentTimeMillis();
    if (l - sGameStartTime < GAME_START_LIMIT) {
      return ERROR_CODE_2001;
    }
    if ((l - sRewardVideoAdLastShowedTime < LAST_SHOW_LIMIT) || (l - sInterstitialAdLastShowedTime < LAST_SHOW_LIMIT)) {
      return ERROR_CODE_2002;
    }
    if ((sRewardVideoAdShowing) || (sInterstitialAdShowing)) {
      return ERROR_CODE_2003;
    }
    return 0;
  }
  
  public static void setInterstitialAdShowing(boolean paramBoolean)
  {
    sInterstitialAdShowing = paramBoolean;
    if (paramBoolean) {
      sInterstitialAdLastShowedTime = System.currentTimeMillis();
    }
  }
  
  public static void setOnStartTime(long paramLong)
  {
    sGameStartTime = paramLong;
  }
  
  public static void setRewardVideoAdShowing(boolean paramBoolean)
  {
    sRewardVideoAdShowing = paramBoolean;
    if (paramBoolean) {
      sRewardVideoAdLastShowedTime = System.currentTimeMillis();
    }
  }
  
  public void reset()
  {
    sRewardVideoAdShowing = false;
    sRewardVideoAdLastShowedTime = -1L;
    sInterstitialAdShowing = false;
    sInterstitialAdLastShowedTime = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.AdFrequencyLimit
 * JD-Core Version:    0.7.0.1
 */