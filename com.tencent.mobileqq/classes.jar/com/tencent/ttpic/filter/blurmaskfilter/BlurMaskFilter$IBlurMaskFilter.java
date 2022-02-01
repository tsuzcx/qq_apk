package com.tencent.ttpic.filter.blurmaskfilter;

import com.tencent.aekit.openrender.internal.Frame;

public abstract interface BlurMaskFilter$IBlurMaskFilter
{
  public abstract Frame RenderProcess(Frame paramFrame1, Frame paramFrame2);
  
  public abstract void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2);
  
  public abstract void clear();
  
  public abstract void setMaskTextureId(int paramInt);
  
  public abstract void updateVideoSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.BlurMaskFilter.IBlurMaskFilter
 * JD-Core Version:    0.7.0.1
 */