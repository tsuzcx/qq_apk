package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.ThinBodyFilter;
import java.util.List;

public class PTFilter$PTThinBodyFilter
  extends PTFilter
{
  private boolean enable = true;
  private ThinBodyFilter mThinBodyFilter = new ThinBodyFilter();
  private Frame mThinBodyFrame = new Frame();
  private float strength = 0.0F;
  
  public void destroy()
  {
    this.mThinBodyFilter.clearGLSLSelf();
    this.mThinBodyFrame.clear();
    super.destroy();
  }
  
  public float getStrength()
  {
    return this.strength;
  }
  
  public int init()
  {
    int i = super.init();
    this.mThinBodyFilter.ApplyGLSLFilter();
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
      this.mThinBodyFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mThinBodyFrame);
      localFrame = this.mThinBodyFrame;
    }
    return localFrame;
  }
  
  public void setBodyPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.mThinBodyFilter.setupBodyPoints(paramList, paramInt1, paramInt2);
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mThinBodyFilter.setShowMark(true);
    this.mThinBodyFilter.setEnable(paramBoolean);
    this.enable = paramBoolean;
  }
  
  public void setStrength(float paramFloat)
  {
    this.mThinBodyFilter.setStrength(paramFloat);
    this.strength = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTThinBodyFilter
 * JD-Core Version:    0.7.0.1
 */