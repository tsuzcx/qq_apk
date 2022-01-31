package com.tencent.thumbplayer.api.proxy;

import java.util.ArrayList;

public abstract interface ITPPreloadProxy
{
  public abstract String getPlayErrorCodeStr(int paramInt);
  
  public abstract boolean isAvailable();
  
  public abstract void pushEvent(int paramInt);
  
  public abstract void setPreloadListener(ITPPreloadProxy.IPreloadListener paramIPreloadListener);
  
  public abstract int startClipPreload(String paramString, ArrayList<TPDownloadParamData> paramArrayList);
  
  public abstract int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData);
  
  public abstract void stopPreload(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
 * JD-Core Version:    0.7.0.1
 */