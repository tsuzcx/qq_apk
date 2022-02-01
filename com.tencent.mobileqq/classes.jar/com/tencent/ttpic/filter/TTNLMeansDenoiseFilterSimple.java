package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class TTNLMeansDenoiseFilterSimple
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvarying vec2 textureCoordinate;\nuniform vec2 textureSize;\n \nconst highp vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \nfloat patchWeight(vec4 srcColor, vec4 dstColor) {\n  float srcLuminance = dot(srcColor.rgb, luminanceWeighting);\n  float dstLuminance = dot(dstColor.rgb, luminanceWeighting);\n  float delta = (dstLuminance - srcLuminance) * 255.0;\n  float dist = abs(delta);\n  float weight = exp(-dist / 8.0);\n  return weight;\n}\n \nvoid main() {\n  vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n  vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n  if (maskColor.r < 0.01) {\n    gl_FragColor = iColor;\n  } else {\n    float pixelWidth = 1.0 / textureSize.x;\n    float pixelHeight = 1.0 / textureSize.y;\n    vec3 average = vec3(0.0);\n    float sweight = 0.0;\n    for (float r=-4.0; r<=4.1; ++r) {\n      for (float s=-4.0; s<=4.1; ++s) {\n        vec2 searchPixel = textureCoordinate + vec2(r * pixelWidth, s * pixelHeight);\n        vec4 searchColor = texture2D(inputImageTexture, searchPixel);\n        float searchWeight = patchWeight(iColor, searchColor);\n        sweight += searchWeight;\n        average += searchColor.rgb * searchWeight;\n      }\n    }\n    vec3 resultColor = mix(iColor.rgb, average.rgb/sweight, maskColor.r);\n    gl_FragColor = vec4(resultColor, iColor.a);\n  }\n}\n";
  
  public TTNLMeansDenoiseFilterSimple()
  {
    super("precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvarying vec2 textureCoordinate;\nuniform vec2 textureSize;\n \nconst highp vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \nfloat patchWeight(vec4 srcColor, vec4 dstColor) {\n  float srcLuminance = dot(srcColor.rgb, luminanceWeighting);\n  float dstLuminance = dot(dstColor.rgb, luminanceWeighting);\n  float delta = (dstLuminance - srcLuminance) * 255.0;\n  float dist = abs(delta);\n  float weight = exp(-dist / 8.0);\n  return weight;\n}\n \nvoid main() {\n  vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n  vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n  if (maskColor.r < 0.01) {\n    gl_FragColor = iColor;\n  } else {\n    float pixelWidth = 1.0 / textureSize.x;\n    float pixelHeight = 1.0 / textureSize.y;\n    vec3 average = vec3(0.0);\n    float sweight = 0.0;\n    for (float r=-4.0; r<=4.1; ++r) {\n      for (float s=-4.0; s<=4.1; ++s) {\n        vec2 searchPixel = textureCoordinate + vec2(r * pixelWidth, s * pixelHeight);\n        vec4 searchColor = texture2D(inputImageTexture, searchPixel);\n        float searchWeight = patchWeight(iColor, searchColor);\n        sweight += searchWeight;\n        average += searchColor.rgb * searchWeight;\n      }\n    }\n    vec3 resultColor = mix(iColor.rgb, average.rgb/sweight, maskColor.r);\n    gl_FragColor = vec4(resultColor, iColor.a);\n  }\n}\n");
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.Float2fParam("textureSize", 0.001388889F, 0.001041667F));
  }
  
  public void updateSize(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.Float2fParam("textureSize", paramFloat1, paramFloat2));
  }
  
  public void updateTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.TTNLMeansDenoiseFilterSimple
 * JD-Core Version:    0.7.0.1
 */