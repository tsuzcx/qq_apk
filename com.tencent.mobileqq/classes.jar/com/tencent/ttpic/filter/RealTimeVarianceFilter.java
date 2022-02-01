package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class RealTimeVarianceFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \n \n void main() \n{ \n  lowp vec3 iColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n  lowp vec3 meanColor = texture2D(inputImageTexture2, textureCoordinate).rgb;\n  highp vec3 diffColor = (iColor - meanColor) * 7.07;\n  diffColor = min(diffColor * diffColor, 1.0);\n  gl_FragColor = vec4(diffColor, 1.0);\n}";
  
  public RealTimeVarianceFilter()
  {
    super("varying highp vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \n \n void main() \n{ \n  lowp vec3 iColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n  lowp vec3 meanColor = texture2D(inputImageTexture2, textureCoordinate).rgb;\n  highp vec3 diffColor = (iColor - meanColor) * 7.07;\n  diffColor = min(diffColor * diffColor, 1.0);\n  gl_FragColor = vec4(diffColor, 1.0);\n}");
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.RealTimeVarianceFilter
 * JD-Core Version:    0.7.0.1
 */