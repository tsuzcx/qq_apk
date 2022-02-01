package com.tencent.mobileqq.kandian.biz.comment.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class RIJEnhancedImageSpan$AlignTopConfig
  extends RIJEnhancedImageSpan.BaseAlignConfig
{
  private RIJEnhancedImageSpan$AlignTopConfig()
  {
    super(null);
  }
  
  public int a(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint, Paint.FontMetricsInt paramFontMetricsInt, int paramInt6, int paramInt7)
  {
    return paramInt4 + paramFontMetricsInt.ascent;
  }
  
  public int a(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt, int paramInt3, int paramInt4)
  {
    if (paramFontMetricsInt != null) {
      paramFontMetricsInt.descent = (paramInt4 + paramFontMetricsInt.ascent);
    }
    return paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.RIJEnhancedImageSpan.AlignTopConfig
 * JD-Core Version:    0.7.0.1
 */