package com.tencent.ttpic.filter;

import com.tencent.filter.Frame;

public class GuideFilterRefine
{
  private GuideFilterRefine1 mFilter1 = new GuideFilterRefine1();
  private GuideFilterRefine2 mFilter2 = new GuideFilterRefine2();
  private GuideFilterRefine3 mFilter3 = new GuideFilterRefine3();
  private Frame mFrame1 = new Frame();
  private Frame mFrame2 = new Frame();
  
  public void ApplyGLSLFilter()
  {
    this.mFilter1.ApplyGLSLFilter();
    this.mFilter2.ApplyGLSLFilter();
    this.mFilter3.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    this.mFilter1.clearGLSLSelf();
    this.mFilter2.clearGLSLSelf();
    this.mFilter3.clearGLSLSelf();
    this.mFrame1.clear();
    this.mFrame2.clear();
  }
  
  public void updateAndRender(Frame paramFrame1, Frame paramFrame2, Frame paramFrame3)
  {
    int i = paramFrame1.width;
    int j = paramFrame1.height;
    this.mFilter1.updateParams(paramFrame2.getTextureId(), i, j);
    this.mFilter1.RenderProcess(paramFrame1.getTextureId(), i, j, -1, 0.0D, this.mFrame1);
    this.mFilter2.updateParams(i, j);
    this.mFilter2.RenderProcess(this.mFrame1.getTextureId(), i, j, -1, 0.0D, this.mFrame2);
    this.mFilter3.updateParams(this.mFrame2.getTextureId());
    this.mFilter3.RenderProcess(paramFrame1.getTextureId(), i, j, -1, 0.0D, paramFrame3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.GuideFilterRefine
 * JD-Core Version:    0.7.0.1
 */