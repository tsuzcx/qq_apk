package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class TTNLMeansMixFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n varying vec2 textureCoordinate;\n uniform float mixpercent;\n\n void main() {\n     vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 denoiseColor = texture2D(inputImageTexture3, textureCoordinate);\n     vec4 resultColor = mix(iColor, denoiseColor, maskColor.r * mixpercent);\n     gl_FragColor = vec4(resultColor.rgb, iColor.a);\n }\n";
  private float mixpercent = 0.5F;
  
  public TTNLMeansMixFilter()
  {
    super("precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n varying vec2 textureCoordinate;\n uniform float mixpercent;\n\n void main() {\n     vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 denoiseColor = texture2D(inputImageTexture3, textureCoordinate);\n     vec4 resultColor = mix(iColor, denoiseColor, maskColor.r * mixpercent);\n     gl_FragColor = vec4(resultColor.rgb, iColor.a);\n }\n");
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.FloatParam("mixpercent", this.mixpercent));
  }
  
  public void setDenoiseTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
  }
  
  public void setMaskTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.TTNLMeansMixFilter
 * JD-Core Version:    0.7.0.1
 */