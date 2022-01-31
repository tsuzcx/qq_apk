package com.tencent.ttpic.openapi.filterwrapper;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.ContrastFilter;

public class ContrastFilterWrapper
{
  private ContrastFilter contrastFilter = new ContrastFilter();
  
  public void ClearGLSL()
  {
    this.contrastFilter.ClearGLSL();
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    this.contrastFilter.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
  }
  
  public void apply()
  {
    this.contrastFilter.apply();
  }
  
  public boolean needRender()
  {
    return this.contrastFilter.needRender();
  }
  
  public void setContrastLevel(int paramInt)
  {
    this.contrastFilter.setContrastLevel(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filterwrapper.ContrastFilterWrapper
 * JD-Core Version:    0.7.0.1
 */