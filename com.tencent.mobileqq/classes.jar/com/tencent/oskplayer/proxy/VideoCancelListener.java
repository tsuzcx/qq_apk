package com.tencent.oskplayer.proxy;

public abstract interface VideoCancelListener
{
  public abstract void onVideoCancelProceed(VideoRequest paramVideoRequest, int paramInt);
  
  public abstract void onVideoCancelStart(VideoRequest paramVideoRequest);
  
  public abstract void onVideoCancelSuccess(VideoRequest paramVideoRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoCancelListener
 * JD-Core Version:    0.7.0.1
 */