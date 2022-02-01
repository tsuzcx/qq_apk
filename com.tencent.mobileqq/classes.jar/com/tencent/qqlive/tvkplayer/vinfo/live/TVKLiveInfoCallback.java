package com.tencent.qqlive.tvkplayer.vinfo.live;

import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;

public abstract class TVKLiveInfoCallback
{
  private boolean mCancelled = false;
  
  protected void cancel()
  {
    this.mCancelled = true;
  }
  
  protected boolean isCancelled()
  {
    return this.mCancelled;
  }
  
  public abstract void onFailure(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo);
  
  public abstract void onSuccess(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoCallback
 * JD-Core Version:    0.7.0.1
 */