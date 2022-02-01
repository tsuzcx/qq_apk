package com.tencent.smtt.sdk.ui.dialog.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class a
  extends View
{
  private int a;
  private int b;
  private Paint c;
  private Paint d;
  private Path e;
  private Path f;
  private RectF g;
  private float[] h;
  private float i;
  private float j;
  
  public a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramContext, null, 0);
    a(paramContext, paramFloat1, paramFloat2, paramFloat3);
  }
  
  private int a(int paramInt)
  {
    int k = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (k == 1073741824) {
      return paramInt;
    }
    if (k == -2147483648) {
      return Math.min(100, paramInt);
    }
    return 100;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.i = paramFloat2;
    this.j = paramFloat3;
    int k = Color.parseColor("#989DB4");
    paramFloat2 = a(paramContext, 6.0F);
    this.c = new Paint();
    this.d = new Paint();
    this.d.setColor(-1);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setAntiAlias(true);
    this.c.setColor(k);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setAntiAlias(true);
    this.c.setStrokeWidth(paramFloat2);
    this.c.setStrokeJoin(Paint.Join.ROUND);
    this.g = new RectF();
    this.h = new float[] { paramFloat1, paramFloat1, paramFloat1, paramFloat1, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.translate(0.0F, 0.0F);
    paramCanvas.rotate(0.0F);
    if (this.f == null) {
      this.f = new Path();
    }
    this.f.reset();
    this.f.addRoundRect(this.g, this.h, Path.Direction.CCW);
    this.f.close();
    paramCanvas.drawPath(this.f, this.d);
    paramCanvas.translate(this.a / 2.0F, this.b / 2.0F + this.j / 2.0F);
    if (this.e == null) {
      this.e = new Path();
    }
    this.e.reset();
    this.e.moveTo(0.0F, 0.0F);
    this.e.lineTo(-this.i / 2.0F, -this.j / 2.0F);
    this.e.close();
    paramCanvas.drawPath(this.e, this.c);
    this.e.reset();
    this.e.moveTo(0.0F, 0.0F);
    this.e.lineTo(this.i / 2.0F, -this.j / 2.0F);
    this.e.close();
    paramCanvas.drawPath(this.e, this.c);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(a(paramInt1), a(paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a = paramInt1;
    this.b = paramInt2;
    this.g.left = 0.0F;
    this.g.top = 0.0F;
    this.g.right = this.a;
    this.g.bottom = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.widget.a
 * JD-Core Version:    0.7.0.1
 */