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
    if (this.mCoverCache != null)
    {
      this.mCoverCache.release();
      this.mCoverCache = null;
    }
  }
  
  private void releaseExecutors()
  {
    Logger.d("TimelineCoverGenerator", "releaseExecutors: ");
    if (this.mExecutors != null)
    {
      this.mExecutors.shutdownNow();
      this.mExecutors = null;
    }
  }
  
  private void releaseImageGenerator()
  {
    Logger.d("TimelineCoverGenerator", "releaseImageGenerator: ");
    if (this.mImageGenerator != null)
    {
      if (this.mImageGenerator.getAssetImageGenerator() != null) {
        this.mImageGenerator.getAssetImageGenerator().release();
      }
      this.mImageGenerator = null;
    }
  }
  
  private void releaseQueue()
  {
    Logger.d("TimelineCoverGenerator", "releaseQueue: ");
    if (this.mCoverTaskMap != null)
    {
      this.mCoverTaskMap.clear();
      this.mCoverTaskMap = null;
    }
    if (this.mCoverTaskQueue != null)
    {
      this.mCoverTaskQueue.clear();
      this.mCoverTaskQueue = null;
    }
  }
  
  protected CGSize calculateRenderSize()
  {
    CGSize localCGSize3 = new CGSize(this.mCoverWidth * 4.0F, this.mCoverHeight * 4.0F);
    if ((this.mTavSource == null) || (this.mTavSource.getVideoComposition() == null) || (FloatUtils.isEquals(this.mCoverWidth, 0.0F)) || (FloatUtils.isEquals(this.mCoverHeight, 0.0F))) {
      return localCGSize3;
    }
    CGSize localCGSize2 = this.mTavSource.getVideoComposition().getRenderSize().clone();
    CGSize localCGSize1;
    if ((localCGSize2 != null) && (!FloatUtils.isEquals(localCGSize2.width, 0.0F)))
    {
      localCGSize1 = localCGSize2;
      if (!FloatUtils.isEquals(localCGSize2.height, 0.0F)) {}
    }
    else
    {
      if ((this.mTavSource.getAsset() == null) || (this.mTavSource.getAsset().getNaturalSize() == null)) {
        return localCGSize3;
      }
      localCGSize1 = this.mTavSource.getAsset().getNaturalSize().clone();
    }
    float f = localCGSize1.width / localCGSize1.height;
    if (f > 1.0F)
    {
      localCGSize1.height = (this.mCoverHeight * 4.0F);
      localCGSize1.width = (f * localCGSize1.height);
      return localCGSize1;
    }
    localCGSize1.width = (this.mCoverWidth * 4.0F);
    localCGSize1.height = (localCGSize1.width / f);
    return localCGSize1;
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
    label17:
    if (i > paramInt1 - 1) {
      if ((this.mCoverCache == null) || (this.mCoverCache.getCover(i) == null)) {
        break label49;
      }
    }
    for (;;)
    {
      i -= 1;
      break label17;
      break;
      label49:
      long l = i * this.mItemDurationMs;
      if ((this.mCoverTaskMap != null) && (this.mCoverTaskMap.containsKey(Long.valueOf(l))))
      {
        TimelineCoverGenerator.CoverTask localCoverTask1 = (TimelineCoverGenerator.CoverTask)this.mCoverTaskMap.get(Long.valueOf(l));
        if (!TimelineCoverGenerator.CoverTask.access$100(localCoverTask1))
        {
          this.mCoverTaskQueue.remove(localCoverTask1);
          TimelineCoverGenerator.CoverTask.access$202(localCoverTask1, System.currentTimeMillis() + paramInt2 - i);
          this.mCoverTaskMap.put(Long.valueOf(l), localCoverTask1);
          try
          {
            this.mCoverTaskQueue.put(localCoverTask1);
          }
          catch (InterruptedException localInterruptedException1)
          {
            localInterruptedException1.printStackTrace();
          }
        }
      }
      else
      {
        TimelineCoverGenerator.CoverTask localCoverTask2 = new TimelineCoverGenerator.CoverTask(this, System.currentTimeMillis() + paramInt2 - i, i);
        try
        {
          this.mCoverTaskQueue.put(localCoverTask2);
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
        }
      }
    }
  }
  
  public void generateCoverByTimeRange(long paramLong1, long paramLong2)
  {
    generateCoverByIndexRange((int)(paramLong1 / this.mItemDurationMs), (int)(paramLong2 / this.mItemDurationMs));
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
      if ((this.mItemDurationMs == 0L) || (this.mTotalDurationMs == 0L)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.mLastCoverWidth = ((float)(this.mTotalDurationMs - (this.mItemCount - 1) * this.mItemDurationMs) * 1.0F / (float)this.mItemDurationMs * this.mCoverWidth);
      if (this.mLastCoverWidth > this.mCoverWidth) {
        this.mLastCoverWidth = this.mCoverWidth;
      }
      Logger.d("TimelineCoverGenerator", "initParams: mItemDurationMs is  " + this.mItemDurationMs);
      Logger.d("TimelineCoverGenerator", "initParams: mItemCount is  " + this.mItemCount);
      Logger.d("TimelineCoverGenerator", "initParams: mTotalDurationMs is  " + this.mTotalDurationMs);
      Logger.d("TimelineCoverGenerator", "initParams: mCoverWidth is " + this.mCoverWidth);
      Logger.d("TimelineCoverGenerator", "initParams: mLastCoverWidth is " + this.mLastCoverWidth);
      this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
      this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.scaleToFit);
      this.mImageGenerator.getAssetImageGenerator().setRenderContextParams(this.mRenderContextParams);
      this.mCoverTaskMap = new ConcurrentHashMap(16);
      this.mCoverTaskQueue = new PriorityBlockingQueue();
      int i = 0;
      for (;;)
      {
        if (i < this.mItemCount)
        {
          TimelineCoverGenerator.CoverTask localCoverTask = new TimelineCoverGenerator.CoverTask(this, this.mItemCount - i, i);
          Logger.d("TimelineCoverGenerator", "initParams: task.index is " + TimelineCoverGenerator.CoverTask.access$000(localCoverTask));
          try
          {
            this.mCoverTaskQueue.put(localCoverTask);
            i += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
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
    if ((this.mExecutors != null) && (!this.mExecutors.isShutdown()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineCoverGenerator
 * JD-Core Version:    0.7.0.1
 */