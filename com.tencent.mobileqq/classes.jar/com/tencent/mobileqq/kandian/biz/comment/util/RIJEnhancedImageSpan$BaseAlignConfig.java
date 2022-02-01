package com.tencent.mobileqq.kandian.biz.comment.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

abstract class RIJEnhancedImageSpan$BaseAlignConfig
  implements RIJEnhancedImageSpan.IAlignConfig
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int b;
  private int c;
  private int d;
  
  private void a(Rect paramRect, Paint paramPaint)
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Float > 0.0F)
    {
      i = (int)((int)paramPaint.getTextSize() * this.jdField_a_of_type_Float);
      j = paramRect.right * i / paramRect.bottom;
    }
    else
    {
      i = this.b;
      j = this.jdField_a_of_type_Int;
    }
    int k;
    if (j > 0)
    {
      k = j;
      j = i;
      if (i > 0) {}
    }
    else
    {
      k = paramRect.right;
      j = paramRect.bottom;
    }
    paramRect = this.jdField_a_of_type_ArrayOfInt;
    paramRect[0] = k;
    paramRect[1] = j;
  }
  
  abstract int a(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint, Paint.FontMetricsInt paramFontMetricsInt, int paramInt6, int paramInt7);
  
  abstract int a(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt, int paramInt3, int paramInt4);
  
  public int a(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt, Drawable paramDrawable)
  {
    a(paramDrawable.getBounds(), paramPaint);
    paramDrawable = this.jdField_a_of_type_ArrayOfInt;
    int i = 0;
    int k = paramDrawable[0];
    int m = paramDrawable[1];
    int j;
    if (paramFontMetricsInt != null)
    {
      i = paramFontMetricsInt.top - paramFontMetricsInt.ascent;
      j = paramFontMetricsInt.bottom - paramFontMetricsInt.descent;
    }
    else
    {
      j = 0;
    }
    paramInt1 = a(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt, k, m);
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.top = (paramFontMetricsInt.ascent + i);
      paramFontMetricsInt.bottom = (paramFontMetricsInt.descent + j);
    }
    return this.c + paramInt1 + this.d;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public void a(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint, Drawable paramDrawable)
  {
    Rect localRect = paramDrawable.getBounds();
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    paramInt1 = a(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint, paramPaint.getFontMetricsInt(), i, j);
    float f1 = i / localRect.right;
    float f2 = j / localRect.bottom;
    paramCanvas.save();
    paramCanvas.translate(paramFloat + this.c, paramInt1);
    paramCanvas.scale(f1, f2);
    paramDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.RIJEnhancedImageSpan.BaseAlignConfig
 * JD-Core Version:    0.7.0.1
 */