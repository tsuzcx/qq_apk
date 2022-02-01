package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;

public class ImageAnimationView
  extends View
{
  long a = 0L;
  float b;
  float c;
  float d;
  float e;
  boolean f = false;
  Paint g = new Paint(6);
  Interpolator h;
  private Bitmap i;
  private long j = 1000L;
  private Rect k;
  private Rect l;
  private Rect m;
  private Rect n;
  private Animation.AnimationListener o;
  private Rect p = new Rect();
  private RectF q = new RectF();
  
  public ImageAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.a = System.currentTimeMillis();
    Animation.AnimationListener localAnimationListener = this.o;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(null);
    }
    this.f = true;
  }
  
  public void a(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.i = paramBitmap;
    this.k = paramRect1;
    this.l = paramRect2;
    this.m = paramRect3;
    this.n = paramRect4;
    this.j = paramLong;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a > 0L)
    {
      long l1 = System.currentTimeMillis() - this.a;
      float f2 = (float)l1 / (float)this.j;
      Interpolator localInterpolator = this.h;
      float f1 = f2;
      if (localInterpolator != null) {
        f1 = localInterpolator.getInterpolation(f2);
      }
      f2 = 1.0F - f1;
      if ((l1 <= this.j) && (this.f))
      {
        this.b = (this.k.top * f2 + this.l.top * f1);
        this.c = (this.k.bottom * f2 + this.l.bottom * f1);
        this.d = (this.k.left * f2 + this.l.left * f1);
        this.e = (this.k.right * f2 + this.l.right * f1);
        this.p.set((int)this.d, (int)this.b, (int)this.e, (int)this.c);
        this.b = (this.m.top * f2 + this.n.top * f1);
        this.c = (this.m.bottom * f2 + this.n.bottom * f1);
        this.d = (this.m.left * f2 + this.n.left * f1);
        this.e = (this.m.right * f2 + this.n.right * f1);
        this.q.set(this.d, this.b, this.e, this.c);
      }
      else if (this.f)
      {
        this.f = false;
        this.o.onAnimationEnd(null);
      }
      paramCanvas.drawBitmap(this.i, this.p, this.q, this.g);
      invalidate();
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.o = paramAnimationListener;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.h = paramInterpolator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageAnimationView
 * JD-Core Version:    0.7.0.1
 */