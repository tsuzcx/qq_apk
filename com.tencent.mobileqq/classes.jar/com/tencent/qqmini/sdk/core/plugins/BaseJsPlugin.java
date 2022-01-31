package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import bgho;
import bgid;
import bgil;
import bgjw;
import bgkd;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class BaseJsPlugin
  implements IJsPlugin
{
  protected bgjw mApkgInfo;
  public Context mContext;
  protected boolean mIsDestroyed;
  public boolean mIsMiniGame;
  public bgho mMiniAppContext;
  public MiniAppInfo mMiniAppInfo;
  
  public void onCreate(bgho parambgho)
  {
    this.mMiniAppContext = parambgho;
    this.mContext = parambgho.a();
    this.mMiniAppInfo = parambgho.a();
    this.mApkgInfo = ((bgjw)this.mMiniAppInfo.apkgInfo);
    this.mIsMiniGame = parambgho.b();
    this.mIsDestroyed = false;
  }
  
  public void onDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  public boolean onInterceptJsEvent(bgkd parambgkd)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  protected void sendNativeViewEvent(bgkd parambgkd, int paramInt)
  {
    this.mMiniAppContext.a(bgid.a(parambgkd, paramInt));
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2)
  {
    this.mMiniAppContext.a(bgil.a(paramString1, paramString2, 0));
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2, int paramInt)
  {
    this.mMiniAppContext.a(bgil.a(paramString1, paramString2, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin
 * JD-Core Version:    0.7.0.1
 */