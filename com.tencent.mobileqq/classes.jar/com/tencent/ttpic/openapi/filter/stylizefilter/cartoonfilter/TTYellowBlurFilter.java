package com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter;

import com.tencent.aekit.openrender.UniformParam.Float2sParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class TTYellowBlurFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform vec2 imgSize;\n uniform float sigma;\n varying vec2 textureCoordinate;\n const float L = 15.0;\n\n void main() {\n float weight = 0.0;\n vec2 c = vec2(0.0);\n for(float pm = -1.0; pm < 2.0; pm += 2.0) {\n   vec2 v0 = pm * (texture2D(inputImageTexture2, textureCoordinate).xy * 2.0 - 1.0);\n   vec2 pt = textureCoordinate + vec2(0.5) / imgSize;\n   for (float l = 0.0; l < L; l++) {\n             if(pt.x < 0.0 || pt.y < 0.0 || pt.x > 1.0 || pt.y > 1.0) {\n                 break;\n             }\n             \n   vec2 v = texture2D(inputImageTexture2, pt).xy * 2.0 - 1.0;\n   if(v.x == 0.0 && v.y == 0.0) {\n                 break;\n             }\n             \n   float w = exp(-l * l / sigma / sigma / 2.0);\n   c += w * texture2D(inputImageTexture, pt).xy;\n   weight += w;\n\n   float inner = dot(v, v0);\n   v0 = sign(inner) * v;\n   pt += v0/imgSize;\n  }\n  }\n    \n  c /= weight;\n  gl_FragColor = vec4(c, 0.0, 1.0);\n }";
  private static final String VERTEX_SHADER = "precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  
  public TTYellowBlurFilter()
  {
    super("precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform vec2 imgSize;\n uniform float sigma;\n varying vec2 textureCoordinate;\n const float L = 15.0;\n\n void main() {\n float weight = 0.0;\n vec2 c = vec2(0.0);\n for(float pm = -1.0; pm < 2.0; pm += 2.0) {\n   vec2 v0 = pm * (texture2D(inputImageTexture2, textureCoordinate).xy * 2.0 - 1.0);\n   vec2 pt = textureCoordinate + vec2(0.5) / imgSize;\n   for (float l = 0.0; l < L; l++) {\n             if(pt.x < 0.0 || pt.y < 0.0 || pt.x > 1.0 || pt.y > 1.0) {\n                 break;\n             }\n             \n   vec2 v = texture2D(inputImageTexture2, pt).xy * 2.0 - 1.0;\n   if(v.x == 0.0 && v.y == 0.0) {\n                 break;\n             }\n             \n   float w = exp(-l * l / sigma / sigma / 2.0);\n   c += w * texture2D(inputImageTexture, pt).xy;\n   weight += w;\n\n   float inner = dot(v, v0);\n   v0 = sign(inner) * v;\n   pt += v0/imgSize;\n  }\n  }\n    \n  c /= weight;\n  gl_FragColor = vec4(c, 0.0, 1.0);\n }");
    initParams(32.0F);
  }
  
  public void initParams(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("sigma", paramFloat));
    updateFrameSize(0, 0);
    setTexture2(0);
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void updateFrameSize(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.Float2sParam("imgSize", new float[] { paramInt1, paramInt2 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTYellowBlurFilter
 * JD-Core Version:    0.7.0.1
 */