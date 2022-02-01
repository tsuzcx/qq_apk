package com.tencent.tavkit.composition.video;

import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoTransition$Filter
  extends Releasable
{
  @RenderThread
  public abstract CIImage apply(TAVVideoTransition paramTAVVideoTransition, CIImage paramCIImage1, CIImage paramCIImage2, float paramFloat, RenderInfo paramRenderInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoTransition.Filter
 * JD-Core Version:    0.7.0.1
 */