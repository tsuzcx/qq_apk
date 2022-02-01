package com.tencent.superplayer.api;

import java.util.Map;

public abstract interface ISPlayerDownloader$Listener
{
  public abstract void onDownloadCdnUrlExpired(int paramInt, Map<String, String> paramMap);
  
  public abstract void onDownloadCdnUrlInfoUpdate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onDownloadCdnUrlUpdate(int paramInt, String paramString);
  
  public abstract void onDownloadError(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void onDownloadFinish(int paramInt);
  
  public abstract void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString);
  
  public abstract void onDownloadProtocolUpdate(int paramInt, String paramString1, String paramString2);
  
  public abstract void onDownloadStatusUpdate(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPlayerDownloader.Listener
 * JD-Core Version:    0.7.0.1
 */