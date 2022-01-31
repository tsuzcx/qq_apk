package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class BoxFilterWithRadius
  extends BaseFilter
{
  private static final int DEFAULT_RADIUS = 5;
  public static final String FRAGMENT_SHADER_3 = "uniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nvarying highp vec4 textureShift_1;\nvarying highp vec4 textureShift_2;\nvoid main() {\n    mediump vec3 sum = texture2D(inputImageTexture, textureCoordinate).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.zw).rgb;\n    sum += texture2D(inputImageTexture, textureShift_2.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_2.zw).rgb;\n    gl_FragColor = vec4(sum * 0.2, 1.0);\n}";
  public static final String FRAGMENT_SHADER_5 = "uniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nvarying highp vec4 textureShift_1;\nvarying highp vec4 textureShift_2;\nvarying highp vec4 textureShift_3;\nvarying highp vec4 textureShift_4;\nvoid main() {\n    mediump vec3 sum = texture2D(inputImageTexture, textureCoordinate).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.zw).rgb;\n    sum += texture2D(inputImageTexture, textureShift_2.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_2.zw).rgb;\n    sum += texture2D(inputImageTexture, textureShift_3.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_3.zw).rgb;\n    sum += texture2D(inputImageTexture, textureShift_4.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_4.zw).rgb;\n    gl_FragColor = vec4(sum * 0.1111, 1.0);\n}";
  public static final String VERTEX_SHADER_3 = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec4 textureShift_1;\nvarying vec4 textureShift_2;\n\nvoid main() {\n    gl_Position = position;\n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureShift_1 = vec4(inputTextureCoordinate.xy - singleStepOffset, inputTextureCoordinate.xy + singleStepOffset);\n    textureShift_2 = vec4(inputTextureCoordinate.xy - 2.0 * singleStepOffset, inputTextureCoordinate.xy + 2.0 * singleStepOffset);\n}";
  public static final String VERTEX_SHADER_5 = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec4 textureShift_1;\nvarying vec4 textureShift_2;\nvarying vec4 textureShift_3;\nvarying vec4 textureShift_4;\n\nvoid main() {\n    gl_Position = position;\n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureShift_1 = vec4(inputTextureCoordinate.xy - singleStepOffset, inputTextureCoordinate.xy + singleStepOffset);\n    textureShift_2 = vec4(inputTextureCoordinate.xy - 2.0 * singleStepOffset, inputTextureCoordinate.xy + 2.0 * singleStepOffset);\n    textureShift_3 = vec4(inputTextureCoordinate.xy - 3.0 * singleStepOffset, inputTextureCoordinate.xy + 3.0 * singleStepOffset);\n    textureShift_4 = vec4(inputTextureCoordinate.xy - 4.0 * singleStepOffset, inputTextureCoordinate.xy + 4.0 * singleStepOffset);\n}";
  private BaseFilter veticalFilter;
  
  public BoxFilterWithRadius()
  {
    this(5);
  }
  
  public BoxFilterWithRadius(int paramInt)
  {
    super(getVertexShader(paramInt), getFragmentShader(paramInt));
    this.veticalFilter = new BaseFilter(getVertexShader(paramInt), getFragmentShader(paramInt));
    initParams();
  }
  
  private static String getFragmentShaderSelf(int paramInt)
  {
    if (paramInt == 3) {
      return "uniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nvarying highp vec4 textureShift_1;\nvarying highp vec4 textureShift_2;\nvoid main() {\n    mediump vec3 sum = texture2D(inputImageTexture, textureCoordinate).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.zw).rgb;\n    sum += texture2D(inputImageTexture, textureShift_2.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_2.zw).rgb;\n    gl_FragColor = vec4(sum * 0.2, 1.0);\n}";
    }
    return "uniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nvarying highp vec4 textureShift_1;\nvarying highp vec4 textureShift_2;\nvarying highp vec4 textureShift_3;\nvarying highp vec4 textureShift_4;\nvoid main() {\n    mediump vec3 sum = texture2D(inputImageTexture, textureCoordinate).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.zw).rgb;\n    sum += texture2D(inputImageTexture, textureShift_2.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_2.zw).rgb;\n    sum += texture2D(inputImageTexture, textureShift_3.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_3.zw).rgb;\n    sum += texture2D(inputImageTexture, textureShift_4.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_4.zw).rgb;\n    gl_FragColor = vec4(sum * 0.1111, 1.0);\n}";
  }
  
  private static String getVertexShaderSelf(int paramInt)
  {
    if (paramInt == 3) {
      return "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec4 textureShift_1;\nvarying vec4 textureShift_2;\n\nvoid main() {\n    gl_Position = position;\n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureShift_1 = vec4(inputTextureCoordinate.xy - singleStepOffset, inputTextureCoordinate.xy + singleStepOffset);\n    textureShift_2 = vec4(inputTextureCoordinate.xy - 2.0 * singleStepOffset, inputTextureCoordinate.xy + 2.0 * singleStepOffset);\n}";
    }
    return "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec4 textureShift_1;\nvarying vec4 textureShift_2;\nvarying vec4 textureShift_3;\nvarying vec4 textureShift_4;\n\nvoid main() {\n    gl_Position = position;\n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureShift_1 = vec4(inputTextureCoordinate.xy - singleStepOffset, inputTextureCoordinate.xy + singleStepOffset);\n    textureShift_2 = vec4(inputTextureCoordinate.xy - 2.0 * singleStepOffset, inputTextureCoordinate.xy + 2.0 * singleStepOffset);\n    textureShift_3 = vec4(inputTextureCoordinate.xy - 3.0 * singleStepOffset, inputTextureCoordinate.xy + 3.0 * singleStepOffset);\n    textureShift_4 = vec4(inputTextureCoordinate.xy - 4.0 * singleStepOffset, inputTextureCoordinate.xy + 4.0 * singleStepOffset);\n}";
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    setNextFilter(this.veticalFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", 0.004166667F));
    addParam(new UniformParam.FloatParam("texelHeightOffset", 0.0F));
    this.veticalFilter.addParam(new UniformParam.FloatParam("texelWidthOffset", 0.0F));
    this.veticalFilter.addParam(new UniformParam.FloatParam("texelHeightOffset", 0.003125F));
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
  
  public void updateParam(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", 1.5F / paramFloat1));
    this.veticalFilter.addParam(new UniformParam.FloatParam("texelHeightOffset", 1.5F / paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.BoxFilterWithRadius
 * JD-Core Version:    0.7.0.1
 */