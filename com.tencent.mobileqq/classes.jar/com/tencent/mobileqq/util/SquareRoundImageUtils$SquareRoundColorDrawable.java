package com.tencent.mobileqq.util;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class SquareRoundImageUtils$SquareRoundColorDrawable
  extends Drawable
{
  private Path a;
  private Paint b;
  private int c;
  private int d;
  private int e;
  
  public SquareRoundImageUtils$SquareRoundColorDrawable(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 > 0) && (paramInt3 > 0))
    {
      this.d = paramInt2;
      this.e = paramInt3;
      this.a = SquareRoundImageUtils.a(this.d, this.e);
    }
    this.c = paramInt1;
    this.b = new Paint();
    this.b.setStyle(Paint.Style.FILL);
    this.b.setAntiAlias(true);
    this.b.setColor(this.c);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = localRect.right - localRect.left;
    int j = localRect.bottom - localRect.top;
    if ((i != this.d) && (j != this.e))
    {
      this.d = i;
      this.e = j;
      this.a = SquareRoundImageUtils.a(this.d, this.e);
    }
    paramCanvas.save();
    paramCanvas.translate(localRect.left, localRect.top);
    paramCanvas.drawPath(this.a, this.b);
    paramCanvas.restore();
  }
  
  public int getOpacity()
  {
    int i = this.c >>> 24;
    if (i != 0)
    {
      if (i != 255) {
        return -3;
      }
      return -1;
    }
    return -2;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SquareRoundImageUtils.SquareRoundColorDrawable
 * JD-Core Version:    0.7.0.1
 */