package com.tencent.superplayer.config;

import java.util.HashMap;
import java.util.Map;

class CacheManager
{
  private Map<String, CacheContent> mCache = new HashMap();
  
  public CacheContent get(String paramString)
  {
    try
    {
      CacheContent localCacheContent2 = (CacheContent)this.mCache.get(paramString);
      CacheContent localCacheContent1 = localCacheContent2;
      if (localCacheContent2 == null)
      {
        localCacheContent2 = new CacheContent(paramString);
        localCacheContent1 = localCacheContent2;
        if (localCacheContent2.isValidate())
        {
          this.mCache.put(paramString, localCacheContent2);
          localCacheContent1 = localCacheContent2;
        }
      }
      return localCacheContent1;
    }
    finally {}
  }
  
  public void save(CacheContent paramCacheContent, String paramString)
  {
    paramCacheContent.save(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.config.CacheManager
 * JD-Core Version:    0.7.0.1
 */