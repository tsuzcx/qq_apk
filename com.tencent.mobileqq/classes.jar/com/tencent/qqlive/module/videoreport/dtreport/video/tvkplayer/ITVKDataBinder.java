package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import android.support.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.AdType;
import com.tencent.qqlive.tvkplayer.api.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;

public abstract interface ITVKDataBinder
{
  public abstract void onAdPrepared(ITVKPlayerEventListener.AdType paramAdType, long paramLong);
  
  public abstract void onAdStop();
  
  public abstract void onNetVideoInfo(@NonNull TVKNetVideoInfo paramTVKNetVideoInfo);
  
  public abstract void onOpenMedia(@NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString);
  
  public abstract void onUpdateReportParam(@NonNull TVKProperties paramTVKProperties);
  
  public abstract void onVideoPlay();
  
  public abstract void onVideoPrepared(long paramLong);
  
  public abstract void onVideoStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
 * JD-Core Version:    0.7.0.1
 */