package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.ListUtils;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoThumbAssetProvider
{
  private static final int END_OFFSET = 100;
  private static final int ONE_SEC = 1000;
  private static final String TAG = "VideoThumbAssetProvider";
  private String mAssetId;
  private int mAssetType = 1;
  private BaseVideoThumbAssetCache mCoverCache;
  private BaseVideoThumbGenerator mCoverGenerator;
  private Bitmap mDefaultBitmap;
  private VideoThumbListener mDefaultVideoThumbListener = new VideoThumbAssetProvider.1(this);
  private String mGroupId;
  private long mSourceTimeDuration;
  private ConcurrentHashMap<String, CopyOnWriteArrayList<Object>> mTagTable = new ConcurrentHashMap();
  private VideoThumbListener mUserVideoThumbListener;
  
  public VideoThumbAssetProvider(String paramString)
  {
    this.mGroupId = paramString;
  }
  
  private Bitmap getBitmapByNormalizedTime(long paramLong, Object paramObject)
  {
    BaseVideoThumbAssetCache.SeekResult localSeekResult = this.mCoverCache.getCover(paramLong);
    if (localSeekResult.bitmap == null)
    {
      sendGenerateRequest(paramObject, paramLong);
      return this.mDefaultBitmap;
    }
    if (localSeekResult.isNormalized) {
      sendGenerateRequest(paramObject, paramLong);
    }
    return localSeekResult.bitmap;
  }
  
  private long getNormalizedSeekTime(long paramLong1, long paramLong2)
  {
    long l2 = paramLong1 / 1000L;
    long l1 = l2;
    if (paramLong1 % 1000L >= 500L) {
      l1 = l2 + 1L;
    }
    paramLong1 = l1 * 1000L;
    l1 = 0L;
    if (paramLong1 < 0L) {
      paramLong1 = l1;
    }
    l1 = paramLong1;
    if (paramLong1 > paramLong2) {
      l1 = paramLong2 - 100L;
    }
    return l1;
  }
  
  private void initGeneratorAndCache(TAVSource paramTAVSource, int paramInt1, int paramInt2, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> paramLruCache, RunnableHandler paramRunnableHandler)
  {
    this.mCoverCache = new VideoThumbVideoCache(this.mAssetId, paramLruCache);
    this.mCoverGenerator = new VideoThumbVideoGenerator();
    ((VideoThumbVideoGenerator)this.mCoverGenerator).init(paramTAVSource);
    this.mCoverGenerator.setCoverHeight(paramInt2);
    this.mCoverGenerator.setCoverWidth(paramInt1);
    this.mCoverGenerator.setVideoThumbListener(this.mDefaultVideoThumbListener);
    this.mCoverGenerator.setGenerateHandler(paramRunnableHandler);
  }
  
  private void initGeneratorAndCache(VideoResourceModel paramVideoResourceModel, int paramInt1, int paramInt2, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> paramLruCache, RunnableHandler paramRunnableHandler)
  {
    this.mAssetType = paramVideoResourceModel.getType();
    int i = this.mAssetType;
    if (i == 2)
    {
      this.mCoverCache = new VideoThumbImageCache(paramVideoResourceModel.getPath(), paramLruCache);
      this.mCoverGenerator = new VideoThumbImageGenerator();
      ((VideoThumbImageGenerator)this.mCoverGenerator).setAssetId(paramVideoResourceModel.getPath());
      this.mCoverGenerator.setCoverHeight(paramInt2);
      this.mCoverGenerator.setCoverWidth(paramInt1);
    }
    else if (i == 1)
    {
      Object localObject = new URLAsset(paramVideoResourceModel.getPath());
      float f4 = ((URLAsset)localObject).getNaturalSize().height;
      float f5 = ((URLAsset)localObject).getNaturalSize().width;
      float f1 = paramInt1;
      float f3 = f4 * f1 / f5;
      float f2 = paramInt2;
      if (f3 < f2) {
        f1 = f5 * f2 / f4;
      } else {
        f2 = f3;
      }
      localObject = new TAVClip((Asset)localObject);
      ((TAVClip)localObject).getResource().setSourceTimeRange(new CMTimeRange(new CMTime((float)paramVideoResourceModel.getSourceTimeStart() / 1000.0F), new CMTime((float)paramVideoResourceModel.getSourceTimeDuration() / 1000.0F)));
      localObject = new TAVComposition(ListUtils.listWithObjects(new TAVClip[] { localObject }));
      ((TAVComposition)localObject).setRenderSize(new CGSize(f1, f2));
      localObject = new TAVCompositionBuilder((TAVComposition)localObject).buildSource();
      this.mCoverCache = new VideoThumbVideoCache(paramVideoResourceModel.getPath(), paramLruCache);
      this.mCoverGenerator = new VideoThumbVideoGenerator();
      ((VideoThumbVideoGenerator)this.mCoverGenerator).init((TAVSource)localObject);
      this.mCoverGenerator.setCoverHeight(f2);
      this.mCoverGenerator.setCoverWidth(f1);
    }
    this.mCoverGenerator.setVideoThumbListener(this.mDefaultVideoThumbListener);
    this.mCoverGenerator.setGenerateHandler(paramRunnableHandler);
  }
  
  private void sendGenerateRequest(Object paramObject, long paramLong)
  {
    if (this.mCoverGenerator == null) {
      return;
    }
    Object localObject1 = String.valueOf(paramLong);
    Object localObject2 = (List)this.mTagTable.get(localObject1);
    if (localObject2 != null)
    {
      if (!((List)localObject2).contains(paramObject)) {
        ((List)localObject2).add(paramObject);
      }
      return;
    }
    localObject2 = new CopyOnWriteArrayList();
    ((CopyOnWriteArrayList)localObject2).add(paramObject);
    this.mTagTable.put(localObject1, localObject2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sendGenerateRequest time:");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append(",Object:");
    ((StringBuilder)localObject1).append(paramObject);
    Logger.i("VideoThumbAssetProvider", ((StringBuilder)localObject1).toString());
    this.mCoverGenerator.generateCoverByTime(CMTime.fromMs(paramLong));
  }
  
  public Bitmap getAbsoluteBitmapByTime(long paramLong, Object paramObject)
  {
    if (this.mAssetType == 2) {
      return getBitmapByNormalizedTime(0L, paramObject);
    }
    return getBitmapByNormalizedTime(getNormalizedSeekTime(paramLong, this.mSourceTimeDuration), paramObject);
  }
  
  public String getAssetId()
  {
    return this.mAssetId;
  }
  
  public long getCache()
  {
    BaseVideoThumbAssetCache localBaseVideoThumbAssetCache = this.mCoverCache;
    if (localBaseVideoThumbAssetCache != null) {
      return localBaseVideoThumbAssetCache.getCacheSize();
    }
    return 0L;
  }
  
  public String getGroupId()
  {
    return this.mGroupId;
  }
  
  public void init(TAVSource paramTAVSource, String paramString, int paramInt1, int paramInt2, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> paramLruCache, RunnableHandler paramRunnableHandler)
  {
    this.mAssetId = paramString;
    this.mSourceTimeDuration = (paramTAVSource.getAsset().getDuration().getTimeUs() / 1000L);
    initGeneratorAndCache(paramTAVSource, paramInt1, paramInt2, paramLruCache, paramRunnableHandler);
  }
  
  public void init(VideoResourceModel paramVideoResourceModel, int paramInt1, int paramInt2, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> paramLruCache, RunnableHandler paramRunnableHandler)
  {
    this.mAssetId = paramVideoResourceModel.getPath();
    this.mSourceTimeDuration = paramVideoResourceModel.getSourceTimeDuration();
    initGeneratorAndCache(paramVideoResourceModel, paramInt1, paramInt2, paramLruCache, paramRunnableHandler);
  }
  
  public void pause()
  {
    BaseVideoThumbGenerator localBaseVideoThumbGenerator = this.mCoverGenerator;
    if (localBaseVideoThumbGenerator != null) {
      localBaseVideoThumbGenerator.pause();
    }
  }
  
  public void release()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release:");
    ((StringBuilder)localObject).append(getAssetId());
    Logger.i("VideoThumbAssetProvider", ((StringBuilder)localObject).toString());
    localObject = this.mCoverGenerator;
    if (localObject != null)
    {
      ((BaseVideoThumbGenerator)localObject).release();
      this.mCoverGenerator = null;
    }
    localObject = this.mCoverCache;
    if (localObject != null)
    {
      ((BaseVideoThumbAssetCache)localObject).release();
      this.mCoverCache = null;
    }
  }
  
  public void releaseBitmap(long paramLong)
  {
    BaseVideoThumbAssetCache localBaseVideoThumbAssetCache = this.mCoverCache;
    if (localBaseVideoThumbAssetCache != null) {
      localBaseVideoThumbAssetCache.releaseLowMemory(paramLong);
    }
  }
  
  public void resume()
  {
    BaseVideoThumbGenerator localBaseVideoThumbGenerator = this.mCoverGenerator;
    if (localBaseVideoThumbGenerator != null) {
      localBaseVideoThumbGenerator.resume();
    }
  }
  
  public void setDefaultBitmap(Bitmap paramBitmap)
  {
    this.mDefaultBitmap = paramBitmap;
  }
  
  public void setThumbListener(VideoThumbListener paramVideoThumbListener)
  {
    this.mUserVideoThumbListener = paramVideoThumbListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbAssetProvider
 * JD-Core Version:    0.7.0.1
 */