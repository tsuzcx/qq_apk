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
  private final String TAG = "ThreadLocalTextureCache@" + Integer.toHexString(hashCode());
  @NonNull
  private final HashMap<String, TextureInfo> textureCache;
  
  private ThreadLocalTextureCache()
  {
    Logger.d(this.TAG, "ThreadLocalTextureCache() called, thread = " + Thread.currentThread().getName());
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
      Logger.d(this.TAG, "putTextureInfo() called with: key = [" + paramString + "], textureInfo = [" + paramTextureInfo + "]");
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
      Logger.d(this.TAG, "release() called, textureCache = " + this.textureCache);
      Iterator localIterator = this.textureCache.values().iterator();
      while (localIterator.hasNext()) {
        ((TextureInfo)localIterator.next()).release();
      }
      this.textureCache.clear();
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.ThreadLocalTextureCache
 * JD-Core Version:    0.7.0.1
 */