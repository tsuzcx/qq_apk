package com.tencent.qqmini.sdk.launcher.core.proxy;

public abstract interface MiniAppCacheProxy
{
  public abstract boolean deleteCacheByTimeStamp(long paramLong);
  
  public abstract boolean enableMiniAppCache();
  
  public abstract long getDeleteIntervalTime();
  
  public abstract byte[] getIdInfo(String paramString1, String paramString2);
  
  public abstract MiniAppCacheProxy.LinkData getLinkInfo(String paramString, int paramInt);
  
  public abstract boolean saveIdInfo(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong);
  
  public abstract boolean saveLinkInfo(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
 * JD-Core Version:    0.7.0.1
 */