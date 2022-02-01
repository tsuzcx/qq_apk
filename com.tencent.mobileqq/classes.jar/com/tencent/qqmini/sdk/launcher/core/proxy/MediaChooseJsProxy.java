package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public abstract class MediaChooseJsProxy
{
  protected MediaChooseJsProxy.Bridge mBridge;
  
  public abstract void chooseMedia(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void create(IMiniAppContext paramIMiniAppContext);
  
  public void destroy()
  {
    this.mBridge = null;
  }
  
  public void setResponseListener(MediaChooseJsProxy.Bridge paramBridge)
  {
    this.mBridge = paramBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy
 * JD-Core Version:    0.7.0.1
 */