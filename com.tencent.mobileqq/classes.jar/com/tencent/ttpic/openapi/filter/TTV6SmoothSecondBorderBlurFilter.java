package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class TTV6SmoothSecondBorderBlurFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n varying highp vec4 textureShift_1;\n varying highp vec4 textureShift_2;\n varying highp vec4 textureShift_3;\n void main() { \n   mediump vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n   float sum = iColor.a;\n   sum += texture2D(inputImageTexture, textureShift_1.xy).a;\n   sum += texture2D(inputImageTexture, textureShift_1.zw).a;\n   sum += texture2D(inputImageTexture, textureShift_2.xy).a;\n   sum += texture2D(inputImageTexture, textureShift_2.zw).a;\n   sum += texture2D(inputImageTexture, textureShift_3.xy).a;\n   sum += texture2D(inputImageTexture, textureShift_3.zw).a;\n   gl_FragColor = vec4(iColor.rgb, sum * 0.1428);\n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n uniform highp float texelWidthOffset;\n uniform highp float texelHeightOffset;\n varying vec2 textureCoordinate;\n varying vec4 textureShift_1;\n varying vec4 textureShift_2;\n varying vec4 textureShift_3;\n void main() { \n   gl_Position = position;\n   vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n   textureCoordinate = inputTextureCoordinate.xy;\n   textureShift_1 = vec4(textureCoordinate.xy - singleStepOffset, textureCoordinate.xy + singleStepOffset);\n   textureShift_2 = vec4(textureCoordinate.xy - 2.0 * singleStepOffset, textureCoordinate.xy + 2.0 * singleStepOffset);\n   textureShift_3 = vec4(textureCoordinate.xy - 3.0 * singleStepOffset, textureCoordinate.xy + 3.0 * singleStepOffset);\n }\n";
  
  public TTV6SmoothSecondBorderBlurFilter()
  {
    super("attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n uniform highp float texelWidthOffset;\n uniform highp float texelHeightOffset;\n varying vec2 textureCoordinate;\n varying vec4 textureShift_1;\n varying vec4 textureShift_2;\n varying vec4 textureShift_3;\n void main() { \n   gl_Position = position;\n   vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n   textureCoordinate = inputTextureCoordinate.xy;\n   textureShift_1 = vec4(textureCoordinate.xy - singleStepOffset, textureCoordinate.xy + singleStepOffset);\n   textureShift_2 = vec4(textureCoordinate.xy - 2.0 * singleStepOffset, textureCoordinate.xy + 2.0 * singleStepOffset);\n   textureShift_3 = vec4(textureCoordinate.xy - 3.0 * singleStepOffset, textureCoordinate.xy + 3.0 * singleStepOffset);\n }\n", "precision mediump float;\nuniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n varying highp vec4 textureShift_1;\n varying highp vec4 textureShift_2;\n varying highp vec4 textureShift_3;\n void main() { \n   mediump vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n   float sum = iColor.a;\n   sum += texture2D(inputImageTexture, textureShift_1.xy).a;\n   sum += texture2D(inputImageTexture, textureShift_1.zw).a;\n   sum += texture2D(inputImageTexture, textureShift_2.xy).a;\n   sum += texture2D(inputImageTexture, textureShift_2.zw).a;\n   sum += texture2D(inputImageTexture, textureShift_3.xy).a;\n   sum += texture2D(inputImageTexture, textureShift_3.zw).a;\n   gl_FragColor = vec4(iColor.rgb, sum * 0.1428);\n }\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", 0.0F));
    addParam(new UniformParam.FloatParam("texelHeightOffset", 0.0F));
  }
  
  public void setTextureOffset(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", paramFloat1));
    addParam(new UniformParam.FloatParam("texelHeightOffset", paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTV6SmoothSecondBorderBlurFilter
 * JD-Core Version:    0.7.0.1
 */