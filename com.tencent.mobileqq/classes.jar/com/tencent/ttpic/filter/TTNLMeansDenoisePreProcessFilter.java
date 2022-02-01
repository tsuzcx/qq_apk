package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.filter.BaseFilter;

public class TTNLMeansDenoisePreProcessFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\nuniform vec2 texOffset;\n\nconst highp vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main() {\n  vec4 result = vec4(0.0);\n  vec4 srcColor = texture2D(inputImageTexture, textureCoordinate);\n  float srcLuminance = dot(srcColor.rgb, luminanceWeighting);\n  vec2 ptx = textureCoordinate - 2.0 * texOffset;\n  vec4 color = texture2D(inputImageTexture, ptx);\n  float luminance = dot(color.rgb, luminanceWeighting);\n  result.r = luminance - srcLuminance;\n  ptx = textureCoordinate - 1.0 * texOffset;\n  color = texture2D(inputImageTexture, ptx);\n  luminance = dot(color.rgb, luminanceWeighting);\n  result.g = luminance - srcLuminance;\n  ptx = textureCoordinate + 1.0 * texOffset;\n  color = texture2D(inputImageTexture, ptx);\n  luminance = dot(color.rgb, luminanceWeighting);\n  result.b = luminance - srcLuminance;\n  ptx = textureCoordinate + 2.0 * texOffset;\n  color = texture2D(inputImageTexture, ptx);\n  luminance = dot(color.rgb, luminanceWeighting);\n  result.a = luminance - srcLuminance;\n  gl_FragColor = result * 0.5 + 0.5;\n}\n";
  
  public TTNLMeansDenoisePreProcessFilter()
  {
    super("precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\nuniform vec2 texOffset;\n\nconst highp vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main() {\n  vec4 result = vec4(0.0);\n  vec4 srcColor = texture2D(inputImageTexture, textureCoordinate);\n  float srcLuminance = dot(srcColor.rgb, luminanceWeighting);\n  vec2 ptx = textureCoordinate - 2.0 * texOffset;\n  vec4 color = texture2D(inputImageTexture, ptx);\n  float luminance = dot(color.rgb, luminanceWeighting);\n  result.r = luminance - srcLuminance;\n  ptx = textureCoordinate - 1.0 * texOffset;\n  color = texture2D(inputImageTexture, ptx);\n  luminance = dot(color.rgb, luminanceWeighting);\n  result.g = luminance - srcLuminance;\n  ptx = textureCoordinate + 1.0 * texOffset;\n  color = texture2D(inputImageTexture, ptx);\n  luminance = dot(color.rgb, luminanceWeighting);\n  result.b = luminance - srcLuminance;\n  ptx = textureCoordinate + 2.0 * texOffset;\n  color = texture2D(inputImageTexture, ptx);\n  luminance = dot(color.rgb, luminanceWeighting);\n  result.a = luminance - srcLuminance;\n  gl_FragColor = result * 0.5 + 0.5;\n}\n");
    addParam(new UniformParam.Float2fParam("texOffset", 0.001388889F, 0.001041667F));
  }
  
  public void setTexOffset(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.Float2fParam("texOffset", paramFloat1, paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.TTNLMeansDenoisePreProcessFilter
 * JD-Core Version:    0.7.0.1
 */