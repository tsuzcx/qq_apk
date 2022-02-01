package com.tencent.mobileqq.videoplatform.api;

import android.graphics.Bitmap;

public abstract interface VideoPlayerCallback
{
  public abstract void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  public abstract void onDownloadComplete(long paramLong);
  
  public abstract void onDownloadProgress(long paramLong1, long paramLong2);
  
  public abstract void onFirstFrameRendered(long paramLong);
  
  public abstract void onLoopBack(long paramLong1, long paramLong2);
  
  public abstract void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void onPlayProgress(long paramLong1, long paramLong2);
  
  public abstract void onStateChange(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
 * JD-Core Version:    0.7.0.1
 */