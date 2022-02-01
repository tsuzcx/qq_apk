package com.tencent.mobileqq.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;

public class RoundRectColorDrawable
  extends ColorDrawable
{
  private float a;
  private final RectF b = new RectF();
  private final Paint c;
  private final int d;
  private final int e;
  
  public RoundRectColorDrawable(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.a = paramFloat;
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setColor(paramInt1);
    this.b.set(0.0F, 0.0F, paramInt2, paramInt3);
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public void draw(Canvas paramCanvas)
  {
    RectF localRectF = this.b;
    float f = this.a;
    paramCanvas.drawRoundRect(localRectF, f, f, this.c);
  }
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.drawable.RoundRectColorDrawable
 * JD-Core Version:    0.7.0.1
 */