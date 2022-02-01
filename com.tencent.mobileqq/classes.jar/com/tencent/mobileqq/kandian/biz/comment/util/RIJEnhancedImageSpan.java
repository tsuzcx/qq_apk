package com.tencent.mobileqq.kandian.biz.comment.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RIJEnhancedImageSpan
  extends ImageSpan
{
  private Drawable a;
  private RIJEnhancedImageSpan.IAlignConfig b;
  
  public RIJEnhancedImageSpan(int paramInt)
  {
    this(null, paramInt);
  }
  
  public RIJEnhancedImageSpan(@NonNull Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
    a();
  }
  
  private void a()
  {
    int i = this.mVerticalAlignment;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          this.b = new RIJEnhancedImageSpan.AlignBottomConfig(null);
          return;
        }
        this.b = new RIJEnhancedImageSpan.AlignTopConfig(null);
        return;
      }
      this.b = new RIJEnhancedImageSpan.AlignCenterConfig(null);
      return;
    }
    this.b = new RIJEnhancedImageSpan.AlignBaselineConfig(null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b.a(paramInt1, paramInt2);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.a = paramDrawable;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.b.b(paramInt1, paramInt2);
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    Drawable localDrawable = getDrawable();
    this.b.a(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint, localDrawable);
  }
  
  public Drawable getDrawable()
  {
    if (this.a == null) {
      this.a = super.getDrawable();
    }
    return this.a;
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    Drawable localDrawable = getDrawable();
    return this.b.a(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt, localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.RIJEnhancedImageSpan
 * JD-Core Version:    0.7.0.1
 */