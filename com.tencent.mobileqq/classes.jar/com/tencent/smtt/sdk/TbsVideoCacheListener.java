package com.tencent.smtt.sdk;

import android.os.Bundle;

public abstract interface TbsVideoCacheListener
{
  public abstract void onVideoDownloadCompletion(TbsVideoCacheTask paramTbsVideoCacheTask, long paramLong1, long paramLong2, Bundle paramBundle);
  
  public abstract void onVideoDownloadError(TbsVideoCacheTask paramTbsVideoCacheTask, int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void onVideoDownloadInit(TbsVideoCacheTask paramTbsVideoCacheTask, int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void onVideoDownloadProgress(TbsVideoCacheTask paramTbsVideoCacheTask, int paramInt1, long paramLong, int paramInt2, Bundle paramBundle);
  
  public abstract void onVideoDownloadStart(TbsVideoCacheTask paramTbsVideoCacheTask, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoCacheListener
 * JD-Core Version:    0.7.0.1
 */