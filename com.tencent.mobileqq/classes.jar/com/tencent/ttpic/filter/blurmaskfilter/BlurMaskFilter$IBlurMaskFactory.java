package com.tencent.ttpic.filter.blurmaskfilter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;

public abstract interface BlurMaskFilter$IBlurMaskFactory
{
  public abstract void apply();
  
  public abstract void clear();
  
  public abstract void pause();
  
  public abstract Frame renderMask(PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr);
  
  public abstract void resume();
  
  public abstract void updateVideoSize(int paramInt1, int paramInt2, double paramDouble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.BlurMaskFilter.IBlurMaskFactory
 * JD-Core Version:    0.7.0.1
 */