package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaFlipFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "translateX", "translateY" };
  
  public ShakaFlipFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_FLIP);
  }
  
  private void setParams(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("x", paramFloat1));
    addParam(new UniformParam.FloatParam("y", paramFloat2));
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
    setParams(0.0F, 0.0F);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    setParams(((Float)paramMap.get("translateX")).floatValue(), ((Float)paramMap.get("translateY")).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaFlipFilter
 * JD-Core Version:    0.7.0.1
 */