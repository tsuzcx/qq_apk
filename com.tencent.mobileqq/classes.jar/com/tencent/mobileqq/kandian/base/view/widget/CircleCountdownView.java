package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CircleCountdownView
  extends View
  implements ICircleCountDownView
{
  private int a;
  private RectF b;
  private Paint c;
  private Paint d;
  private Paint e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public CircleCountdownView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public CircleCountdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleCountdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.a = ((int)(getResources().getDisplayMetrics().density * 1.5F + 0.5F));
    this.b = new RectF();
    this.h = 5000;
    int j = Color.parseColor("#80FFFFFF");
    int k = Color.parseColor("#FFFFFFFF");
    int m = (int)(getResources().getDisplayMetrics().density * 12.0F + 0.5F);
    this.c = new Paint();
    this.c.setColor(j);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(this.a);
    this.c.setFlags(1);
    this.d = new Paint();
    this.d.setColor(k);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeWidth(this.a);
    this.d.setFlags(1);
    this.e = new Paint();
    this.e.setColor(k);
    this.e.setTextSize(m);
    this.e.setAntiAlias(true);
    setBackgroundColor(0);
  }
  
  public void a()
  {
    this.i = 0;
    invalidate();
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      int k = this.i;
      int j = this.h;
      if (k + paramInt > j) {
        paramInt = j;
      } else {
        paramInt = k + paramInt;
      }
      this.i = paramInt;
      invalidate();
      bool1 = bool2;
      if (this.i == this.h) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    float f1 = this.i * 360.0F / this.h;
    paramCanvas.save();
    paramCanvas.drawArc(this.b, -90.0F, f1, false, this.d);
    paramCanvas.drawArc(this.b, f1 - 90.0F, 360.0F - f1, false, this.c);
    double d1 = this.h - this.i;
    Double.isNaN(d1);
    String str = String.valueOf((int)Math.ceil(d1 / 1000.0D));
    paramCanvas.drawText(str, (this.f - this.e.measureText(str)) / 2.0F, this.g / 2 - (this.e.descent() + this.e.ascent()) / 2.0F, this.e);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = paramInt1;
    this.g = paramInt2;
    RectF localRectF = this.b;
    paramInt1 = this.a;
    localRectF.set(paramInt1 / 2, paramInt1 / 2, this.f - paramInt1 / 2, this.g - paramInt1 / 2);
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt > 0) {
      this.h = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CircleCountdownView
 * JD-Core Version:    0.7.0.1
 */