package com.tencent.mobileqq.kandian.biz.comment.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

abstract interface RIJEnhancedImageSpan$IAlignConfig
{
  public abstract int a(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt, Drawable paramDrawable);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint, Drawable paramDrawable);
  
  public abstract void b(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.RIJEnhancedImageSpan.IAlignConfig
 * JD-Core Version:    0.7.0.1
 */