package dov.com.qq.im.ae.biz.qcircle.widget;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class Util
{
  static int a(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8;
  }
  
  static void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= paramFloat2) {
      throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
    }
    if (paramFloat2 >= paramFloat3) {
      throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    }
  }
  
  static boolean a(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    switch (Util.1.a[paramScaleType.ordinal()])
    {
    default: 
      return true;
    }
    throw new IllegalStateException("Matrix scale type is not supported");
  }
  
  static boolean a(ImageView paramImageView)
  {
    return paramImageView.getDrawable() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.widget.Util
 * JD-Core Version:    0.7.0.1
 */