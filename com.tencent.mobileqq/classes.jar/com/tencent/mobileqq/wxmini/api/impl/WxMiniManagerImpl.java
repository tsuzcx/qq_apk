package com.tencent.mobileqq.wxmini.api.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import com.tencent.mobileqq.wxmini.impl.loader.WxDFLoader;
import com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment;
import com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity;
import common.config.service.QzoneConfig;

public class WxMiniManagerImpl
  implements IWxMiniManager
{
  public static final String TAG = "wxminin.WxMiniManagerImpl";
  public static final String URL_PREFIX_WX_MINIAPP_URL1 = "https://mp.weixin.qq.com/a/";
  
  public void attachBaseContext(Context paramContext)
  {
    WxMiniSDKImpl.a.a(paramContext);
  }
  
  public Class<?> getWXMiniEntryClass()
  {
    return WxMiniDemoActivity.class;
  }
  
  public void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent)
  {
    try
    {
      if (!WxMiniSDKImpl.a.a()) {
        WxMiniSDKImpl.a.a(BaseApplicationImpl.sApplication);
      }
      WxMiniSDKImpl.a.c().handleIntent(paramActivity, paramIntent);
      return;
    }
    catch (Exception paramActivity)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("handleWxaAPI e=");
      paramIntent.append(paramActivity);
      Log.e("WxMiniManagerImpl", paramIntent.toString());
    }
  }
  
  public boolean isWxMiniApp(String paramString)
  {
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "wxMiniAppEnable", 1) == 0) {
      return false;
    }
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://mp.weixin.qq.com/a/"));
  }
  
  public void onAppProcessStart(Application paramApplication) {}
  
  public void onWxContainerProcessStart() {}
  
  public void preDownload()
  {
    WxDFLoader.a().c();
  }
  
  public void startWxMiniApp(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "wxMiniAppEnable", 1) == 0) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wxmini_link", paramString);
    localIntent.putExtra("wxmini_link_type", paramInt1);
    localIntent.putExtra("wxmini_scene", paramInt2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (paramContext != null)
    {
      boolean bool = paramContext instanceof Activity;
      if (!bool) {
        localIntent.addFlags(402653184);
      }
      PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicTransFragmentActivity.class, PreloadingFragment.class);
      if (bool) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
    }
  }
  
  public void startWxMiniAppById(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "wxMiniAppEnable", 1) == 0) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wxmini_appid", paramString1);
    localIntent.putExtra("wxmini_scene", paramInt);
    localIntent.putExtra("wxmini_path", paramString2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (paramContext != null)
    {
      boolean bool = paramContext instanceof Activity;
      if (!bool) {
        localIntent.addFlags(402653184);
      }
      PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicTransFragmentActivity.class, PreloadingFragment.class);
      if (bool) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.api.impl.WxMiniManagerImpl
 * JD-Core Version:    0.7.0.1
 */