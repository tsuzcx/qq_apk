package com.tencent.mobileqq.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class OffsetableImageSpan
  extends ImageSpan
{
  private float mVerticalOffsetPercent;
  private int mVerticalOffsetValue;
  
  public OffsetableImageSpan(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    paramInt2 = paramInt5 - paramCharSequence.getBounds().bottom;
    paramInt1 = paramInt2;
    if (this.mVerticalAlignment == 1) {
      paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
    }
    if ((this.mVerticalOffsetValue == 0) && (this.mVerticalOffsetPercent != 0.0F)) {
      this.mVerticalOffsetValue = ((int)((paramInt5 - paramInt3) * this.mVerticalOffsetPercent));
    }
    paramCanvas.translate(paramFloat, paramInt1 + this.mVerticalOffsetValue);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public OffsetableImageSpan setOffset(float paramFloat)
  {
    this.mVerticalOffsetPercent = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.OffsetableImageSpan
 * JD-Core Version:    0.7.0.1
 */