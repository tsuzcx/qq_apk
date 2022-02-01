package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class VideoThumbVideoGenerator$GeneratorRunnable
  implements Runnable
{
  private static final long TIME_OUT_MS = 500L;
  private boolean mIsPause = false;
  private boolean mIsRelease = false;
  private boolean mIsTimeOut = false;
  
  VideoThumbVideoGenerator$GeneratorRunnable(VideoThumbVideoGenerator paramVideoThumbVideoGenerator) {}
  
  private boolean checkLoop()
  {
    return (this.this$0.mImageGenerator != null) && (!this.mIsPause) && (!this.mIsRelease);
  }
  
  private Bitmap getBitmap(CMTime paramCMTime)
  {
    Logger.i("VideoThumbVideoGenerator", "run: start generateThumbnailAtTimeSync");
    Object localObject = null;
    try
    {
      paramCMTime = this.this$0.mImageGenerator.generateThumbnailAtTimeSync(paramCMTime);
      Logger.i("VideoThumbVideoGenerator", "run: end generateThumbnailAtTimeSync");
      return paramCMTime;
    }
    catch (Throwable paramCMTime)
    {
      for (;;)
      {
        if ((paramCMTime instanceof OutOfMemoryError))
        {
          this.mIsRelease = true;
          this.this$0.mGenerateHandler.runnableFailAndReleaseCache();
        }
        Logger.e("VideoThumbVideoGenerator", "getBitmap", paramCMTime);
        paramCMTime.printStackTrace();
        paramCMTime = localObject;
      }
    }
  }
  
  private void runnableFinish()
  {
    VideoThumbVideoGenerator.access$502(this.this$0, null);
    if ((this.mIsRelease) || (this.mIsTimeOut))
    {
      VideoThumbVideoGenerator.access$100(this.this$0);
      VideoThumbVideoGenerator.access$600(this.this$0);
    }
    while (!this.mIsPause) {
      return;
    }
    VideoThumbVideoGenerator.access$100(this.this$0);
  }
  
  public void run()
  {
    if (!VideoThumbVideoGenerator.access$200(this.this$0))
    {
      runnableFinish();
      return;
    }
    do
    {
      try
      {
        Logger.i("VideoThumbVideoGenerator", "run: startTime is " + VideoThumbVideoGenerator.VideoThumbTask.access$400(localVideoThumbTask));
        Bitmap localBitmap = getBitmap(VideoThumbVideoGenerator.VideoThumbTask.access$400(localVideoThumbTask));
        if ((localBitmap == null) || (this.this$0.mVideoThumbListener == null)) {
          break label142;
        }
        this.this$0.mVideoThumbListener.onThumbGenerated(null, VideoThumbVideoGenerator.VideoThumbTask.access$400(localVideoThumbTask), localBitmap);
      }
      catch (InterruptedException localInterruptedException1)
      {
        for (;;)
        {
          VideoThumbVideoGenerator.VideoThumbTask localVideoThumbTask;
          Logger.e("VideoThumbVideoGenerator", "time out");
          this.mIsTimeOut = true;
          continue;
          try
          {
            VideoThumbVideoGenerator.access$300(this.this$0).put(localVideoThumbTask);
          }
          catch (InterruptedException localInterruptedException2)
          {
            localInterruptedException2.printStackTrace();
          }
        }
      }
      if (!checkLoop()) {
        break;
      }
      localVideoThumbTask = (VideoThumbVideoGenerator.VideoThumbTask)VideoThumbVideoGenerator.access$300(this.this$0).poll(500L, TimeUnit.MILLISECONDS);
    } while (localVideoThumbTask != null);
    this.mIsTimeOut = true;
    runnableFinish();
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.mIsPause = paramBoolean;
  }
  
  public void setRelease(boolean paramBoolean)
  {
    this.mIsRelease = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoGenerator.GeneratorRunnable
 * JD-Core Version:    0.7.0.1
 */