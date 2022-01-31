package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.ttpic.EffectBlendFilter;
import com.tencent.filter.ttpic.EffectBlurFilter;

public class BlurEffectForMultiConnect
  extends BaseFilter
{
  private EffectBlendFilter mBlendFilter = new EffectBlendFilter();
  private Frame mBlendFrame = new Frame();
  private EffectBlurFilter mBlurFilter = new EffectBlurFilter();
  private Frame mBlurFrame1 = new Frame();
  private Frame mBlurFrame2 = new Frame();
  
  public BlurEffectForMultiConnect()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void ClearGLSL()
  {
    this.mBlurFilter.clearGLSLSelf();
    this.mBlendFilter.clearGLSLSelf();
    this.mBlurFrame1.clear();
    this.mBlurFrame2.clear();
    this.mBlendFrame.clear();
    super.ClearGLSL();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.mBlurFilter.apply();
    this.mBlendFilter.apply();
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeRender(paramInt1, paramInt2, paramInt3);
    if ((paramInt2 <= 0) || (paramInt3 <= 0)) {
      return;
    }
    int i = paramInt3 * 400 / paramInt2;
    this.mBlurFilter.updateTextureSize(1.0F / 400, 0.0F);
    this.mBlurFilter.RenderProcess(paramInt1, 400, i, -1, 0.0D, this.mBlurFrame1);
    this.mBlurFilter.updateTextureSize(0.0F, 1.0F / i);
    this.mBlurFilter.RenderProcess(this.mBlurFrame1.getTextureId(), 400, i, -1, 0.0D, this.mBlurFrame2);
    this.mBlendFilter.updateTexture(paramInt1);
    this.mBlendFilter.RenderProcess(this.mBlurFrame2.getTextureId(), paramInt2, paramInt3, -1, 0.0D, this.mBlendFrame);
  }
  
  public void clearGLSLSelf()
  {
    this.mBlurFilter.clearGLSLSelf();
    this.mBlendFilter.clearGLSLSelf();
    this.mBlurFrame1.clear();
    this.mBlurFrame2.clear();
    this.mBlendFrame.clear();
    super.clearGLSLSelf();
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mBlendFrame.getTextureId() > 0) {
      return super.renderTexture(this.mBlendFrame.getTextureId(), paramInt2, paramInt3);
    }
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void updateFilterBlurStrength(double paramDouble)
  {
    this.mBlendFilter.updateAlpha((float)paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BlurEffectForMultiConnect
 * JD-Core Version:    0.7.0.1
 */