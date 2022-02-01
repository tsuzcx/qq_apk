package com.tencent.qqlive.tvkplayer.vinfo.api;

import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;

public abstract interface ITVKVodInfoGetter$ITVKVodInfoGetterCallback
{
  public abstract void onFailure(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2);
  
  public abstract void onSuccess(int paramInt, TVKVideoInfo paramTVKVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterCallback
 * JD-Core Version:    0.7.0.1
 */