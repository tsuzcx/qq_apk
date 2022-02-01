package com.tencent.thumbplayer.datatransport.resourceloader;

import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;

public abstract interface ITPAssetResourceLoader
{
  public abstract void fillInContentInformation();
  
  public abstract String getContentType(int paramInt, String paramString);
  
  public abstract String getDataFilePath(int paramInt, String paramString);
  
  public abstract long getDataTotalSize(int paramInt, String paramString);
  
  public abstract int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract int onStopReadData(int paramInt1, String paramString, int paramInt2);
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void setTPAssetResourceLoaderListener(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.ITPAssetResourceLoader
 * JD-Core Version:    0.7.0.1
 */