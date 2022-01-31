package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.TextureParam;
import com.tencent.ttpic.util.VideoFilterUtil;

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
    paramDouble3 = (paramDouble3 - paramDouble1) / (paramDouble2 - paramDouble1);
    switch (this.easeCurve)
    {
    default: 
      return (paramDouble2 - paramDouble1) * paramDouble3 + paramDouble1;
    case 1: 
      return -(paramDouble2 - paramDouble1) * Math.cos(1.570796326794897D * paramDouble3) + paramDouble2;
    case 2: 
      return (paramDouble2 - paramDouble1) * Math.sin(1.570796326794897D * paramDouble3) + paramDouble1;
    }
    return -(paramDouble2 - paramDouble1) / 2.0D * (Math.cos(3.141592653589793D * paramDouble3) - 1.0D) + paramDouble1;
  }
  
  private void initParams()
  {
    addParam(new Param.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new Param.FloatParam("alpha", 0.0F));
  }
  
  private void updateTextureParam(long paramLong)
  {
    float f = (float)(getDuration(this.transitionStartTime, this.transitionStartTime + this.transitionDuration, paramLong) - this.transitionStartTime) / (float)this.transitionDuration;
    if (f > 1.0F)
    {
      addParam(new Param.FloatParam("alpha", 1.0F));
      clearTextureParam();
      return;
    }
    addParam(new Param.FloatParam("alpha", f));
  }
  
  protected void clearTextureParam()
  {
    setPositions(VideoFilterUtil.EMPTY_POSITIONS);
    this.transitionStartTime = -1L;
  }
  
  public void reset()
  {
    if (this.transitionStartTime > 0L)
    {
      this.transitionStartTime = -1L;
      setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
    }
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
    addParam(new Param.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void updatePreview(long paramLong)
  {
    if (this.transitionStartTime < 0L) {
      this.transitionStartTime = paramLong;
    }
    updateTextureParam(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionAlphaFilter
 * JD-Core Version:    0.7.0.1
 */