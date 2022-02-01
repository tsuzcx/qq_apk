package com.tencent.ttpic.filter;

import android.graphics.RectF;

public class BeautyBodyThinShoulder$ThinShoulderParameters
{
  public RectF rect;
  
  public BeautyBodyThinShoulder$ThinShoulderParameters(BeautyBodyThinShoulder paramBeautyBodyThinShoulder)
  {
    this.rect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public BeautyBodyThinShoulder$ThinShoulderParameters(BeautyBodyThinShoulder paramBeautyBodyThinShoulder, RectF paramRectF)
  {
    this.rect = paramRectF;
  }
  
  public ThinShoulderParameters copy()
  {
    return new ThinShoulderParameters(this.this$0, new RectF(this.rect));
  }
  
  public void reset()
  {
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyBodyThinShoulder.ThinShoulderParameters
 * JD-Core Version:    0.7.0.1
 */