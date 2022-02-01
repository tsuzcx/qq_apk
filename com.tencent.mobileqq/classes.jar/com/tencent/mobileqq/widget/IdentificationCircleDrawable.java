package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class IdentificationCircleDrawable
  extends Drawable
{
  private Paint a = new Paint();
  private Paint b;
  private Path c;
  private Path d;
  private RectF e = new RectF();
  private ColorMatrixColorFilter f;
  private Paint g;
  private float h;
  
  public IdentificationCircleDrawable()
  {
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL);
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(Color.argb(200, 0, 0, 0));
    this.a.setColor(-1);
    this.c = new Path();
    this.d = new Path();
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setStyle(Paint.Style.FILL);
    this.g.setColor(0);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.c.reset();
    this.d.reset();
    Object localObject = getBounds();
    int i = ((Rect)localObject).width();
    int j = ((Rect)localObject).height();
    if (this.h > Math.min(i, j)) {
      return;
    }
    localObject = this.e;
    float f1 = j;
    float f2 = f1 / 2.0F;
    float f3 = this.h;
    ((RectF)localObject).bottom = (f2 + f3);
    ((RectF)localObject).top = (f2 - f3);
    float f4 = i;
    float f5 = f4 / 2.0F;
    ((RectF)localObject).left = (f5 - f3);
    ((RectF)localObject).right = (f3 + f5);
    this.c.moveTo(0.0F, f2);
    this.c.lineTo(0.0F, 0.0F);
    this.c.lineTo(f4, 0.0F);
    this.c.lineTo(f4, f2);
    this.c.lineTo(this.e.right, f2);
    this.c.arcTo(this.e, 0.0F, -180.0F, true);
    this.c.lineTo(this.e.left, f2);
    this.c.close();
    this.d.moveTo(0.0F, f2);
    this.d.lineTo(0.0F, f1);
    this.d.lineTo(f4, f1);
    this.d.lineTo(f4, f2);
    this.c.lineTo(this.e.right, f2);
    this.d.arcTo(this.e, 0.0F, 180.0F, true);
    this.c.lineTo(this.e.left, f2);
    this.d.close();
    paramCanvas.drawPath(this.c, this.a);
    paramCanvas.drawPath(this.d, this.a);
    if (this.g.getColor() != 0) {
      paramCanvas.drawCircle(f5, f2, this.h, this.g);
    }
    if (this.f != null)
    {
      paramCanvas.drawPath(this.c, this.b);
      paramCanvas.drawPath(this.d, this.b);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IdentificationCircleDrawable
 * JD-Core Version:    0.7.0.1
 */