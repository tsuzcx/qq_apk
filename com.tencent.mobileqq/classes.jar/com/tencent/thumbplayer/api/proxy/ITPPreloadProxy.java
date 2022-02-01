package com.tencent.thumbplayer.api.proxy;

import java.util.ArrayList;
import java.util.Map;

public abstract interface ITPPreloadProxy
{
  public abstract String getPlayErrorCodeStr(int paramInt);
  
  public abstract boolean isAvailable();
  
  public abstract void pushEvent(int paramInt);
  
  public abstract void setPreloadListener(ITPPreloadProxy.IPreloadListener paramIPreloadListener);
  
  public abstract int startClipPreload(String paramString, ArrayList<TPDownloadParamData> paramArrayList);
  
  public abstract int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData, ITPPreloadProxy.IPreloadListener paramIPreloadListener);
  
  public abstract int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData, Map<String, String> paramMap, ITPPreloadProxy.IPreloadListener paramIPreloadListener);
  
  public abstract void stopPreload(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
 * JD-Core Version:    0.7.0.1
 */