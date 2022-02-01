package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;

public abstract interface ITPDownloadProxy
{
  public abstract int deinit();
  
  public abstract String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract String getPlayErrorCodeStr(int paramInt);
  
  public abstract String getPlayUrl(int paramInt1, int paramInt2);
  
  public abstract int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam);
  
  public abstract int pauseDownload(int paramInt);
  
  public abstract void pushEvent(int paramInt);
  
  public abstract int removeStorageCache(String paramString);
  
  public abstract int resumeDownload(int paramInt);
  
  public abstract void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam);
  
  public abstract void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener);
  
  public abstract void setMaxStorageSizeMB(long paramLong);
  
  public abstract void setPlayState(int paramInt1, int paramInt2);
  
  public abstract void setUserData(String paramString, Object paramObject);
  
  public abstract int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener);
  
  public abstract int startClipPlay(String paramString, int paramInt, ITPPlayListener paramITPPlayListener);
  
  public abstract int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener);
  
  public abstract int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, ITPPlayListener paramITPPlayListener);
  
  public abstract int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, ITPPreLoadListener paramITPPreLoadListener);
  
  public abstract void startTask(int paramInt);
  
  public abstract void stopOfflineDownload(int paramInt);
  
  public abstract void stopPlay(int paramInt);
  
  public abstract void stopPreload(int paramInt);
  
  public abstract void updateStoragePath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
 * JD-Core Version:    0.7.0.1
 */