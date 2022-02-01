package com.tencent.thumbplayer.core.downloadproxy.api;

public abstract interface ITPPreLoadListener
{
  public abstract void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString);
  
  public abstract void onPrepareError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onPrepareOK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
 * JD-Core Version:    0.7.0.1
 */