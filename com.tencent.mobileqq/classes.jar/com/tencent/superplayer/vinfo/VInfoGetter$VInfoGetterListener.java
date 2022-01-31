package com.tencent.superplayer.vinfo;

import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public abstract interface VInfoGetter$VInfoGetterListener
{
  public abstract void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt, String paramString);
  
  public abstract void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener
 * JD-Core Version:    0.7.0.1
 */