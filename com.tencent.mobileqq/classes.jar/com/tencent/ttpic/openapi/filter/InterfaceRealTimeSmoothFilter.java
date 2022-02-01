package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTFaceAttr;

public abstract interface InterfaceRealTimeSmoothFilter
{
  public abstract void clear();
  
  public abstract void initial();
  
  public abstract void setRenderMode(int paramInt);
  
  public abstract void setSharpenFactor(float paramFloat);
  
  public abstract void setSharpenSize(int paramInt1, int paramInt2);
  
  public abstract Frame updateAndRender(Frame paramFrame, PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void updateBlurAlpha(float paramFloat);
  
  public abstract void updateBlurAlphaValue(float paramFloat);
  
  public abstract void updateFemalePercent(float paramFloat);
  
  public abstract void updateLastFrameForDenoise(Frame paramFrame);
  
  public abstract void updateMalePercent(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.InterfaceRealTimeSmoothFilter
 * JD-Core Version:    0.7.0.1
 */