package com.tencent.thumbplayer.core.downloadproxy.api;

import java.util.Map;

public abstract interface ITPProxyAdapter
{
  public abstract String checkVideoStatus(String paramString1, String paramString2);
  
  public abstract long getCurrentOffset(int paramInt);
  
  public abstract long getFilesize(int paramInt);
  
  public abstract String getProxyClipUrl(int paramInt1, int paramInt2);
  
  public abstract int getRecordDuration(String paramString1, String paramString2);
  
  public abstract int startOnlineOrOfflinePlay(int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Map<String, String> paramMap1, Map<String, String> paramMap2);
  
  public abstract void stopPlay(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.ITPProxyAdapter
 * JD-Core Version:    0.7.0.1
 */