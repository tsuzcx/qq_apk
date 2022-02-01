package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.ThinShoulderFilter;
import java.util.List;

public class PTFilter$PTThinShoulderFilter
  extends PTFilter
{
  private boolean enable = true;
  private ThinShoulderFilter mThinShoulderFilter = new ThinShoulderFilter();
  private Frame mThinShoulderFrame = new Frame();
  private float strength = 0.0F;
  
  public void destroy()
  {
    this.mThinShoulderFilter.clearGLSLSelf();
    this.mThinShoulderFrame.clear();
    super.destroy();
  }
  
  public float getStrength()
  {
    return this.strength;
  }
  
  public int init()
  {
    int i = super.init();
    this.mThinShoulderFilter.ApplyGLSLFilter();
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
      this.mThinShoulderFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mThinShoulderFrame);
      localFrame = this.mThinShoulderFrame;
    }
    return localFrame;
  }
  
  public boolean setBodyPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    return this.mThinShoulderFilter.setupBodyPoints(paramList, paramInt1, paramInt2);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mThinShoulderFilter.setShowMark(true);
    this.mThinShoulderFilter.setEnable(paramBoolean);
    this.enable = paramBoolean;
  }
  
  public void setStrength(float paramFloat)
  {
    this.mThinShoulderFilter.setStrength(paramFloat);
    this.strength = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTThinShoulderFilter
 * JD-Core Version:    0.7.0.1
 */