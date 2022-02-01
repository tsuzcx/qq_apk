package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CountDownProgressBar
  extends View
{
  private Paint a = new Paint();
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private long k;
  private int l;
  private float m;
  private float n = 0.0F;
  private long o = 1000L;
  private int p;
  private int q;
  private CountDownProgressBar.OnCountDownLinstener r;
  private final int s = 0;
  private final int t = 1;
  private final int u = 2;
  private Handler v = new CountDownProgressBar.1(this);
  
  public CountDownProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CountDownProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext.getResources().getColor(2131167251);
    this.c = paramContext.getResources().getColor(2131167248);
    this.d = paramContext.getResources().getColor(2131167252);
    this.f = paramContext.getResources().getColor(2131165715);
    this.q = paramContext.getResources().getColor(2131167249);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.g = ((int)(21.0F * f1 + 0.5F));
    this.e = ((int)(2.0F * f1 + 0.5F));
    this.h = ((int)(18.0F * f1 + 0.5F));
    this.j = 0;
    double d1 = f1;
    Double.isNaN(d1);
    this.p = Math.max(1, (int)(d1 * 0.5D + 0.5D));
  }
  
  public void a()
  {
    this.v.removeMessages(2);
    this.v.removeMessages(1);
    this.j = 0;
    this.l = 0;
    this.m = 0.0F;
    this.n = 0.0F;
    this.o = 1000L;
    if (this.k > 0L)
    {
      this.m = 0.0F;
      this.l = 100;
      this.v.sendEmptyMessage(0);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1;
    if (getWidth() > getHeight()) {
      i1 = getHeight();
    } else {
      i1 = getWidth();
    }
    if (this.h > i1) {
      this.h = i1;
    }
    int i2 = this.h - this.p / 2;
    int i3 = this.e / 2;
    float f1 = i1 / 2;
    this.a.setStyle(Paint.Style.FILL);
    this.a.setColor(this.c);
    paramCanvas.drawCircle(f1, f1, this.h, this.a);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(this.p);
    this.a.setColor(this.q);
    paramCanvas.drawCircle(f1, f1, i2, this.a);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(this.e);
    this.a.setColor(this.b);
    float f2 = i2 - i3;
    paramCanvas.drawCircle(f1, f1, f2, this.a);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setTextSize(this.g);
    this.a.setColor(this.f);
    this.a.setTextAlign(Paint.Align.CENTER);
    float f3 = (this.a.descent() + this.a.ascent()) / 2.0F;
    paramCanvas.drawText(Integer.toString(this.i), f1, f1 - f3, this.a);
    RectF localRectF = new RectF();
    f3 = f1 - f2;
    f1 += f2;
    localRectF.set(f3, f3, f1, f1);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setColor(this.d);
    paramCanvas.drawArc(localRectF, 270.0F, this.j, false, this.a);
  }
  
  public void setOnCountDownLinstener(CountDownProgressBar.OnCountDownLinstener paramOnCountDownLinstener)
  {
    this.r = paramOnCountDownLinstener;
  }
  
  public void setTotalMills(long paramLong)
  {
    this.k = paramLong;
    this.o = 1000L;
    this.i = ((int)(this.k / 1000L));
  }
  
  public void setTotalMills(long paramLong, int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 1;
    }
    this.k = paramLong;
    this.i = i1;
    this.o = (paramLong / i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.CountDownProgressBar
 * JD-Core Version:    0.7.0.1
 */