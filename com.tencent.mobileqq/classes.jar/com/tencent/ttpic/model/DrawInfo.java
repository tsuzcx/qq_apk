package com.tencent.ttpic.model;

import android.graphics.PointF;

public class DrawInfo
{
  public float[] faceAngles;
  public int faceIndex;
  public float faceWidth;
  public PointF relativePoint;
  
  public DrawInfo(PointF paramPointF, int paramInt, float paramFloat, float[] paramArrayOfFloat)
  {
    this.relativePoint = paramPointF;
    this.faceIndex = paramInt;
    this.faceWidth = paramFloat;
    this.faceAngles = paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.DrawInfo
 * JD-Core Version:    0.7.0.1
 */