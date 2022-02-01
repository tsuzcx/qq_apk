package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class TTBeautyV5DeepBlurFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n varying highp vec2 v_texCoord;\n varying highp vec4 v_textureShift1;\n varying highp vec4 v_textureShift2;\n \n void main()\n {\n    mediump vec3 sum = texture2D(inputImageTexture, v_texCoord).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift1.xy).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift1.zw).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift2.xy).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift2.zw).rgb;\n    sum = sum * 0.2;\n    gl_FragColor = vec4(sum, 1.0);\n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform highp float texelWidthOffset;\n uniform highp float texelHeightOffset;\n \n varying vec2 v_texCoord;\n varying vec4 v_textureShift1;\n varying vec4 v_textureShift2;\n \n void main(void)\n {\n    gl_Position = position;\n    \n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    vec2 a_texCoord = inputTextureCoordinate.xy;\n    v_texCoord = a_texCoord.xy;\n    v_textureShift1 = vec4(a_texCoord.xy - singleStepOffset, a_texCoord.xy + singleStepOffset);\n    v_textureShift2 = vec4(a_texCoord.xy - 2.0 * singleStepOffset, a_texCoord.xy + 2.0 * singleStepOffset);\n }\n";
  private BaseFilter veticalFilter = new BaseFilter("attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform highp float texelWidthOffset;\n uniform highp float texelHeightOffset;\n \n varying vec2 v_texCoord;\n varying vec4 v_textureShift1;\n varying vec4 v_textureShift2;\n \n void main(void)\n {\n    gl_Position = position;\n    \n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    vec2 a_texCoord = inputTextureCoordinate.xy;\n    v_texCoord = a_texCoord.xy;\n    v_textureShift1 = vec4(a_texCoord.xy - singleStepOffset, a_texCoord.xy + singleStepOffset);\n    v_textureShift2 = vec4(a_texCoord.xy - 2.0 * singleStepOffset, a_texCoord.xy + 2.0 * singleStepOffset);\n }\n", "precision highp float;\n uniform sampler2D inputImageTexture;\n varying highp vec2 v_texCoord;\n varying highp vec4 v_textureShift1;\n varying highp vec4 v_textureShift2;\n \n void main()\n {\n    mediump vec3 sum = texture2D(inputImageTexture, v_texCoord).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift1.xy).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift1.zw).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift2.xy).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift2.zw).rgb;\n    sum = sum * 0.2;\n    gl_FragColor = vec4(sum, 1.0);\n }\n");
  
  public TTBeautyV5DeepBlurFilter()
  {
    super("attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform highp float texelWidthOffset;\n uniform highp float texelHeightOffset;\n \n varying vec2 v_texCoord;\n varying vec4 v_textureShift1;\n varying vec4 v_textureShift2;\n \n void main(void)\n {\n    gl_Position = position;\n    \n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    vec2 a_texCoord = inputTextureCoordinate.xy;\n    v_texCoord = a_texCoord.xy;\n    v_textureShift1 = vec4(a_texCoord.xy - singleStepOffset, a_texCoord.xy + singleStepOffset);\n    v_textureShift2 = vec4(a_texCoord.xy - 2.0 * singleStepOffset, a_texCoord.xy + 2.0 * singleStepOffset);\n }\n", "precision highp float;\n uniform sampler2D inputImageTexture;\n varying highp vec2 v_texCoord;\n varying highp vec4 v_textureShift1;\n varying highp vec4 v_textureShift2;\n \n void main()\n {\n    mediump vec3 sum = texture2D(inputImageTexture, v_texCoord).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift1.xy).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift1.zw).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift2.xy).rgb;\n    sum += texture2D(inputImageTexture, v_textureShift2.zw).rgb;\n    sum = sum * 0.2;\n    gl_FragColor = vec4(sum, 1.0);\n }\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", 0.009444444F));
    addParam(new UniformParam.FloatParam("texelHeightOffset", 0.0F));
    this.veticalFilter.addParam(new UniformParam.FloatParam("texelWidthOffset", 0.0F));
    this.veticalFilter.addParam(new UniformParam.FloatParam("texelHeightOffset", 0.007083334F));
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    setNextFilter(this.veticalFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    this.veticalFilter.setPositions(paramArrayOfFloat);
    return super.setPositions(paramArrayOfFloat);
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    this.veticalFilter.setTexCords(paramArrayOfFloat);
    return super.setTexCords(paramArrayOfFloat);
  }
  
  public void updateSize(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", 3.4F / paramFloat1));
    this.veticalFilter.addParam(new UniformParam.FloatParam("texelHeightOffset", 3.4F / paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV5DeepBlurFilter
 * JD-Core Version:    0.7.0.1
 */