package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaNineTileFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "xMin", "xMax", "yMin", "yMax" };
  
  public ShakaNineTileFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_NINE_TILE);
  }
  
  private void setParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    addParam(new UniformParam.FloatParam("x_min", paramFloat1));
    addParam(new UniformParam.FloatParam("x_max", paramFloat2));
    addParam(new UniformParam.FloatParam("y_min", paramFloat3));
    addParam(new UniformParam.FloatParam("y_max", paramFloat4));
  }
  
  protected float getDefaultParamValue()
  {
    return 0.0F;
  }
  
  protected String[] getParamKeys()
  {
    return PARAM_KEYS;
  }
  
  public void initParams()
  {
    setParams(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    setParams(((Float)paramMap.get("xMin")).floatValue(), ((Float)paramMap.get("xMax")).floatValue(), ((Float)paramMap.get("yMin")).floatValue(), ((Float)paramMap.get("yMax")).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaNineTileFilter
 * JD-Core Version:    0.7.0.1
 */