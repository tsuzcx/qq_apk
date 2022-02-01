package com.tencent.qqmini.sdk.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ExpParam;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.util.List;

@MiniKeep
public class AdUtil
{
  public static final String AD_GDT_COOKIE_PRE = "gdt_cookie";
  public static final int BANNER_AD_TYPE = 0;
  public static final int MINI_APP_AD_BOX_AD_TYPE = 7;
  public static final int MINI_APP_AD_IN_FEEDS_AD_TYPE = 6;
  public static final int MINI_APP_BANNER_AD_TYPE = 2;
  public static final int MINI_APP_CARD_AD_TYPE = 5;
  public static final int MINI_APP_FLIP_PAGE_AD_TYPE = 4;
  public static final int MINI_APP_SPLASH_SCREEN_AD_TYPE = 14;
  public static final int MINI_APP_VIDEO_AD_TYPE = 3;
  public static final int MINI_GAME_AD_BOX_AD_TYPE = 8;
  public static final int MINI_GAME_BUILDING_BLOCK_AD_TYPE = 13;
  public static final int MINI_GAME_NEW_BANNER_AD_TYPE = 9;
  public static final int MINI_GAME_SPLASH_SCREEN_AD_TYPE = 15;
  public static final int REWARDED_AD_LOAD_INTERNAL_EXP_KEY = 106492;
  public static final String TAG = "AdUtil";
  public static final int VIDEO_AD_TYPE = 1;
  
  private static String getGdtCookieSpKey(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gdt_cookie_");
    localStringBuilder.append(LoginManager.getInstance().getAccount());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static long getLoadIntervalFromExpParam(List<AdProxy.ExpParam> paramList)
  {
    long l1 = 9223372036854775807L;
    long l2 = l1;
    if (paramList != null)
    {
      int i = 0;
      for (;;)
      {
        l2 = l1;
        try
        {
          if (i < paramList.size())
          {
            l2 = l1;
            if (((AdProxy.ExpParam)paramList.get(i)).key == 106492) {
              l2 = Long.parseLong(((AdProxy.ExpParam)paramList.get(i)).value);
            }
            i += 1;
            l1 = l2;
          }
        }
        catch (Throwable paramList)
        {
          QMLog.e("AdUtil", "getLoadIntervalFromExpParam fail:", paramList);
          l2 = l1;
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append("getLoadIntervalFromExpParam loadInterval:");
    paramList.append(l2);
    QMLog.i("RealTimeRewardedVideoAdPlugin", paramList.toString());
    return l2;
  }
  
  public static String getSpAdGdtCookie(int paramInt)
  {
    String str = getGdtCookieSpKey(paramInt);
    return StorageUtil.getPreference().getString(str, "");
  }
  
  public static void putSpAdGdtCookie(int paramInt, String paramString)
  {
    String str = getGdtCookieSpKey(paramInt);
    StorageUtil.getPreference().edit().putString(str, paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.AdUtil
 * JD-Core Version:    0.7.0.1
 */