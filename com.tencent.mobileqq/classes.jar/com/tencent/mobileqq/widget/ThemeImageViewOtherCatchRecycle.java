package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class ThemeImageViewOtherCatchRecycle
  extends ThemeImageView
{
  public ThemeImageViewOtherCatchRecycle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setMaskShape(ThemeImageWrapper.MODE_OTHER);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      label6:
      break label6;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeImageViewOtherCatchRecycle", 2, "onDraw() Canvas: trying to use a recycled bitmap");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ThemeImageViewOtherCatchRecycle
 * JD-Core Version:    0.7.0.1
 */