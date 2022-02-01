package com.tencent.mobileqq.dinifly;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

public class SimpleColorFilter
  extends PorterDuffColorFilter
{
  public SimpleColorFilter(@ColorInt int paramInt)
  {
    super(paramInt, PorterDuff.Mode.SRC_ATOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.SimpleColorFilter
 * JD-Core Version:    0.7.0.1
 */