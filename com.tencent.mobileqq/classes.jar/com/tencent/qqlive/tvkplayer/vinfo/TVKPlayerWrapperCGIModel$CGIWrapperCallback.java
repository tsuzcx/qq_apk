package com.tencent.qqlive.tvkplayer.vinfo;

public abstract interface TVKPlayerWrapperCGIModel$CGIWrapperCallback
{
  public abstract void onGetLiveInfoFailed(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo);
  
  public abstract void onGetLiveInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo);
  
  public abstract void onGetVodInfoFailed(int paramInt1, TVKPlaybackInfo.RequestInfo paramRequestInfo, String paramString1, int paramInt2, String paramString2);
  
  public abstract void onGetVodInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKVideoInfo paramTVKVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel.CGIWrapperCallback
 * JD-Core Version:    0.7.0.1
 */