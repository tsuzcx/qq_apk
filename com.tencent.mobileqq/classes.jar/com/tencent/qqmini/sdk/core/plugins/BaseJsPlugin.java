package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import bglv;
import bgmk;
import bgms;
import bgod;
import bgok;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class BaseJsPlugin
  implements IJsPlugin
{
  protected bgod mApkgInfo;
  public Context mContext;
  protected boolean mIsDestroyed;
  public boolean mIsMiniGame;
  public bglv mMiniAppContext;
  public MiniAppInfo mMiniAppInfo;
  
  public void onCreate(bglv parambglv)
  {
    this.mMiniAppContext = parambglv;
    this.mContext = parambglv.a();
    this.mMiniAppInfo = parambglv.a();
    this.mApkgInfo = ((bgod)this.mMiniAppInfo.apkgInfo);
    this.mIsMiniGame = parambglv.b();
    this.mIsDestroyed = false;
  }
  
  public void onDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  public boolean onInterceptJsEvent(bgok parambgok)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  protected void sendNativeViewEvent(bgok parambgok, int paramInt)
  {
    this.mMiniAppContext.a(bgmk.a(parambgok, paramInt));
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2)
  {
    this.mMiniAppContext.a(bgms.a(paramString1, paramString2, 0));
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2, int paramInt)
  {
    this.mMiniAppContext.a(bgms.a(paramString1, paramString2, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin
 * JD-Core Version:    0.7.0.1
 */