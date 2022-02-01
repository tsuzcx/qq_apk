package com.tencent.mobileqq.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class SlideBottomPanel
  extends FrameLayout
{
  protected static float a = 5.0F;
  private int A;
  private float B;
  private int C;
  private VelocityTracker D;
  private Context E;
  private int F;
  protected boolean b = false;
  protected boolean c = false;
  protected float d;
  protected float e;
  protected float f;
  protected int g;
  protected int h;
  protected float i;
  protected float j;
  protected float k;
  protected float l;
  protected long m;
  protected boolean n = false;
  protected float o;
  protected float p;
  protected float q;
  protected int r;
  protected boolean s = false;
  protected int t;
  protected int u;
  protected int v;
  protected boolean w = false;
  protected Interpolator x = new AccelerateInterpolator();
  protected Interpolator y = new AccelerateInterpolator();
  protected ISlidePanelListener z;
  
  public SlideBottomPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.E = paramContext;
    this.B = getResources().getDisplayMetrics().density;
    paramContext = ViewConfiguration.get(this.E);
    this.C = paramContext.getScaledMaximumFlingVelocity();
    this.g = paramContext.getScaledMinimumFlingVelocity();
    this.f = paramContext.getScaledTouchSlop();
    paramContext = (WindowManager)this.E.getSystemService("window");
    paramAttributeSet = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(paramAttributeSet);
    this.F = paramAttributeSet.heightPixels;
    this.o = (this.F - a(60));
    float f1 = a(84);
    this.p = f1;
    a = f1;
    this.q = a(30);
    this.r = 250;
    this.h = this.F;
    if (a(this.E))
    {
      this.t = a(30);
      this.u = ((int)(this.p - this.t + QQUIDelegate.b(this.E)));
    }
    else
    {
      this.t = a(51);
      this.u = ((int)(this.p - this.t));
    }
    this.v = a(5);
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt * this.B + 0.5F);
  }
  
  private boolean a(Context paramContext)
  {
    return QQUIDelegate.a(paramContext);
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    if (this.D == null) {
      this.D = VelocityTracker.obtain();
    }
    this.D.addMovement(paramMotionEvent);
  }
  
  private void i()
  {
    VelocityTracker localVelocityTracker = this.D;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.clear();
      this.D.recycle();
      this.D = null;
    }
  }
  
  protected double a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public void a()
  {
    if (!this.c)
    {
      if (this.b) {
        return;
      }
      Object localObject = findViewWithTag(Integer.valueOf(1));
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { ((View)localObject).getY(), this.h - this.o }).setDuration(this.r);
      localValueAnimator.setTarget(localObject);
      localValueAnimator.setInterpolator(this.x);
      localValueAnimator.addUpdateListener(new SlideBottomPanel.4(this, (View)localObject));
      localValueAnimator.addListener(new SlideBottomPanel.5(this));
      localValueAnimator.start();
      this.c = true;
      this.w = false;
      localObject = this.z;
      if (localObject != null) {
        ((ISlidePanelListener)localObject).displayPanel();
      }
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    if (!this.s) {
      return;
    }
    g();
    if (Math.abs(this.d) > Math.abs(this.e)) {
      return;
    }
    View localView = findViewWithTag(Integer.valueOf(1));
    if ((!this.n) && (Math.abs(paramMotionEvent.getY() - this.j) > this.f))
    {
      this.n = true;
      this.k = paramMotionEvent.getY();
      localView.addOnLayoutChangeListener(new SlideBottomPanel.1(this));
    }
    if (this.n)
    {
      this.l = (paramMotionEvent.getY() - this.k);
      this.k = paramMotionEvent.getY();
      float f1 = localView.getY();
      paramMotionEvent = this.z;
      if (paramMotionEvent != null)
      {
        i1 = this.h;
        if (f1 > i1 - this.o)
        {
          f2 = i1;
          f3 = this.p;
          if (f1 < f2 - f3) {
            paramMotionEvent.fadeBackground(1.0F - f1 / (i1 - f3));
          }
        }
      }
      float f2 = this.l;
      int i1 = this.h;
      float f3 = i1;
      float f4 = this.o;
      if (f1 + f2 <= f3 - f4)
      {
        localView.offsetTopAndBottom((int)(i1 - f4 - f1));
        return;
      }
      if (f1 + f2 >= getBottomHeight())
      {
        if (this.w) {
          return;
        }
        f1 = this.l;
        i1 = this.u;
        if (f1 > i1) {
          this.l = i1;
        }
        localView.offsetTopAndBottom((int)this.l);
        return;
      }
      localView.offsetTopAndBottom((int)this.l);
    }
  }
  
  protected void b()
  {
    if (this.b) {
      return;
    }
    Object localObject = findViewWithTag(Integer.valueOf(1));
    int i1 = (int)(this.h - this.p);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { ((View)localObject).getY(), this.h - this.p });
    localValueAnimator.setInterpolator(this.y);
    localValueAnimator.setTarget(localObject);
    localValueAnimator.addUpdateListener(new SlideBottomPanel.2(this, (View)localObject, i1));
    localValueAnimator.addListener(new SlideBottomPanel.3(this));
    localValueAnimator.start();
    localObject = this.z;
    if (localObject != null) {
      ((ISlidePanelListener)localObject).hidePanel();
    }
  }
  
  protected void b(MotionEvent paramMotionEvent)
  {
    if (!this.s) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.m;
    g();
    float f1;
    if ((this.c) || (paramMotionEvent.getY() - this.j >= 0.0F) || (Math.abs(paramMotionEvent.getY() - this.j) <= this.q))
    {
      f1 = this.e;
      if ((f1 >= 0.0F) || (Math.abs(f1) <= Math.abs(this.d)) || (Math.abs(this.e) <= this.g)) {}
    }
    else
    {
      a();
      break label284;
    }
    float f2;
    if ((!this.c) && (l1 - l2 < 300L))
    {
      f1 = paramMotionEvent.getY();
      f2 = this.j;
      if ((f1 - f2 < 0.0F) && (a(this.i, f2, paramMotionEvent.getX(), paramMotionEvent.getY()) < a))
      {
        a();
        break label284;
      }
    }
    int i1;
    if ((!this.c) && (this.n))
    {
      i1 = (int)(paramMotionEvent.getY() - this.j);
      if (((!this.w) && (i1 > this.v)) || ((this.w) && (i1 < 0) && (Math.abs(i1) < this.q))) {
        c();
      }
      if ((!this.w) && (i1 < 0) && (Math.abs(i1) < this.q)) {
        d();
      }
    }
    label284:
    if (this.c)
    {
      paramMotionEvent = findViewWithTag(Integer.valueOf(1));
      f1 = paramMotionEvent.getY();
      i1 = this.h;
      float f3 = i1;
      f2 = this.o;
      if (f1 >= f3 - f2)
      {
        f3 = i1;
        float f4 = this.q;
        if (f1 >= f3 - f2 + f4)
        {
          if (f1 <= i1 - f2 + f4) {
            break label414;
          }
          b();
          break label414;
        }
      }
      ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { f1, this.h - this.o }).setDuration(this.r).start();
    }
    label414:
    this.s = false;
    this.n = false;
    this.l = 0.0F;
  }
  
  public void c()
  {
    View localView = findViewWithTag(Integer.valueOf(1));
    float f1 = localView.getY();
    int i1;
    if (a(this.E)) {
      i1 = this.h - this.t + QQUIDelegate.b(this.E);
    } else {
      i1 = this.h - this.t;
    }
    ObjectAnimator.ofFloat(localView, "y", new float[] { f1, i1 }).setDuration(this.r).start();
    this.w = true;
  }
  
  protected boolean c(MotionEvent paramMotionEvent)
  {
    this.m = System.currentTimeMillis();
    this.i = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    this.k = f1;
    this.j = f1;
    if ((!this.c) && (this.k > getBottomHeight()))
    {
      this.s = true;
      return true;
    }
    if ((!this.c) && (this.k <= getBottomHeight()))
    {
      this.s = false;
    }
    else
    {
      if (this.c)
      {
        f1 = this.k;
        int i1 = this.h;
        float f2 = i1;
        float f3 = this.o;
        if ((f1 > f2 - f3) && (f1 <= i1 - f3 + this.p))
        {
          this.s = true;
          break label180;
        }
      }
      if ((this.c) && (this.k < this.h - this.o))
      {
        b();
        this.s = false;
      }
    }
    label180:
    return false;
  }
  
  public void d()
  {
    View localView = findViewWithTag(Integer.valueOf(1));
    ObjectAnimator.ofFloat(localView, "y", new float[] { localView.getY(), this.h - this.p }).setDuration(this.r).start();
    this.w = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    d(paramMotionEvent);
    ISlidePanelListener localISlidePanelListener = this.z;
    if (localISlidePanelListener != null) {
      localISlidePanelListener.cancelAnimator();
    }
    int i1 = paramMotionEvent.getAction();
    boolean bool2 = true;
    boolean bool1;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2) {
          a(paramMotionEvent);
        }
      }
      else
      {
        b(paramMotionEvent);
        i();
      }
      bool1 = false;
    }
    else
    {
      bool1 = c(paramMotionEvent);
    }
    if (!bool1)
    {
      if (super.dispatchTouchEvent(paramMotionEvent)) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  public boolean e()
  {
    return this.w;
  }
  
  public void f()
  {
    if (!this.c) {
      return;
    }
    b();
  }
  
  protected void g()
  {
    this.D.computeCurrentVelocity(1000, this.C);
    this.d = this.D.getXVelocity();
    this.e = this.D.getYVelocity();
  }
  
  protected int getBottomHeight()
  {
    if (this.w)
    {
      if (a(this.E)) {
        return this.h - this.t + QQUIDelegate.b(this.E);
      }
      return this.h - this.t;
    }
    return (int)(this.h - this.p);
  }
  
  public boolean h()
  {
    return this.c;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.n;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.A = getChildCount();
    paramInt2 = (int)(this.h - this.p);
    paramInt1 = 0;
    while (paramInt1 < this.A)
    {
      View localView = getChildAt(paramInt1);
      localView.layout(0, paramInt2, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
      localView.setTag(Integer.valueOf(1));
      paramInt1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.n) || (this.c);
  }
  
  public void setSlidePanelListener(ISlidePanelListener paramISlidePanelListener)
  {
    this.z = paramISlidePanelListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */