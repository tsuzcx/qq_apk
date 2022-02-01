package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.ttpic.EffectBlendFilter;
import com.tencent.filter.ttpic.EffectBlurFilter;

public class BlurEffectFilter
  extends AEChainI
{
  private EffectBlendFilter mBlendFilter = new EffectBlendFilter();
  private Frame mBlendFrame = new Frame();
  private EffectBlurFilter mBlurFilter = new EffectBlurFilter();
  private Frame mBlurFrame1 = new Frame();
  private Frame mBlurFrame2 = new Frame();
  private double mStrength;
  
  public void applyGLSLFilter()
  {
    this.mBlurFilter.apply();
    this.mBlendFilter.apply();
  }
  
  public void clearGLSL()
  {
    this.mBlurFilter.clearGLSLSelf();
    this.mBlendFilter.clearGLSLSelf();
    this.mBlurFrame1.clear();
    this.mBlurFrame2.clear();
    this.mBlendFrame.clear();
  }
  
  public double getStrength()
  {
    return this.mStrength;
  }
  
  public Frame render(Frame paramFrame)
  {
    return renderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public Frame renderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3 * 300 / paramInt2;
    this.mBlurFilter.updateTextureSize(1.0F / 300, 0.0F);
    this.mBlurFilter.RenderProcess(paramInt1, 300, i, -1, 0.0D, this.mBlurFrame1);
    this.mBlurFilter.updateTextureSize(0.0F, 1.0F / i);
    this.mBlurFilter.RenderProcess(this.mBlurFrame1.getTextureId(), 300, i, -1, 0.0D, this.mBlurFrame2);
    this.mBlendFilter.updateTexture(paramInt1);
    this.mBlendFilter.RenderProcess(this.mBlurFrame2.getTextureId(), paramInt2, paramInt3, -1, 0.0D, this.mBlendFrame);
    return this.mBlendFrame;
  }
  
  public void updateFilterBlurStrength(double paramDouble)
  {
    this.mStrength = paramDouble;
    this.mBlendFilter.updateAlpha((float)paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BlurEffectFilter
 * JD-Core Version:    0.7.0.1
 */