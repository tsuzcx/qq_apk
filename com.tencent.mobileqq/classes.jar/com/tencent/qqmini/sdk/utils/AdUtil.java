package com.tencent.qqmini.sdk.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;

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
  public static final int VIDEO_AD_TYPE = 1;
  
  private static String getGdtCookieSpKey(int paramInt)
  {
    return "gdt_cookie_" + LoginManager.getInstance().getAccount() + "_" + paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.AdUtil
 * JD-Core Version:    0.7.0.1
 */