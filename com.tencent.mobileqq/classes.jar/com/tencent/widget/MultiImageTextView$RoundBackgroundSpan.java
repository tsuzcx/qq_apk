package com.tencent.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

class MultiImageTextView$RoundBackgroundSpan
  extends ReplacementSpan
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  private float a(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + 10.0F + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + 40.0F;
    }
    return paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + 40.0F;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    Object localObject = paramPaint.getFontMetricsInt();
    localObject = new RectF(2.0F + paramFloat, ((Paint.FontMetricsInt)localObject).top + paramInt4 + 2, a(paramPaint, paramCharSequence, paramInt1, paramInt2) + paramFloat - 2.0F, ((Paint.FontMetricsInt)localObject).bottom + paramInt4 - 2);
    paramPaint.setColor(this.jdField_a_of_type_Int);
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setAntiAlias(true);
    paramPaint.setStrokeWidth(2.0F);
    paramCanvas.drawRoundRect((RectF)localObject, 10.0F, 10.0F, paramPaint);
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setColor(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      paramInt3 = paramInt5 - paramInt3;
      if (i < paramInt3)
      {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 20.0F + paramFloat, (paramInt3 - i) / 2, paramPaint);
        paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, 20.0F + paramFloat + 10.0F + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), paramInt4, paramPaint);
        return;
      }
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + 20.0F, paramInt4, paramPaint);
      return;
    }
    paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + 20.0F, paramInt4, paramPaint);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return Math.round(a(paramPaint, paramCharSequence, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView.RoundBackgroundSpan
 * JD-Core Version:    0.7.0.1
 */