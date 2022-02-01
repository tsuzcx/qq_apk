package com.tencent.mobileqq.structmsg;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class RoundedColorDrawable
  extends Drawable
{
  private int a = -16777216;
  private int b;
  private int c;
  private final Paint d = new Paint();
  private RectF e = null;
  private float f;
  
  public RoundedColorDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.e = new RectF();
    this.f = paramInt4;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.d.setColor(this.a);
    Object localObject = getBounds();
    this.e.top = ((Rect)localObject).top;
    this.e.left = ((Rect)localObject).left;
    this.e.right = ((Rect)localObject).right;
    this.e.bottom = ((Rect)localObject).bottom;
    localObject = this.e;
    float f1 = this.f;
    paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.d);
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.RoundedColorDrawable
 * JD-Core Version:    0.7.0.1
 */