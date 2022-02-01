package com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class TTStylizationFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform float p;\n uniform float phi;\n uniform float threshold;\n varying vec2 textureCoordinate;\n\n void main() {\n     vec2 g = texture2D(inputImageTexture, textureCoordinate).xy;\n     float difference = ((1.0 + p) * g.x - p * g.y) * 255.0;\n     float phiDiff = phi * (difference - threshold);\n     gl_FragColor = vec4(vec3((difference > threshold) ? 1.0 : 1.0 + (exp(phiDiff) - exp(-phiDiff)) / (exp(phiDiff) + exp(-phiDiff))), 1.0);\n }";
  private static final String VERTEX_SHADER = "precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  
  public TTStylizationFilter()
  {
    super("precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform float p;\n uniform float phi;\n uniform float threshold;\n varying vec2 textureCoordinate;\n\n void main() {\n     vec2 g = texture2D(inputImageTexture, textureCoordinate).xy;\n     float difference = ((1.0 + p) * g.x - p * g.y) * 255.0;\n     float phiDiff = phi * (difference - threshold);\n     gl_FragColor = vec4(vec3((difference > threshold) ? 1.0 : 1.0 + (exp(phiDiff) - exp(-phiDiff)) / (exp(phiDiff) + exp(-phiDiff))), 1.0);\n }");
    initParams(20.0F, 0.018F, 50.0F);
  }
  
  public void initParams(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    addParam(new UniformParam.FloatParam("p", paramFloat1));
    addParam(new UniformParam.FloatParam("phi", paramFloat2));
    addParam(new UniformParam.FloatParam("threshold", paramFloat3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTStylizationFilter
 * JD-Core Version:    0.7.0.1
 */