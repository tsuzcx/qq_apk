package com.tencent.mobileqq.olympic.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;

public class PaddingAbleImgSpan
  extends DynamicDrawableSpan
{
  int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  int b;
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCanvas.save();
    paramInt2 = paramInt5 - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().bottom;
    paramInt1 = paramInt2;
    if (this.mVerticalAlignment == 1) {
      paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
    }
    paramCanvas.translate(this.jdField_a_of_type_Int + paramFloat, paramInt1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt) + this.jdField_a_of_type_Int + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.PaddingAbleImgSpan
 * JD-Core Version:    0.7.0.1
 */