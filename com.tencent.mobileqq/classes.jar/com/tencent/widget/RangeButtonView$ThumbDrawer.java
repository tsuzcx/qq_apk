package com.tencent.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

class RangeButtonView$ThumbDrawer
{
  public Bitmap bitmap;
  public int left;
  public int top;
  
  public RangeButtonView$ThumbDrawer(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    calculatePosition(paramInt1, paramInt2);
  }
  
  public void calculatePosition(int paramInt1, int paramInt2)
  {
    int i = this.bitmap.getWidth();
    int j = this.bitmap.getHeight();
    this.left = (paramInt1 - i / 2);
    this.top = (paramInt2 - j / 2);
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    paramCanvas.drawBitmap(this.bitmap, this.left, this.top, paramPaint);
  }
  
  public int getThumbHeight()
  {
    Bitmap localBitmap = this.bitmap;
    if (localBitmap == null) {
      return 0;
    }
    return localBitmap.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView.ThumbDrawer
 * JD-Core Version:    0.7.0.1
 */