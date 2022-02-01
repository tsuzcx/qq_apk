package com.tencent.mobileqq.nearby.now.view.impl;

import android.content.Context;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerViewUtil;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerView;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import java.io.File;

public class VideoPlayerViewUtilImpl
  implements IVideoPlayerViewUtil
{
  public TVK_ICacheMgr createCacheMgr()
  {
    return VideoPlayerView.createCacheMgr();
  }
  
  public String getFileName(String paramString)
  {
    return VideoPlayerView.getFileName(paramString);
  }
  
  public void initTVKSDK(Context paramContext)
  {
    VideoPlayerView.initTVKSDK(paramContext);
  }
  
  public void preloadVideo(String paramString)
  {
    VideoPlayerView.preloadVideo(paramString);
  }
  
  public String setFileCompleted(File paramFile)
  {
    return VideoPlayerView.setFileCompleted(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.impl.VideoPlayerViewUtilImpl
 * JD-Core Version:    0.7.0.1
 */