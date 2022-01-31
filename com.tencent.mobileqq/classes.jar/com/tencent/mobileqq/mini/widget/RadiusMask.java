package com.tencent.mobileqq.mini.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class RadiusMask
  extends Drawable
{
  private static final RectF sTmpRectF = new RectF();
  private int alpha;
  private ColorFilter color;
  private Paint mPaint;
  private float mRoundRadius;
  
  public RadiusMask(int paramInt1, Paint.Style paramStyle, float paramFloat1, int paramInt2, float paramFloat2)
  {
    this.mRoundRadius = paramFloat2;
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt1);
    this.mPaint.setAlpha(paramInt2);
    this.mPaint.setStyle(paramStyle);
    this.mPaint.setStrokeWidth(paramFloat1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    if ((i > 0) && (j > 0))
    {
      paramCanvas.save();
      sTmpRectF.set(localRect);
      paramCanvas.drawRoundRect(sTmpRectF, this.mRoundRadius, this.mRoundRadius, this.mPaint);
      paramCanvas.restore();
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.alpha = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.color = paramColorFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.RadiusMask
 * JD-Core Version:    0.7.0.1
 */