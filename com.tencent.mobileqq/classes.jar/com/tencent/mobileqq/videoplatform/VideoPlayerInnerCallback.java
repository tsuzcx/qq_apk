package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;

public abstract interface VideoPlayerInnerCallback
  extends VideoPlayerCallback
{
  public abstract void onSurfaceDestroy(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerInnerCallback
 * JD-Core Version:    0.7.0.1
 */