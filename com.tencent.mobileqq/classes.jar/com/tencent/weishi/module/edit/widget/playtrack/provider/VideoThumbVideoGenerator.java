package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.support.annotation.NonNull;
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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class VideoThumbVideoGenerator
  extends BaseVideoThumbGenerator
{
  private static final float SCALE_SIZE = 1.0F;
  public static final String TAG = "VideoThumbVideoGenerator";
  protected TAVSourceImageGenerator mImageGenerator;
  private boolean mIsNeedDump;
  private volatile VideoThumbVideoGenerator.GeneratorRunnable mRunnable;
  private TAVSource mTavSource;
  private BlockingQueue<VideoThumbVideoGenerator.VideoThumbTask> mVideoThumbTaskQueue = new PriorityBlockingQueue();
  
  private CGSize calculateRenderSize()
  {
    CGSize localCGSize3 = new CGSize(this.mCoverWidth * 1.0F, this.mCoverHeight * 1.0F);
    if (!checkTavSourceIsNull(this.mTavSource))
    {
      if (checkHeightAndWidth(this.mCoverHeight, this.mCoverWidth)) {
        return localCGSize3;
      }
      CGSize localCGSize2 = this.mTavSource.getVideoComposition().getRenderSize().clone();
      CGSize localCGSize1;
      if (localCGSize2 != null)
      {
        localCGSize1 = localCGSize2;
        if (!checkHeightAndWidth(localCGSize2.height, localCGSize2.width)) {}
      }
      else
      {
        if (checkTavAsset(this.mTavSource)) {
          return localCGSize3;
        }
        localCGSize1 = this.mTavSource.getAsset().getNaturalSize().clone();
      }
      float f = localCGSize1.width / localCGSize1.height;
      if (f > 1.0F)
      {
        localCGSize1.height = (this.mCoverHeight * 1.0F);
        localCGSize1.width = (localCGSize1.height * f);
        return localCGSize1;
      }
      localCGSize1.width = (this.mCoverWidth * 1.0F);
      localCGSize1.height = (localCGSize1.width / f);
      return localCGSize1;
    }
    return localCGSize3;
  }
  
  private boolean checkHeightAndWidth(float paramFloat1, float paramFloat2)
  {
    return (FloatUtils.isEquals(paramFloat2, 0.0F)) || (FloatUtils.isEquals(0.0F, paramFloat1));
  }
  
  private boolean checkTavAsset(@NonNull TAVSource paramTAVSource)
  {
    return (paramTAVSource.getAsset() == null) || (paramTAVSource.getAsset().getNaturalSize() == null);
  }
  
  private boolean checkTavSourceIsNull(TAVSource paramTAVSource)
  {
    return (paramTAVSource == null) || (paramTAVSource.getVideoComposition() == null);
  }
  
  private boolean reInitImageGenerator()
  {
    if (this.mImageGenerator == null) {
      try
      {
        this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
        RenderContextParams localRenderContextParams = new RenderContextParams();
        localRenderContextParams.putParam("video_cover", "video_cover_param");
        this.mImageGenerator.getAssetImageGenerator().setRenderContextParams(localRenderContextParams);
        this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
      }
      catch (Throwable localThrowable)
      {
        if ((localThrowable instanceof OutOfMemoryError)) {
          this.mGenerateHandler.runnableFailAndReleaseCache();
        }
        return false;
      }
    }
    return true;
  }
  
  private void releaseImageGenerator()
  {
    Logger.i("VideoThumbVideoGenerator", "releaseImageGenerator:");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("releaseImageGenerator:");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    Logger.i("VideoThumbVideoGenerator", ((StringBuilder)localObject).toString());
    localObject = this.mImageGenerator;
    if (localObject != null)
    {
      if (((TAVSourceImageGenerator)localObject).getAssetImageGenerator() != null) {
        this.mImageGenerator.getAssetImageGenerator().release();
      }
      this.mImageGenerator = null;
    }
  }
  
  private void releaseQueue()
  {
    Logger.i("VideoThumbVideoGenerator", "releaseQueue:");
    BlockingQueue localBlockingQueue = this.mVideoThumbTaskQueue;
    if (localBlockingQueue != null) {
      localBlockingQueue.clear();
    }
  }
  
  private void startGenerate()
  {
    if (this.mRunnable != null)
    {
      Logger.i("VideoThumbVideoGenerator", "mRunnable is run");
      return;
    }
    this.mRunnable = new VideoThumbVideoGenerator.GeneratorRunnable(this);
    this.mGenerateHandler.postRunnable(this.mRunnable);
  }
  
  public void generateCoverByTime(CMTime paramCMTime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("generateCoverByTime:");
    localStringBuilder.append(paramCMTime.getTimeUs());
    Logger.i("VideoThumbVideoGenerator", localStringBuilder.toString());
    paramCMTime = new VideoThumbVideoGenerator.VideoThumbTask(System.currentTimeMillis(), paramCMTime);
    try
    {
      this.mVideoThumbTaskQueue.put(paramCMTime);
    }
    catch (InterruptedException paramCMTime)
    {
      paramCMTime.printStackTrace();
    }
    startGenerate();
  }
  
  public void init(TAVSource paramTAVSource)
  {
    Logger.i("VideoThumbVideoGenerator", "init");
    this.mTavSource = paramTAVSource;
  }
  
  public void pause()
  {
    Logger.i("VideoThumbVideoGenerator", "pause:");
    if (this.mRunnable == null) {
      return;
    }
    this.mRunnable.setPause(true);
  }
  
  public void release()
  {
    Logger.i("VideoThumbVideoGenerator", "release:");
    if (this.mRunnable != null)
    {
      this.mRunnable.setRelease(true);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release threadName:");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.i("VideoThumbVideoGenerator", localStringBuilder.toString());
    releaseQueue();
    if (this.mGenerateHandler != null) {
      this.mGenerateHandler.postRunnable(new VideoThumbVideoGenerator.ReleaseRunnable(this, null));
    }
  }
  
  public void resume()
  {
    Logger.i("VideoThumbVideoGenerator", "resume:");
    if (this.mVideoThumbTaskQueue.isEmpty()) {
      return;
    }
    startGenerate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoGenerator
 * JD-Core Version:    0.7.0.1
 */