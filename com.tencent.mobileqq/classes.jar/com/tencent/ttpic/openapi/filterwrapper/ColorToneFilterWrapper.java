package com.tencent.ttpic.openapi.filterwrapper;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.ColorToneFilter;

public class ColorToneFilterWrapper
{
  private ColorToneFilter colorToneFilter = new ColorToneFilter();
  
  public void ClearGLSL()
  {
    this.colorToneFilter.ClearGLSL();
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.colorToneFilter.RenderProcess(paramInt1, paramInt2, paramInt3);
  }
  
  public void apply()
  {
    this.colorToneFilter.apply();
  }
  
  public ColorToneFilter getColorToneFilter()
  {
    return this.colorToneFilter;
  }
  
  public boolean needRender()
  {
    return this.colorToneFilter.needRender();
  }
  
  public void updateAlpha(float paramFloat)
  {
    this.colorToneFilter.updateAlpha(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filterwrapper.ColorToneFilterWrapper
 * JD-Core Version:    0.7.0.1
 */