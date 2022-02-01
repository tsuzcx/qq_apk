package com.tencent.mobileqq.ocr.view.gesture.control;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy.OnStateChangeListener;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy.OnStateSourceChangeListener;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy.StateSource;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine;
import com.tencent.mobileqq.ocr.view.gesture.animation.StateScroller;
import com.tencent.mobileqq.ocr.view.gesture.detector.OptimizedScaleGestureDetector;
import com.tencent.mobileqq.ocr.view.gesture.detector.RotationGestureDetector;
import com.tencent.mobileqq.ocr.view.gesture.state.MoveBounds;
import com.tencent.mobileqq.ocr.view.gesture.state.State;
import com.tencent.mobileqq.ocr.view.gesture.state.StateController;
import com.tencent.mobileqq.ocr.view.gesture.utils.MathUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestureController
{
  private static final PointF m = new PointF();
  private static final RectF n = new RectF();
  private static final float[] o = new float[2];
  private boolean A;
  private float B = (0.0F / 0.0F);
  private float C = (0.0F / 0.0F);
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private GestureProxy.StateSource H = GestureProxy.StateSource.NONE;
  private final OverScroller I;
  private final StateScroller J;
  private final MoveBounds K;
  protected OnGestureListener a;
  protected GestureProxy.OnStateSourceChangeListener b;
  protected final List<GestureProxy.OnStateChangeListener> c = new ArrayList();
  protected float d = (0.0F / 0.0F);
  protected float e = (0.0F / 0.0F);
  protected final State f = new State();
  protected final State g = new State();
  protected final View h;
  protected final Settings i;
  protected final State j = new State();
  protected final State k = new State();
  protected final StateController l;
  private final int p;
  private final int q;
  private final int r;
  private final AnimationEngine s;
  private final GestureDetector t;
  private final ScaleGestureDetector u;
  private final RotationGestureDetector v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public GestureController(View paramView)
  {
    Context localContext = paramView.getContext();
    this.h = paramView;
    this.i = new Settings();
    this.l = new StateController(this.i);
    this.s = new GestureController.LocalAnimationEngine(this, paramView);
    paramView = new InternalGestureListener(this);
    this.t = new GestureDetector(localContext, paramView);
    this.u = new OptimizedScaleGestureDetector(localContext, paramView);
    this.v = new RotationGestureDetector(localContext, paramView);
    this.I = new OverScroller(localContext);
    this.J = new StateScroller();
    this.K = new MoveBounds(this.i);
    paramView = ViewConfiguration.get(localContext);
    this.p = paramView.getScaledTouchSlop();
    this.q = paramView.getScaledMinimumFlingVelocity();
    this.r = paramView.getScaledMaximumFlingVelocity();
  }
  
  private int a(float paramFloat)
  {
    if (Math.abs(paramFloat) < this.q) {
      return 0;
    }
    if (Math.abs(paramFloat) >= this.r) {
      return (int)Math.signum(paramFloat) * this.r;
    }
    return Math.round(paramFloat);
  }
  
  private void a()
  {
    GestureProxy.StateSource localStateSource = GestureProxy.StateSource.NONE;
    if (i()) {
      localStateSource = GestureProxy.StateSource.ANIMATION;
    } else if ((this.y) || (this.z) || (this.A)) {
      localStateSource = GestureProxy.StateSource.USER;
    }
    if (this.H != localStateSource)
    {
      this.H = localStateSource;
      GestureProxy.OnStateSourceChangeListener localOnStateSourceChangeListener = this.b;
      if (localOnStateSourceChangeListener != null) {
        localOnStateSourceChangeListener.a(localStateSource);
      }
    }
  }
  
  private boolean a(State paramState, boolean paramBoolean)
  {
    if (paramState == null) {
      return false;
    }
    State localState = null;
    if (paramBoolean) {
      localState = this.l.a(paramState, this.k, this.d, this.e, false, false, true);
    }
    if (localState != null) {
      paramState = localState;
    }
    if (paramState.equals(this.j)) {
      return false;
    }
    l();
    this.G = paramBoolean;
    this.f.a(this.j);
    this.g.a(paramState);
    if ((!Float.isNaN(this.d)) && (!Float.isNaN(this.e)))
    {
      paramState = o;
      paramState[0] = this.d;
      paramState[1] = this.e;
      MathUtils.a(paramState, this.f, this.g);
      paramState = o;
      this.B = paramState[0];
      this.C = paramState[1];
    }
    this.J.a(this.i.A());
    this.J.a(0.0F, 1.0F);
    this.s.a(2);
    a();
    return true;
  }
  
  protected void a(boolean paramBoolean)
  {
    this.G = false;
    this.d = (0.0F / 0.0F);
    this.e = (0.0F / 0.0F);
    a();
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    float f5 = this.j.b();
    float f6 = this.j.c();
    float f3 = paramInt1 + f5;
    float f4 = paramInt2 + f6;
    float f2 = f3;
    float f1 = f4;
    if (this.i.z())
    {
      this.K.a(f3, f4, m);
      f2 = m.x;
      f1 = m.y;
    }
    this.j.b(f2, f1);
    return (!State.c(f5, f2)) || (!State.c(f6, f1));
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool = true;
    if ((i1 != 0) && (i1 != 2))
    {
      if (i1 != 5) {
        return false;
      }
      if (!this.i.u())
      {
        if (this.i.v()) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    this.l.a(this.j, n);
    if ((State.d(n.width(), 0.0F) <= 0) && (State.d(n.height(), 0.0F) <= 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    return (this.i.s()) && ((i1 != 0) || (!this.i.z()));
  }
  
  protected boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.i.s())
    {
      if (g()) {
        return false;
      }
      if (!this.y)
      {
        boolean bool;
        if ((Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX()) <= this.p) && (Math.abs(paramMotionEvent2.getY() - paramMotionEvent1.getY()) <= this.p)) {
          bool = false;
        } else {
          bool = true;
        }
        this.y = bool;
        if (this.y) {
          return false;
        }
      }
      if (this.y)
      {
        OnGestureListener localOnGestureListener = this.a;
        if ((localOnGestureListener != null) && (localOnGestureListener.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))) {
          return true;
        }
        this.j.a(-paramFloat1, -paramFloat2);
        this.D = true;
      }
      return this.y;
    }
    return false;
  }
  
  protected boolean a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.z = this.i.u();
    OnGestureListener localOnGestureListener = this.a;
    if (localOnGestureListener != null) {
      localOnGestureListener.b(paramScaleGestureDetector);
    }
    return this.z;
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    this.w = true;
    return c(paramView, paramMotionEvent);
  }
  
  protected boolean a(RotationGestureDetector paramRotationGestureDetector)
  {
    this.A = this.i.v();
    return this.A;
  }
  
  public boolean a(State paramState)
  {
    return a(paramState, true);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      f();
    }
    a();
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    this.x = false;
    k();
    OnGestureListener localOnGestureListener = this.a;
    if (localOnGestureListener != null) {
      localOnGestureListener.d(paramMotionEvent);
    }
    return false;
  }
  
  protected boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.i.s()) && (this.i.t()) && (!g()))
    {
      OnGestureListener localOnGestureListener = this.a;
      if ((localOnGestureListener != null) && (localOnGestureListener.b(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))) {
        return true;
      }
      k();
      this.K.a(this.j).a(this.j.b(), this.j.c());
      this.I.fling(Math.round(this.j.b()), Math.round(this.j.c()), a(paramFloat1 * 0.9F), a(paramFloat2 * 0.9F), -2147483648, 2147483647, -2147483648, 2147483647);
      this.s.a(3);
      a();
      return true;
    }
    return false;
  }
  
  protected boolean b(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.i.u()) && (!g()))
    {
      float f1 = paramScaleGestureDetector.getScaleFactor();
      this.d = paramScaleGestureDetector.getFocusX();
      this.e = paramScaleGestureDetector.getFocusY();
      this.j.a(f1, this.d, this.e);
      this.D = true;
      OnGestureListener localOnGestureListener = this.a;
      if (localOnGestureListener != null) {
        localOnGestureListener.c(paramScaleGestureDetector);
      }
      return true;
    }
    return false;
  }
  
  protected boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.w) {
      c(paramView, paramMotionEvent);
    }
    this.w = false;
    return this.i.B();
  }
  
  protected boolean b(RotationGestureDetector paramRotationGestureDetector)
  {
    if ((this.i.v()) && (!g()))
    {
      this.d = paramRotationGestureDetector.a();
      this.e = paramRotationGestureDetector.b();
      this.j.c(paramRotationGestureDetector.c(), this.d, this.e);
      this.D = true;
      return true;
    }
    return false;
  }
  
  protected void c(MotionEvent paramMotionEvent)
  {
    this.y = false;
    this.z = false;
    this.A = false;
    if ((!h()) && (!this.G)) {
      f();
    }
    OnGestureListener localOnGestureListener = this.a;
    if (localOnGestureListener != null) {
      localOnGestureListener.a(paramMotionEvent);
    }
  }
  
  protected void c(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.z = false;
    this.E = true;
    OnGestureListener localOnGestureListener = this.a;
    if (localOnGestureListener != null) {
      localOnGestureListener.a(paramScaleGestureDetector);
    }
  }
  
  protected void c(RotationGestureDetector paramRotationGestureDetector)
  {
    this.A = false;
    this.F = true;
  }
  
  protected boolean c(View paramView, MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(-paramView.getPaddingLeft(), -paramView.getPaddingTop());
    this.t.setIsLongpressEnabled(paramView.isLongClickable());
    boolean bool2 = this.t.onTouchEvent(localMotionEvent);
    boolean bool1 = bool2;
    if (paramMotionEvent.getPointerCount() > 1)
    {
      if (this.i.u()) {
        this.u.onTouchEvent(localMotionEvent);
      }
      if (this.i.v()) {
        this.v.a(localMotionEvent);
      }
      if ((!bool2) && (!this.z) && (!this.A)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
    a();
    if (this.D)
    {
      this.D = false;
      this.l.b(this.j, this.k, this.d, this.e, true, true, false);
      if (!this.j.equals(this.k)) {
        m();
      }
    }
    if ((this.E) || (this.F))
    {
      this.E = false;
      this.F = false;
      a(this.l.a(this.j, this.k, this.d, this.e, true, false, true), false);
    }
    if ((localMotionEvent.getActionMasked() == 1) || (localMotionEvent.getActionMasked() == 3))
    {
      c(localMotionEvent);
      a();
    }
    if ((!this.x) && (a(localMotionEvent)))
    {
      this.x = true;
      paramView = paramView.getParent();
      if (paramView != null) {
        paramView.requestDisallowInterceptTouchEvent(true);
      }
    }
    localMotionEvent.recycle();
    return bool1;
  }
  
  protected boolean d(MotionEvent paramMotionEvent)
  {
    if (!this.i.x()) {
      this.h.performClick();
    }
    OnGestureListener localOnGestureListener = this.a;
    return (localOnGestureListener != null) && (localOnGestureListener.c(paramMotionEvent));
  }
  
  protected void e(MotionEvent paramMotionEvent)
  {
    if (this.i.B())
    {
      this.h.performLongClick();
      OnGestureListener localOnGestureListener = this.a;
      if (localOnGestureListener != null) {
        localOnGestureListener.e(paramMotionEvent);
      }
    }
  }
  
  public boolean f()
  {
    return a(this.j, true);
  }
  
  protected boolean f(MotionEvent paramMotionEvent)
  {
    if (this.i.x()) {
      this.h.performClick();
    }
    OnGestureListener localOnGestureListener = this.a;
    return (localOnGestureListener != null) && (localOnGestureListener.f(paramMotionEvent));
  }
  
  public boolean g()
  {
    return this.J.c() ^ true;
  }
  
  protected boolean g(MotionEvent paramMotionEvent)
  {
    if (!this.i.x()) {
      return false;
    }
    if (paramMotionEvent.getActionMasked() != 1) {
      return false;
    }
    if (this.z) {
      return false;
    }
    OnGestureListener localOnGestureListener = this.a;
    if ((localOnGestureListener != null) && (localOnGestureListener.b(paramMotionEvent))) {
      return true;
    }
    a(this.l.a(this.j, paramMotionEvent.getX(), paramMotionEvent.getY()));
    return true;
  }
  
  public boolean h()
  {
    return this.I.isFinished() ^ true;
  }
  
  public boolean i()
  {
    return (g()) || (h());
  }
  
  public void j()
  {
    if (g())
    {
      this.J.a();
      a(true);
    }
  }
  
  public void k()
  {
    if (h())
    {
      this.I.forceFinished(true);
      b(true);
    }
  }
  
  public void l()
  {
    j();
    k();
  }
  
  protected void m()
  {
    this.k.a(this.j);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GestureProxy.OnStateChangeListener)localIterator.next()).a(this.j);
    }
  }
  
  protected void n()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GestureProxy.OnStateChangeListener)localIterator.next()).a(this.k, this.j);
    }
    m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.control.GestureController
 * JD-Core Version:    0.7.0.1
 */