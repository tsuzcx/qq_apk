package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.filter.BeautyBodyFilter;
import java.util.List;

public class PTFilter$PTBeautyBodyFilter
  extends PTFilter
{
  private boolean enable = true;
  private BeautyBodyFilter mBeautyBodyFilter = new BeautyBodyFilter();
  private Frame mBeautyBodyFrame = new Frame();
  
  public void beautyBody(float paramFloat, List<PointF> paramList, int paramInt1, int paramInt2)
  {
    this.mBeautyBodyFilter.beautyBody(paramFloat, paramList, paramInt1, paramInt2);
  }
  
  public void beautyBody(float paramFloat, boolean paramBoolean, List<PointF> paramList, int paramInt1, int paramInt2)
  {
    this.mBeautyBodyFilter.beautyBody(paramFloat, paramBoolean, paramList, paramInt1, paramInt2);
  }
  
  public void beautyBody(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    this.mBeautyBodyFilter.beautyBody(paramList, paramInt1, paramInt2);
  }
  
  public void destroy()
  {
    this.mBeautyBodyFilter.clearGLSLSelf();
    this.mBeautyBodyFilter = null;
    this.mBeautyBodyFrame.clear();
    super.destroy();
  }
  
  public float getLongLegStrength()
  {
    return this.mBeautyBodyFilter.getStrength("LONG_LEG");
  }
  
  public float getSlimWaistStrength()
  {
    return this.mBeautyBodyFilter.getStrength("SLIM_WAIST");
  }
  
  public float getThinBodyStrength()
  {
    return this.mBeautyBodyFilter.getStrength("THIN_BODY");
  }
  
  public float getThinShoulderStrength()
  {
    return this.mBeautyBodyFilter.getStrength("THIN_SHOULDER");
  }
  
  public int init()
  {
    int i = super.init();
    if (this.mBeautyBodyFilter == null) {
      this.mBeautyBodyFilter = new BeautyBodyFilter();
    }
    this.mBeautyBodyFilter.ApplyGLSLFilter();
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
      this.mBeautyBodyFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mBeautyBodyFrame);
      localFrame = this.mBeautyBodyFrame;
    }
    return localFrame;
  }
  
  public void setLongLegEnable(boolean paramBoolean)
  {
    this.mBeautyBodyFilter.setEnableLeg(paramBoolean);
  }
  
  public void setLongLegStrength(float paramFloat)
  {
    BeautyBodyFilter localBeautyBodyFilter = this.mBeautyBodyFilter;
    if (localBeautyBodyFilter != null) {
      localBeautyBodyFilter.setStrength("LONG_LEG", paramFloat);
    }
  }
  
  public void setSlimWaistEnable(boolean paramBoolean)
  {
    this.mBeautyBodyFilter.setEnableWaist(paramBoolean);
  }
  
  public void setSlimWaistStrength(float paramFloat)
  {
    BeautyBodyFilter localBeautyBodyFilter = this.mBeautyBodyFilter;
    if (localBeautyBodyFilter != null) {
      localBeautyBodyFilter.setStrength("SLIM_WAIST", paramFloat);
    }
  }
  
  public void setThinBodyEnable(boolean paramBoolean)
  {
    this.mBeautyBodyFilter.setEnableBody(paramBoolean);
  }
  
  public void setThinBodyStrength(float paramFloat)
  {
    BeautyBodyFilter localBeautyBodyFilter = this.mBeautyBodyFilter;
    if (localBeautyBodyFilter != null) {
      localBeautyBodyFilter.setStrength("THIN_BODY", paramFloat);
    }
  }
  
  public void setThinShoulderEnable(boolean paramBoolean)
  {
    this.mBeautyBodyFilter.setEnableShoulder(paramBoolean);
  }
  
  public void setThinShoulderStrength(float paramFloat)
  {
    BeautyBodyFilter localBeautyBodyFilter = this.mBeautyBodyFilter;
    if (localBeautyBodyFilter != null) {
      localBeautyBodyFilter.setStrength("THIN_SHOULDER", paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTBeautyBodyFilter
 * JD-Core Version:    0.7.0.1
 */