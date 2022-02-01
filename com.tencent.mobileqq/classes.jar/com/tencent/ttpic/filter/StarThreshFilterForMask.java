package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class StarThreshFilterForMask
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D   inputImageTexture;\nuniform sampler2D   inputImageTexture2;\nuniform sampler2D   inputImageTexture3;\nvarying vec2        textureCoordinate;\nuniform float thresh; \nuniform float colors;\nuniform float pattern;\n\nfloat rand(vec2 co){ \n  return floor(fract(sin(dot(co.xy * pattern ,vec2(12.9898,78.233))) * 43758.5453) * colors); \n} \n \nvoid main() {\n  vec4 fragColor = vec4(0.0);\n  float value = thresh;\n  vec3 origin = texture2D(inputImageTexture, textureCoordinate).rgb; \n  vec3 blurColor = texture2D(inputImageTexture2, textureCoordinate).rgb; \n  float v = origin.r*0.299 + origin.g*0.587 + origin.b*0.114;  \n  float v2 = blurColor.r*0.299 + blurColor.g*0.587 + blurColor.b*0.114 + value;  \n  float th = max(0.5, v2);  \n  if (v > th)  \n  { \n    vec3 light;\n    if (colors > 1.5) {\n      float randomValue = rand(textureCoordinate);\n      light = texture2D(inputImageTexture3, vec2((randomValue * 2.0 + 1.0) / (2.0 * colors), 0.5)).rgb;\n    } else {\n      light = texture2D(inputImageTexture3, vec2(0.5, 0.5)).rgb;\n    }\n    v = (v-th) / (1.0-th) * 1.5;  \n    fragColor = vec4(v * light, 1.0);  \n  }  \n  else  \n  {  \n    fragColor = vec4(0.0, 0.0, 0.0, 1.0);  \n  }  \n  gl_FragColor = fragColor;\n}\n";
  
  public StarThreshFilterForMask()
  {
    super("precision highp float;\nuniform sampler2D   inputImageTexture;\nuniform sampler2D   inputImageTexture2;\nuniform sampler2D   inputImageTexture3;\nvarying vec2        textureCoordinate;\nuniform float thresh; \nuniform float colors;\nuniform float pattern;\n\nfloat rand(vec2 co){ \n  return floor(fract(sin(dot(co.xy * pattern ,vec2(12.9898,78.233))) * 43758.5453) * colors); \n} \n \nvoid main() {\n  vec4 fragColor = vec4(0.0);\n  float value = thresh;\n  vec3 origin = texture2D(inputImageTexture, textureCoordinate).rgb; \n  vec3 blurColor = texture2D(inputImageTexture2, textureCoordinate).rgb; \n  float v = origin.r*0.299 + origin.g*0.587 + origin.b*0.114;  \n  float v2 = blurColor.r*0.299 + blurColor.g*0.587 + blurColor.b*0.114 + value;  \n  float th = max(0.5, v2);  \n  if (v > th)  \n  { \n    vec3 light;\n    if (colors > 1.5) {\n      float randomValue = rand(textureCoordinate);\n      light = texture2D(inputImageTexture3, vec2((randomValue * 2.0 + 1.0) / (2.0 * colors), 0.5)).rgb;\n    } else {\n      light = texture2D(inputImageTexture3, vec2(0.5, 0.5)).rgb;\n    }\n    v = (v-th) / (1.0-th) * 1.5;  \n    fragColor = vec4(v * light, 1.0);  \n  }  \n  else  \n  {  \n    fragColor = vec4(0.0, 0.0, 0.0, 1.0);  \n  }  \n  gl_FragColor = fragColor;\n}\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.FloatParam("thresh", 0.475F));
    addParam(new UniformParam.FloatParam("colors", 1.0F));
    addParam(new UniformParam.FloatParam("pattern", 1.0F));
  }
  
  public void setColorTex(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt1, 33987));
    addParam(new UniformParam.FloatParam("colors", paramInt2));
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void setThreshold(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("thresh", paramFloat));
  }
  
  public void updatePattern()
  {
    addParam(new UniformParam.FloatParam("pattern", (float)(Math.random() * 100.0D)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.StarThreshFilterForMask
 * JD-Core Version:    0.7.0.1
 */