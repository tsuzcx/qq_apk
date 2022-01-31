package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.TextureParam;

public class FabbyFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n     vec4 cameraColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     \n     if (maskColor.r >= 0.3 || maskColor.g >= 0.3 || maskColor.b >= 0.3) { \n         gl_FragColor = cameraColor; \n     } else { \n         gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0); \n     } \n }";
  
  public FabbyFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n     vec4 cameraColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     \n     if (maskColor.r >= 0.3 || maskColor.g >= 0.3 || maskColor.b >= 0.3) { \n         gl_FragColor = cameraColor; \n     } else { \n         gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0); \n     } \n }");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new Param.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public void setTex(int paramInt)
  {
    addParam(new Param.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyFilter
 * JD-Core Version:    0.7.0.1
 */