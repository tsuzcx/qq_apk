package com.tencent.tavkit.ciimage;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ThreadLocalTextureCache
{
  private static final ThreadLocal<ThreadLocalTextureCache> TEXTURE_CACHE = new ThreadLocalTextureCache.1();
  private final String TAG;
  @NonNull
  private final HashMap<String, TextureInfo> textureCache;
  
  private ThreadLocalTextureCache()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ThreadLocalTextureCache@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.TAG = ((StringBuilder)localObject).toString();
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ThreadLocalTextureCache() called, thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
    this.textureCache = new HashMap();
  }
  
  public static ThreadLocalTextureCache getInstance()
  {
    return (ThreadLocalTextureCache)TEXTURE_CACHE.get();
  }
  
  public TextureInfo getTextureInfo(String paramString)
  {
    try
    {
      paramString = (TextureInfo)this.textureCache.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void putTextureInfo(String paramString, TextureInfo paramTextureInfo)
  {
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("putTextureInfo() called with: key = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], textureInfo = [");
      localStringBuilder.append(paramTextureInfo);
      localStringBuilder.append("]");
      Logger.d(str, localStringBuilder.toString());
      this.textureCache.put(paramString, paramTextureInfo);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void release()
  {
    try
    {
      Object localObject1 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release() called, textureCache = ");
      localStringBuilder.append(this.textureCache);
      Logger.d((String)localObject1, localStringBuilder.toString());
      localObject1 = this.textureCache.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((TextureInfo)((Iterator)localObject1).next()).release();
      }
      this.textureCache.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void remove(String paramString)
  {
    try
    {
      this.textureCache.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.ThreadLocalTextureCache
 * JD-Core Version:    0.7.0.1
 */