package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

public class OvalProgress
  extends RelativeLayout
{
  public float a;
  private Paint b;
  private Paint c;
  private Paint d;
  private Paint e;
  private Paint f;
  private RectF g;
  private RectF h;
  private RectF i;
  private RectF j;
  private RectF k;
  private RectF l;
  private RectF m;
  private RectF n;
  private OvalProgress.TagProgress o;
  private float p = -1.0F;
  private float q = -1.0F;
  private boolean r = false;
  private double s;
  private int t = -3355444;
  private int u = -16745985;
  
  public OvalProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public OvalProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OvalProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private double a(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int i1;
    if (this.o.a > 0.0D)
    {
      double d1 = 90;
      Double.isNaN(d1);
      i1 = (int)(1.0D * paramDouble * d1 / this.o.a);
    }
    else
    {
      i1 = 0;
    }
    int i2 = i1;
    if (i1 > 90) {
      i2 = 90;
    }
    paramCanvas.drawArc(this.m, 180.0F, i2, false, this.e);
    return paramDouble - this.o.a;
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.drawRect(this.g, this.b);
    paramCanvas.drawRect(this.h, this.b);
    paramCanvas.drawArc(this.i, 90.0F, 180.0F, false, this.d);
    paramCanvas.drawArc(this.j, 270.0F, 180.0F, false, this.d);
    e(paramCanvas, d(paramCanvas, c(paramCanvas, b(paramCanvas, a(paramCanvas, this.s)))));
  }
  
  private boolean a()
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if ((i1 <= 0) && (i2 <= 0)) {
      return false;
    }
    if (this.a <= 0.0F) {
      this.a = (getResources().getDisplayMetrics().density * 4.0F / 2.0F);
    }
    if ((this.b == null) || (this.c == null))
    {
      this.b = new Paint();
      this.b.setAntiAlias(true);
      this.b.setColor(this.t);
      this.b.setStrokeWidth(2.0F);
      this.c = new Paint();
      this.c.setAntiAlias(true);
      this.c.setColor(this.u);
      this.c.setStrokeWidth(2.0F);
    }
    Object localObject;
    float f2;
    float f3;
    if ((this.i == null) || (this.j == null) || (this.m == null) || (this.n == null) || (this.d == null) || (this.e == null))
    {
      this.d = new Paint();
      this.d.setAntiAlias(true);
      this.d.setColor(this.t);
      this.d.setStrokeWidth(2.0F);
      this.d.setStyle(Paint.Style.STROKE);
      this.e = new Paint();
      this.e.setAntiAlias(true);
      this.e.setColor(this.u);
      this.e.setStrokeWidth(2.0F);
      this.e.setStyle(Paint.Style.STROKE);
      this.i = new RectF();
      localObject = this.i;
      ((RectF)localObject).left = 1.0F;
      f2 = ((RectF)localObject).left;
      f1 = i2;
      ((RectF)localObject).right = (f2 + f1 - 2.0F);
      localObject = this.i;
      ((RectF)localObject).top = 1.0F;
      f2 = i2 - 1;
      ((RectF)localObject).bottom = f2;
      this.j = new RectF();
      localObject = this.j;
      int i3 = i1 - 1;
      f3 = i3 - (i2 - 2);
      ((RectF)localObject).left = f3;
      float f4 = i3;
      ((RectF)localObject).right = f4;
      ((RectF)localObject).top = 1.0F;
      ((RectF)localObject).bottom = f2;
      this.m = new RectF();
      localObject = this.m;
      ((RectF)localObject).left = 1.0F;
      ((RectF)localObject).right = (((RectF)localObject).left + f1 - 2.0F);
      localObject = this.m;
      ((RectF)localObject).top = 1.0F;
      ((RectF)localObject).bottom = f2;
      this.n = new RectF();
      localObject = this.n;
      ((RectF)localObject).left = f3;
      ((RectF)localObject).right = f4;
      ((RectF)localObject).top = 1.0F;
      ((RectF)localObject).bottom = f2;
    }
    float f1 = i1 - i2;
    double d1;
    if ((this.g == null) || (this.h == null) || (this.k == null) || (this.l == null))
    {
      this.g = new RectF();
      localObject = this.g;
      d1 = i1 - f1;
      Double.isNaN(d1);
      ((RectF)localObject).left = ((float)(d1 * 1.0D / 2.0D - 0.5D));
      d1 = ((RectF)localObject).left + f1;
      Double.isNaN(d1);
      ((RectF)localObject).right = ((float)(d1 + 0.5D + 0.5D));
      localObject = this.g;
      ((RectF)localObject).top = 0.0F;
      ((RectF)localObject).bottom = 2.0F;
      this.h = new RectF();
      this.h.left = this.g.left;
      this.h.right = this.g.right;
      localObject = this.h;
      f2 = i2 - 2;
      ((RectF)localObject).top = f2;
      f3 = i2;
      ((RectF)localObject).bottom = f3;
      this.k = new RectF();
      this.k.left = this.g.left;
      this.k.right = this.g.right;
      localObject = this.k;
      ((RectF)localObject).top = 0.0F;
      ((RectF)localObject).bottom = 2.0F;
      this.l = new RectF();
      this.l.left = this.k.left;
      this.l.right = this.k.right;
      localObject = this.l;
      ((RectF)localObject).top = f2;
      ((RectF)localObject).bottom = f3;
    }
    double d2;
    if ((this.f == null) || (this.p == -1.0F) || (this.q == -1.0F))
    {
      this.f = new Paint();
      this.f.setAntiAlias(true);
      this.f.setColor(-65536);
      d1 = (i2 - 2) / 2;
      Double.isNaN(d1);
      d1 /= 1.4142135623731D;
      f2 = (this.j.left + this.j.right) / 2.0F;
      f3 = (this.j.top + this.j.bottom) / 2.0F;
      d2 = f2;
      Double.isNaN(d2);
      this.p = ((float)(d2 + d1));
      d2 = f3;
      Double.isNaN(d2);
      this.q = ((float)(d2 - d1));
    }
    if (this.o == null)
    {
      d1 = i2 - 2;
      Double.isNaN(d1);
      d1 *= 3.141592653589793D;
      d2 = 2.0F * f1;
      Double.isNaN(d2);
      d2 += d1;
      this.o = new OvalProgress.TagProgress(this);
      localObject = this.o;
      double d3 = 0.25D * d1 / d2;
      ((OvalProgress.TagProgress)localObject).a = d3;
      double d4 = f1;
      Double.isNaN(d4);
      d4 = d4 * 1.0D / d2;
      ((OvalProgress.TagProgress)localObject).b = d4;
      ((OvalProgress.TagProgress)localObject).c = (d1 * 0.5D / d2);
      ((OvalProgress.TagProgress)localObject).d = d4;
      ((OvalProgress.TagProgress)localObject).e = d3;
    }
    return true;
  }
  
  private double b(Canvas paramCanvas, double paramDouble)
  {
    double d1 = 0.0D;
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (this.o.b > 0.0D) {
      d1 = paramDouble / this.o.b;
    }
    double d2 = d1;
    if (d1 > 1.0D) {
      d2 = 1.0D;
    }
    d1 = this.k.right - this.k.left;
    Double.isNaN(d1);
    float f1 = (float)(d2 * d1);
    paramCanvas.drawRect(this.k.left, this.k.top, this.k.left + f1, this.k.bottom, this.c);
    return paramDouble - this.o.b;
  }
  
  private double c(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int i1;
    if (this.o.c > 0.0D)
    {
      double d1 = '´';
      Double.isNaN(d1);
      i1 = (int)(1.0D * paramDouble * d1 / this.o.c);
    }
    else
    {
      i1 = 0;
    }
    int i2 = i1;
    if (i1 > 180) {
      i2 = 180;
    }
    paramCanvas.drawArc(this.n, 270.0F, i2, false, this.e);
    return paramDouble - this.o.c;
  }
  
  private double d(Canvas paramCanvas, double paramDouble)
  {
    double d1 = 0.0D;
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (this.o.d > 0.0D) {
      d1 = paramDouble / this.o.d;
    }
    double d2 = d1;
    if (d1 > 1.0D) {
      d2 = 1.0D;
    }
    d1 = this.l.right - this.l.left;
    Double.isNaN(d1);
    float f1 = (float)((1.0D - d2) * d1);
    paramCanvas.drawRect(this.l.left + f1, this.l.top, this.l.right, this.l.bottom, this.c);
    return paramDouble - this.o.d;
  }
  
  private double e(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int i1;
    if (this.o.e > 0.0D)
    {
      if (paramDouble > this.o.e * 0.99D)
      {
        i1 = 90;
      }
      else
      {
        double d1 = 90;
        Double.isNaN(d1);
        i1 = (int)(1.0D * paramDouble * d1 / this.o.e);
      }
    }
    else {
      i1 = 0;
    }
    int i2 = i1;
    if (i1 > 90) {
      i2 = 90;
    }
    paramCanvas.drawArc(this.m, 90.0F, i2, false, this.e);
    return paramDouble - this.o.e;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (a())
    {
      a(paramCanvas);
      if (this.r) {
        paramCanvas.drawCircle(this.p, this.q, 4.0F, this.f);
      }
    }
  }
  
  public void setProgressParams(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L))
    {
      if (paramLong2 > paramLong1)
      {
        this.r = false;
        this.s = 1.0D;
      }
      else
      {
        this.r = false;
        double d1 = paramLong2;
        Double.isNaN(d1);
        double d2 = paramLong1;
        Double.isNaN(d2);
        this.s = (d1 * 1.0D / d2);
      }
    }
    else {
      this.s = 0.0D;
    }
    postInvalidate();
  }
  
  public void setThemeColor(int paramInt1, int paramInt2)
  {
    this.t = paramInt1;
    this.u = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OvalProgress
 * JD-Core Version:    0.7.0.1
 */