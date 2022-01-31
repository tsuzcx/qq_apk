package com.tencent.tavkit.composition.video;

import android.support.annotation.Nullable;

public abstract interface TAVVideoEffect
{
  @RenderThread
  public abstract TAVVideoEffect.Filter createFilter();
  
  @Nullable
  public abstract String effectId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoEffect
 * JD-Core Version:    0.7.0.1
 */