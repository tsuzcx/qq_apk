package com.tencent.tavkit.composition.video;

import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoMixEffect$Filter
  extends Releasable
{
  @RenderThread
  public abstract CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
 * JD-Core Version:    0.7.0.1
 */