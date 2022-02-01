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
    CGSize localCGSize2 = new CGSize(this.mCoverWidth * 1.0F, this.mCoverHeight * 1.0F);
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
          break label204;
        }
        if (this.mTavSource.getAsset().getNaturalSize() == null) {
          return localCGSize2;
        }
        localObject = this.mTavSource.getAsset().getNaturalSize().clone();
      }
      float f = ((CGSize)localObject).width / ((CGSize)localObject).height;
      if (f > 1.0F)
      {
        ((CGSize)localObject).height = (this.mCoverHeight * 1.0F);
        ((CGSize)localObject).width = (((CGSize)localObject).height * f);
        return localObject;
      }
      ((CGSize)localObject).width = (this.mCoverWidth * 1.0F);
      ((CGSize)localObject).height = (((CGSize)localObject).width / f);
      return localObject;
    }
    label204:
    return localCGSize2;
  }
  
  private void initParams()
  {
    Object localObject = this.mGenerateTimeList;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      int i = 0;
      this.mPaused = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initParams: generateTimeList is  ");
      ((StringBuilder)localObject).append(this.mGenerateTimeList);
      Logger.d("EditCoverGenerator", ((StringBuilder)localObject).toString());
      this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
      this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.aspectFit);
      this.mCoverTaskMap = new ConcurrentHashMap(16);
      this.mCoverTaskQueue = new PriorityBlockingQueue();
      while (i < this.mGenerateTimeList.size())
      {
        localObject = (CMTime)this.mGenerateTimeList.get(i);
        if (localObject != null)
        {
          localObject = new EditCoverGenerator.CoverTask(this, System.currentTimeMillis() + i, (CMTime)localObject, i);
          try
          {
            this.mCoverTaskQueue.put(localObject);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        i += 1;
      }
      this.mExecutors = Executors.newSingleThreadExecutor();
      this.mExecutors.submit(new EditCoverGenerator.CoverRunnable(this, null));
    }
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
    CoverCache localCoverCache = this.mCoverCache;
    if (localCoverCache != null)
    {
      localCoverCache.release();
      this.mCoverCache = null;
    }
  }
  
  private void releaseExecutors()
  {
    Logger.d("EditCoverGenerator", "releaseExecutors: ");
    ExecutorService localExecutorService = this.mExecutors;
    if (localExecutorService != null)
    {
      localExecutorService.shutdownNow();
      this.mExecutors = null;
    }
  }
  
  private void releaseImageGenerator()
  {
    Logger.d("EditCoverGenerator", "releaseImageGenerator: ");
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
    Logger.d("EditCoverGenerator", "releaseQueue: ");
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
  
  public void generateCoverByIndex(int paramInt, CMTime paramCMTime)
  {
    ConcurrentHashMap localConcurrentHashMap = this.mCoverTaskMap;
    if (localConcurrentHashMap == null) {
      return;
    }
    if ((localConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) && (!EditCoverGenerator.CoverTask.access$100((EditCoverGenerator.CoverTask)this.mCoverTaskMap.get(Integer.valueOf(paramInt)))))
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
    Object localObject = this.mCoverTaskMap;
    if (localObject != null)
    {
      if (((ConcurrentHashMap)localObject).isEmpty()) {
        return;
      }
      Logger.d("EditCoverGenerator", "pause: ");
      this.mPaused = true;
      localObject = this.mExecutors;
      if ((localObject != null) && (!((ExecutorService)localObject).isShutdown())) {
        this.mExecutors.submit(new EditCoverGenerator.CoverRunnable(this, null));
      }
    }
  }
  
  public void release()
  {
    Logger.d("EditCoverGenerator", "release: ");
    this.mReleased = true;
    ExecutorService localExecutorService = this.mExecutors;
    if ((localExecutorService != null) && (!localExecutorService.isShutdown()))
    {
      this.mExecutors.submit(new EditCoverGenerator.CoverRunnable(this, null));
      return;
    }
    releaseQueue();
    releaseCache();
  }
  
  public void resume()
  {
    ConcurrentHashMap localConcurrentHashMap = this.mCoverTaskMap;
    if (localConcurrentHashMap != null)
    {
      if (localConcurrentHashMap.isEmpty()) {
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