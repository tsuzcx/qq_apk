package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.ParamHelper;
import com.tencent.filter.ParamHelper.ParamType;

public class AlphaAdjustFilter
  extends BaseFilter
{
  private static String FRAGMENT = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float filterAdjustParam;\n void main()\n {\n     vec4 c2 = texture2D(inputImageTexture2, textureCoordinate.xy);\n     vec4 c1 = texture2D(inputImageTexture, textureCoordinate.xy);\n     gl_FragColor = mix(c1,c2,filterAdjustParam);\n}\n";
  
  public AlphaAdjustFilter()
  {
    super(FRAGMENT);
    initParams();
    this.mParamHelper = new ParamHelper(this).addParam("strength", "filterAdjustParam", ParamHelper.ParamType.Float);
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.FloatParam("filterAdjustParam", 1.0F));
  }
  
  public void setAdjustParam(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("filterAdjustParam", paramFloat));
  }
  
  public void setFilterTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.AlphaAdjustFilter
 * JD-Core Version:    0.7.0.1
 */