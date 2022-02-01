package com.tencent.superplayer.framecheck;

public class FirstFrameCaptureTask
  extends VideoFrameCaptureTask
{
  public FirstFrameCaptureTask(IFrameCaptureTaskRunner paramIFrameCaptureTaskRunner)
  {
    super(paramIFrameCaptureTaskRunner);
  }
  
  public int getTaskDelay()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.FirstFrameCaptureTask
 * JD-Core Version:    0.7.0.1
 */