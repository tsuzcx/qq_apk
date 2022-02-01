package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.util.LruCache;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.util.Logger;
import com.tencent.weseevideo.editor.utils.HandlerUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoThumbVideoCache
  extends BaseVideoThumbAssetCache
{
  private static final String TAG = "VideoThumbVideoCache";
  private CopyOnWriteArrayList<BaseVideoThumbAssetCache.BitmapPoint> mBitmapList = new CopyOnWriteArrayList();
  private HashSet<String> mGeneratingRecorder = new HashSet();
  
  public VideoThumbVideoCache(String paramString, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> paramLruCache)
  {
    super(paramString, paramLruCache);
  }
  
  private BaseVideoThumbAssetCache.SeekListResult commonBinarySearch(List<BaseVideoThumbAssetCache.BitmapPoint> paramList, long paramLong, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    BaseVideoThumbAssetCache.SeekListResult localSeekListResult = new BaseVideoThumbAssetCache.SeekListResult();
    localSeekListResult.index = 0;
    localSeekListResult.isNormalized = true;
    if ((paramList.isEmpty()) || (paramLong < ((BaseVideoThumbAssetCache.BitmapPoint)paramList.get(0)).time)) {
      return localSeekListResult;
    }
    if (paramLong > ((BaseVideoThumbAssetCache.BitmapPoint)paramList.get(i)).time)
    {
      if (paramBoolean) {}
      for (localSeekListResult.index = paramList.size();; localSeekListResult.index = i) {
        return localSeekListResult;
      }
    }
    for (;;)
    {
      int j;
      if (j <= i)
      {
        int k = (j + i) / 2;
        if (((BaseVideoThumbAssetCache.BitmapPoint)paramList.get(k)).time > paramLong)
        {
          i = k - 1;
        }
        else if (((BaseVideoThumbAssetCache.BitmapPoint)paramList.get(k)).time < paramLong)
        {
          j = k + 1;
        }
        else
        {
          localSeekListResult.index = k;
          localSeekListResult.isNormalized = false;
          return localSeekListResult;
        }
      }
      else
      {
        paramList = new BaseVideoThumbAssetCache.SeekListResult();
        paramList.index = j;
        paramList.isNormalized = true;
        return paramList;
        j = 0;
      }
    }
  }
  
  public void addCover(CMTime paramCMTime, Bitmap paramBitmap)
  {
    long l = paramCMTime.getTimeUs() / 1000L;
    Logger.i("VideoThumbVideoCache", "addCover: " + l);
    if (!this.mGeneratingRecorder.contains(String.valueOf(l)))
    {
      this.mGeneratingRecorder.add(String.valueOf(l));
      paramCMTime = commonBinarySearch(this.mBitmapList, l, true);
      this.mBitmapList.add(paramCMTime.index, new BaseVideoThumbAssetCache.BitmapPoint(paramBitmap, l));
      int i = paramBitmap.getAllocationByteCount();
      this.mCacheSize += i;
      this.mLruCache.put(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, l), Integer.valueOf(i));
    }
    Logger.i("VideoThumbVideoCache", "mCacheSize: " + this.mCacheSize);
  }
  
  public BaseVideoThumbAssetCache.SeekResult getCover(long paramLong)
  {
    if (this.mBitmapList.isEmpty()) {
      return new BaseVideoThumbAssetCache.SeekResult(null, false);
    }
    BaseVideoThumbAssetCache.SeekListResult localSeekListResult = commonBinarySearch(this.mBitmapList, paramLong, false);
    BaseVideoThumbAssetCache.BitmapPoint localBitmapPoint = (BaseVideoThumbAssetCache.BitmapPoint)this.mBitmapList.get(localSeekListResult.index);
    this.mLruCache.get(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, paramLong));
    return new BaseVideoThumbAssetCache.SeekResult(localBitmapPoint.bitmap, localSeekListResult.isNormalized);
  }
  
  public void release()
  {
    Iterator localIterator = this.mBitmapList.iterator();
    while (localIterator.hasNext())
    {
      BaseVideoThumbAssetCache.BitmapPoint localBitmapPoint = (BaseVideoThumbAssetCache.BitmapPoint)localIterator.next();
      if ((localBitmapPoint.bitmap != null) && (!localBitmapPoint.bitmap.isRecycled())) {
        localBitmapPoint.bitmap.recycle();
      }
      this.mLruCache.remove(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, localBitmapPoint.time));
    }
    this.mBitmapList.clear();
    this.mGeneratingRecorder.clear();
  }
  
  public void releaseLowMemory(long paramLong)
  {
    HandlerUtils.getMainHandler().post(new VideoThumbVideoCache.1(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoCache
 * JD-Core Version:    0.7.0.1
 */