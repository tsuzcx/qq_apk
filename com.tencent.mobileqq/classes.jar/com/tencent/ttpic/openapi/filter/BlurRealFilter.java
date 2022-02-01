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
    float f = this.mRadiusInPixels;
    int i;
    if (f >= 1.0F)
    {
      double d1 = Math.pow(f, 2.0D);
      double d2 = 0.0039063F;
      double d3 = Math.sqrt(Math.pow(this.mRadiusInPixels, 2.0D) * 6.283185307179586D);
      Double.isNaN(d2);
      i = (int)Math.floor(Math.sqrt(d1 * -2.0D * Math.log(d2 * d3)));
      i += i % 2;
    }
    else
    {
      i = 0;
    }
    this.horizontal = new BaseFilter(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i, this.mRadiusInPixels, true));
    this.vertical = new BaseFilter(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i, this.mRadiusInPixels, false));
    setNextFilter(this.horizontal, null);
    this.horizontal.setNextFilter(this.vertical, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BlurRealFilter
 * JD-Core Version:    0.7.0.1
 */