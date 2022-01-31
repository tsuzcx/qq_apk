package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.TextureParam;

public class FabbyFilter2
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     maskColor.rgb *= maskColor.a;\n     gl_FragColor = maskColor; \n }";
  private int mMaskTex;
  
  public FabbyFilter2()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     maskColor.rgb *= maskColor.a;\n     gl_FragColor = maskColor; \n }");
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new Param.TextureParam("inputImageTexture2", this.mMaskTex, 33986));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setTex(int paramInt)
  {
    this.mMaskTex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyFilter2
 * JD-Core Version:    0.7.0.1
 */