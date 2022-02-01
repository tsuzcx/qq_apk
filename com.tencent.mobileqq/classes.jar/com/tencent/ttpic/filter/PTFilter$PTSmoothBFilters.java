package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.GPUImageTwoInputHighPassFilter;
import com.tencent.ttpic.openapi.filter.SmoothBClarifyFilter;
import com.tencent.ttpic.openapi.filter.SmoothBLargeBlurFilter;
import com.tencent.ttpic.openapi.filter.SmoothBProcessFilter;
import com.tencent.ttpic.openapi.filter.SmoothBVarianceFilter;
import com.tencent.ttpic.util.FrameUtil;

public class PTFilter$PTSmoothBFilters
  extends PTFilter
{
  private SmoothBLargeBlurFilter mBigBlurFilter = new SmoothBLargeBlurFilter();
  private Frame mBigBlurFrame1 = new Frame();
  private BoxFilterWithRadius mBoxFilter = new BoxFilterWithRadius();
  private Frame mBoxFrame1 = new Frame();
  private Frame mBoxFrame1_1 = new Frame();
  private Frame mBoxFrame2 = new Frame();
  private Frame mBoxFrame2_1 = new Frame();
  private Frame mBoxFrame3 = new Frame();
  private SmoothBClarifyFilter mClarityFilter = new SmoothBClarifyFilter();
  private Frame mClarityFrame1 = new Frame();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private GPUImageTwoInputHighPassFilter mHighPassFilter = new GPUImageTwoInputHighPassFilter();
  private Frame mHighPassFrame = new Frame();
  private SmoothBProcessFilter mProcessVarianceFilter = new SmoothBProcessFilter();
  private SmoothBProcessFilter mProcessVarianceFilter2 = new SmoothBProcessFilter();
  private Frame mProcessVarianceFrame1 = new Frame();
  private SmoothBVarianceFilter mVarianceFilter = new SmoothBVarianceFilter();
  private SmoothBVarianceFilter mVarianceFilter2 = new SmoothBVarianceFilter();
  private Frame mVarianceFrame1 = new Frame();
  private Frame mVarianceFrame1_1 = new Frame();
  private Frame outputFrame = new Frame();
  
  public void destroy()
  {
    this.mClarityFilter.clearGLSL();
    this.mBigBlurFilter.clearGLSL();
    this.mVarianceFilter.clearGLSL();
    this.mVarianceFilter2.clearGLSL();
    this.mBoxFilter.clearGLSL();
    this.mProcessVarianceFilter.clearGLSL();
    this.mProcessVarianceFilter2.clearGLSL();
    this.mHighPassFilter.clearGLSL();
    this.mCopyFilter.clearGLSL();
    this.mBoxFrame1.clear();
    this.mBoxFrame1_1.clear();
    this.mVarianceFrame1.clear();
    this.mVarianceFrame1_1.clear();
    this.mProcessVarianceFrame1.clear();
    this.mBoxFrame2.clear();
    this.mBoxFrame2_1.clear();
    this.mBoxFrame3.clear();
    this.mBigBlurFrame1.clear();
    this.mClarityFrame1.clear();
    this.mHighPassFrame.clear();
    this.outputFrame.clear();
    super.destroy();
  }
  
  public int init()
  {
    int i = super.init();
    this.mClarityFilter.apply();
    this.mBigBlurFilter.apply();
    this.mVarianceFilter.apply();
    this.mVarianceFilter2.apply();
    this.mBoxFilter.applyFilterChain(true, 0.0F, 0.0F);
    this.mProcessVarianceFilter.apply();
    this.mProcessVarianceFilter2.apply();
    this.mHighPassFilter.apply();
    this.mCopyFilter.apply();
    return i;
  }
  
  public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
  {
    if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01F)
    {
      paramInt1 = paramFrame.height * 360 / paramFrame.width;
      this.mBoxFilter.updateParam(360, paramInt1);
      this.mBoxFilter.RenderProcess(paramFrame.getTextureId(), 360, paramInt1, -1, 0.0D, this.mBoxFrame1);
      this.mVarianceFilter2.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).getTextureId());
      this.mVarianceFilter2.RenderProcess(paramFrame.getTextureId(), 360, paramInt1, -1, 0.0D, this.mVarianceFrame1);
      this.mBoxFilter.updateParam(360, paramInt1);
      this.mBoxFilter.RenderProcess(this.mVarianceFrame1.getTextureId(), 360, paramInt1, -1, 0.0D, this.mBoxFrame2);
      this.mProcessVarianceFilter2.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).getTextureId(), FrameUtil.getLastRenderFrame(this.mBoxFrame2).getTextureId());
      this.mProcessVarianceFilter2.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.outputFrame);
    }
    for (;;)
    {
      return this.outputFrame;
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.outputFrame);
    }
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    this.mProcessVarianceFilter.updateBlurAlpha(0.8F * paramFloat);
    this.mProcessVarianceFilter2.updateBlurAlpha(0.8F * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTFilter.PTSmoothBFilters
 * JD-Core Version:    0.7.0.1
 */