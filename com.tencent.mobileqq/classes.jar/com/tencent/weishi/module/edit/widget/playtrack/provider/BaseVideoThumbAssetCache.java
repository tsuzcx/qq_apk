package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.tav.coremedia.CMTime;

public abstract class BaseVideoThumbAssetCache
{
  protected final String mAssetId;
  protected long mCacheSize = 0L;
  protected LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> mLruCache;
  
  public BaseVideoThumbAssetCache(String paramString, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> paramLruCache)
  {
    this.mAssetId = paramString;
    this.mLruCache = paramLruCache;
  }
  
  public abstract void addCover(CMTime paramCMTime, Bitmap paramBitmap);
  
  public String getAssetId()
  {
    return this.mAssetId;
  }
  
  public long getCacheSize()
  {
    return this.mCacheSize;
  }
  
  public abstract BaseVideoThumbAssetCache.SeekResult getCover(long paramLong);
  
  public abstract void release();
  
  public abstract void releaseLowMemory(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache
 * JD-Core Version:    0.7.0.1
 */