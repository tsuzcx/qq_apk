package com.tencent.tavkit.composition.video;

import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoMixEffect$Filter
{
  @RenderThread
  public abstract CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo);
  
  @RenderThread
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
 * JD-Core Version:    0.7.0.1
 */