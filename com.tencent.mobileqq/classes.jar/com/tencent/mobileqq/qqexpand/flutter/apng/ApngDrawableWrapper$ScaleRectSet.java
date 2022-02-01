package com.tencent.mobileqq.qqexpand.flutter.apng;

import android.graphics.Rect;

public class ApngDrawableWrapper$ScaleRectSet
{
  public Rect a = new Rect();
  public Rect b = new Rect();
  public String c;
  
  public static String a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRect1.hashCode());
    localStringBuilder.append(",");
    localStringBuilder.append(paramRect2.hashCode());
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static ScaleRectSet b(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    ScaleRectSet localScaleRectSet = new ScaleRectSet();
    localScaleRectSet.c = a(paramRect1, paramRect2, paramInt);
    localScaleRectSet.a.set(paramRect1);
    localScaleRectSet.b.set(paramRect2);
    if ((paramInt != 0) && (paramRect1.width() != 0) && (paramRect1.height() != 0) && (paramRect2.width() != 0))
    {
      if (paramRect2.height() == 0) {
        return localScaleRectSet;
      }
      float f1 = paramRect1.width() * 1.0F / paramRect1.height();
      float f2 = paramRect2.width() * 1.0F / paramRect2.height();
      if (f1 == f2) {
        return localScaleRectSet;
      }
      if (paramInt == 1)
      {
        if (f1 > f2)
        {
          paramInt = (int)(paramRect1.height() * f2);
          localScaleRectSet.a.left = ((paramRect1.width() - paramInt) / 2);
          paramRect1 = localScaleRectSet.a;
          paramRect1.right = (paramRect1.left + paramInt);
          return localScaleRectSet;
        }
        paramInt = (int)(paramRect1.width() / f2);
        localScaleRectSet.a.top = ((paramRect1.height() - paramInt) / 2);
        paramRect1 = localScaleRectSet.a;
        paramRect1.bottom = (paramRect1.top + paramInt);
        return localScaleRectSet;
      }
      if (paramInt == 2)
      {
        if (f1 > f2)
        {
          paramInt = (int)(paramRect2.width() / f1);
          localScaleRectSet.b.top = ((paramRect2.height() - paramInt) / 2);
          paramRect1 = localScaleRectSet.b;
          paramRect1.bottom = (paramRect1.top + paramInt);
          return localScaleRectSet;
        }
        paramInt = (int)(paramRect2.height() * f1);
        localScaleRectSet.b.left = ((paramRect2.width() - paramInt) / 2);
        paramRect1 = localScaleRectSet.b;
        paramRect1.right += paramInt;
      }
    }
    return localScaleRectSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.apng.ApngDrawableWrapper.ScaleRectSet
 * JD-Core Version:    0.7.0.1
 */