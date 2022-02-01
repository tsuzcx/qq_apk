package com.tencent.tavkit.composition.video;

import android.support.annotation.Nullable;

public abstract interface TAVVideoMixEffect
{
  @RenderThread
  public abstract TAVVideoMixEffect.Filter createFilter();
  
  @Nullable
  public abstract String effectId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoMixEffect
 * JD-Core Version:    0.7.0.1
 */