package com.tencent.mobileqq.widget;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;

public class VerticalCenterMarginImageSpan
  extends VerticalCenterImageSpan
{
  private int a;
  
  public VerticalCenterMarginImageSpan(Drawable paramDrawable)
  {
    super(paramDrawable, 0);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt) + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VerticalCenterMarginImageSpan
 * JD-Core Version:    0.7.0.1
 */