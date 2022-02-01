package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.SlimWaistFilter;
import java.util.List;

public class PTFilter$PTSlimWaistFilter
  extends PTFilter
{
  private boolean enable = true;
  private SlimWaistFilter mSlimWaistFilter = new SlimWaistFilter();
  private Frame mSlimWaistFrame = new Frame();
  private float strength = 0.0F;
  
  public void destroy()
  {
    this.mSlimWaistFilter.clearGLSLSelf();
    this.mSlimWaistFrame.clear();
    super.destroy();
  }
  
  public float getStrength()
  {
    return this.strength;
  }
  
  public int init()
  {
    int i = super.init();
    this.mSlimWaistFilter.ApplyGLSLFilter();
    return i;
  }
  
  public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
  {
    this.mSlimWaistFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mSlimWaistFrame);
    return this.mSlimWaistFrame;
  }
  
  public void setStatusReset()
  {
    this.mSlimWaistFilter.setStatusReset();
  }
  
  public void setStrength(float paramFloat)
  {
    this.mSlimWaistFilter.setStrength(paramFloat);
    this.strength = paramFloat;
  }
  
  public boolean setWaistRectangle(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    return this.mSlimWaistFilter.setWaistRectangle(paramList, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTFilter.PTSlimWaistFilter
 * JD-Core Version:    0.7.0.1
 */