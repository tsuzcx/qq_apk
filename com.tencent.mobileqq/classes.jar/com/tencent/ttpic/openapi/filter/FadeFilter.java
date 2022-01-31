package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.TextureResParam;
import com.tencent.filter.ttpic.GPUImageLookupFilter;

public class FadeFilter
  extends GPUImageLookupFilter
{
  private float mAlpha = 1.0F;
  
  public FadeFilter()
  {
    addParam(new TextureResParam("inputImageTexture2", "sh/fade_effect.png", 33986));
    addParam(new UniformParam.FloatParam("alpha", this.mAlpha));
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mAlpha = (1.0F - paramFloat);
    addParam(new UniformParam.FloatParam("alpha", this.mAlpha));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FadeFilter
 * JD-Core Version:    0.7.0.1
 */