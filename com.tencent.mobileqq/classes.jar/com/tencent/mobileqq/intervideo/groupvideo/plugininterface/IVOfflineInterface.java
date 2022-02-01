package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import android.webkit.WebResourceResponse;

public abstract interface IVOfflineInterface
{
  public abstract void asyncLoadUrl(String paramString);
  
  public abstract boolean isOfflineUrl(String paramString);
  
  public abstract WebResourceResponse shouldInterceptRequest(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVOfflineInterface
 * JD-Core Version:    0.7.0.1
 */