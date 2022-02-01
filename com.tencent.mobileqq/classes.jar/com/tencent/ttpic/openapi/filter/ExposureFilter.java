package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class ExposureFilter
  extends BaseFilter
{
  private static final float EXPOSURE_MAX = 1.5F;
  private static final float EXPOSURE_MIN = -2.0F;
  private static final String FRAG_SHADER = " precision mediump float;\n varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform lowp float exposure;\n void main()\n {\n     vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(textureColor.rgb * pow(1.41, exposure), textureColor.a);\n }";
  private float mExposure = 0.0F;
  
  public ExposureFilter()
  {
    super(" precision mediump float;\n varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform lowp float exposure;\n void main()\n {\n     vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(textureColor.rgb * pow(1.41, exposure), textureColor.a);\n }");
    setExposureValue(0.0F);
  }
  
  private float transLevel2Value(float paramFloat)
  {
    float f;
    if (paramFloat < 50.0F) {
      f = (paramFloat - 50.0F) / 50.0F;
    }
    for (paramFloat = Math.abs(-2.0F);; paramFloat = Math.abs(1.5F))
    {
      return f * paramFloat;
      f = (paramFloat - 50.0F) / 50.0F;
    }
  }
  
  public boolean needRender()
  {
    return Math.abs(this.mExposure) > 0.01F;
  }
  
  public void setExposureLevel(float paramFloat)
  {
    setExposureValue(transLevel2Value(paramFloat));
  }
  
  public void setExposureValue(float paramFloat)
  {
    paramFloat = Math.max(Math.min(paramFloat, 1.5F), -2.0F);
    this.mExposure = paramFloat;
    addParam(new UniformParam.FloatParam("exposure", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.ExposureFilter
 * JD-Core Version:    0.7.0.1
 */