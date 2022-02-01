package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import blfw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

public class ThemeImageViewOtherCatchRecycle
  extends ThemeImageView
{
  public ThemeImageViewOtherCatchRecycle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setMaskShape(blfw.c);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ThemeImageViewOtherCatchRecycle", 2, "onDraw() Canvas: trying to use a recycled bitmap");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ThemeImageViewOtherCatchRecycle
 * JD-Core Version:    0.7.0.1
 */