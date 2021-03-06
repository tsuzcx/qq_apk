package com.tencent.mobileqq.winkpublish.widget.multitouchimg;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Util
{
  static int a(int paramInt)
  {
    return (paramInt & 0xFF00) >> 8;
  }
  
  public static void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2)
    {
      if (paramFloat2 < paramFloat3) {
        return;
      }
      throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    }
    throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
  }
  
  public static boolean a(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    if (Util.1.a[paramScaleType.ordinal()] != 1) {
      return true;
    }
    throw new IllegalStateException("Matrix scale type is not supported");
  }
  
  public static boolean a(ImageView paramImageView)
  {
    return paramImageView.getDrawable() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.multitouchimg.Util
 * JD-Core Version:    0.7.0.1
 */