package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import java.io.File;

@QAPI(process={"all"})
public abstract interface IVideoPlayerViewUtil
  extends QRouteApi
{
  public abstract TVK_ICacheMgr createCacheMgr();
  
  public abstract String getFileName(String paramString);
  
  public abstract void initTVKSDK(Context paramContext);
  
  public abstract void preloadVideo(String paramString);
  
  public abstract String setFileCompleted(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.IVideoPlayerViewUtil
 * JD-Core Version:    0.7.0.1
 */