package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class VerticalCenterImageSpan
  extends ImageSpan
{
  private int mLeftPadding = 0;
  private int mRightPadding = 0;
  
  public VerticalCenterImageSpan(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
  }
  
  public VerticalCenterImageSpan(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    paramInt1 = (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2;
    paramCanvas.translate(paramFloat + this.mLeftPadding - this.mRightPadding, paramInt1 + paramInt3);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt2 = paramPaint.bottom;
      int i = paramPaint.top;
      paramInt1 = (paramCharSequence.bottom - paramCharSequence.top) / 2;
      i = (paramInt2 - i) / 4;
      paramInt2 = paramInt1 - i;
      paramInt1 = -(paramInt1 + i);
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      paramFontMetricsInt.bottom = paramInt2;
      paramFontMetricsInt.descent = paramInt2;
    }
    return paramCharSequence.right + this.mLeftPadding + this.mRightPadding;
  }
  
  public void setPadding(int paramInt1, int paramInt2)
  {
    this.mLeftPadding = paramInt1;
    this.mRightPadding = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.VerticalCenterImageSpan
 * JD-Core Version:    0.7.0.1
 */