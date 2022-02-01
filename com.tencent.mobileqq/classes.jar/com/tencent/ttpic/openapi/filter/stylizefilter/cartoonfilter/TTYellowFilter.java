package com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter;

import com.tencent.aekit.openrender.UniformParam.Float2sParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class TTYellowFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform vec2 img_size;\n uniform float sigma1;\n uniform float sigma2;\n varying vec2 textureCoordinate;\n const vec3 rgb2gray = vec3(0.2125, 0.7154, 0.0721);\n\n void main() {\n     vec2 v0 = texture2D(inputImageTexture, textureCoordinate).xy*2.-1.;\n     v0 = vec2(v0.y, -v0.x);\n     vec2 weight = vec2(1.);\n     vec2 sum = vec2(dot(texture2D(inputImageTexture2, textureCoordinate).rgb, rgb2gray));\n     for(float l = 1.; l <= 12.; l++){\n         vec2 w = vec2(exp(-l * l / sigma1 / sigma1 / 2.0), exp(-l * l / sigma2 / sigma2 / 2.0));\n         float g1 = dot(rgb2gray, texture2D(inputImageTexture2, textureCoordinate + v0 * l / img_size).rgb);\n         float g2 = dot(rgb2gray, texture2D(inputImageTexture2, textureCoordinate - v0 * l / img_size).rgb);\n         sum += w * vec2(g1 + g2);\n         weight += 2.0 * w;\n     }\n\n     sum /= weight;\n     gl_FragColor = vec4(sum, 0.0, 1.0);\n }";
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  
  public TTYellowFilter()
  {
    super("precision highp float;\nattribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform vec2 img_size;\n uniform float sigma1;\n uniform float sigma2;\n varying vec2 textureCoordinate;\n const vec3 rgb2gray = vec3(0.2125, 0.7154, 0.0721);\n\n void main() {\n     vec2 v0 = texture2D(inputImageTexture, textureCoordinate).xy*2.-1.;\n     v0 = vec2(v0.y, -v0.x);\n     vec2 weight = vec2(1.);\n     vec2 sum = vec2(dot(texture2D(inputImageTexture2, textureCoordinate).rgb, rgb2gray));\n     for(float l = 1.; l <= 12.; l++){\n         vec2 w = vec2(exp(-l * l / sigma1 / sigma1 / 2.0), exp(-l * l / sigma2 / sigma2 / 2.0));\n         float g1 = dot(rgb2gray, texture2D(inputImageTexture2, textureCoordinate + v0 * l / img_size).rgb);\n         float g2 = dot(rgb2gray, texture2D(inputImageTexture2, textureCoordinate - v0 * l / img_size).rgb);\n         sum += w * vec2(g1 + g2);\n         weight += 2.0 * w;\n     }\n\n     sum /= weight;\n     gl_FragColor = vec4(sum, 0.0, 1.0);\n }");
    initParams(1.4F, 4.4F);
  }
  
  public void initParams(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("sigma1", paramFloat1));
    addParam(new UniformParam.FloatParam("sigma2", paramFloat2));
    updateFrameSize(0, 0);
    setTexture2(0);
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void updateFrameSize(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.Float2sParam("img_size", new float[] { paramInt1, paramInt2 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTYellowFilter
 * JD-Core Version:    0.7.0.1
 */