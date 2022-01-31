package com.tencent.tavkit.composition.video;

import android.support.annotation.NonNull;
import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoEffect$Filter
{
  @RenderThread
  @NonNull
  public abstract CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo);
  
  @RenderThread
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
 * JD-Core Version:    0.7.0.1
 */