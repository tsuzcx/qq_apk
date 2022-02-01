package com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class FaceHorizontalBlurFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform vec2 imgSize;\n uniform int blurRadius;\n \n void main()\n {\n    float horStep = 1.0 / imgSize.x;\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    float sum = 0.0;\n    \n    // Blur\n    for (int i = -blurRadius; i <= blurRadius; i++) {\n        vec2 fIdx = textureCoordinate + vec2(horStep * float(i), 0);\n        float nearAlpha = texture2D(inputImageTexture, fIdx).r;\n        sum += nearAlpha;\n    }\n    \n    sum /= (2.0 * float(blurRadius) + 1.0);\n    gl_FragColor = vec4(vec3(sum), 1.0);\n }";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  
  public FaceHorizontalBlurFilter()
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform vec2 imgSize;\n uniform int blurRadius;\n \n void main()\n {\n    float horStep = 1.0 / imgSize.x;\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    float sum = 0.0;\n    \n    // Blur\n    for (int i = -blurRadius; i <= blurRadius; i++) {\n        vec2 fIdx = textureCoordinate + vec2(horStep * float(i), 0);\n        float nearAlpha = texture2D(inputImageTexture, fIdx).r;\n        sum += nearAlpha;\n    }\n    \n    sum /= (2.0 * float(blurRadius) + 1.0);\n    gl_FragColor = vec4(vec3(sum), 1.0);\n }");
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("blurRadius", 1));
  }
  
  public void updateFrameSize(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.Float2fParam("imgSize", paramInt1, paramInt2));
  }
  
  public void updateRadius(int paramInt)
  {
    addParam(new UniformParam.IntParam("blurRadius", paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter.FaceHorizontalBlurFilter
 * JD-Core Version:    0.7.0.1
 */