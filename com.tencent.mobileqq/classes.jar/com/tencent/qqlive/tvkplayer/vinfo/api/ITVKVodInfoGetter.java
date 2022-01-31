package com.tencent.qqlive.tvkplayer.vinfo.api;

import android.support.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;

public abstract interface ITVKVodInfoGetter
{
  public abstract int getDlnaUrl(@NonNull TVKUserInfo paramTVKUserInfo, @NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo, @NonNull String paramString, int paramInt);
  
  public abstract int getPlayInfo(@NonNull TVKUserInfo paramTVKUserInfo, @NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo, @NonNull String paramString, int paramInt1, int paramInt2);
  
  public abstract void setOnInfoGetListener(ITVKVodInfoGetter.ITVKVodInfoGetterCallback paramITVKVodInfoGetterCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter
 * JD-Core Version:    0.7.0.1
 */