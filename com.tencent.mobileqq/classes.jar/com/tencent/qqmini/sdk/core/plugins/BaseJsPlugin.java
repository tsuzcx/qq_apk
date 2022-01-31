package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import behq;
import bekj;
import bekn;
import bekp;
import bekr;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class BaseJsPlugin
  implements IJsPlugin
{
  protected bekp mApkgInfo;
  protected Context mContext;
  protected boolean mIsDestroyed;
  public boolean mIsMiniGame;
  public behq mMiniAppContext;
  public MiniAppInfo mMiniAppInfo;
  
  public void onCreate(behq parambehq)
  {
    this.mMiniAppContext = parambehq;
    this.mContext = parambehq.a();
    this.mMiniAppInfo = parambehq.a();
    this.mApkgInfo = ((bekp)this.mMiniAppInfo.apkgInfo);
    this.mIsMiniGame = parambehq.e();
    this.mIsDestroyed = false;
  }
  
  public void onDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  public boolean onInterceptJsEvent(bekr parambekr)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  protected void sendNativeViewEvent(bekr parambekr, int paramInt)
  {
    this.mMiniAppContext.a(bekj.a(parambekr, paramInt));
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2)
  {
    this.mMiniAppContext.a(bekn.a(paramString1, paramString2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin
 * JD-Core Version:    0.7.0.1
 */