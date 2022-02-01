package com.tencent.mobileqq.olympic.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class ScanIconAnimateView
  extends View
{
  Bitmap a;
  Bitmap b;
  Paint c;
  Paint d;
  float e = 0.0F;
  float f = 0.5F;
  float g = 1.0F;
  float h = 0.0F;
  DrawFilter i;
  ValueAnimator j;
  AnimatorSet k;
  ValueAnimator l;
  ValueAnimator m;
  ValueAnimator n;
  ValueAnimator o;
  float p = 1.0F;
  float q = 1.0F;
  ValueAnimator r;
  ValueAnimator s;
  ScanIconAnimateView.PopUpListener t;
  private boolean u = false;
  
  public ScanIconAnimateView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScanIconAnimateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScanIconAnimateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      paramContext = BitmapFactory.decodeResource(getResources(), 2130844384);
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130844386);
      int i1 = AIOUtils.b(32.0F, getResources());
      int i2 = i1 * 2;
      this.a = Bitmap.createScaledBitmap(paramContext, i2, i2, true);
      this.b = Bitmap.createScaledBitmap(localBitmap, i1, i1, true);
      this.c = new Paint();
      this.c.setAntiAlias(true);
      this.d = new Paint();
      this.d.setAntiAlias(true);
      this.i = new PaintFlagsDrawFilter(0, 3);
      this.j = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1333333F, 8.0F), Keyframe.ofFloat(0.2F, -6.0F), Keyframe.ofFloat(0.2666667F, 3.0F), Keyframe.ofFloat(0.3333333F, 0.0F), Keyframe.ofFloat(0.6666667F, 0.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.j.setDuration(1500L);
      this.j.setRepeatCount(-1);
      this.j.addUpdateListener(new ScanIconAnimateView.1(this));
      this.l = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, -90.0F), Keyframe.ofFloat(0.2F, 40.0F), Keyframe.ofFloat(0.4F, -20.0F), Keyframe.ofFloat(0.6F, 5.0F), Keyframe.ofFloat(0.8F, -5.0F), Keyframe.ofFloat(0.9F, 3.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.l.setDuration(1000L);
      this.l.setInterpolator(new AccelerateDecelerateInterpolator());
      this.l.addUpdateListener(new ScanIconAnimateView.2(this));
      this.m = ValueAnimator.ofFloat(new float[] { 0.5F, 1.0F, 1.0F, 1.0F, 0.5F, 0.5F });
      this.m.setDuration(1000L);
      this.m.setInterpolator(new AccelerateDecelerateInterpolator());
      this.m.addUpdateListener(new ScanIconAnimateView.3(this));
      this.n = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F });
      this.n.setDuration(1000L);
      this.n.addUpdateListener(new ScanIconAnimateView.4(this));
      this.o = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F });
      this.o.setDuration(1000L);
      this.o.addUpdateListener(new ScanIconAnimateView.5(this));
      this.r = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.6F, 1.0F), Keyframe.ofFloat(0.8F, 1.08F), Keyframe.ofFloat(0.9F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.r.setDuration(1000L);
      this.r.addUpdateListener(new ScanIconAnimateView.6(this));
      this.s = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.6F, 0.0F), Keyframe.ofFloat(0.9F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.s.setDuration(1000L);
      this.s.addUpdateListener(new ScanIconAnimateView.7(this));
      this.k = new AnimatorSet();
      this.k.setDuration(1000L);
      this.k.playTogether(new Animator[] { this.l, this.m, this.o, this.n, this.r, this.s });
      this.k.addListener(new ScanIconAnimateView.8(this));
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.d("ScanIconAnimateView", 1, "init failed ", paramContext);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "startPendulumAnim ");
    }
    if (!this.u) {
      return;
    }
    this.j.start();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "stopPendulumAnim ");
    }
    this.j.cancel();
    this.e = 0.0F;
    invalidate();
  }
  
  public boolean c()
  {
    boolean bool = this.j.isRunning();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPendulumRunning = ");
      localStringBuilder.append(bool);
      QLog.d("ScanIconAnimateView", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "startPopUpAnim ");
    }
    if (this.u) {
      return;
    }
    this.k.start();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "stopPopUpAnim ");
    }
    this.k.cancel();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    this.d.setAlpha((int)(this.p * 255.0F));
    float f1 = this.q;
    paramCanvas.scale(f1, f1, AIOUtils.b(16.0F, getResources()), AIOUtils.b(16.0F, getResources()));
    paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, this.d);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.h);
    f1 = this.f;
    paramCanvas.scale(f1, f1, AIOUtils.b(16.0F, getResources()), AIOUtils.b(23.0F, getResources()));
    paramCanvas.rotate(this.e, AIOUtils.b(16.0F, getResources()), AIOUtils.b(23.0F, getResources()));
    this.c.setAlpha((int)(this.g * 255.0F));
    paramCanvas.setDrawFilter(this.i);
    paramCanvas.drawBitmap(this.a, AIOUtils.b(-16.0F, getResources()), AIOUtils.b(-23.0F, getResources()), this.c);
    paramCanvas.restore();
  }
  
  public void setPopUpListener(ScanIconAnimateView.PopUpListener paramPopUpListener)
  {
    this.t = paramPopUpListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.ScanIconAnimateView
 * JD-Core Version:    0.7.0.1
 */