package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public abstract class VideoJsProxy
{
  public VideoJsProxy.Bridge mBridge;
  
  public abstract void chooseVideo(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void create(IMiniAppContext paramIMiniAppContext);
  
  public void destroy()
  {
    this.mBridge = null;
  }
  
  public abstract void saveVideoToPhotosAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public void setResponseListener(VideoJsProxy.Bridge paramBridge)
  {
    this.mBridge = paramBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
 * JD-Core Version:    0.7.0.1
 */