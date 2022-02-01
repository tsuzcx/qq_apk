package com.tencent.weishi.module.edit.widget.playtrack.provider;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.util.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class VideoThumbImageGenerator
  extends BaseVideoThumbGenerator
{
  private static final String TAG = "VideoThumbImageGenerator";
  private String mAssetId;
  private volatile VideoThumbImageGenerator.ImageRunnable mRunnable;
  private BlockingQueue<VideoThumbImageGenerator.ImageThumbTask> mVideoThumbTaskQueue = new PriorityBlockingQueue();
  
  private void releaseQueue()
  {
    Logger.i("VideoThumbImageGenerator", "releaseQueue:");
    if (this.mVideoThumbTaskQueue != null) {
      this.mVideoThumbTaskQueue.clear();
    }
  }
  
  private void startGenerate()
  {
    if (this.mRunnable != null)
    {
      Logger.i("VideoThumbImageGenerator", "mRunnable is run");
      return;
    }
    this.mRunnable = new VideoThumbImageGenerator.ImageRunnable(this, null);
    this.mGenerateHandler.postRunnable(this.mRunnable);
  }
  
  public void generateCoverByTime(CMTime paramCMTime)
  {
    Logger.i("VideoThumbImageGenerator", "generateCoverByTime:" + paramCMTime.getTimeUs());
    paramCMTime = new VideoThumbImageGenerator.ImageThumbTask(System.currentTimeMillis(), paramCMTime);
    try
    {
      this.mVideoThumbTaskQueue.put(paramCMTime);
      startGenerate();
      return;
    }
    catch (InterruptedException paramCMTime)
    {
      for (;;)
      {
        paramCMTime.printStackTrace();
      }
    }
  }
  
  public void pause()
  {
    Logger.i("VideoThumbImageGenerator", "pause:");
    if (this.mRunnable == null) {
      return;
    }
    this.mRunnable.setPause(true);
  }
  
  public void release()
  {
    if (this.mRunnable != null)
    {
      this.mRunnable.setRelease(true);
      return;
    }
    releaseQueue();
  }
  
  public void resume()
  {
    Logger.i("VideoThumbImageGenerator", "resume:");
    if (this.mVideoThumbTaskQueue.isEmpty()) {
      return;
    }
    startGenerate();
  }
  
  public void setAssetId(String paramString)
  {
    this.mAssetId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbImageGenerator
 * JD-Core Version:    0.7.0.1
 */