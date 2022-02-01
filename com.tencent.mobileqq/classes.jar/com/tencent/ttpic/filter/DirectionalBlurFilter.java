package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.filter.BaseFilter;

public class DirectionalBlurFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\nuniform vec2 texOffset;\nvoid main() {\n  vec4 sum = vec4(0.0);\n  vec2 ptx = textureCoordinate - 2.0 * texOffset;\n  for (int i = -2; i <= 2; i++) {\n    sum += texture2D(inputImageTexture, ptx);\n    ptx += texOffset;\n  }\n  gl_FragColor = sum / 5.0;\n}\n";
  
  public DirectionalBlurFilter()
  {
    super("precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\nuniform vec2 texOffset;\nvoid main() {\n  vec4 sum = vec4(0.0);\n  vec2 ptx = textureCoordinate - 2.0 * texOffset;\n  for (int i = -2; i <= 2; i++) {\n    sum += texture2D(inputImageTexture, ptx);\n    ptx += texOffset;\n  }\n  gl_FragColor = sum / 5.0;\n}\n");
    addParam(new UniformParam.Float2fParam("texOffset", 0.001388889F, 0.001041667F));
  }
  
  public void setTexOffset(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.Float2fParam("texOffset", paramFloat1, paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.DirectionalBlurFilter
 * JD-Core Version:    0.7.0.1
 */