package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;

public abstract interface TVK_IDownloadMgr
{
  public abstract void DownloadDeinit(int paramInt);
  
  public abstract int DownloadInit(Context paramContext, int paramInt, String paramString);
  
  public abstract void appToBack(int paramInt);
  
  public abstract void appToFront(int paramInt);
  
  public abstract String buildClipPlayURL(int paramInt1, int paramInt2);
  
  public abstract String buildPlayURLMp4(int paramInt);
  
  public abstract int cleanMemory(int paramInt);
  
  public abstract int cleanStorage(int paramInt);
  
  public abstract int deleteClipFileOnDisk(int paramInt1, String paramString, int paramInt2);
  
  public abstract int deleteFileOnDisk(int paramInt, String paramString);
  
  public abstract long getClipFileSizeOnDisk(int paramInt1, String paramString, int paramInt2);
  
  public abstract long getCurrentOffset(int paramInt);
  
  public abstract long getTotalOffset(int paramInt);
  
  public abstract boolean isClipCompleteOnDisk(int paramInt1, String paramString, int paramInt2);
  
  public abstract int pauseAllPreLoad(int paramInt);
  
  public abstract int pauseStorageIO(int paramInt);
  
  public abstract int preLoad(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int preLoadClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5);
  
  public abstract int resumeAllPreLoad(int paramInt);
  
  public abstract int resumeStorageIO(int paramInt);
  
  public abstract void setCallBackListener(int paramInt, TVK_IDownloadMgr.ICallBackListener paramICallBackListener);
  
  public abstract int setClipInfo(int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3);
  
  public abstract void setCookie(int paramInt, String paramString);
  
  public abstract void setHttpLowSpeedParams(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int setMaxMemorySize(int paramInt, long paramLong);
  
  public abstract int setMaxStorageSize(int paramInt, long paramLong);
  
  public abstract void setPlayerState(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setRemainTime(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int startPlay(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, int paramInt3);
  
  public abstract int startPlay(int paramInt1, String paramString1, int paramInt2, String paramString2, long paramLong, int paramInt3);
  
  public abstract int startPlayWithSavePath(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3);
  
  public abstract int startPreLoad(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, int paramInt3);
  
  public abstract int startPreLoadWithSavePath(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3);
  
  public abstract int stopAllPreLoad(int paramInt);
  
  public abstract void stopPlay(int paramInt1, int paramInt2);
  
  public abstract int stopPreLoad(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr
 * JD-Core Version:    0.7.0.1
 */