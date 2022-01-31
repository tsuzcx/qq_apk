package com.tencent.qqlive.tvkplayer.vinfo;

public abstract interface ITVKUrlGetter$OnGetUrlListener
{
  public abstract void onGetUrl(ITVKUrlGetter paramITVKUrlGetter, int paramInt, String paramString, ITVKUrlGetter.ExtraVideoInfo paramExtraVideoInfo, TVKNetVideoInfo paramTVKNetVideoInfo);
  
  public abstract void onGetUrlFailed(ITVKUrlGetter paramITVKUrlGetter, int paramInt1, int paramInt2, int paramInt3, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ITVKUrlGetter.OnGetUrlListener
 * JD-Core Version:    0.7.0.1
 */