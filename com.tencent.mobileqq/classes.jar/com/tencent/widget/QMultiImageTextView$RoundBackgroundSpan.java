package com.tencent.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.tencent.qphone.base.util.QLog;

class QMultiImageTextView$RoundBackgroundSpan
  extends ReplacementSpan
{
  private static final int iconPadding = 10;
  private static final int padding = 20;
  private int mLabelColor;
  private Bitmap mLabelIcon;
  
  public QMultiImageTextView$RoundBackgroundSpan(int paramInt1, int paramInt2, Resources paramResources)
  {
    this.mLabelColor = paramInt1;
    if (paramInt2 != 0)
    {
      try
      {
        this.mLabelIcon = BitmapFactory.decodeResource(paramResources, paramInt2);
        return;
      }
      catch (OutOfMemoryError paramResources)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("RoundbackgroundSpan", 2, paramResources, new Object[0]);
    }
    else
    {
      this.mLabelIcon = null;
    }
  }
  
  private float measureText(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (this.mLabelIcon != null) {}
    for (float f = paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + 10.0F + this.mLabelIcon.getWidth();; f = paramPaint.measureText(paramCharSequence, paramInt1, paramInt2)) {
      return f + 40.0F;
    }
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    Object localObject = paramPaint.getFontMetricsInt();
    localObject = new RectF(paramFloat + 2.0F, ((Paint.FontMetricsInt)localObject).top + paramInt4 + 2, paramFloat + measureText(paramPaint, paramCharSequence, paramInt1, paramInt2) - 2.0F, ((Paint.FontMetricsInt)localObject).bottom + paramInt4 - 2);
    paramPaint.setColor(this.mLabelColor);
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setAntiAlias(true);
    paramPaint.setStrokeWidth(2.0F);
    paramCanvas.drawRoundRect((RectF)localObject, 10.0F, 10.0F, paramPaint);
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setColor(this.mLabelColor);
    localObject = this.mLabelIcon;
    if (localObject != null)
    {
      int i = ((Bitmap)localObject).getHeight();
      paramInt3 = paramInt5 - paramInt3;
      if (i < paramInt3)
      {
        localObject = this.mLabelIcon;
        paramFloat += 20.0F;
        paramCanvas.drawBitmap((Bitmap)localObject, paramFloat, (paramInt3 - i) / 2, paramPaint);
        paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + 10.0F + this.mLabelIcon.getWidth(), paramInt4, paramPaint);
        return;
      }
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + 20.0F, paramInt4, paramPaint);
      return;
    }
    paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + 20.0F, paramInt4, paramPaint);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return Math.round(measureText(paramPaint, paramCharSequence, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.QMultiImageTextView.RoundBackgroundSpan
 * JD-Core Version:    0.7.0.1
 */