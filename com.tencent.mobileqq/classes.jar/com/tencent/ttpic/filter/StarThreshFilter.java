package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class StarThreshFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D   inputImageTexture;\nuniform sampler2D   inputImageTexture2;\nvarying vec2        textureCoordinate;\nuniform float thresh; \n \nvoid main() {\n  vec4 fragColor = vec4(0.0);\n  float value = thresh; \n \n  vec3 origin = texture2D(inputImageTexture, textureCoordinate).rgb; \n \n  vec3 blurColor = texture2D(inputImageTexture2, textureCoordinate).rgb; \n  float v = origin.r*0.299 + origin.g*0.587 + origin.b*0.114;  \n  float v2 = blurColor.r*0.299 + blurColor.g*0.587 + blurColor.b*0.114 + value;  \n  float th = max(0.5, v2);  \n  if (v > th)  \n  {  \n    v = (v-th) / (1.0-th) * 1.5;  \n    fragColor = vec4(v, v, v, 1.0);  \n  }  \n  else  \n  {  \n    fragColor = vec4(0.0, 0.0, 0.0, 1.0);  \n  }  \n  gl_FragColor = fragColor;\n}\n";
  
  public StarThreshFilter()
  {
    super("precision highp float;\nuniform sampler2D   inputImageTexture;\nuniform sampler2D   inputImageTexture2;\nvarying vec2        textureCoordinate;\nuniform float thresh; \n \nvoid main() {\n  vec4 fragColor = vec4(0.0);\n  float value = thresh; \n \n  vec3 origin = texture2D(inputImageTexture, textureCoordinate).rgb; \n \n  vec3 blurColor = texture2D(inputImageTexture2, textureCoordinate).rgb; \n  float v = origin.r*0.299 + origin.g*0.587 + origin.b*0.114;  \n  float v2 = blurColor.r*0.299 + blurColor.g*0.587 + blurColor.b*0.114 + value;  \n  float th = max(0.5, v2);  \n  if (v > th)  \n  {  \n    v = (v-th) / (1.0-th) * 1.5;  \n    fragColor = vec4(v, v, v, 1.0);  \n  }  \n  else  \n  {  \n    fragColor = vec4(0.0, 0.0, 0.0, 1.0);  \n  }  \n  gl_FragColor = fragColor;\n}\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.FloatParam("thresh", 0.475F));
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void setThreshold(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("thresh", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.StarThreshFilter
 * JD-Core Version:    0.7.0.1
 */