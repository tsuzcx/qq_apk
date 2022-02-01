package com.tencent.tavcut.timeline;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ApertureMode;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavcut.cover.CoverCache;
import com.tencent.tavcut.cover.ICoverGenerator;
import com.tencent.tavcut.util.FloatUtils;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVSource;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class TimelineCoverGenerator
  implements ICoverGenerator
{
  private static final float SCALE_SIZE = 4.0F;
  public static final String TAG = "TimelineCoverGenerator";
  protected CoverCache mCoverCache;
  protected float mCoverHeight;
  protected ConcurrentHashMap<Long, TimelineCoverGenerator.CoverTask> mCoverTaskMap;
  protected BlockingQueue<TimelineCoverGenerator.CoverTask> mCoverTaskQueue;
  protected float mCoverWidth;
  protected ExecutorService mExecutors;
  protected TAVSourceImageGenerator mImageGenerator;
  protected int mItemCount;
  protected long mItemDurationMs;
  protected float mLastCoverWidth;
  protected volatile boolean mReleased;
  private RenderContextParams mRenderContextParams;
  protected TAVSource mTavSource;
  protected long mTotalDurationMs;
  
  private void realRelease()
  {
    Logger.d("TimelineCoverGenerator", "realRelease: ");
    releaseImageGenerator();
    releaseCache();
    releaseQueue();
    releaseExecutors();
  }
  
  private void releaseCache()
  {
    Logger.d("TimelineCoverGenerator", "releaseCache: ");
    CoverCache localCoverCache = this.mCoverCache;
    if (localCoverCache != null)
    {
      localCoverCache.release();
      this.mCoverCache = null;
    }
  }
  
  private void releaseExecutors()
  {
    Logger.d("TimelineCoverGenerator", "releaseExecutors: ");
    ExecutorService localExecutorService = this.mExecutors;
    if (localExecutorService != null)
    {
      localExecutorService.shutdownNow();
      this.mExecutors = null;
    }
  }
  
  private void releaseImageGenerator()
  {
    Logger.d("TimelineCoverGenerator", "releaseImageGenerator: ");
    TAVSourceImageGenerator localTAVSourceImageGenerator = this.mImageGenerator;
    if (localTAVSourceImageGenerator != null)
    {
      if (localTAVSourceImageGenerator.getAssetImageGenerator() != null) {
        this.mImageGenerator.getAssetImageGenerator().release();
      }
      this.mImageGenerator = null;
    }
  }
  
  private void releaseQueue()
  {
    Logger.d("TimelineCoverGenerator", "releaseQueue: ");
    Object localObject = this.mCoverTaskMap;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.mCoverTaskMap = null;
    }
    localObject = this.mCoverTaskQueue;
    if (localObject != null)
    {
      ((BlockingQueue)localObject).clear();
      this.mCoverTaskQueue = null;
    }
  }
  
  protected CGSize calculateRenderSize()
  {
    CGSize localCGSize2 = new CGSize(this.mCoverWidth * 4.0F, this.mCoverHeight * 4.0F);
    Object localObject = this.mTavSource;
    if ((localObject != null) && (((TAVSource)localObject).getVideoComposition() != null) && (!FloatUtils.isEquals(this.mCoverWidth, 0.0F)))
    {
      if (FloatUtils.isEquals(this.mCoverHeight, 0.0F)) {
        return localCGSize2;
      }
      CGSize localCGSize1 = this.mTavSource.getVideoComposition().getRenderSize().clone();
      if ((localCGSize1 != null) && (!FloatUtils.isEquals(localCGSize1.width, 0.0F)))
      {
        localObject = localCGSize1;
        if (!FloatUtils.isEquals(localCGSize1.height, 0.0F)) {}
      }
      else
      {
        if (this.mTavSource.getAsset() == null) {
          break label208;
        }
        if (this.mTavSource.getAsset().getNaturalSize() == null) {
          return localCGSize2;
        }
        localObject = this.mTavSource.getAsset().getNaturalSize().clone();
      }
      float f = ((CGSize)localObject).width / ((CGSize)localObject).height;
      if (f > 1.0F)
      {
        ((CGSize)localObject).height = (this.mCoverHeight * 4.0F);
        ((CGSize)localObject).width = (((CGSize)localObject).height * f);
        return localObject;
      }
      ((CGSize)localObject).width = (this.mCoverWidth * 4.0F);
      ((CGSize)localObject).height = (((CGSize)localObject).width / f);
      return localObject;
    }
    label208:
    return localCGSize2;
  }
  
  public void generateCoverByIndex(int paramInt, CMTime paramCMTime) {}
  
  public void generateCoverByIndexRange(int paramInt1, int paramInt2)
  {
    if (this.mCoverTaskQueue == null)
    {
      Logger.e("TimelineCoverGenerator", "CoverTaskQueue is null maybe TimelineCoverGenerator was released");
      return;
    }
    int i = paramInt2;
    while (i > paramInt1 - 1)
    {
      Object localObject = this.mCoverCache;
      if ((localObject == null) || (((CoverCache)localObject).getCover(i) == null))
      {
        long l1 = i;
        long l2 = this.mItemDurationMs * l1;
        localObject = this.mCoverTaskMap;
        if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(l2))))
        {
          localObject = (TimelineCoverGenerator.CoverTask)this.mCoverTaskMap.get(Long.valueOf(l2));
          if (!TimelineCoverGenerator.CoverTask.access$100((TimelineCoverGenerator.CoverTask)localObject))
          {
            this.mCoverTaskQueue.remove(localObject);
            TimelineCoverGenerator.CoverTask.access$202((TimelineCoverGenerator.CoverTask)localObject, System.currentTimeMillis() + paramInt2 - l1);
            this.mCoverTaskMap.put(Long.valueOf(l2), localObject);
            try
            {
              this.mCoverTaskQueue.put(localObject);
            }
            catch (InterruptedException localInterruptedException1)
            {
              localInterruptedException1.printStackTrace();
            }
          }
        }
        else
        {
          TimelineCoverGenerator.CoverTask localCoverTask = new TimelineCoverGenerator.CoverTask(this, System.currentTimeMillis() + paramInt2 - l1, i);
          try
          {
            this.mCoverTaskQueue.put(localCoverTask);
          }
          catch (InterruptedException localInterruptedException2)
          {
            localInterruptedException2.printStackTrace();
          }
        }
      }
      i -= 1;
    }
  }
  
  public void generateCoverByTimeRange(long paramLong1, long paramLong2)
  {
    long l = this.mItemDurationMs;
    generateCoverByIndexRange((int)(paramLong1 / l), (int)(paramLong2 / l));
  }
  
  public void init(TAVSource paramTAVSource, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTavSource = paramTAVSource;
    this.mItemDurationMs = paramLong;
    this.mItemCount = paramInt1;
    this.mCoverWidth = paramInt2;
    this.mCoverHeight = paramInt3;
    initParams();
  }
  
  public void init(TAVSource paramTAVSource, List<CMTime> paramList, int paramInt1, int paramInt2) {}
  
  protected void initParams()
  {
    try
    {
      this.mTotalDurationMs = (this.mTavSource.getAsset().getDuration().getTimeUs() / 1000L);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    long l1 = this.mItemDurationMs;
    if (l1 != 0L)
    {
      long l2 = this.mTotalDurationMs;
      if (l2 == 0L) {
        return;
      }
      float f1 = (float)(l2 - (this.mItemCount - 1) * l1) * 1.0F / (float)l1;
      float f2 = this.mCoverWidth;
      this.mLastCoverWidth = (f1 * f2);
      if (this.mLastCoverWidth > f2) {
        this.mLastCoverWidth = f2;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initParams: mItemDurationMs is  ");
      ((StringBuilder)localObject).append(this.mItemDurationMs);
      Logger.d("TimelineCoverGenerator", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initParams: mItemCount is  ");
      ((StringBuilder)localObject).append(this.mItemCount);
      Logger.d("TimelineCoverGenerator", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initParams: mTotalDurationMs is  ");
      ((StringBuilder)localObject).append(this.mTotalDurationMs);
      Logger.d("TimelineCoverGenerator", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initParams: mCoverWidth is ");
      ((StringBuilder)localObject).append(this.mCoverWidth);
      Logger.d("TimelineCoverGenerator", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initParams: mLastCoverWidth is ");
      ((StringBuilder)localObject).append(this.mLastCoverWidth);
      Logger.d("TimelineCoverGenerator", ((StringBuilder)localObject).toString());
      this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
      this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.scaleToFit);
      this.mImageGenerator.getAssetImageGenerator().setRenderContextParams(this.mRenderContextParams);
      this.mCoverTaskMap = new ConcurrentHashMap(16);
      this.mCoverTaskQueue = new PriorityBlockingQueue();
      int i = 0;
      for (;;)
      {
        int j = this.mItemCount;
        if (i >= j) {
          break;
        }
        localObject = new TimelineCoverGenerator.CoverTask(this, j - i, i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initParams: task.index is ");
        localStringBuilder.append(TimelineCoverGenerator.CoverTask.access$000((TimelineCoverGenerator.CoverTask)localObject));
        Logger.d("TimelineCoverGenerator", localStringBuilder.toString());
        try
        {
          this.mCoverTaskQueue.put(localObject);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        i += 1;
      }
      this.mExecutors = Executors.newSingleThreadExecutor();
      this.mExecutors.submit(new TimelineCoverGenerator.CoverRunnable(this));
    }
  }
  
  public void pause() {}
  
  public void release()
  {
    Logger.d("TimelineCoverGenerator", "release: ");
    this.mReleased = true;
    ExecutorService localExecutorService = this.mExecutors;
    if ((localExecutorService != null) && (!localExecutorService.isShutdown()))
    {
      this.mExecutors.submit(new TimelineCoverGenerator.CoverRunnable(this));
      return;
    }
    releaseQueue();
    releaseCache();
  }
  
  public void resume() {}
  
  public void setCoverCache(CoverCache paramCoverCache)
  {
    this.mCoverCache = paramCoverCache;
  }
  
  public void setRenderContextParamas(RenderContextParams paramRenderContextParams)
  {
    this.mRenderContextParams = paramRenderContextParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineCoverGenerator
 * JD-Core Version:    0.7.0.1
 */