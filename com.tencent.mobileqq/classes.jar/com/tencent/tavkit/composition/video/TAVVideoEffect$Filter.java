package com.tencent.tavkit.composition.video;

import android.support.annotation.NonNull;
import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoEffect$Filter
  extends Releasable
{
  @RenderThread
  @NonNull
  public abstract CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
 * JD-Core Version:    0.7.0.1
 */