package com.tencent.qqlive.tvkplayer.vinfo.api;

import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;

public abstract interface ITVKLiveInfoGetter$OnGetLiveInfoListener
{
  public abstract void onGetLiveInfoFailed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo);
  
  public abstract void onGetLiveInfoSucceed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.OnGetLiveInfoListener
 * JD-Core Version:    0.7.0.1
 */