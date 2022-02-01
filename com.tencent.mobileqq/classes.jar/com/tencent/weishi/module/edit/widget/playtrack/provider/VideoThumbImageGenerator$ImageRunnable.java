package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.Logger;
import java.util.concurrent.BlockingQueue;

class VideoThumbImageGenerator$ImageRunnable
  implements Runnable
{
  private boolean mIsPause = false;
  private boolean mIsRelease = false;
  
  private VideoThumbImageGenerator$ImageRunnable(VideoThumbImageGenerator paramVideoThumbImageGenerator) {}
  
  private boolean checkLoop()
  {
    return (!this.mIsPause) && (!this.mIsRelease) && (!VideoThumbImageGenerator.access$100(this.this$0).isEmpty());
  }
  
  private void runnableFinish()
  {
    VideoThumbImageGenerator.access$402(this.this$0, null);
    if (this.mIsRelease) {
      VideoThumbImageGenerator.access$500(this.this$0);
    }
  }
  
  public void run()
  {
    while (checkLoop())
    {
      VideoThumbImageGenerator.ImageThumbTask localImageThumbTask;
      try
      {
        localImageThumbTask = (VideoThumbImageGenerator.ImageThumbTask)VideoThumbImageGenerator.access$100(this.this$0).take();
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run: startTime is ");
          localStringBuilder.append(VideoThumbImageGenerator.ImageThumbTask.access$200(localImageThumbTask));
          Logger.i("VideoThumbImageGenerator", localStringBuilder.toString());
        }
        catch (InterruptedException localInterruptedException2) {}
        Logger.e("VideoThumbImageGenerator", "run", localInterruptedException3);
      }
      catch (InterruptedException localInterruptedException3)
      {
        localImageThumbTask = null;
      }
      localInterruptedException3.printStackTrace();
      if (localImageThumbTask == null) {
        break;
      }
      Bitmap localBitmap = BitmapUtil.getBitmapWithSize(VideoThumbImageGenerator.access$300(this.this$0), (int)this.this$0.mCoverWidth, (int)this.this$0.mCoverHeight, true, true);
      if (localBitmap != null)
      {
        if (this.this$0.mVideoThumbListener != null) {
          this.this$0.mVideoThumbListener.onThumbGenerated(null, VideoThumbImageGenerator.ImageThumbTask.access$200(localImageThumbTask), localBitmap);
        }
      }
      else {
        try
        {
          VideoThumbImageGenerator.access$100(this.this$0).put(localImageThumbTask);
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
        }
      }
    }
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
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbImageGenerator.ImageRunnable
 * JD-Core Version:    0.7.0.1
 */