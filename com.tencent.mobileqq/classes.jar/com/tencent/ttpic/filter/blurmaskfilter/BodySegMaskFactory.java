package com.tencent.ttpic.filter.blurmaskfilter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;

public class BodySegMaskFactory
  implements BlurMaskFilter.IBlurMaskFactory
{
  private int mFrameHeight;
  private int mFrameWidth;
  private GaussinNoMaskFilter mGaussinNoMaskFilter;
  private Frame tmpFrame;
  
  private void clearGaussinBlur()
  {
    if (this.mGaussinNoMaskFilter != null) {
      this.mGaussinNoMaskFilter.clear();
    }
    if (this.tmpFrame != null) {
      this.tmpFrame.clear();
    }
    this.mGaussinNoMaskFilter = null;
    this.tmpFrame = null;
  }
  
  public void apply() {}
  
  public void clear()
  {
    clearGaussinBlur();
  }
  
  public void needGaussinBlurMask(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGaussinNoMaskFilter == null) {
        this.mGaussinNoMaskFilter = new GaussinNoMaskFilter(10.0F);
      }
      this.mGaussinNoMaskFilter.applyFilterChain(false, this.mFrameWidth, this.mFrameHeight);
      if (this.tmpFrame == null) {
        this.tmpFrame = new Frame();
      }
      return;
    }
    clearGaussinBlur();
  }
  
  public void pause() {}
  
  public Frame renderMask(PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    if ((paramPTSegAttr != null) && (paramPTSegAttr.getMaskFrame() != null))
    {
      paramPTSegAttr = paramPTSegAttr.getMaskFrame();
      paramPTFaceAttr = paramPTSegAttr;
      if (this.mGaussinNoMaskFilter != null)
      {
        this.mGaussinNoMaskFilter.updateVideoSize(paramPTSegAttr.width, paramPTSegAttr.height);
        paramPTFaceAttr = this.mGaussinNoMaskFilter.RenderProcess(paramPTSegAttr, this.tmpFrame);
      }
      return paramPTFaceAttr;
    }
    if (this.tmpFrame == null) {
      this.tmpFrame = new Frame();
    }
    this.tmpFrame.bindFrame(-1, this.mFrameWidth, this.mFrameHeight, 0.0D);
    return this.tmpFrame;
  }
  
  public void resume() {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mFrameWidth = paramInt1;
    this.mFrameHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.BodySegMaskFactory
 * JD-Core Version:    0.7.0.1
 */