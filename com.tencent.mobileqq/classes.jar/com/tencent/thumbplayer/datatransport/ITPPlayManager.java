package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;

public abstract interface ITPPlayManager
  extends ITPPlayerProxy
{
  public abstract String getPlayErrorCodeStr();
  
  public abstract ITPPlayerProxyListener getTPPlayerProxyListener();
  
  public abstract boolean hasWaitDefTask();
  
  public abstract boolean isEnable();
  
  public abstract void pauseDownload();
  
  public abstract void playerSwitchDefComplete(long paramLong);
  
  public abstract void release();
  
  public abstract void resumeDownload();
  
  public abstract void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener);
  
  public abstract void setPlayListener(ITPPlayListener paramITPPlayListener);
  
  public abstract void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam);
  
  public abstract void setProxyPlayState(int paramInt);
  
  public abstract void setVideoInfo(TPVideoInfo paramTPVideoInfo);
  
  public abstract String startDownLoadTrackUrl(int paramInt, String paramString);
  
  public abstract String startDownloadPlay(String paramString);
  
  public abstract ITPMediaAsset startDownloadPlayByAsset(ITPMediaAsset paramITPMediaAsset);
  
  public abstract String startSwitchDefTask(long paramLong, String paramString, TPVideoInfo paramTPVideoInfo);
  
  public abstract ITPMediaAsset startSwitchDefTaskByAsset(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo);
  
  public abstract void stopDownLoadTrackUrl(String paramString);
  
  public abstract void stopDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.ITPPlayManager
 * JD-Core Version:    0.7.0.1
 */