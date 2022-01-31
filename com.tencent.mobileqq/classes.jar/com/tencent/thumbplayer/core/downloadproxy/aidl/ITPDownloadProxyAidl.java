package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.IInterface;
import java.util.Map;

public abstract interface ITPDownloadProxyAidl
  extends IInterface
{
  public abstract String getClipPlayUrl(int paramInt1, int paramInt2);
  
  public abstract String getPlayErrorCodeStr(int paramInt);
  
  public abstract String getPlayUrl(int paramInt);
  
  public abstract int init(String paramString);
  
  public abstract int pauseDownload(int paramInt);
  
  public abstract void pushEvent(int paramInt);
  
  public abstract int resumeDownload(int paramInt);
  
  public abstract boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl);
  
  public abstract void setMaxStorageSizeMB(long paramLong);
  
  public abstract void setPlayState(int paramInt1, int paramInt2);
  
  public abstract void setUserData(Map paramMap);
  
  public abstract int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl);
  
  public abstract int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl);
  
  public abstract int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl);
  
  public abstract void stopPlay(int paramInt);
  
  public abstract void stopPreload(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
 * JD-Core Version:    0.7.0.1
 */