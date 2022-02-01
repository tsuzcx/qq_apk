package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class GuideFilterRefine3
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main() {\n   vec4 r = texture2D(inputImageTexture, textureCoordinate);\n   vec4 s = (texture2D(inputImageTexture2, textureCoordinate) - vec4(0.5, 0.5, 0.5, 0.5)) * 2.0;\n   float src = s.x * r.x + s.y * r.y + s.z * r.z + s.w * 2.0;\n   src = (src - 0.5) * 2.0 + 0.5;\n   if (src < 0.1) src = 0.0;\n   if (src > 0.9) src = 1.0;\n   gl_FragColor = vec4(src, src, src, 1.0);\n}";
  
  public GuideFilterRefine3()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main() {\n   vec4 r = texture2D(inputImageTexture, textureCoordinate);\n   vec4 s = (texture2D(inputImageTexture2, textureCoordinate) - vec4(0.5, 0.5, 0.5, 0.5)) * 2.0;\n   float src = s.x * r.x + s.y * r.y + s.z * r.z + s.w * 2.0;\n   src = (src - 0.5) * 2.0 + 0.5;\n   if (src < 0.1) src = 0.0;\n   if (src > 0.9) src = 1.0;\n   gl_FragColor = vec4(src, src, src, 1.0);\n}");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public void updateParams(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.GuideFilterRefine3
 * JD-Core Version:    0.7.0.1
 */