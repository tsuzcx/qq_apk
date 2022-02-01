package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class CircleBarView
  extends View
{
  private Paint a;
  private Paint b;
  private RectF c;
  private CircleBarView.ProgressAnim d;
  private float e;
  private float f;
  private int g;
  private int h;
  private float i;
  private float j;
  private float k;
  private int l;
  private float m;
  private TextView n;
  private CircleBarView.OnAnimationListener o;
  private CircleBarView.CircleAnim p;
  
  public CircleBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 1073741824) {
      return i2;
    }
    paramInt2 = paramInt1;
    if (i1 == -2147483648) {
      paramInt2 = Math.min(paramInt1, i2);
    }
    return paramInt2;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.g = -16711936;
    this.h = -7829368;
    this.i = -90.0F;
    this.j = 360.0F;
    this.k = a(paramContext, 4.0F);
    this.e = 0.0F;
    this.f = 100.0F;
    this.l = a(paramContext, 100.0F);
    this.c = new RectF();
    this.b = new Paint();
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(this.g);
    this.b.setAntiAlias(true);
    this.b.setStrokeWidth(this.k);
    this.b.setStrokeCap(Paint.Cap.ROUND);
    this.a = new Paint();
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setColor(this.h);
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(this.k);
    this.a.setStrokeCap(Paint.Cap.ROUND);
    this.d = new CircleBarView.ProgressAnim(this);
  }
  
  public void a()
  {
    CircleBarView.CircleAnim localCircleAnim = this.p;
    if ((localCircleAnim != null) && (localCircleAnim.hasStarted())) {
      this.p.cancel();
    }
    clearAnimation();
  }
  
  public boolean a(int paramInt)
  {
    if (this.a.getColor() != paramInt)
    {
      this.a.setColor(paramInt);
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    if (this.b.getColor() != paramInt)
    {
      this.b.setColor(paramInt);
      invalidate();
      return true;
    }
    return false;
  }
  
  public void c(int paramInt)
  {
    this.p = new CircleBarView.CircleAnim(this);
    this.e = 100.0F;
    this.p.setDuration(paramInt);
    this.p.setRepeatCount(-1);
    this.p.setInterpolator(new LinearInterpolator());
    startAnimation(this.p);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.c, this.i, this.j, false, this.a);
    paramCanvas.drawArc(this.c, this.i, this.m, false, this.b);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = a(this.l, paramInt2);
    paramInt1 = Math.min(a(this.l, paramInt1), paramInt2);
    setMeasuredDimension(paramInt1, paramInt1);
    float f1 = paramInt1;
    float f2 = this.k;
    if (f1 >= f2 * 2.0F) {
      this.c.set(f2 / 2.0F, f2 / 2.0F, f1 - f2 / 2.0F, f1 - f2 / 2.0F);
    }
  }
  
  public void setMaxNum(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void setOnAnimationListener(CircleBarView.OnAnimationListener paramOnAnimationListener)
  {
    this.o = paramOnAnimationListener;
  }
  
  public void setTextView(TextView paramTextView)
  {
    this.n = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CircleBarView
 * JD-Core Version:    0.7.0.1
 */