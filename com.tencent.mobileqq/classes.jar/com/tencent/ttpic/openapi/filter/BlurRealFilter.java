package com.tencent.ttpic.openapi.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.ttpic.HFGPUShaderFactory;

public class BlurRealFilter
  extends BaseFilter
{
  private BaseFilter horizontal = null;
  private float mRadiusInPixels = 1.0F;
  private int previewHeight;
  private int previewWidth;
  private BaseFilter vertical = null;
  
  public BlurRealFilter(float paramFloat)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.mRadiusInPixels = paramFloat;
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.previewWidth = ((int)paramFloat1);
    this.previewHeight = ((int)paramFloat2);
    int i = 0;
    if (this.mRadiusInPixels >= 1.0F)
    {
      double d = Math.pow(this.mRadiusInPixels, 2.0D);
      i = (int)Math.floor(Math.sqrt(Math.log(0.0039063F * Math.sqrt(6.283185307179586D * Math.pow(this.mRadiusInPixels, 2.0D))) * (-2.0D * d)));
      i += i % 2;
    }
    this.horizontal = new BaseFilter(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i, this.mRadiusInPixels, true));
    this.vertical = new BaseFilter(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i, this.mRadiusInPixels, false));
    setNextFilter(this.horizontal, null);
    this.horizontal.setNextFilter(this.vertical, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BlurRealFilter
 * JD-Core Version:    0.7.0.1
 */