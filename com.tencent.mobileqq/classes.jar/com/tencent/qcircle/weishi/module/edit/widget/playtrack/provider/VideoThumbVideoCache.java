package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.util.LruCache;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.tav.coremedia.CMTime;
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
    int j = paramList.size() - 1;
    BaseVideoThumbAssetCache.SeekListResult localSeekListResult = new BaseVideoThumbAssetCache.SeekListResult();
    localSeekListResult.index = 0;
    localSeekListResult.isNormalized = true;
    if (!paramList.isEmpty())
    {
      if (paramLong < ((BaseVideoThumbAssetCache.BitmapPoint)paramList.get(0)).time) {
        return localSeekListResult;
      }
      if (paramLong > ((BaseVideoThumbAssetCache.BitmapPoint)paramList.get(j)).time)
      {
        if (paramBoolean)
        {
          localSeekListResult.index = paramList.size();
          return localSeekListResult;
        }
        localSeekListResult.index = j;
        return localSeekListResult;
      }
      int i = 0;
      while (i <= j)
      {
        int k = (i + j) / 2;
        if (((BaseVideoThumbAssetCache.BitmapPoint)paramList.get(k)).time > paramLong)
        {
          j = k - 1;
        }
        else if (((BaseVideoThumbAssetCache.BitmapPoint)paramList.get(k)).time < paramLong)
        {
          i = k + 1;
        }
        else
        {
          localSeekListResult.index = k;
          localSeekListResult.isNormalized = false;
          return localSeekListResult;
        }
      }
      paramList = new BaseVideoThumbAssetCache.SeekListResult();
      paramList.index = i;
      paramList.isNormalized = true;
      return paramList;
    }
    return localSeekListResult;
  }
  
  public void addCover(CMTime paramCMTime, Bitmap paramBitmap)
  {
    long l = paramCMTime.getTimeUs() / 1000L;
    paramCMTime = new StringBuilder();
    paramCMTime.append("addCover: ");
    paramCMTime.append(l);
    Logger.i("VideoThumbVideoCache", paramCMTime.toString());
    if (!this.mGeneratingRecorder.contains(String.valueOf(l)))
    {
      this.mGeneratingRecorder.add(String.valueOf(l));
      paramCMTime = commonBinarySearch(this.mBitmapList, l, true);
      this.mBitmapList.add(paramCMTime.index, new BaseVideoThumbAssetCache.BitmapPoint(paramBitmap, l));
      int i = paramBitmap.getAllocationByteCount();
      this.mCacheSize += i;
      this.mLruCache.put(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, l), Integer.valueOf(i));
    }
    paramCMTime = new StringBuilder();
    paramCMTime.append("mCacheSize: ");
    paramCMTime.append(this.mCacheSize);
    Logger.i("VideoThumbVideoCache", paramCMTime.toString());
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
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoCache
 * JD-Core Version:    0.7.0.1
 */