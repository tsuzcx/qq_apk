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
    try
    {
      paramCMTime = this.this$0.mImageGenerator.generateThumbnailAtTimeSync(paramCMTime);
    }
    catch (Throwable paramCMTime)
    {
      if ((paramCMTime instanceof OutOfMemoryError))
      {
        this.mIsRelease = true;
        this.this$0.mGenerateHandler.runnableFailAndReleaseCache();
      }
      Logger.e("VideoThumbVideoGenerator", "getBitmap", paramCMTime);
      paramCMTime.printStackTrace();
      paramCMTime = null;
    }
    Logger.i("VideoThumbVideoGenerator", "run: end generateThumbnailAtTimeSync");
    return paramCMTime;
  }
  
  private void runnableFinish()
  {
    VideoThumbVideoGenerator.access$502(this.this$0, null);
    if ((!this.mIsRelease) && (!this.mIsTimeOut))
    {
      if (this.mIsPause) {
        VideoThumbVideoGenerator.access$100(this.this$0);
      }
      return;
    }
    VideoThumbVideoGenerator.access$100(this.this$0);
    VideoThumbVideoGenerator.access$600(this.this$0);
  }
  
  public void run()
  {
    if (!VideoThumbVideoGenerator.access$200(this.this$0))
    {
      runnableFinish();
      return;
    }
    for (;;)
    {
      if (!checkLoop()) {
        break label169;
      }
      try
      {
        VideoThumbVideoGenerator.VideoThumbTask localVideoThumbTask = (VideoThumbVideoGenerator.VideoThumbTask)VideoThumbVideoGenerator.access$300(this.this$0).poll(500L, TimeUnit.MILLISECONDS);
        if (localVideoThumbTask == null)
        {
          this.mIsTimeOut = true;
          break label169;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("run: startTime is ");
        ((StringBuilder)localObject).append(VideoThumbVideoGenerator.VideoThumbTask.access$400(localVideoThumbTask));
        Logger.i("VideoThumbVideoGenerator", ((StringBuilder)localObject).toString());
        localObject = getBitmap(VideoThumbVideoGenerator.VideoThumbTask.access$400(localVideoThumbTask));
        if ((localObject != null) && (this.this$0.mVideoThumbListener != null)) {
          this.this$0.mVideoThumbListener.onThumbGenerated(null, VideoThumbVideoGenerator.VideoThumbTask.access$400(localVideoThumbTask), (Bitmap)localObject);
        } else {
          try
          {
            VideoThumbVideoGenerator.access$300(this.this$0).put(localVideoThumbTask);
          }
          catch (InterruptedException localInterruptedException1)
          {
            localInterruptedException1.printStackTrace();
          }
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        label157:
        break label157;
      }
    }
    Logger.e("VideoThumbVideoGenerator", "time out");
    this.mIsTimeOut = true;
    label169:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoGenerator.GeneratorRunnable
 * JD-Core Version:    0.7.0.1
 */