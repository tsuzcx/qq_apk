package com.tencent.qqmini.sdk.launcher.core.plugins;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class BaseJsPlugin
  implements IJsPlugin
{
  public static final String EMPTY_RESULT = "{}";
  public ApkgInfo mApkgInfo;
  public Context mContext;
  protected boolean mIsDestroyed;
  public boolean mIsMiniGame;
  public IMiniAppContext mMiniAppContext;
  public MiniAppInfo mMiniAppInfo;
  
  protected MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    this.mContext = paramIMiniAppContext.getContext();
    this.mMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    this.mApkgInfo = ((ApkgInfo)this.mMiniAppInfo.apkgInfo);
    this.mIsMiniGame = paramIMiniAppContext.isMiniGame();
    this.mIsDestroyed = false;
  }
  
  public void onDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  protected void sendNativeViewEvent(RequestEvent paramRequestEvent, int paramInt)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, paramInt));
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2)
  {
    this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(paramString1, paramString2, 0));
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2, int paramInt, IJsService paramIJsService)
  {
    this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(paramString1, paramString2, paramInt, paramIJsService));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin
 * JD-Core Version:    0.7.0.1
 */