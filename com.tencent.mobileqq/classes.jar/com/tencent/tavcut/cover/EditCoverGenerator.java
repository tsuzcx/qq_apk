package com.tencent.tavcut.cover;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ApertureMode;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
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

public class EditCoverGenerator
  implements ICoverGenerator
{
  private static final float SCALE_SIZE = 1.0F;
  public static final String TAG = "EditCoverGenerator";
  private CoverCache mCoverCache;
  private float mCoverHeight;
  private ConcurrentHashMap<Integer, EditCoverGenerator.CoverTask> mCoverTaskMap;
  private BlockingQueue<EditCoverGenerator.CoverTask> mCoverTaskQueue;
  private float mCoverWidth;
  private ExecutorService mExecutors;
  private List<CMTime> mGenerateTimeList;
  private TAVSourceImageGenerator mImageGenerator;
  private volatile boolean mPaused;
  private volatile boolean mReleased;
  private TAVSource mTavSource;
  
  private CGSize calculateRenderSize()
  {
    CGSize localCGSize3 = new CGSize(this.mCoverWidth * 1.0F, this.mCoverHeight * 1.0F);
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
      localCGSize1.height = (this.mCoverHeight * 1.0F);
      localCGSize1.width = (f * localCGSize1.height);
      return localCGSize1;
    }
    localCGSize1.width = (this.mCoverWidth * 1.0F);
    localCGSize1.height = (localCGSize1.width / f);
    return localCGSize1;
  }
  
  private void initParams()
  {
    int i = 0;
    if ((this.mGenerateTimeList == null) || (this.mGenerateTimeList.isEmpty())) {
      return;
    }
    this.mPaused = false;
    Logger.d("EditCoverGenerator", "initParams: generateTimeList is  " + this.mGenerateTimeList);
    this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
    this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.aspectFit);
    this.mCoverTaskMap = new ConcurrentHashMap(16);
    this.mCoverTaskQueue = new PriorityBlockingQueue();
    if (i < this.mGenerateTimeList.size())
    {
      Object localObject = (CMTime)this.mGenerateTimeList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        long l = System.currentTimeMillis();
        localObject = new EditCoverGenerator.CoverTask(this, i + l, (CMTime)localObject, i);
        try
        {
          this.mCoverTaskQueue.put(localObject);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    this.mExecutors = Executors.newSingleThreadExecutor();
    this.mExecutors.submit(new EditCoverGenerator.CoverRunnable(this, null));
  }
  
  private void realRelease()
  {
    Logger.d("EditCoverGenerator", "realRelease: ");
    releaseImageGenerator();
    releaseCache();
    releaseQueue();
    releaseExecutors();
  }
  
  private void releaseCache()
  {
    Logger.d("EditCoverGenerator", "releaseCache: ");
    if (this.mCoverCache != null)
    {
      this.mCoverCache.release();
      this.mCoverCache = null;
    }
  }
  
  private void releaseExecutors()
  {
    Logger.d("EditCoverGenerator", "releaseExecutors: ");
    if (this.mExecutors != null)
    {
      this.mExecutors.shutdownNow();
      this.mExecutors = null;
    }
  }
  
  private void releaseImageGenerator()
  {
    Logger.d("EditCoverGenerator", "releaseImageGenerator: ");
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
    Logger.d("EditCoverGenerator", "releaseQueue: ");
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
  
  public void generateCoverByIndex(int paramInt, CMTime paramCMTime)
  {
    if (this.mCoverTaskMap == null) {
      return;
    }
    if ((this.mCoverTaskMap.containsKey(Integer.valueOf(paramInt))) && (!EditCoverGenerator.CoverTask.access$100((EditCoverGenerator.CoverTask)this.mCoverTaskMap.get(Integer.valueOf(paramInt)))))
    {
      EditCoverGenerator.CoverTask.access$202((EditCoverGenerator.CoverTask)this.mCoverTaskMap.get(Integer.valueOf(paramInt)), paramCMTime);
      return;
    }
    paramCMTime = new EditCoverGenerator.CoverTask(this, System.currentTimeMillis(), paramCMTime, paramInt);
    this.mCoverTaskMap.put(Integer.valueOf(paramInt), paramCMTime);
    try
    {
      this.mCoverTaskQueue.put(paramCMTime);
      return;
    }
    catch (InterruptedException paramCMTime)
    {
      paramCMTime.printStackTrace();
    }
  }
  
  public void generateCoverByIndexRange(int paramInt1, int paramInt2) {}
  
  public void generateCoverByTimeRange(long paramLong1, long paramLong2) {}
  
  public void init(TAVSource paramTAVSource, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void init(TAVSource paramTAVSource, List<CMTime> paramList, int paramInt1, int paramInt2)
  {
    this.mTavSource = paramTAVSource;
    this.mGenerateTimeList = paramList;
    this.mCoverWidth = paramInt1;
    this.mCoverHeight = paramInt2;
    initParams();
  }
  
  public void pause()
  {
    if ((this.mCoverTaskMap == null) || (this.mCoverTaskMap.isEmpty())) {}
    do
    {
      return;
      Logger.d("EditCoverGenerator", "pause: ");
      this.mPaused = true;
    } while ((this.mExecutors == null) || (this.mExecutors.isShutdown()));
    this.mExecutors.submit(new EditCoverGenerator.CoverRunnable(this, null));
  }
  
  public void release()
  {
    Logger.d("EditCoverGenerator", "release: ");
    this.mReleased = true;
    if ((this.mExecutors != null) && (!this.mExecutors.isShutdown()))
    {
      this.mExecutors.submit(new EditCoverGenerator.CoverRunnable(this, null));
      return;
    }
    releaseQueue();
    releaseCache();
  }
  
  public void resume()
  {
    if ((this.mCoverTaskMap == null) || (this.mCoverTaskMap.isEmpty())) {
      return;
    }
    this.mPaused = false;
    Logger.d("EditCoverGenerator", "resume: ");
    if (this.mImageGenerator == null)
    {
      this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
      this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.scaleToFit);
    }
    if (this.mExecutors == null) {
      this.mExecutors = Executors.newSingleThreadExecutor();
    }
    this.mExecutors.submit(new EditCoverGenerator.CoverRunnable(this, null));
  }
  
  public void setCoverCache(CoverCache paramCoverCache)
  {
    this.mCoverCache = paramCoverCache;
  }
  
  public void setRenderContextParamas(RenderContextParams paramRenderContextParams) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.cover.EditCoverGenerator
 * JD-Core Version:    0.7.0.1
 */