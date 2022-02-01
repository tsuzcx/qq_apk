package com.tencent.tav.coremedia;

import android.graphics.PointF;
import android.support.annotation.NonNull;

public class CGRect
  implements Cloneable
{
  @NonNull
  public final PointF origin;
  @NonNull
  public final CGSize size;
  
  public CGRect()
  {
    this.origin = new PointF();
    this.size = new CGSize();
  }
  
  public CGRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new PointF(paramFloat1, paramFloat2), new CGSize(paramFloat3, paramFloat4));
  }
  
  public CGRect(@NonNull PointF paramPointF, @NonNull CGSize paramCGSize)
  {
    Utils.a(paramPointF);
    Utils.a(paramCGSize);
    PointF localPointF = paramPointF;
    if (paramPointF == null) {
      localPointF = new PointF();
    }
    paramPointF = paramCGSize;
    if (paramCGSize == null) {
      paramPointF = new CGSize();
    }
    this.origin = localPointF;
    this.size = paramPointF;
  }
  
  public CGRect clone()
  {
    return new CGRect(this.origin.x, this.origin.y, this.size.width, this.size.height);
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
      paramObject = (CGRect)paramObject;
      return (this.origin.equals(paramObject.origin)) && (this.size.equals(paramObject.size));
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.origin);
    localStringBuilder.append(",");
    localStringBuilder.append(this.size);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.coremedia.CGRect
 * JD-Core Version:    0.7.0.1
 */