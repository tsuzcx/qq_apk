package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPPostProcessFrame;

public abstract interface ITPNativePlayerPostProcessFrameCallback
{
  public static final int EVENT_EOS = 1;
  public static final int EVENT_FLUSH = 2;
  
  public abstract TPPostProcessFrame onPostProcessFrame(TPPostProcessFrame paramTPPostProcessFrame, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback
 * JD-Core Version:    0.7.0.1
 */