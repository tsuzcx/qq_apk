package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class TTBeautyV5SimpleDenoiseFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n lowp vec4 denoiseColor(sampler2D curFrameTex, sampler2D lastFrameTex) {\n     lowp vec4 curColor = texture2D(curFrameTex, textureCoordinate);\n     highp vec3 curMean = curColor.rgb;\n     highp float curLuminance = dot(curMean.rgb, luminanceWeighting);\n     \n     lowp vec4 lastColor = texture2D(lastFrameTex, textureCoordinate);\n     highp vec3 lastMean = lastColor.rgb;\n     highp float lastLuminance = dot(lastMean.rgb, luminanceWeighting);\n     \n     highp float lumDelta = abs(curLuminance - lastLuminance);\n     highp float lumWeight = 1.0 + 0.02 * lumDelta * lumDelta * 255.0 * 255.0;\n     highp float mixAlpha = lumWeight / (lumWeight + 1.5);\n     lowp vec4 resultColor = mix(lastColor, curColor, mixAlpha);\n     return resultColor;\n }\n \n void main() {\n     gl_FragColor = denoiseColor(inputImageTexture, inputImageTexture2);\n }\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }\n";
  
  public TTBeautyV5SimpleDenoiseFilter()
  {
    super("attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }\n", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n lowp vec4 denoiseColor(sampler2D curFrameTex, sampler2D lastFrameTex) {\n     lowp vec4 curColor = texture2D(curFrameTex, textureCoordinate);\n     highp vec3 curMean = curColor.rgb;\n     highp float curLuminance = dot(curMean.rgb, luminanceWeighting);\n     \n     lowp vec4 lastColor = texture2D(lastFrameTex, textureCoordinate);\n     highp vec3 lastMean = lastColor.rgb;\n     highp float lastLuminance = dot(lastMean.rgb, luminanceWeighting);\n     \n     highp float lumDelta = abs(curLuminance - lastLuminance);\n     highp float lumWeight = 1.0 + 0.02 * lumDelta * lumDelta * 255.0 * 255.0;\n     highp float mixAlpha = lumWeight / (lumWeight + 1.5);\n     lowp vec4 resultColor = mix(lastColor, curColor, mixAlpha);\n     return resultColor;\n }\n \n void main() {\n     gl_FragColor = denoiseColor(inputImageTexture, inputImageTexture2);\n }\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public void setDenoiseTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV5SimpleDenoiseFilter
 * JD-Core Version:    0.7.0.1
 */