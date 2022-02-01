package com.tencent.ttpic.util;

import android.graphics.PointF;

public class PointWithIndex
{
  public int index;
  public PointF point;
  
  public PointWithIndex(float paramFloat1, float paramFloat2, int paramInt)
  {
    this.point = new PointF(paramFloat1, paramFloat2);
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.PointWithIndex
 * JD-Core Version:    0.7.0.1
 */