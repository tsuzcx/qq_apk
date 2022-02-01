package com.tencent.ttpic.openapi.filter.stylizefilter;

import com.tencent.aekit.openrender.internal.Frame;

public class BSmoothFilter
{
  private BSkinSmoothBilateralFilter mBilateralFilter = new BSkinSmoothBilateralFilter();
  private Frame mBilateralFrame;
  private BSkinSmoothProcessFilter mProcessFilter = new BSkinSmoothProcessFilter();
  
  public void clear()
  {
    this.mBilateralFilter.clearGLSLSelf();
    this.mProcessFilter.clearGLSLSelf();
    this.mBilateralFrame.clear();
  }
  
  public void initial()
  {
    this.mBilateralFilter.applyChain();
    this.mProcessFilter.applyChain();
    this.mBilateralFrame = new Frame();
  }
  
  public void updateAndRender(Frame paramFrame1, Frame paramFrame2)
  {
    this.mBilateralFilter.updateSize(paramFrame1.width, paramFrame1.height);
    this.mBilateralFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.mBilateralFrame);
    this.mProcessFilter.setTexture2(this.mBilateralFrame);
    this.mProcessFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, paramFrame2);
  }
  
  public void updateSmoothOpacity(float paramFloat)
  {
    this.mProcessFilter.updateSmoothOpacity(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.BSmoothFilter
 * JD-Core Version:    0.7.0.1
 */