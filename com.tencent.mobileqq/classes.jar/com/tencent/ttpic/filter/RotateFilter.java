package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;

public class RotateFilter
  extends BaseFilter
{
  public RotateFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void setDegree(float paramFloat)
  {
    setPositions(new float[] { (float)(-Math.cos(paramFloat * 3.141592653589793D / 180.0D) + Math.sin(paramFloat * 3.141592653589793D / 180.0D)), (float)(-Math.cos(paramFloat * 3.141592653589793D / 180.0D) - Math.sin(paramFloat * 3.141592653589793D / 180.0D)), (float)(-Math.cos(paramFloat * 3.141592653589793D / 180.0D) - Math.sin(paramFloat * 3.141592653589793D / 180.0D)), (float)(Math.cos(paramFloat * 3.141592653589793D / 180.0D) - Math.sin(paramFloat * 3.141592653589793D / 180.0D)), (float)(Math.cos(paramFloat * 3.141592653589793D / 180.0D) - Math.sin(paramFloat * 3.141592653589793D / 180.0D)), (float)(Math.cos(paramFloat * 3.141592653589793D / 180.0D) + Math.sin(paramFloat * 3.141592653589793D / 180.0D)), (float)(Math.cos(paramFloat * 3.141592653589793D / 180.0D) + Math.sin(paramFloat * 3.141592653589793D / 180.0D)), (float)(-Math.cos(paramFloat * 3.141592653589793D / 180.0D) + Math.sin(paramFloat * 3.141592653589793D / 180.0D)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.RotateFilter
 * JD-Core Version:    0.7.0.1
 */