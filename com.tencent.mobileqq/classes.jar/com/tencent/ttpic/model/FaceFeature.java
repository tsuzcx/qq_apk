package com.tencent.ttpic.model;

import android.graphics.PointF;
import java.util.List;

public class FaceFeature
{
  public int height;
  public List<PointF> points;
  public int width;
  
  public FaceFeature(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    this.points = paramList;
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceFeature
 * JD-Core Version:    0.7.0.1
 */