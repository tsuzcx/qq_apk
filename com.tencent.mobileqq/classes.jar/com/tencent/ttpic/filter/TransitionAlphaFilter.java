package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;

public class TransitionAlphaFilter
  extends BaseFilter
  implements ITransitionFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float alpha;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = mix(last, current, alpha); \n }";
  private int easeCurve;
  private long transitionDuration;
  private long transitionStartTime = -1L;
  
  public TransitionAlphaFilter()
  {
    super(" precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float alpha;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = mix(last, current, alpha); \n }");
    initParams();
  }
  
  private double getDuration(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double d = paramDouble2 - paramDouble1;
    paramDouble3 = (paramDouble3 - paramDouble1) / d;
    int i = this.easeCurve;
    if (i != 1)
    {
      if (i != 2) {
        if (i == 3) {}
      }
      for (paramDouble2 = d * paramDouble3;; paramDouble2 = d * Math.sin(paramDouble3 * 1.570796326794897D))
      {
        return paramDouble2 + paramDouble1;
        return -d / 2.0D * (Math.cos(paramDouble3 * 3.141592653589793D) - 1.0D) + paramDouble1;
      }
    }
    return -d * Math.cos(paramDouble3 * 1.570796326794897D) + paramDouble2;
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.FloatParam("alpha", 0.0F));
  }
  
  private void updateTextureParam(long paramLong)
  {
    long l = this.transitionStartTime;
    float f2 = (float)(getDuration(l, l + this.transitionDuration, paramLong) - this.transitionStartTime) / (float)this.transitionDuration;
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    addParam(new UniformParam.FloatParam("alpha", f1));
  }
  
  public void reset()
  {
    this.transitionStartTime = -1L;
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void setDataPath(String paramString) {}
  
  public void setDuration(long paramLong)
  {
    this.transitionDuration = paramLong;
  }
  
  public void setEaseCurve(int paramInt)
  {
    this.easeCurve = paramInt;
  }
  
  public void setLastTex(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void updatePreview(long paramLong)
  {
    if (this.transitionStartTime < 0L) {
      this.transitionStartTime = paramLong;
    }
    updateTextureParam(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionAlphaFilter
 * JD-Core Version:    0.7.0.1
 */