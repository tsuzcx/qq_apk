package com.tencent.oskplayer;

import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.VideoProxy.HttpErrorListener;

public abstract interface VideoLoader
{
  public abstract void addHttpErrorListener(String paramString, VideoProxy.HttpErrorListener paramHttpErrorListener);
  
  public abstract void addHttpRetryLogic(String paramString, HttpRetryLogic paramHttpRetryLogic);
  
  public abstract void clearCacheByInfo(SegmentVideoInfo paramSegmentVideoInfo);
  
  public abstract double getCachedSizeRate(String paramString);
  
  public abstract String getUrl(String paramString);
  
  public abstract void initEnv();
  
  public abstract void removeHttpErrorListener(String paramString);
  
  public abstract void removeHttpRetryLogic(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.VideoLoader
 * JD-Core Version:    0.7.0.1
 */