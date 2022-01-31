package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.ParamHelper;
import com.tencent.filter.ParamHelper.ParamType;

public class IOSSharpenFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\n \n varying highp vec2 textureCoordinate;\n varying highp vec2 leftTextureCoordinate;\n varying highp vec2 rightTextureCoordinate; \n varying highp vec2 topTextureCoordinate;\n varying highp vec2 bottomTextureCoordinate;\n \n varying highp float centerMultiplier;\n varying highp float edgeMultiplier;\n\n uniform sampler2D inputImageTexture;\n \n void main()\n {\n     mediump vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n     mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n     mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n     mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n     mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n\n     gl_FragColor = vec4((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), texture2D(inputImageTexture, bottomTextureCoordinate).w);\n }";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform float imageWidthFactor; \n uniform float imageHeightFactor; \n uniform float sharpness;\n \n varying vec2 textureCoordinate;\n varying vec2 leftTextureCoordinate;\n varying vec2 rightTextureCoordinate; \n varying vec2 topTextureCoordinate;\n varying vec2 bottomTextureCoordinate;\n \n varying float centerMultiplier;\n varying float edgeMultiplier;\n \n void main()\n {\n     gl_Position = position;\n     \n     mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);\n     mediump vec2 heightStep = vec2(0.0, imageHeightFactor);\n     \n     textureCoordinate = inputTextureCoordinate.xy;\n     leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n     rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n     topTextureCoordinate = inputTextureCoordinate.xy + heightStep;     \n     bottomTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n     \n     centerMultiplier = 1.0 + 4.0 * sharpness;\n     edgeMultiplier = sharpness;\n }";
  
  public IOSSharpenFilter()
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform float imageWidthFactor; \n uniform float imageHeightFactor; \n uniform float sharpness;\n \n varying vec2 textureCoordinate;\n varying vec2 leftTextureCoordinate;\n varying vec2 rightTextureCoordinate; \n varying vec2 topTextureCoordinate;\n varying vec2 bottomTextureCoordinate;\n \n varying float centerMultiplier;\n varying float edgeMultiplier;\n \n void main()\n {\n     gl_Position = position;\n     \n     mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);\n     mediump vec2 heightStep = vec2(0.0, imageHeightFactor);\n     \n     textureCoordinate = inputTextureCoordinate.xy;\n     leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n     rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n     topTextureCoordinate = inputTextureCoordinate.xy + heightStep;     \n     bottomTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n     \n     centerMultiplier = 1.0 + 4.0 * sharpness;\n     edgeMultiplier = sharpness;\n }", "precision highp float;\n \n varying highp vec2 textureCoordinate;\n varying highp vec2 leftTextureCoordinate;\n varying highp vec2 rightTextureCoordinate; \n varying highp vec2 topTextureCoordinate;\n varying highp vec2 bottomTextureCoordinate;\n \n varying highp float centerMultiplier;\n varying highp float edgeMultiplier;\n\n uniform sampler2D inputImageTexture;\n \n void main()\n {\n     mediump vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n     mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n     mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n     mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n     mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n\n     gl_FragColor = vec4((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), texture2D(inputImageTexture, bottomTextureCoordinate).w);\n }");
    initParams();
    this.mParamHelper = new ParamHelper(this).addParam("sharpness", ParamHelper.ParamType.Float);
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("imageWidthFactor", 0.0F));
    addParam(new UniformParam.FloatParam("imageHeightFactor", 0.0F));
    addParam(new UniformParam.FloatParam("sharpness", 0.0F));
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeRender(paramInt1, paramInt2, paramInt3);
    updateSize(paramInt2, paramInt3);
  }
  
  public void setSharpness(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("sharpness", paramFloat));
  }
  
  public void updateSize(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.FloatParam("imageWidthFactor", 1.0F / paramInt1));
    addParam(new UniformParam.FloatParam("imageHeightFactor", 1.0F / paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.IOSSharpenFilter
 * JD-Core Version:    0.7.0.1
 */