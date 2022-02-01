package com.tencent.superplayer.preload;

import android.app.Activity;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public abstract interface IPreloadPlayerMgr
{
  public abstract PreloadPlayerInfo getPlayerFromPool(int paramInt, SuperPlayerVideoInfo paramSuperPlayerVideoInfo);
  
  public abstract int startPreloadTask(Activity paramActivity, int paramInt, SuperPlayerVideoInfo paramSuperPlayerVideoInfo);
  
  public abstract void stopPreloadTask(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.preload.IPreloadPlayerMgr
 * JD-Core Version:    0.7.0.1
 */