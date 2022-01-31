package com.tencent.qqmini.sdk.core.proxy;

import android.app.Activity;
import android.os.Bundle;

public abstract class AdProxy
{
  public static String KEY_ACCOUNT = "key_account";
  public static String KEY_AD_TYPE = "key_ad_type";
  public static String KEY_ENTRY_PATH;
  public static String KEY_GDT_COOKIE;
  public static String KEY_ORIENTATION = "key_orientation";
  public static String KEY_REFER = "key_refer";
  public static String KEY_REPORT_DATA;
  public static String KEY_VIA = "key_via";
  
  static
  {
    KEY_GDT_COOKIE = "key_gdt_cookie";
    KEY_ENTRY_PATH = "key_entry_path";
    KEY_REPORT_DATA = "key_report_data";
  }
  
  public boolean adClick(Activity paramActivity, String paramString)
  {
    return false;
  }
  
  public abstract AdProxy.AbsBannerAdView createBannerAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, AdProxy.IBannerAdListener paramIBannerAdListener, Bundle paramBundle);
  
  public AdProxy.AbsBoxAdView createBoxAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.IBoxADLisener paramIBoxADLisener, Bundle paramBundle)
  {
    return null;
  }
  
  public AdProxy.AbsInterstitialAdView createInterstitialAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.InterstitialADLisener paramInterstitialADLisener, Bundle paramBundle)
  {
    return null;
  }
  
  public abstract AdProxy.AbsRewardVideoAdView createRewardVideoAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener, Bundle paramBundle);
  
  public void destroy(Activity paramActivity) {}
  
  public void requestAdInfo(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.ICmdListener paramICmdListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.AdProxy
 * JD-Core Version:    0.7.0.1
 */