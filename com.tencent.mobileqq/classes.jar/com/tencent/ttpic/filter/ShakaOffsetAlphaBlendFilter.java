package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaOffsetAlphaBlendFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "translateXup", "translateYup", "translateXdown", "translateYdown" };
  
  public ShakaOffsetAlphaBlendFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_OFFSET_ALPHA_BLEND);
  }
  
  private void setParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    addParam(new UniformParam.Float2fParam("offset1", paramFloat1, paramFloat2));
    addParam(new UniformParam.Float2fParam("offset2", paramFloat3, paramFloat4));
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
    setParams(((Float)paramMap.get("translateXup")).floatValue(), ((Float)paramMap.get("translateYup")).floatValue(), ((Float)paramMap.get("translateXdown")).floatValue(), ((Float)paramMap.get("translateYdown")).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaOffsetAlphaBlendFilter
 * JD-Core Version:    0.7.0.1
 */