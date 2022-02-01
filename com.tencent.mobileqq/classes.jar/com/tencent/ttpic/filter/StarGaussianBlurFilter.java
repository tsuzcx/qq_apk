package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class StarGaussianBlurFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n    \nuniform sampler2D   inputImageTexture;\nvarying vec2        textureCoordinate;\nvarying highp vec2 blurCoordinates[11]; \n \nvoid main() {\n  lowp vec4 sum = vec4(0.0); \n  sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.100590; \n  sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.186265; \n  sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.186265; \n  sum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.136940; \n  sum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.136940; \n  sum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.078710; \n  sum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.078710; \n  sum += texture2D(inputImageTexture, blurCoordinates[7]) * 0.035367; \n  sum += texture2D(inputImageTexture, blurCoordinates[8]) * 0.035367; \n  sum += texture2D(inputImageTexture, blurCoordinates[9]) * 0.012422; \n  sum += texture2D(inputImageTexture, blurCoordinates[10]) * 0.012422;\n  gl_FragColor = sum;\n}";
  private static String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nprecision highp float; \n \nuniform float texelWidth; \nuniform float texelHeight; \n      \nvarying vec2 blurCoordinates[11]; \n \nvoid main() \n{ \n    gl_Position = position; \n \n    vec2 singleStepOffset = vec2(texelWidth, texelHeight); \n     \n    textureCoordinate = inputTextureCoordinate.xy; \n     \n    blurCoordinates[0] = inputTextureCoordinate.xy; \n    blurCoordinates[1] = inputTextureCoordinate.xy + singleStepOffset * 1.476580; \n    blurCoordinates[2] = inputTextureCoordinate.xy - singleStepOffset * 1.476580; \n    blurCoordinates[3] = inputTextureCoordinate.xy + singleStepOffset * 3.445529; \n    blurCoordinates[4] = inputTextureCoordinate.xy - singleStepOffset * 3.445529; \n    blurCoordinates[5] = inputTextureCoordinate.xy + singleStepOffset * 5.414899; \n    blurCoordinates[6] = inputTextureCoordinate.xy - singleStepOffset * 5.414899; \n    blurCoordinates[7] = inputTextureCoordinate.xy + singleStepOffset * 7.384912; \n    blurCoordinates[8] = inputTextureCoordinate.xy - singleStepOffset * 7.384912; \n    blurCoordinates[9] = inputTextureCoordinate.xy + singleStepOffset * 9.355775; \n    blurCoordinates[10] = inputTextureCoordinate.xy - singleStepOffset * 9.355775; \n}";
  private BaseFilter mVerticalFilter = new BaseFilter(VERTEX_SHADER, "precision highp float;\n    \nuniform sampler2D   inputImageTexture;\nvarying vec2        textureCoordinate;\nvarying highp vec2 blurCoordinates[11]; \n \nvoid main() {\n  lowp vec4 sum = vec4(0.0); \n  sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.100590; \n  sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.186265; \n  sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.186265; \n  sum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.136940; \n  sum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.136940; \n  sum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.078710; \n  sum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.078710; \n  sum += texture2D(inputImageTexture, blurCoordinates[7]) * 0.035367; \n  sum += texture2D(inputImageTexture, blurCoordinates[8]) * 0.035367; \n  sum += texture2D(inputImageTexture, blurCoordinates[9]) * 0.012422; \n  sum += texture2D(inputImageTexture, blurCoordinates[10]) * 0.012422;\n  gl_FragColor = sum;\n}");
  
  public StarGaussianBlurFilter()
  {
    super(VERTEX_SHADER, "precision highp float;\n    \nuniform sampler2D   inputImageTexture;\nvarying vec2        textureCoordinate;\nvarying highp vec2 blurCoordinates[11]; \n \nvoid main() {\n  lowp vec4 sum = vec4(0.0); \n  sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.100590; \n  sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.186265; \n  sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.186265; \n  sum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.136940; \n  sum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.136940; \n  sum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.078710; \n  sum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.078710; \n  sum += texture2D(inputImageTexture, blurCoordinates[7]) * 0.035367; \n  sum += texture2D(inputImageTexture, blurCoordinates[8]) * 0.035367; \n  sum += texture2D(inputImageTexture, blurCoordinates[9]) * 0.012422; \n  sum += texture2D(inputImageTexture, blurCoordinates[10]) * 0.012422;\n  gl_FragColor = sum;\n}");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("texelWidth", 0.001388889F));
    addParam(new UniformParam.FloatParam("texelHeight", 0.0F));
    this.mVerticalFilter.addParam(new UniformParam.FloatParam("texelWidth", 0.0F));
    this.mVerticalFilter.addParam(new UniformParam.FloatParam("texelHeight", 0.001041667F));
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    setNextFilter(this.mVerticalFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void updateTexelSize(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("texelWidth", paramFloat1));
    addParam(new UniformParam.FloatParam("texelHeight", 0.0F));
    this.mVerticalFilter.addParam(new UniformParam.FloatParam("texelWidth", 0.0F));
    this.mVerticalFilter.addParam(new UniformParam.FloatParam("texelHeight", paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.StarGaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */