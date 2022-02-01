package com.tencent.mobileqq.qqexpand.flutter.apng;

import android.graphics.Rect;

public class ApngDrawableWrapper$ScaleRectSet
{
  public Rect a;
  public String a;
  public Rect b = new Rect();
  
  public ApngDrawableWrapper$ScaleRectSet()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public static ScaleRectSet a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    ScaleRectSet localScaleRectSet = new ScaleRectSet();
    localScaleRectSet.jdField_a_of_type_JavaLangString = a(paramRect1, paramRect2, paramInt);
    localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.set(paramRect1);
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
          localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.left = ((paramRect1.width() - paramInt) / 2);
          paramRect1 = localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect;
          paramRect1.right = (paramRect1.left + paramInt);
          return localScaleRectSet;
        }
        paramInt = (int)(paramRect1.width() / f2);
        localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.top = ((paramRect1.height() - paramInt) / 2);
        paramRect1 = localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.apng.ApngDrawableWrapper.ScaleRectSet
 * JD-Core Version:    0.7.0.1
 */