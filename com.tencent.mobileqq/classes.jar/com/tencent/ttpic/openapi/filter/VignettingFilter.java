package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

public class VignettingFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n varying vec2 textureCoordinate;\n uniform float alpha;\n \n void main()\n {\n     vec4 origin = texture2D(inputImageTexture, textureCoordinate);\n     vec4 dark = texture2D(inputImageTexture2, textureCoordinate);\n     float darkGray = dot(dark.rgb, vec3(0.299, 0.587, 0.114));\n     float factor = 0.75;\n    \n     vec3 result = clamp(origin.rgb * darkGray, vec3(0.0), vec3(1.0));\n     gl_FragColor = mix(origin, vec4(result, origin.a), alpha * factor);\n }\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = position.xy * 0.5 + 0.5;\n }\n";
  
  public VignettingFilter()
  {
    super("attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = position.xy * 0.5 + 0.5;\n }\n", "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n varying vec2 textureCoordinate;\n uniform float alpha;\n \n void main()\n {\n     vec4 origin = texture2D(inputImageTexture, textureCoordinate);\n     vec4 dark = texture2D(inputImageTexture2, textureCoordinate);\n     float darkGray = dot(dark.rgb, vec3(0.299, 0.587, 0.114));\n     float factor = 0.75;\n    \n     vec3 result = clamp(origin.rgb * darkGray, vec3(0.0), vec3(1.0));\n     gl_FragColor = mix(origin, vec4(result, origin.a), alpha * factor);\n }\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("alpha", 0.0F));
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), "raw/sh/darkcornermask_revert.png", 1), 33986, true));
  }
  
  public void setAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VignettingFilter
 * JD-Core Version:    0.7.0.1
 */