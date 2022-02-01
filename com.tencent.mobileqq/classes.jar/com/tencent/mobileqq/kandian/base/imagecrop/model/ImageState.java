package com.tencent.mobileqq.kandian.base.imagecrop.model;

import android.graphics.RectF;
import android.support.annotation.NonNull;

public class ImageState
{
  private RectF a;
  private RectF b;
  private float c;
  private float d;
  
  public ImageState(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    this.a = paramRectF1;
    this.b = paramRectF2;
    this.c = paramFloat1;
    this.d = paramFloat2;
  }
  
  public RectF a()
  {
    return this.a;
  }
  
  public RectF b()
  {
    return this.b;
  }
  
  public float c()
  {
    return this.c;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cropRect:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ,imageRect:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ,scale:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ,angle:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.model.ImageState
 * JD-Core Version:    0.7.0.1
 */