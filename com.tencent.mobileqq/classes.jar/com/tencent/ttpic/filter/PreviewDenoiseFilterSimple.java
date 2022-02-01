package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class PreviewDenoiseFilterSimple
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform sampler2D inputImageTexture4;\n uniform lowp float blurAlpha;\n \n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n lowp vec4 denoiseColor(sampler2D curFrameTex, sampler2D lastFrameTex) {\n     lowp vec4 curColor = texture2D(curFrameTex, textureCoordinate);\n     highp float curLuminance = dot(curColor.rgb, luminanceWeighting);\n     \n     lowp vec4 lastColor = texture2D(lastFrameTex, textureCoordinate);\n     highp float lastLuminance = dot(lastColor.rgb, luminanceWeighting);\n     \n     highp float lumDelta = abs(curLuminance - lastLuminance);\n     highp float lumWeight = 1.0 + 0.02 * lumDelta * lumDelta * 255.0 * 255.0;\n     highp float mixAlpha = lumWeight / (lumWeight + 1.5);\n     lowp vec4 resultColor = mix(lastColor, curColor, mixAlpha);\n     return resultColor;\n }\n \n void main() {\n     lowp vec4 iColor = denoiseColor(inputImageTexture, inputImageTexture4);\n     lowp vec4 meanColor = texture2D(inputImageTexture2, textureCoordinate);\n     lowp vec4 varColor = texture2D(inputImageTexture3, textureCoordinate);\n     \n     mediump float kMin = 1.0 - varColor.g;\n     lowp vec3 smoothColor = mix(iColor.rgb, meanColor.rgb, blurAlpha * 0.72 * kMin);\n     \n     gl_FragColor = vec4(smoothColor, iColor.a);\n }";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform float stepX;\n uniform float stepY;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  private float blurAlpha = 0.5F;
  
  public PreviewDenoiseFilterSimple()
  {
    super("attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform float stepX;\n uniform float stepY;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", "varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform sampler2D inputImageTexture4;\n uniform lowp float blurAlpha;\n \n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n lowp vec4 denoiseColor(sampler2D curFrameTex, sampler2D lastFrameTex) {\n     lowp vec4 curColor = texture2D(curFrameTex, textureCoordinate);\n     highp float curLuminance = dot(curColor.rgb, luminanceWeighting);\n     \n     lowp vec4 lastColor = texture2D(lastFrameTex, textureCoordinate);\n     highp float lastLuminance = dot(lastColor.rgb, luminanceWeighting);\n     \n     highp float lumDelta = abs(curLuminance - lastLuminance);\n     highp float lumWeight = 1.0 + 0.02 * lumDelta * lumDelta * 255.0 * 255.0;\n     highp float mixAlpha = lumWeight / (lumWeight + 1.5);\n     lowp vec4 resultColor = mix(lastColor, curColor, mixAlpha);\n     return resultColor;\n }\n \n void main() {\n     lowp vec4 iColor = denoiseColor(inputImageTexture, inputImageTexture4);\n     lowp vec4 meanColor = texture2D(inputImageTexture2, textureCoordinate);\n     lowp vec4 varColor = texture2D(inputImageTexture3, textureCoordinate);\n     \n     mediump float kMin = 1.0 - varColor.g;\n     lowp vec3 smoothColor = mix(iColor.rgb, meanColor.rgb, blurAlpha * 0.72 * kMin);\n     \n     gl_FragColor = vec4(smoothColor, iColor.a);\n }");
    initParams();
  }
  
  public float getBlurAlpha()
  {
    return this.blurAlpha;
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("blurAlpha", this.blurAlpha));
    addParam(new UniformParam.FloatParam("stepX", 0.002777778F));
    addParam(new UniformParam.FloatParam("stepY", 0.002083333F));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    this.blurAlpha = paramFloat;
    addParam(new UniformParam.FloatParam("blurAlpha", paramFloat));
  }
  
  public void updateSize(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("stepX", 1.0F / paramFloat1));
    addParam(new UniformParam.FloatParam("stepY", 1.0F / paramFloat2));
  }
  
  public void updateTextures(int paramInt1, int paramInt2, int paramInt3)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt1, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt2, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture4", paramInt3, 33988));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.PreviewDenoiseFilterSimple
 * JD-Core Version:    0.7.0.1
 */