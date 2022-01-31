package com.tencent.thumbplayer.core.downloadproxy.api;

import java.util.Map;

public abstract interface ITPOfflineDownloadListener
{
  public abstract void onDownloadCdnUrlExpired(Map<String, String> paramMap);
  
  public abstract void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onDownloadCdnUrlUpdate(String paramString);
  
  public abstract void onDownloadError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onDownloadFinish();
  
  public abstract void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public abstract void onDownloadProtocolUpdate(String paramString1, String paramString2);
  
  public abstract void onDownloadStatusUpdate(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener
 * JD-Core Version:    0.7.0.1
 */