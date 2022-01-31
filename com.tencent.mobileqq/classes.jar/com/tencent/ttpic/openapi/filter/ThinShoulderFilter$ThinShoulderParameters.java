package com.tencent.ttpic.openapi.filter;

import android.graphics.RectF;

class ThinShoulderFilter$ThinShoulderParameters
{
  private RectF rect;
  
  public ThinShoulderFilter$ThinShoulderParameters(ThinShoulderFilter paramThinShoulderFilter)
  {
    this.rect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public ThinShoulderFilter$ThinShoulderParameters(ThinShoulderFilter paramThinShoulderFilter, RectF paramRectF)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.ThinShoulderFilter.ThinShoulderParameters
 * JD-Core Version:    0.7.0.1
 */