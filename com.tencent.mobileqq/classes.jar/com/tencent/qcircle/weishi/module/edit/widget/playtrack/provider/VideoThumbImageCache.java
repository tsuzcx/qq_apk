package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.tav.coremedia.CMTime;

public class VideoThumbImageCache
  extends BaseVideoThumbAssetCache
{
  private Bitmap mBitmap;
  
  public VideoThumbImageCache(String paramString, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> paramLruCache)
  {
    super(paramString, paramLruCache);
  }
  
  public void addCover(CMTime paramCMTime, Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    this.mCacheSize += paramBitmap.getAllocationByteCount();
  }
  
  public BaseVideoThumbAssetCache.SeekResult getCover(long paramLong)
  {
    if (this.mBitmap == null) {
      return new BaseVideoThumbAssetCache.SeekResult(null, false);
    }
    this.mLruCache.get(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, 0L));
    return new BaseVideoThumbAssetCache.SeekResult(this.mBitmap, false);
  }
  
  public void release()
  {
    Bitmap localBitmap = this.mBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
      this.mLruCache.remove(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, 0L));
    }
    this.mCacheSize = 0L;
  }
  
  public void releaseLowMemory(long paramLong)
  {
    release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbImageCache
 * JD-Core Version:    0.7.0.1
 */