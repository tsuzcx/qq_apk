package com.tencent.mobileqq.wink.editor.model;

import android.graphics.Point;
import java.io.Serializable;

public class PointF
  implements Serializable
{
  public float x;
  public float y;
  
  public PointF() {}
  
  public PointF(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public PointF(Point paramPoint)
  {
    this.x = paramPoint.x;
    this.y = paramPoint.y;
  }
  
  public static float length(float paramFloat1, float paramFloat2)
  {
    return (float)Math.hypot(paramFloat1, paramFloat2);
  }
  
  public final boolean equals(float paramFloat1, float paramFloat2)
  {
    return (this.x == paramFloat1) && (this.y == paramFloat2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (android.graphics.PointF)paramObject;
      if (Float.compare(paramObject.x, this.x) != 0) {
        return false;
      }
      return Float.compare(paramObject.y, this.y) == 0;
    }
    return false;
  }
  
  public int hashCode()
  {
    float f = this.x;
    int j = 0;
    int i;
    if (f != 0.0F) {
      i = Float.floatToIntBits(f);
    } else {
      i = 0;
    }
    f = this.y;
    if (f != 0.0F) {
      j = Float.floatToIntBits(f);
    }
    return i * 31 + j;
  }
  
  public final float length()
  {
    return length(this.x, this.y);
  }
  
  public final void negate()
  {
    this.x = (-this.x);
    this.y = (-this.y);
  }
  
  public final void offset(float paramFloat1, float paramFloat2)
  {
    this.x += paramFloat1;
    this.y += paramFloat2;
  }
  
  public final void set(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public final void set(android.graphics.PointF paramPointF)
  {
    this.x = paramPointF.x;
    this.y = paramPointF.y;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PointF(");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.y);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.model.PointF
 * JD-Core Version:    0.7.0.1
 */