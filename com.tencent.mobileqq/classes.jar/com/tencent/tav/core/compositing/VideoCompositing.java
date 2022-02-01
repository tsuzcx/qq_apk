package com.tencent.tav.core.compositing;

import java.util.HashMap;

public abstract interface VideoCompositing
{
  public abstract void cancelAllPendingVideoCompositionRequests();
  
  public abstract void release();
  
  public abstract void renderContextChanged(VideoCompositionRenderContext paramVideoCompositionRenderContext);
  
  public abstract HashMap<String, Object> requiredPixelBufferAttributesForRenderContext();
  
  public abstract HashMap<String, Object> sourcePixelBufferAttributes();
  
  public abstract void startVideoCompositionRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.compositing.VideoCompositing
 * JD-Core Version:    0.7.0.1
 */