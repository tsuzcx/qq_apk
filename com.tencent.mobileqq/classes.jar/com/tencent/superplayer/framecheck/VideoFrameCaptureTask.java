package com.tencent.superplayer.framecheck;

import android.graphics.Bitmap;
import com.tencent.superplayer.utils.LogUtil;

public class VideoFrameCaptureTask
{
  public static final String TAG = "MediaPlayerMgr.VideoFrameCaptureTask";
  public static final int TARGET_BITMAP_LENGTH = 32;
  public static final int TASK_INTERVAL = 1000;
  public boolean isEndTask = false;
  private IFrameCaptureTaskRunner mTaskRunner;
  
  public VideoFrameCaptureTask(IFrameCaptureTaskRunner paramIFrameCaptureTaskRunner)
  {
    this(paramIFrameCaptureTaskRunner, false);
  }
  
  public VideoFrameCaptureTask(IFrameCaptureTaskRunner paramIFrameCaptureTaskRunner, boolean paramBoolean)
  {
    this.mTaskRunner = paramIFrameCaptureTaskRunner;
    this.isEndTask = paramBoolean;
  }
  
  public Bitmap doTask()
  {
    if (this.mTaskRunner == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = this.mTaskRunner.doCapture(32, 32);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e("MediaPlayerMgr.VideoFrameCaptureTask", "doTask error," + localThrowable.getLocalizedMessage());
    }
    return null;
  }
  
  public int getTaskDelay()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.VideoFrameCaptureTask
 * JD-Core Version:    0.7.0.1
 */