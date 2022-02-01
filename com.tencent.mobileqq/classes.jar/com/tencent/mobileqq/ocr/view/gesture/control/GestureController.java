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
import ayvs;
import ayvt;
import ayvv;
import ayvw;
import ayvx;
import ayvz;
import aywa;
import aywc;
import aywg;
import aywh;
import aywj;
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
  protected ayvt a;
  private final ayvv jdField_a_of_type_Ayvv;
  protected ayvx a;
  private final aywa jdField_a_of_type_Aywa;
  private final aywc jdField_a_of_type_Aywc;
  protected final aywg a;
  protected final aywh a;
  private GestureProxy.StateSource jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy$StateSource = GestureProxy.StateSource.NONE;
  protected final Settings a;
  private final AnimationEngine jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine;
  protected final List<ayvs> a;
  private boolean jdField_a_of_type_Boolean;
  protected float b;
  private final int jdField_b_of_type_Int;
  protected final aywg b;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = (0.0F / 0.0F);
  private final int jdField_c_of_type_Int;
  protected final aywg c;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = (0.0F / 0.0F);
  protected final aywg d;
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
    this.jdField_a_of_type_Aywg = new aywg();
    this.jdField_b_of_type_Aywg = new aywg();
    this.jdField_c_of_type_Aywg = new aywg();
    this.jdField_d_of_type_Aywg = new aywg();
    Context localContext = paramView.getContext();
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = new Settings();
    this.jdField_a_of_type_Aywh = new aywh(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine = new GestureController.LocalAnimationEngine(this, paramView);
    paramView = new ayvw(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(localContext, paramView);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ayvz(localContext, paramView);
    this.jdField_a_of_type_Aywa = new aywa(localContext, paramView);
    this.jdField_a_of_type_AndroidWidgetOverScroller = new OverScroller(localContext);
    this.jdField_a_of_type_Ayvv = new ayvv();
    this.jdField_a_of_type_Aywc = new aywc(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings);
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
          if (this.jdField_a_of_type_Ayvt != null) {
            this.jdField_a_of_type_Ayvt.a(localStateSource);
          }
        }
        return;
      } while ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (!this.e));
    }
  }
  
  private boolean a(aywg paramaywg, boolean paramBoolean)
  {
    if (paramaywg == null) {}
    for (;;)
    {
      return false;
      aywg localaywg = null;
      if (paramBoolean) {
        localaywg = this.jdField_a_of_type_Aywh.a(paramaywg, this.jdField_d_of_type_Aywg, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, false, false, true);
      }
      if (localaywg == null) {}
      while (!paramaywg.equals(this.jdField_c_of_type_Aywg))
      {
        e();
        this.i = paramBoolean;
        this.jdField_a_of_type_Aywg.a(this.jdField_c_of_type_Aywg);
        this.jdField_b_of_type_Aywg.a(paramaywg);
        if ((!Float.isNaN(this.jdField_a_of_type_Float)) && (!Float.isNaN(this.jdField_b_of_type_Float)))
        {
          jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_Float;
          jdField_a_of_type_ArrayOfFloat[1] = this.jdField_b_of_type_Float;
          aywj.a(jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Aywg, this.jdField_b_of_type_Aywg);
          this.jdField_c_of_type_Float = jdField_a_of_type_ArrayOfFloat[0];
          this.jdField_d_of_type_Float = jdField_a_of_type_ArrayOfFloat[1];
        }
        this.jdField_a_of_type_Ayvv.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a());
        this.jdField_a_of_type_Ayvv.a(0.0F, 1.0F);
        this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine.a(2);
        a();
        return true;
        paramaywg = localaywg;
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
    if (this.jdField_a_of_type_Ayvx != null) {
      this.jdField_a_of_type_Ayvx.a(paramMotionEvent);
    }
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_d_of_type_Boolean = false;
    this.g = true;
    if (this.jdField_a_of_type_Ayvx != null) {
      this.jdField_a_of_type_Ayvx.a(paramScaleGestureDetector);
    }
  }
  
  public void a(aywa paramaywa)
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
    return a(this.jdField_c_of_type_Aywg, true);
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    float f5 = this.jdField_c_of_type_Aywg.a();
    float f6 = this.jdField_c_of_type_Aywg.b();
    float f3 = f5 + paramInt1;
    float f4 = paramInt2 + f6;
    float f2 = f4;
    float f1 = f3;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.i())
    {
      this.jdField_a_of_type_Aywc.a(f3, f4, jdField_a_of_type_AndroidGraphicsPointF);
      f1 = jdField_a_of_type_AndroidGraphicsPointF.x;
      f2 = jdField_a_of_type_AndroidGraphicsPointF.y;
    }
    this.jdField_c_of_type_Aywg.b(f1, f2);
    return (!aywg.a(f5, f1)) || (!aywg.a(f6, f2));
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    do
    {
      return false;
      this.jdField_a_of_type_Aywh.a(this.jdField_c_of_type_Aywg, jdField_a_of_type_AndroidGraphicsRectF);
      if ((aywg.a(jdField_a_of_type_AndroidGraphicsRectF.width(), 0.0F) > 0) || (aywg.a(jdField_a_of_type_AndroidGraphicsRectF.height(), 0.0F) > 0)) {}
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
      if ((this.jdField_a_of_type_Ayvx == null) || (!this.jdField_a_of_type_Ayvx.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))) {
        break label123;
      }
      return true;
    }
    label123:
    this.jdField_c_of_type_Aywg.a(-paramFloat1, -paramFloat2);
    this.f = true;
    label140:
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.d();
    if (this.jdField_a_of_type_Ayvx != null) {
      this.jdField_a_of_type_Ayvx.a(paramScaleGestureDetector);
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Boolean = true;
    return c(paramView, paramMotionEvent);
  }
  
  public boolean a(aywa paramaywa)
  {
    this.e = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e();
    return this.e;
  }
  
  public boolean a(aywg paramaywg)
  {
    return a(paramaywg, true);
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.j())
    {
      this.jdField_a_of_type_AndroidViewView.performLongClick();
      if (this.jdField_a_of_type_Ayvx != null) {
        this.jdField_a_of_type_Ayvx.c(paramMotionEvent);
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
    return !this.jdField_a_of_type_Ayvv.b();
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    this.jdField_b_of_type_Boolean = false;
    d();
    if (this.jdField_a_of_type_Ayvx != null) {
      this.jdField_a_of_type_Ayvx.b(paramMotionEvent);
    }
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.b()) || (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.c()) || (b())) {
      return false;
    }
    if ((this.jdField_a_of_type_Ayvx != null) && (this.jdField_a_of_type_Ayvx.b(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))) {
      return true;
    }
    d();
    this.jdField_a_of_type_Aywc.a(this.jdField_c_of_type_Aywg).a(this.jdField_c_of_type_Aywg.a(), this.jdField_c_of_type_Aywg.b());
    this.jdField_a_of_type_AndroidWidgetOverScroller.fling(Math.round(this.jdField_c_of_type_Aywg.a()), Math.round(this.jdField_c_of_type_Aywg.b()), a(paramFloat1 * 0.9F), a(0.9F * paramFloat2), -2147483648, 2147483647, -2147483648, 2147483647);
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
      this.jdField_c_of_type_Aywg.a(f1, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      this.f = true;
    } while (this.jdField_a_of_type_Ayvx == null);
    this.jdField_a_of_type_Ayvx.b(paramScaleGestureDetector);
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
  
  public boolean b(aywa paramaywa)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e()) || (b())) {
      return false;
    }
    this.jdField_a_of_type_Float = paramaywa.a();
    this.jdField_b_of_type_Float = paramaywa.b();
    this.jdField_c_of_type_Aywg.c(paramaywa.c(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    this.f = true;
    return true;
  }
  
  public void c()
  {
    if (b())
    {
      this.jdField_a_of_type_Ayvv.a();
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
    return (this.jdField_a_of_type_Ayvx != null) && (this.jdField_a_of_type_Ayvx.b(paramMotionEvent));
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
        this.jdField_a_of_type_Aywa.a(localMotionEvent);
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
        this.jdField_a_of_type_Aywh.a(this.jdField_c_of_type_Aywg, this.jdField_d_of_type_Aywg, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, true, true, false);
        if (!this.jdField_c_of_type_Aywg.equals(this.jdField_d_of_type_Aywg)) {
          f();
        }
      }
      if ((this.g) || (this.h))
      {
        this.g = false;
        this.h = false;
        a(this.jdField_a_of_type_Aywh.a(this.jdField_c_of_type_Aywg, this.jdField_d_of_type_Aywg, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, true, false, true), false);
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
    return (this.jdField_a_of_type_Ayvx != null) && (this.jdField_a_of_type_Ayvx.c(paramMotionEvent));
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
    if ((this.jdField_a_of_type_Ayvx != null) && (this.jdField_a_of_type_Ayvx.a(paramMotionEvent))) {
      return true;
    }
    a(this.jdField_a_of_type_Aywh.a(this.jdField_c_of_type_Aywg, paramMotionEvent.getX(), paramMotionEvent.getY()));
    return true;
  }
  
  protected void f()
  {
    this.jdField_d_of_type_Aywg.a(this.jdField_c_of_type_Aywg);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ayvs)localIterator.next()).a(this.jdField_c_of_type_Aywg);
    }
  }
  
  protected void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ayvs)localIterator.next()).a(this.jdField_d_of_type_Aywg, this.jdField_c_of_type_Aywg);
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.control.GestureController
 * JD-Core Version:    0.7.0.1
 */