package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.LongLegFilter;
import java.util.List;

public class PTFilter$PTLongLegFilter
  extends PTFilter
{
  private boolean enable = true;
  private LongLegFilter mLongLegFilter = new LongLegFilter();
  private Frame mLongLegFrame = new Frame();
  private float strength = 0.0F;
  
  public void destroy()
  {
    this.mLongLegFilter.clearGLSLSelf();
    this.mLongLegFrame.clear();
    super.destroy();
  }
  
  public float getStrength()
  {
    return this.strength;
  }
  
  public int init()
  {
    int i = super.init();
    this.mLongLegFilter.ApplyGLSLFilter();
    return i;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
  {
    Frame localFrame = paramFrame;
    if (this.enable)
    {
      this.mLongLegFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mLongLegFrame);
      localFrame = this.mLongLegFrame;
    }
    return localFrame;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setStrength(float paramFloat)
  {
    this.mLongLegFilter.setStrength(paramFloat);
    this.strength = paramFloat;
  }
  
  public void setWaistLine(List<PointF> paramList, int paramInt)
  {
    this.mLongLegFilter.setWaistLine(paramList, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTFilter.PTLongLegFilter
 * JD-Core Version:    0.7.0.1
 */