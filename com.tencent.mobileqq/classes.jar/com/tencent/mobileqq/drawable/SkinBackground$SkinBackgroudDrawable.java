package com.tencent.mobileqq.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

public class SkinBackground$SkinBackgroudDrawable
  extends BitmapDrawable
{
  private final Paint a;
  private Bitmap b;
  private Rect c;
  
  protected Rect a(Rect paramRect)
  {
    int i = getBitmap().getHeight();
    int k = getBitmap().getWidth();
    if (paramRect == null) {
      return new Rect(0, 0, k, i);
    }
    if (paramRect.height() / paramRect.width() >= i / k)
    {
      int j = paramRect.width() * i / paramRect.height();
      double d = k - j;
      Double.isNaN(d);
      k = (int)(d * 0.5D);
      return new Rect(k, 0, j + k, i);
    }
    return new Rect(0, 0, k, paramRect.height() * k / paramRect.width());
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.b, this.c, getBounds(), this.a);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.c = a(getBounds());
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.drawable.SkinBackground.SkinBackgroudDrawable
 * JD-Core Version:    0.7.0.1
 */