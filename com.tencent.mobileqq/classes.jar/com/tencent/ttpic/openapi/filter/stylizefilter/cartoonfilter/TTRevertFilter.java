package com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter;

import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class TTRevertFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n varying vec2 textureCoordinate;\n\n void main() {\n     vec3 sobel = texture2D(inputImageTexture, textureCoordinate).rgb;\n     float dxdy = sobel.z * 2.0 - 1.0;\n     float difference = sqrt((sobel.x - sobel.y) * (sobel.x - sobel.y) + 4.0 * dxdy * dxdy);\n     float l1 = 0.5 * (sobel.x + sobel.y + difference);\n     float l2 = 0.5 * (sobel.x + sobel.y - difference);\n     float l = (l1 > l2) ? l1 : l2;\n     float angle = atan(-dxdy, l - sobel.x);\n     float vx = (cos(angle) + 1.0) / 2.0;\n     float vy = (sin(angle) + 1.0) / 2.0;\n\t gl_FragColor = vec4(vx, vy, 0.0, 1.0);\n }";
  private static final String VERTEX_SHADER = "precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  
  public TTRevertFilter()
  {
    super("precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", "precision highp float;\n uniform sampler2D inputImageTexture;\n varying vec2 textureCoordinate;\n\n void main() {\n     vec3 sobel = texture2D(inputImageTexture, textureCoordinate).rgb;\n     float dxdy = sobel.z * 2.0 - 1.0;\n     float difference = sqrt((sobel.x - sobel.y) * (sobel.x - sobel.y) + 4.0 * dxdy * dxdy);\n     float l1 = 0.5 * (sobel.x + sobel.y + difference);\n     float l2 = 0.5 * (sobel.x + sobel.y - difference);\n     float l = (l1 > l2) ? l1 : l2;\n     float angle = atan(-dxdy, l - sobel.x);\n     float vx = (cos(angle) + 1.0) / 2.0;\n     float vy = (sin(angle) + 1.0) / 2.0;\n\t gl_FragColor = vec4(vx, vy, 0.0, 1.0);\n }");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTRevertFilter
 * JD-Core Version:    0.7.0.1
 */