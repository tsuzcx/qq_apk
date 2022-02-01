package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class WaveView
  extends ImageView
{
  public static int a;
  public static int b;
  public int c;
  public int d;
  public int e;
  private float f;
  private int g = -1249807;
  private int h = -1249807;
  private int i;
  private int j;
  private Path k;
  private Path l;
  private Paint m;
  private Paint n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private Handler y = new Handler(new WaveView.1(this));
  
  public WaveView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.l = new Path();
    this.k = new Path();
    this.m = new Paint();
    this.m.setAntiAlias(true);
    this.m.setColor(this.g);
    this.m.setAlpha(102);
    this.n = new Paint();
    this.n.setAntiAlias(true);
    this.n.setColor(this.h);
    this.n.setAlpha(38);
    this.j = getResources().getDisplayMetrics().widthPixels;
    this.i = getResources().getDimensionPixelSize(2131299049);
    this.f = getResources().getDisplayMetrics().density;
    double d1 = this.f * 4.0F;
    Double.isNaN(d1);
    a = (int)(d1 + 0.5D);
    int i1 = a;
    this.c = i1;
    this.d = (i1 * 3);
    this.e = (this.d - this.c);
    i1 = this.j;
    int i2 = i1 / 125;
    b = i2;
    this.x = i2;
    this.p = 0;
    this.o = (-i1);
    this.q = (i1 / 4);
    this.r = (i1 / 2);
    this.s = (i1 * 3 / 4);
    this.t = (i1 * 5 / 4);
    this.u = (i1 * 3 / 2);
    this.v = (i1 * 7 / 4);
    this.w = (i1 * 2);
  }
  
  private void b()
  {
    this.k.reset();
    this.k.moveTo(this.o, this.d);
    Path localPath = this.k;
    int i1 = this.o;
    float f1 = this.q + i1;
    int i2 = this.d;
    localPath.quadTo(f1, i2 - this.c * 2, i1 + this.r, i2);
    localPath = this.k;
    i1 = this.o;
    f1 = this.s + i1;
    i2 = this.d;
    localPath.quadTo(f1, this.c * 2 + i2, i1 + this.j, i2);
    localPath = this.k;
    i1 = this.o;
    f1 = this.t + i1;
    i2 = this.d;
    localPath.quadTo(f1, i2 - this.c * 2, i1 + this.u, i2);
    localPath = this.k;
    i1 = this.o;
    f1 = this.v + i1;
    i2 = this.d;
    localPath.quadTo(f1, this.c * 2 + i2, i1 + this.w, i2);
    this.k.lineTo(this.o + this.w, this.i);
    this.k.lineTo(this.o, this.i);
    this.k.close();
  }
  
  private void c()
  {
    this.l.reset();
    this.l.moveTo(this.p, this.e);
    Path localPath = this.l;
    int i1 = this.p;
    float f1 = this.q + i1;
    int i2 = this.e;
    localPath.quadTo(f1, i2 - this.c * 2, i1 + this.r, i2);
    localPath = this.l;
    i1 = this.p;
    f1 = this.s + i1;
    i2 = this.e;
    localPath.quadTo(f1, this.c * 2 + i2, i1 + this.j, i2);
    localPath = this.l;
    i1 = this.p;
    f1 = this.t + i1;
    i2 = this.e;
    localPath.quadTo(f1, i2 - this.c * 2, i1 + this.u, i2);
    localPath = this.l;
    i1 = this.p;
    f1 = this.v + i1;
    i2 = this.e;
    localPath.quadTo(f1, this.c * 2 + i2, i1 + this.w, i2);
    this.l.lineTo(this.p + this.w, this.i);
    this.l.lineTo(this.p, this.i);
    this.l.close();
  }
  
  private void d()
  {
    if (!VersionUtils.e()) {
      return;
    }
    this.y.sendEmptyMessage(1001);
  }
  
  private void e()
  {
    if (!VersionUtils.e()) {
      return;
    }
    this.y.sendEmptyMessage(1003);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d();
    if (QLog.isColorLevel()) {
      QLog.i("WaveView", 2, "WaveVie onAttachedToWindow.");
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e();
    if (QLog.isColorLevel()) {
      QLog.i("WaveView", 2, "WaveView onDetachedFromWindow.");
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b();
    c();
    paramCanvas.drawPath(this.l, this.n);
    paramCanvas.drawPath(this.k, this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.WaveView
 * JD-Core Version:    0.7.0.1
 */