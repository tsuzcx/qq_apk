package com.tencent.mobileqq.wink.pick.circle.widget;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class Util
{
  static int a(int paramInt)
  {
    return (paramInt & 0xFF00) >> 8;
  }
  
  static boolean a(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    if (Util.1.a[paramScaleType.ordinal()] != 1) {
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
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.Util
 * JD-Core Version:    0.7.0.1
 */