package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy.LinkData;

@ProxyService(proxy=MiniAppCacheProxy.class)
public class MiniAppCacheProxyDefault
  implements MiniAppCacheProxy
{
  public boolean deleteCacheByTimeStamp(long paramLong)
  {
    return false;
  }
  
  public boolean enableMiniAppCache()
  {
    return false;
  }
  
  public long getDeleteIntervalTime()
  {
    return 0L;
  }
  
  public byte[] getIdInfo(String paramString1, String paramString2)
  {
    return null;
  }
  
  public MiniAppCacheProxy.LinkData getLinkInfo(String paramString, int paramInt)
  {
    return null;
  }
  
  public boolean saveIdInfo(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    return false;
  }
  
  public boolean saveLinkInfo(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MiniAppCacheProxyDefault
 * JD-Core Version:    0.7.0.1
 */