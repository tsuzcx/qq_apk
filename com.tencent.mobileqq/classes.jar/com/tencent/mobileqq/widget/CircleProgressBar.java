package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.HardCodeUtil;

public class CircleProgressBar
  extends View
{
  public float A;
  public int B = -90;
  public int C = this.B;
  public boolean D = false;
  public boolean E = false;
  public int F;
  public int G;
  public long H;
  public long I;
  public long J;
  public long K;
  public float L;
  public RectF M = new RectF();
  CircleProgressBar.RefreshHandler N = new CircleProgressBar.RefreshHandler(this);
  public Paint a = new Paint();
  public TextPaint b = new TextPaint();
  public int c;
  public int d;
  public int e;
  public float f;
  public String g = "10";
  public float h;
  public float i;
  public float j;
  public float k;
  public float l;
  public float m;
  public float n;
  public int o;
  public int p;
  public int q;
  public int r;
  public float s;
  public float t;
  public float u;
  public float v;
  public float w;
  public float x;
  public float y;
  public float z;
  
  public CircleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleProgressBar);
    this.c = paramContext.getColor(13, Color.parseColor("#999999"));
    this.d = paramContext.getColor(10, Color.parseColor("#12b7f5"));
    this.e = paramContext.getColor(7, Color.parseColor("#000000"));
    this.f = paramContext.getDimension(8, 25.0F);
    this.h = paramContext.getDimension(3, 200.0F);
    this.i = paramContext.getDimension(6, 250.0F);
    this.j = paramContext.getInteger(9, 60);
    this.k = paramContext.getDimension(14, 40.0F);
    this.l = paramContext.getDimension(12, 200.0F);
    this.m = paramContext.getDimension(2, 200.0F);
    this.n = paramContext.getDimension(5, 200.0F);
    this.o = paramContext.getColor(11, Color.parseColor("#999999"));
    this.p = paramContext.getColor(1, Color.parseColor("#999999"));
    this.q = paramContext.getColor(4, Color.parseColor("#999999"));
    this.r = paramContext.getColor(0, Color.parseColor("#999999"));
    paramContext.recycle();
    float f2 = this.i;
    float f1 = this.h;
    this.s = ((f2 - f1) / 2.0F);
    f2 = f1 / 2.0F;
    float f3 = this.s;
    this.x = (f2 + f3 / 2.0F);
    this.t = ((this.l - f1) / 2.0F);
    this.u = ((this.m - f1) / 2.0F);
    this.v = ((this.n - f1) / 2.0F);
    this.w = f3;
    this.y = (f1 / 2.0F + this.t / 2.0F);
    this.z = (f1 / 2.0F + this.u / 2.0F);
    this.A = (f1 / 2.0F + this.v / 2.0F);
  }
  
  private double a(float paramFloat)
  {
    double d1 = paramFloat / 360.0F * 2.0F;
    Double.isNaN(d1);
    return d1 * 3.141592653589793D;
  }
  
  public void a()
  {
    this.D = true;
    this.E = false;
    postInvalidate();
    this.N.sendEmptyMessageDelayed(10000, 50L);
  }
  
  public void b()
  {
    this.D = false;
    this.N.removeMessages(10000);
    postInvalidate();
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.F = (getWidth() / 2);
    this.G = (getHeight() / 2);
    Object localObject;
    int i1;
    float f1;
    float f2;
    int i2;
    float f3;
    float f4;
    float f5;
    float f6;
    if (!this.E)
    {
      this.a.setColor(this.c);
      this.a.setStyle(Paint.Style.STROKE);
      this.a.setStrokeWidth(this.s);
      this.a.setAntiAlias(true);
      paramCanvas.drawCircle(this.F, this.G, this.x, this.a);
      if (this.D)
      {
        localObject = this.M;
        i1 = this.F;
        f1 = i1;
        f2 = this.x;
        ((RectF)localObject).left = (f1 - f2);
        i2 = this.G;
        ((RectF)localObject).top = (i2 - f2);
        ((RectF)localObject).right = (i1 + f2);
        ((RectF)localObject).bottom = (i2 + f2);
        double d1 = i1;
        double d2 = f2;
        double d3 = Math.sin(a(this.C + 90));
        Double.isNaN(d2);
        Double.isNaN(d1);
        f1 = (float)(d1 + d2 * d3);
        d1 = this.G;
        d2 = this.x;
        d3 = Math.cos(a(this.C + 90));
        Double.isNaN(d2);
        Double.isNaN(d1);
        f2 = (float)(d1 - d2 * d3);
        d1 = this.F;
        d2 = this.x;
        d3 = Math.sin(a(this.C + 90 + this.j));
        Double.isNaN(d2);
        Double.isNaN(d1);
        f3 = (float)(d1 + d2 * d3);
        d1 = this.G;
        d2 = this.x;
        d3 = Math.cos(a(this.C + 90 + this.j));
        Double.isNaN(d2);
        Double.isNaN(d1);
        localObject = new LinearGradient(f1, f2, f3, (float)(d1 - d2 * d3), this.c, this.d, Shader.TileMode.MIRROR);
        this.a.setShader((Shader)localObject);
        paramCanvas.drawArc(this.M, this.C, this.j, false, this.a);
        this.a.setShader(null);
      }
      this.b.setColor(this.e);
      this.b.setAntiAlias(true);
      this.b.setTextSize(this.f);
      f4 = this.F;
      f5 = this.b.measureText(this.g);
      f6 = this.k;
      f3 = this.G - (this.b.descent() + this.b.ascent()) / 2.0F;
      f1 = this.G;
      f2 = (this.b.descent() + this.b.ascent()) / 2.0F;
      paramCanvas.drawText(this.g, f4 - f5 + f6, f3, this.b);
      this.b.setTextSize(this.f / 2.0F);
      f4 = this.F + this.k;
      paramCanvas.drawText("%", f4, f3, this.b);
      this.b.setTextSize(this.f / 4.0F);
      f3 = this.b.descent();
      f5 = this.b.ascent();
      paramCanvas.drawText(HardCodeUtil.a(2131900120), f4, f1 + f2 - (f3 + f5), this.b);
    }
    else
    {
      this.a.setAntiAlias(true);
      this.a.setStyle(Paint.Style.STROKE);
      this.a.setColor(this.r);
      this.a.setStrokeWidth(this.w);
      paramCanvas.drawCircle(this.F, this.G, this.x, this.a);
      long l1 = this.H;
      f4 = (float)(this.I + l1 + this.J + this.K);
      f2 = (float)l1 * 360.0F / f4;
      if (f2 > 0.0F)
      {
        f1 = this.L;
        if (f2 < f1) {
          f2 = f1;
        }
      }
      localObject = new RectF();
      i1 = this.F;
      f1 = i1;
      f3 = this.y;
      ((RectF)localObject).left = (f1 - f3);
      i2 = this.G;
      ((RectF)localObject).top = (i2 - f3);
      ((RectF)localObject).right = (i1 + f3);
      ((RectF)localObject).bottom = (i2 + f3);
      this.a.setColor(this.o);
      this.a.setStrokeWidth(this.t);
      paramCanvas.drawArc((RectF)localObject, -90.0F, f2, false, this.a);
      f1 = (float)this.I * 360.0F / f4;
      if (f1 > 0.0F)
      {
        f3 = this.L;
        if (f1 < f3) {
          f1 = f3;
        }
      }
      i1 = this.F;
      f3 = i1;
      f5 = this.z;
      ((RectF)localObject).left = (f3 - f5);
      i2 = this.G;
      ((RectF)localObject).top = (i2 - f5);
      ((RectF)localObject).right = (i1 + f5);
      ((RectF)localObject).bottom = (i2 + f5);
      this.a.setColor(this.p);
      this.a.setStrokeWidth(this.u);
      f5 = -90.0F + f2;
      paramCanvas.drawArc((RectF)localObject, f5, f1, false, this.a);
      f2 = (float)this.J * 360.0F / f4;
      if (f2 > 0.0F)
      {
        f3 = this.L;
        if (f2 < f3) {
          f2 = f3;
        }
      }
      i1 = this.F;
      f3 = i1;
      f4 = this.A;
      ((RectF)localObject).left = (f3 - f4);
      i2 = this.G;
      ((RectF)localObject).top = (i2 - f4);
      ((RectF)localObject).right = (i1 + f4);
      ((RectF)localObject).bottom = (i2 + f4);
      this.a.setColor(this.q);
      this.a.setStrokeWidth(this.v);
      paramCanvas.drawArc((RectF)localObject, f5 + f1, f2, false, this.a);
      this.b.setColor(this.e);
      this.b.setAntiAlias(true);
      this.b.setTextSize(this.f);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      l1 = this.H;
      long l2 = this.I;
      long l3 = this.J;
      ((StringBuilder)localObject).append((l1 + l2 + l3) * 100L / (l1 + l2 + l3 + this.K));
      localObject = ((StringBuilder)localObject).toString();
      f4 = this.F;
      f5 = this.b.measureText((String)localObject);
      f6 = this.k;
      f3 = this.G - (this.b.descent() + this.b.ascent()) / 2.0F;
      f1 = this.G;
      f2 = (this.b.descent() + this.b.ascent()) / 2.0F;
      paramCanvas.drawText((String)localObject, f4 - f5 + f6, f3, this.b);
      this.b.setTextSize(this.f / 2.0F);
      f4 = this.F + this.k;
      paramCanvas.drawText("%", f4, f3, this.b);
      this.b.setTextSize(this.f / 4.0F);
      f3 = this.b.descent();
      f5 = this.b.ascent();
      paramCanvas.drawText(HardCodeUtil.a(2131900121), f4, f1 + f2 - (f3 + f5), this.b);
    }
    this.a.reset();
  }
  
  public void setFinish(long paramLong1, long paramLong2, long paramLong3, long paramLong4, float paramFloat)
  {
    this.H = paramLong1;
    this.I = paramLong2;
    this.J = paramLong3;
    this.K = paramLong4;
    this.L = paramFloat;
    b();
    this.E = true;
    postInvalidate();
  }
  
  public void setPercent(int paramInt)
  {
    if (paramInt < 100)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      this.g = localStringBuilder.toString();
    }
    else
    {
      this.g = "100";
      b();
    }
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgressBar
 * JD-Core Version:    0.7.0.1
 */