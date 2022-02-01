package com.tencent.tavkit.composition.video;

import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoTransition$Filter
{
  @RenderThread
  public abstract CIImage apply(TAVVideoTransition paramTAVVideoTransition, CIImage paramCIImage1, CIImage paramCIImage2, float paramFloat, RenderInfo paramRenderInfo);
  
  @RenderThread
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoTransition.Filter
 * JD-Core Version:    0.7.0.1
 */