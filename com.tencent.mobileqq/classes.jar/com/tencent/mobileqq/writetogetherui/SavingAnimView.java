package com.tencent.mobileqq.writetogetherui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import com.tencent.mobileqq.writetogether.R.styleable;

public class SavingAnimView
  extends View
{
  private int a;
  private float b = 0.0F;
  private float c = 1.0F;
  private float d = 1.0F;
  private float e;
  private float f;
  private boolean g;
  private int h;
  private int i;
  private int j;
  private ValueAnimator k;
  private ValueAnimator l;
  private ValueAnimator m;
  private ValueAnimator n;
  private Paint o;
  private Path p;
  private Path q;
  private PathMeasure r;
  private PathMeasure s;
  private int t;
  private SavingAnimView.OnAnimationStateListener u;
  
  public SavingAnimView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public SavingAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public SavingAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    this.j = paramInt;
    if (paramInt == 1) {
      this.n.setDuration(300L);
    } else {
      this.n.setDuration(500L);
    }
    this.n.start();
  }
  
  private void a(@ColorInt int paramInt1, @Dimension int paramInt2)
  {
    setLayerType(1, null);
    this.o = new Paint(1);
    this.o.setColor(paramInt1);
    this.o.setStyle(Paint.Style.STROKE);
    this.o.setStrokeCap(Paint.Cap.ROUND);
    this.o.setStrokeWidth(paramInt2);
    this.t = paramInt2;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i4 = paramContext.getResources().getColor(2131168216);
    int i3 = paramContext.getResources().getDimensionPixelOffset(2131300107);
    int i2 = i4;
    int i1 = i3;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bt);
      i2 = paramContext.getColor(R.styleable.bv, i4);
      i1 = paramContext.getDimensionPixelOffset(R.styleable.bu, i3);
      paramContext.recycle();
    }
    a(i2, i1);
    c();
    d();
    e();
    f();
  }
  
  private void c()
  {
    this.k = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.k.setInterpolator(new AccelerateInterpolator());
    this.k.setDuration(300L);
    this.k.addUpdateListener(new SavingAnimView.1(this));
    this.k.addListener(new SavingAnimView.2(this));
  }
  
  private void d()
  {
    this.l = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.l.setDuration(500L);
    this.l.setRepeatMode(1);
    this.l.setRepeatCount(-1);
    this.l.setInterpolator(new LinearInterpolator());
    this.l.addUpdateListener(new SavingAnimView.3(this));
    this.l.addListener(new SavingAnimView.4(this));
  }
  
  private void e()
  {
    this.m = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.m.setInterpolator(new LinearInterpolator());
    this.m.setDuration(500L);
    this.m.addUpdateListener(new SavingAnimView.5(this));
    this.m.addListener(new SavingAnimView.6(this));
  }
  
  private void f()
  {
    this.n = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.n.setDuration(500L);
    this.n.addUpdateListener(new SavingAnimView.7(this));
    this.n.addListener(new SavingAnimView.8(this));
  }
  
  private void g()
  {
    this.l.setRepeatCount(-1);
    this.k.start();
    a(0);
    this.g = false;
  }
  
  private void h()
  {
    this.l.start();
  }
  
  private void i()
  {
    this.l.setRepeatCount(1);
  }
  
  private void setState(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a != 3) {
        return;
      }
      this.a = paramInt;
      return;
    }
    if (paramInt == 1)
    {
      if (this.a != 0) {
        return;
      }
      this.a = paramInt;
      g();
      return;
    }
    if (paramInt == 2)
    {
      if (this.a != 1) {
        return;
      }
      this.a = paramInt;
      h();
      return;
    }
    if (paramInt == 3)
    {
      if (this.a == 1)
      {
        this.k.end();
        h();
        i();
        this.a = paramInt;
      }
      if (this.a != 2) {
        return;
      }
      this.a = paramInt;
      i();
      return;
    }
    throw new IllegalStateException("[setState] unknown state");
  }
  
  public void a()
  {
    setState(1);
  }
  
  public void b()
  {
    setState(3);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.l.removeAllListeners();
    this.l.removeAllUpdateListeners();
    this.n.removeAllListeners();
    this.n.removeAllUpdateListeners();
    this.k.removeAllListeners();
    this.k.removeAllUpdateListeners();
    this.m.removeAllListeners();
    this.m.removeAllUpdateListeners();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.r.getLength();
    this.p.reset();
    float f2 = (this.b + 1.0F - 0.25F) % 1.0F;
    float f3 = (this.c + 1.0F - 0.25F) % 1.0F;
    if (f2 >= f3)
    {
      this.r.getSegment(f2 * f1, f1, this.p, true);
      this.r.getSegment(0.0F, f3 * f1, this.p, true);
    }
    else
    {
      this.r.getSegment(f2 * f1, f3 * f1, this.p, true);
    }
    paramCanvas.drawPath(this.p, this.o);
    this.q.reset();
    f1 = this.s.getLength();
    f2 = this.d;
    this.s.getSegment(0.0F, f1 * f2, this.q, true);
    paramCanvas.drawPath(this.q, this.o);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = (paramInt1 / 2);
    this.i = (paramInt2 / 2);
    paramInt1 = Math.min(paramInt1, paramInt2) / 2;
    paramInt2 = this.t / 2;
    Path localPath = new Path();
    float f1 = paramInt1 - paramInt2;
    localPath.moveTo(f1, f1);
    localPath.addCircle(this.h, this.i, f1, Path.Direction.CW);
    this.r = new PathMeasure(localPath, true);
    this.p = new Path();
    localPath = new Path();
    localPath.moveTo(this.h - 0.5F * f1, this.i);
    localPath.lineTo(this.h - 0.1F * f1, this.i + 0.4F * f1);
    localPath.lineTo(this.h + 0.6F * f1, this.i - f1 * 0.3F);
    this.s = new PathMeasure(localPath, false);
    this.q = new Path();
  }
  
  public void setOnAnimationStateListener(SavingAnimView.OnAnimationStateListener paramOnAnimationStateListener)
  {
    this.u = paramOnAnimationStateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView
 * JD-Core Version:    0.7.0.1
 */