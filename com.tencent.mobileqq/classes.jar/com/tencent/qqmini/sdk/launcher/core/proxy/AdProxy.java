package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public abstract class AdProxy
{
  public static String KEY_ACCOUNT = "key_account";
  public static String KEY_ADCOUNT = "key_ad_count";
  public static String KEY_AD_TYPE = "key_ad_type";
  public static String KEY_APPID;
  public static String KEY_ENTRY_PATH;
  public static String KEY_GDT_COOKIE;
  public static String KEY_MODE = "key_mode";
  public static String KEY_ORIENTATION = "key_orientation";
  public static String KEY_POSID;
  public static String KEY_REFER;
  public static String KEY_REPORT_DATA;
  public static String KEY_SHARE_RATE;
  public static String KEY_VIA;
  
  static
  {
    KEY_GDT_COOKIE = "key_gdt_cookie";
    KEY_ENTRY_PATH = "key_entry_path";
    KEY_REPORT_DATA = "key_report_data";
    KEY_REFER = "key_refer";
    KEY_VIA = "key_via";
    KEY_APPID = "key_appid";
    KEY_SHARE_RATE = "key_share_rate";
    KEY_POSID = "key_pos_id";
  }
  
  public boolean adClick(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean adExposure(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public abstract AdProxy.AbsBannerAdView createBannerAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, AdProxy.IBannerAdListener paramIBannerAdListener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext, IGetAdPosInfo paramIGetAdPosInfo);
  
  public AdProxy.AbsBlockAdView createBlockAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, AdProxy.IBlockAdListener paramIBlockAdListener, Bundle paramBundle)
  {
    return null;
  }
  
  public AdProxy.AbsBoxAdView createBoxAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.IBoxADLisener paramIBoxADLisener, Bundle paramBundle)
  {
    return null;
  }
  
  public AdProxy.AbsInterstitialAdView createInterstitialAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.InterstitialADLisener paramInterstitialADLisener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext)
  {
    return null;
  }
  
  public abstract AdProxy.AbsRewardVideoAdView createRewardVideoAdView(Context paramContext, String paramString1, String paramString2, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext);
  
  public void destroy(Activity paramActivity) {}
  
  public void downloadRealTimeAdPic(String paramString1, String paramString2, String paramString3, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public void onFirstFrame() {}
  
  public void preloadLoadingAd(Context paramContext, Bundle paramBundle, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
  
  public void requestAdInfo(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4, AdProxy.ICmdListener paramICmdListener) {}
  
  public void selectLoadingAd(Context paramContext, Bundle paramBundle, String paramString, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
  
  public void updateLoadingAdLayoutAndShow(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
 * JD-Core Version:    0.7.0.1
 */