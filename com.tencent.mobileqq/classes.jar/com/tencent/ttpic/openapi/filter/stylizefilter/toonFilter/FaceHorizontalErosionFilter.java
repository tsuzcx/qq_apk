package com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class FaceHorizontalErosionFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform vec2 imgSize;\n uniform int erosionRadius;\n \n void main()\n {\n    float horStep = 1.0 / imgSize.x;\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    float alpha = textureColor.r;\n    \n    // mask erode\n    for (int i = -erosionRadius; i <= erosionRadius; i++) {\n        vec2 fIdx = textureCoordinate + vec2(horStep * float(i), 0);\n        float nearAlpha = texture2D(inputImageTexture, fIdx).r;\n        alpha = min(alpha, nearAlpha);\n    }\n    \n    gl_FragColor = vec4(vec3(alpha), 1.0);\n }";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  
  public FaceHorizontalErosionFilter()
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform vec2 imgSize;\n uniform int erosionRadius;\n \n void main()\n {\n    float horStep = 1.0 / imgSize.x;\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    float alpha = textureColor.r;\n    \n    // mask erode\n    for (int i = -erosionRadius; i <= erosionRadius; i++) {\n        vec2 fIdx = textureCoordinate + vec2(horStep * float(i), 0);\n        float nearAlpha = texture2D(inputImageTexture, fIdx).r;\n        alpha = min(alpha, nearAlpha);\n    }\n    \n    gl_FragColor = vec4(vec3(alpha), 1.0);\n }");
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("erosionRadius", 1));
  }
  
  public void updateFrameSize(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.Float2fParam("imgSize", paramInt1, paramInt2));
  }
  
  public void updateRadius(int paramInt)
  {
    addParam(new UniformParam.IntParam("erosionRadius", paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter.FaceHorizontalErosionFilter
 * JD-Core Version:    0.7.0.1
 */