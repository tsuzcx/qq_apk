package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.ClarityMaskFilter;
import com.tencent.ttpic.openapi.filter.SmoothSharpenFilter;

public class PTFilter$PTClarityMaskFilter
  extends PTFilter
{
  private boolean hasApply = false;
  private ClarityMaskFilter mClarityMaskFilter = new ClarityMaskFilter();
  private Frame mClarityMaskFrame = new Frame();
  private SmoothSharpenFilter mSmoothSharpenFilter = new SmoothSharpenFilter();
  private Frame mSmoothSharpenFrame = new Frame();
  
  public void destroy()
  {
    this.mClarityMaskFilter.clearGLSLSelf();
    this.mSmoothSharpenFilter.clearGLSLSelf();
    this.mClarityMaskFrame.clear();
    this.mSmoothSharpenFrame.clear();
    this.hasApply = false;
    super.destroy();
  }
  
  public int init()
  {
    return super.init();
  }
  
  public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
  {
    if (!this.hasApply)
    {
      this.mClarityMaskFilter.applyFilterChain(true, paramInt1, paramInt2);
      this.mSmoothSharpenFilter.applyFilterChain(true, paramInt1, paramInt2);
      this.hasApply = true;
    }
    paramInt1 = paramFrame.height * 720 / paramFrame.width;
    this.mClarityMaskFilter.updateSize(720, paramInt1);
    this.mClarityMaskFilter.RenderProcess(paramFrame.getTextureId(), 720, paramInt1, -1, 0.0D, this.mClarityMaskFrame);
    this.mSmoothSharpenFilter.updateTexture(this.mClarityMaskFrame.getTextureId());
    this.mSmoothSharpenFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mSmoothSharpenFrame);
    return this.mSmoothSharpenFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTFilter.PTClarityMaskFilter
 * JD-Core Version:    0.7.0.1
 */