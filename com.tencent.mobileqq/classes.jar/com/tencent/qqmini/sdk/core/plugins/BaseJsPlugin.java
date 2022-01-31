package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import bdcz;
import bdfs;
import bdfv;
import bdfx;
import bdfz;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class BaseJsPlugin
  implements IJsPlugin
{
  protected bdfx mApkgInfo;
  protected Context mContext;
  protected boolean mIsDestroyed;
  protected boolean mIsMiniGame;
  public bdcz mMiniAppContext;
  public MiniAppInfo mMiniAppInfo;
  
  public void onCreate(bdcz parambdcz)
  {
    this.mMiniAppContext = parambdcz;
    this.mContext = parambdcz.a();
    this.mMiniAppInfo = parambdcz.a();
    this.mApkgInfo = ((bdfx)this.mMiniAppInfo.apkgInfo);
    this.mIsMiniGame = parambdcz.e();
    this.mIsDestroyed = false;
  }
  
  public void onDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  public boolean onInterceptJsEvent(bdfz parambdfz)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  protected void sendNativeViewEvent(bdfz parambdfz, int paramInt)
  {
    this.mMiniAppContext.a(bdfs.a(parambdfz, paramInt));
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2)
  {
    this.mMiniAppContext.a(bdfv.a(paramString1, paramString2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin
 * JD-Core Version:    0.7.0.1
 */