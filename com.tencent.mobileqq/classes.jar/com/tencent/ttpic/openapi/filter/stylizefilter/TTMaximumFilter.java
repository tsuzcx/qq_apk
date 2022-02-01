package com.tencent.ttpic.openapi.filter.stylizefilter;

public class TTMaximumFilter
  extends TTStylizeFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n \n varying highp vec2 textureCoordinate;\n varying highp vec2 maximumCoordinates[3];\n\n void main() {\n     lowp vec3 maxColor = vec3(0.0);\n     maxColor = max(maxColor, texture2D(inputImageTexture, maximumCoordinates[0]).rgb);\n     maxColor = max(maxColor, texture2D(inputImageTexture, maximumCoordinates[1]).rgb);\n     maxColor = max(maxColor, texture2D(inputImageTexture, maximumCoordinates[2]).rgb);\n     gl_FragColor = vec4(maxColor, 1.0);\n }";
  private static final String VERTEX_SHADER = "attribute vec3 position;\n attribute vec2 inputTextureCoordinate;\n \n uniform float texelWidthOffset;\n uniform float texelHeightOffset;\n varying vec2 maximumCoordinates[3];\n varying vec2 textureCoordinate;\n \n void main(void) {\n    gl_Position = vec4(position, 1.0);\n    vec2 pixelOffset = vec2(texelWidthOffset, texelHeightOffset);\n    \n    textureCoordinate = inputTextureCoordinate.xy;\n    maximumCoordinates[0] = textureCoordinate.xy - pixelOffset * 1.000000;\n    maximumCoordinates[1] = textureCoordinate.xy;\n    maximumCoordinates[2] = textureCoordinate.xy + pixelOffset * 1.000000;\n }";
  
  public TTMaximumFilter()
  {
    super("attribute vec3 position;\n attribute vec2 inputTextureCoordinate;\n \n uniform float texelWidthOffset;\n uniform float texelHeightOffset;\n varying vec2 maximumCoordinates[3];\n varying vec2 textureCoordinate;\n \n void main(void) {\n    gl_Position = vec4(position, 1.0);\n    vec2 pixelOffset = vec2(texelWidthOffset, texelHeightOffset);\n    \n    textureCoordinate = inputTextureCoordinate.xy;\n    maximumCoordinates[0] = textureCoordinate.xy - pixelOffset * 1.000000;\n    maximumCoordinates[1] = textureCoordinate.xy;\n    maximumCoordinates[2] = textureCoordinate.xy + pixelOffset * 1.000000;\n }", "precision highp float;\n uniform sampler2D inputImageTexture;\n \n varying highp vec2 textureCoordinate;\n varying highp vec2 maximumCoordinates[3];\n\n void main() {\n     lowp vec3 maxColor = vec3(0.0);\n     maxColor = max(maxColor, texture2D(inputImageTexture, maximumCoordinates[0]).rgb);\n     maxColor = max(maxColor, texture2D(inputImageTexture, maximumCoordinates[1]).rgb);\n     maxColor = max(maxColor, texture2D(inputImageTexture, maximumCoordinates[2]).rgb);\n     gl_FragColor = vec4(maxColor, 1.0);\n }");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.TTMaximumFilter
 * JD-Core Version:    0.7.0.1
 */