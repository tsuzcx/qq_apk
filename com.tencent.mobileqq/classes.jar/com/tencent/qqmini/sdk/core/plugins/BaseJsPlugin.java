package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import begz;
import bejs;
import bejw;
import bejy;
import beka;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class BaseJsPlugin
  implements IJsPlugin
{
  protected bejy mApkgInfo;
  protected Context mContext;
  protected boolean mIsDestroyed;
  public boolean mIsMiniGame;
  public begz mMiniAppContext;
  public MiniAppInfo mMiniAppInfo;
  
  public void onCreate(begz parambegz)
  {
    this.mMiniAppContext = parambegz;
    this.mContext = parambegz.a();
    this.mMiniAppInfo = parambegz.a();
    this.mApkgInfo = ((bejy)this.mMiniAppInfo.apkgInfo);
    this.mIsMiniGame = parambegz.e();
    this.mIsDestroyed = false;
  }
  
  public void onDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  public boolean onInterceptJsEvent(beka parambeka)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  protected void sendNativeViewEvent(beka parambeka, int paramInt)
  {
    this.mMiniAppContext.a(bejs.a(parambeka, paramInt));
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2)
  {
    this.mMiniAppContext.a(bejw.a(paramString1, paramString2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin
 * JD-Core Version:    0.7.0.1
 */