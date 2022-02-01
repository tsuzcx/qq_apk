package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;

public abstract interface TVK_ICacheMgr
{
  public abstract void addCgiPreloadCallback(TVK_ICacheMgr.ICGIPreloadCallback paramICGIPreloadCallback);
  
  public abstract int isVideoCached(Context paramContext, String paramString1, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString2);
  
  public abstract void preLoadVideoById(Context paramContext, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString);
  
  public abstract void preLoadVideoByUrl(Context paramContext, String paramString, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
  
  public abstract int preLoadVideoByUrlWithResult(Context paramContext, String paramString, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
  
  public abstract boolean quickCheckVideoCached(Context paramContext, String paramString1, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString2);
  
  public abstract void releasePreload(int paramInt);
  
  public abstract void removeCgiPreloadCallback();
  
  public abstract void removePreloadCallback();
  
  public abstract void setOnPreLoadCompleteCallback(TVK_ICacheMgr.IPreloadCompleteCallback paramIPreloadCompleteCallback);
  
  public abstract void setPreloadCallback(TVK_ICacheMgr.IPreloadCallback paramIPreloadCallback);
  
  public abstract void stopCacheData(int paramInt);
  
  public abstract void stopCacheDataById(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr
 * JD-Core Version:    0.7.0.1
 */