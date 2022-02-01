package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class ImageViewCatchRecycle
  extends ImageView
{
  public ImageViewCatchRecycle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
      QLog.d("ImageViewCatchRecycle", 2, "onDraw() Canvas: trying to use a recycled bitmap");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageViewCatchRecycle
 * JD-Core Version:    0.7.0.1
 */