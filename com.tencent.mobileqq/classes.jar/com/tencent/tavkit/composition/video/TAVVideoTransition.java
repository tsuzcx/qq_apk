package com.tencent.tavkit.composition.video;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;

public abstract interface TAVVideoTransition
{
  @RenderThread
  public abstract TAVVideoTransition.Filter createFilter();
  
  @Nullable
  public abstract String effectId();
  
  public abstract CMTime getDuration();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoTransition
 * JD-Core Version:    0.7.0.1
 */