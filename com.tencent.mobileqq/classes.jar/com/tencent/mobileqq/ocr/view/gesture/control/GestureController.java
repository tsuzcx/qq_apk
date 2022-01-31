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
import avvf;
import avvg;
import avvi;
import avvj;
import avvk;
import avvm;
import avvn;
import avvp;
import avvt;
import avvu;
import avvw;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy.StateSource;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestureController
{
  private static final PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private static final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  protected float a;
  private final int jdField_a_of_type_Int;
  private final GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private final ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  protected final View a;
  private final OverScroller jdField_a_of_type_AndroidWidgetOverScroller;
  protected avvg a;
  private final avvi jdField_a_of_type_Avvi;
  protected avvk a;
  private final avvn jdField_a_of_type_Avvn;
  private final avvp jdField_a_of_type_Avvp;
  protected final avvt a;
  protected final avvu a;
  private GestureProxy.StateSource jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy$StateSource = GestureProxy.StateSource.NONE;
  protected final Settings a;
  private final AnimationEngine jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine;
  protected final List<avvf> a;
  private boolean jdField_a_of_type_Boolean;
  protected float b;
  private final int jdField_b_of_type_Int;
  protected final avvt b;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = (0.0F / 0.0F);
  private final int jdField_c_of_type_Int;
  protected final avvt c;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = (0.0F / 0.0F);
  protected final avvt d;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public GestureController(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Float = (0.0F / 0.0F);
    this.jdField_b_of_type_Float = (0.0F / 0.0F);
    this.jdField_a_of_type_Avvt = new avvt();
    this.jdField_b_of_type_Avvt = new avvt();
    this.jdField_c_of_type_Avvt = new avvt();
    this.jdField_d_of_type_Avvt = new avvt();
    Context localContext = paramView.getContext();
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = new Settings();
    this.jdField_a_of_type_Avvu = new avvu(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine = new GestureController.LocalAnimationEngine(this, paramView);
    paramView = new avvj(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(localContext, paramView);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new avvm(localContext, paramView);
    this.jdField_a_of_type_Avvn = new avvn(localContext, paramView);
    this.jdField_a_of_type_AndroidWidgetOverScroller = new OverScroller(localContext);
    this.jdField_a_of_type_Avvi = new avvi();
    this.jdField_a_of_type_Avvp = new avvp(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings);
    paramView = ViewConfiguration.get(localContext);
    this.jdField_a_of_type_Int = paramView.getScaledTouchSlop();
    this.jdField_b_of_type_Int = paramView.getScaledMinimumFlingVelocity();
    this.jdField_c_of_type_Int = paramView.getScaledMaximumFlingVelocity();
  }
  
  private int a(float paramFloat)
  {
    if (Math.abs(paramFloat) < this.jdField_b_of_type_Int) {
      return 0;
    }
    if (Math.abs(paramFloat) >= this.jdField_c_of_type_Int) {
      return (int)Math.signum(paramFloat) * this.jdField_c_of_type_Int;
    }
    return Math.round(paramFloat);
  }
  
  private void a()
  {
    GestureProxy.StateSource localStateSource = GestureProxy.StateSource.NONE;
    if (d()) {}
    for (localStateSource = GestureProxy.StateSource.ANIMATION;; localStateSource = GestureProxy.StateSource.USER) {
      do
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy$StateSource != localStateSource)
        {
          this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy$StateSource = localStateSource;
          if (this.jdField_a_of_type_Avvg != null) {
            this.jdField_a_of_type_Avvg.a(localStateSource);
          }
        }
        return;
      } while ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (!this.e));
    }
  }
  
  private boolean a(avvt paramavvt, boolean paramBoolean)
  {
    if (paramavvt == null) {}
    for (;;)
    {
      return false;
      avvt localavvt = null;
      if (paramBoolean) {
        localavvt = this.jdField_a_of_type_Avvu.a(paramavvt, this.jdField_d_of_type_Avvt, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, false, false, true);
      }
      if (localavvt == null) {}
      while (!paramavvt.equals(this.jdField_c_of_type_Avvt))
      {
        e();
        this.i = paramBoolean;
        this.jdField_a_of_type_Avvt.a(this.jdField_c_of_type_Avvt);
        this.jdField_b_of_type_Avvt.a(paramavvt);
        if ((!Float.isNaN(this.jdField_a_of_type_Float)) && (!Float.isNaN(this.jdField_b_of_type_Float)))
        {
          jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_Float;
          jdField_a_of_type_ArrayOfFloat[1] = this.jdField_b_of_type_Float;
          avvw.a(jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Avvt, this.jdField_b_of_type_Avvt);
          this.jdField_c_of_type_Float = jdField_a_of_type_ArrayOfFloat[0];
          this.jdField_d_of_type_Float = jdField_a_of_type_ArrayOfFloat[1];
        }
        this.jdField_a_of_type_Avvi.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a());
        this.jdField_a_of_type_Avvi.a(0.0F, 1.0F);
        this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine.a(2);
        a();
        return true;
        paramavvt = localavvt;
      }
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
    if ((!c()) && (!this.i)) {
      a();
    }
    if (this.jdField_a_of_type_Avvk != null) {
      this.jdField_a_of_type_Avvk.a(paramMotionEvent);
    }
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_d_of_type_Boolean = false;
    this.g = true;
    if (this.jdField_a_of_type_Avvk != null) {
      this.jdField_a_of_type_Avvk.a(paramScaleGestureDetector);
    }
  }
  
  public void a(avvn paramavvn)
  {
    this.e = false;
    this.h = true;
  }
  
  protected void a(boolean paramBoolean)
  {
    this.i = false;
    this.jdField_a_of_type_Float = (0.0F / 0.0F);
    this.jdField_b_of_type_Float = (0.0F / 0.0F);
    a();
  }
  
  public boolean a()
  {
    return a(this.jdField_c_of_type_Avvt, true);
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    float f5 = this.jdField_c_of_type_Avvt.a();
    float f6 = this.jdField_c_of_type_Avvt.b();
    float f3 = f5 + paramInt1;
    float f4 = paramInt2 + f6;
    float f2 = f4;
    float f1 = f3;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.i())
    {
      this.jdField_a_of_type_Avvp.a(f3, f4, jdField_a_of_type_AndroidGraphicsPointF);
      f1 = jdField_a_of_type_AndroidGraphicsPointF.x;
      f2 = jdField_a_of_type_AndroidGraphicsPointF.y;
    }
    this.jdField_c_of_type_Avvt.b(f1, f2);
    return (!avvt.a(f5, f1)) || (!avvt.a(f6, f2));
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    do
    {
      return false;
      this.jdField_a_of_type_Avvu.a(this.jdField_c_of_type_Avvt, jdField_a_of_type_AndroidGraphicsRectF);
      if ((avvt.a(jdField_a_of_type_AndroidGraphicsRectF.width(), 0.0F) > 0) || (avvt.a(jdField_a_of_type_AndroidGraphicsRectF.height(), 0.0F) > 0)) {}
      for (int j = 1; (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.b()) && ((j != 0) || (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.i())); j = 0) {
        return true;
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.d()) && (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e()));
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.b()) || (b())) {
      return false;
    }
    if (!this.jdField_c_of_type_Boolean) {
      if ((Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX()) <= this.jdField_a_of_type_Int) && (Math.abs(paramMotionEvent2.getY() - paramMotionEvent1.getY()) <= this.jdField_a_of_type_Int)) {
        break label117;
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      if (this.jdField_c_of_type_Boolean) {
        break;
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label140;
      }
      if ((this.jdField_a_of_type_Avvk == null) || (!this.jdField_a_of_type_Avvk.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))) {
        break label123;
      }
      return true;
    }
    label123:
    this.jdField_c_of_type_Avvt.a(-paramFloat1, -paramFloat2);
    this.f = true;
    label140:
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.d();
    if (this.jdField_a_of_type_Avvk != null) {
      this.jdField_a_of_type_Avvk.a(paramScaleGestureDetector);
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Boolean = true;
    return c(paramView, paramMotionEvent);
  }
  
  public boolean a(avvn paramavvn)
  {
    this.e = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e();
    return this.e;
  }
  
  public boolean a(avvt paramavvt)
  {
    return a(paramavvt, true);
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.j())
    {
      this.jdField_a_of_type_AndroidViewView.performLongClick();
      if (this.jdField_a_of_type_Avvk != null) {
        this.jdField_a_of_type_Avvk.c(paramMotionEvent);
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      a();
    }
    a();
  }
  
  public boolean b()
  {
    return !this.jdField_a_of_type_Avvi.b();
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_b_of_type_Boolean = false;
    d();
    if (this.jdField_a_of_type_Avvk != null) {
      this.jdField_a_of_type_Avvk.b(paramMotionEvent);
    }
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.b()) || (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.c()) || (b())) {
      return false;
    }
    if ((this.jdField_a_of_type_Avvk != null) && (this.jdField_a_of_type_Avvk.b(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))) {
      return true;
    }
    d();
    this.jdField_a_of_type_Avvp.a(this.jdField_c_of_type_Avvt).a(this.jdField_c_of_type_Avvt.a(), this.jdField_c_of_type_Avvt.b());
    this.jdField_a_of_type_AndroidWidgetOverScroller.fling(Math.round(this.jdField_c_of_type_Avvt.a()), Math.round(this.jdField_c_of_type_Avvt.b()), a(paramFloat1 * 0.9F), a(0.9F * paramFloat2), -2147483648, 2147483647, -2147483648, 2147483647);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine.a(3);
    a();
    return true;
  }
  
  public boolean b(ScaleGestureDetector paramScaleGestureDetector)
  {
    boolean bool = true;
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.d()) || (b())) {
      bool = false;
    }
    do
    {
      return bool;
      float f1 = paramScaleGestureDetector.getScaleFactor();
      this.jdField_a_of_type_Float = paramScaleGestureDetector.getFocusX();
      this.jdField_b_of_type_Float = paramScaleGestureDetector.getFocusY();
      this.jdField_c_of_type_Avvt.a(f1, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      this.f = true;
    } while (this.jdField_a_of_type_Avvk == null);
    this.jdField_a_of_type_Avvk.b(paramScaleGestureDetector);
    return true;
  }
  
  protected boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c(paramView, paramMotionEvent);
    }
    this.jdField_a_of_type_Boolean = false;
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.j();
  }
  
  public boolean b(avvn paramavvn)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e()) || (b())) {
      return false;
    }
    this.jdField_a_of_type_Float = paramavvn.a();
    this.jdField_b_of_type_Float = paramavvn.b();
    this.jdField_c_of_type_Avvt.c(paramavvn.c(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    this.f = true;
    return true;
  }
  
  public void c()
  {
    if (b())
    {
      this.jdField_a_of_type_Avvi.a();
      a(true);
    }
  }
  
  public boolean c()
  {
    return !this.jdField_a_of_type_AndroidWidgetOverScroller.isFinished();
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.g()) {
      this.jdField_a_of_type_AndroidViewView.performClick();
    }
    return (this.jdField_a_of_type_Avvk != null) && (this.jdField_a_of_type_Avvk.b(paramMotionEvent));
  }
  
  protected boolean c(View paramView, MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(-paramView.getPaddingLeft(), -paramView.getPaddingTop());
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(paramView.isLongClickable());
    boolean bool = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(localMotionEvent);
    if (paramMotionEvent.getPointerCount() > 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.d()) {
        this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(localMotionEvent);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e()) {
        this.jdField_a_of_type_Avvn.a(localMotionEvent);
      }
      if ((bool) || (this.jdField_d_of_type_Boolean) || (this.e)) {
        bool = true;
      }
    }
    for (;;)
    {
      a();
      if (this.f)
      {
        this.f = false;
        this.jdField_a_of_type_Avvu.a(this.jdField_c_of_type_Avvt, this.jdField_d_of_type_Avvt, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, true, true, false);
        if (!this.jdField_c_of_type_Avvt.equals(this.jdField_d_of_type_Avvt)) {
          f();
        }
      }
      if ((this.g) || (this.h))
      {
        this.g = false;
        this.h = false;
        a(this.jdField_a_of_type_Avvu.a(this.jdField_c_of_type_Avvt, this.jdField_d_of_type_Avvt, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, true, false, true), false);
      }
      if ((localMotionEvent.getActionMasked() == 1) || (localMotionEvent.getActionMasked() == 3))
      {
        a(localMotionEvent);
        a();
      }
      if ((!this.jdField_b_of_type_Boolean) && (a(localMotionEvent)))
      {
        this.jdField_b_of_type_Boolean = true;
        paramView = paramView.getParent();
        if (paramView != null) {
          paramView.requestDisallowInterceptTouchEvent(true);
        }
      }
      localMotionEvent.recycle();
      return bool;
      bool = false;
    }
  }
  
  public void d()
  {
    if (c())
    {
      this.jdField_a_of_type_AndroidWidgetOverScroller.forceFinished(true);
      b(true);
    }
  }
  
  public boolean d()
  {
    return (b()) || (c());
  }
  
  public boolean d(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.g()) {
      this.jdField_a_of_type_AndroidViewView.performClick();
    }
    return (this.jdField_a_of_type_Avvk != null) && (this.jdField_a_of_type_Avvk.c(paramMotionEvent));
  }
  
  public void e()
  {
    c();
    d();
  }
  
  public boolean e(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.g()) {}
    while ((paramMotionEvent.getActionMasked() != 1) || (this.jdField_d_of_type_Boolean)) {
      return false;
    }
    if ((this.jdField_a_of_type_Avvk != null) && (this.jdField_a_of_type_Avvk.a(paramMotionEvent))) {
      return true;
    }
    a(this.jdField_a_of_type_Avvu.a(this.jdField_c_of_type_Avvt, paramMotionEvent.getX(), paramMotionEvent.getY()));
    return true;
  }
  
  protected void f()
  {
    this.jdField_d_of_type_Avvt.a(this.jdField_c_of_type_Avvt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avvf)localIterator.next()).a(this.jdField_c_of_type_Avvt);
    }
  }
  
  protected void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avvf)localIterator.next()).a(this.jdField_d_of_type_Avvt, this.jdField_c_of_type_Avvt);
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.control.GestureController
 * JD-Core Version:    0.7.0.1
 */