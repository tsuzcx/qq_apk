package com.tencent.qqlive.tvkplayer.vinfo.apiinner;

import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoParams;

public abstract interface ITVKVideoInfoRequest
{
  public abstract void cancelRequest();
  
  public abstract int startRequest(TVKVideoInfoParams paramTVKVideoInfoParams, ITVKVideoInfoResponse paramITVKVideoInfoResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVideoInfoRequest
 * JD-Core Version:    0.7.0.1
 */