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
  public static final int BannerAdType = 0;
  public static final int MiniAppAdBoxAdType = 7;
  public static final int MiniAppAdInFeedsAdType = 6;
  public static final int MiniAppBannerAdType = 2;
  public static final int MiniAppCardAdType = 5;
  public static final int MiniAppFlipPageAdType = 4;
  public static final int MiniAppSplashScreenAdType = 14;
  public static final int MiniAppVideoAdType = 3;
  public static final int MiniGameAdBoxAdType = 8;
  public static final int MiniGameBuildingBlockAdType = 13;
  public static final int MiniGameNewBannerAdType = 9;
  public static final int MiniGameSplashScreenAdType = 15;
  public static final int VideoAdType = 1;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.AdUtil
 * JD-Core Version:    0.7.0.1
 */