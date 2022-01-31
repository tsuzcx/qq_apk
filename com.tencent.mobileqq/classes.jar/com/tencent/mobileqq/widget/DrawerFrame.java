package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import bbll;
import bclz;
import bcma;
import bcmb;
import bfob;
import com.tencent.qphone.base.util.QLog;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private bcma jdField_a_of_type_Bcma;
  private bfob jdField_a_of_type_Bfob;
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int h;
  private int i;
  private int j = -1;
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    this.jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new bcmb());
    a(paramViewGroup);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = this.jdField_a_of_type_AndroidViewView.getParent();
    if ((paramView instanceof ViewGroup))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
      paramView = new FrameLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_AndroidViewView, paramView);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new bclz(this));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
  
  private boolean a(int paramInt)
  {
    if (this.jdField_c_of_type_Boolean) {
      return true;
    }
    float f2 = this.h * this.jdField_a_of_type_Float;
    float f1 = f2;
    if (f2 < bbll.a(50.0F)) {
      f1 = bbll.a(50.0F);
    }
    if ((this.j == 1) && (paramInt >= this.h - f1) && (paramInt <= this.h) && (this.j == 1)) {
      return true;
    }
    if ((this.j == 0) && (paramInt >= 0) && (paramInt <= f1)) {
      return true;
    }
    return (!c()) && ((this.jdField_g_of_type_Boolean) || (this.jdField_g_of_type_Boolean));
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int m = 0;
    if ((paramInt2 == 1) || (paramInt1 == 1)) {}
    for (int k = 8;; k = 0)
    {
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != k)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(k);
      }
      if (paramInt2 != 1)
      {
        paramInt2 = m;
        if (paramInt1 != 0) {}
      }
      else
      {
        paramInt2 = 8;
      }
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != paramInt2)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt2);
      }
      return;
    }
  }
  
  private boolean b()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    return true;
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_AndroidViewView != null) || (this.jdField_c_of_type_AndroidViewView != null);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawerFrame", 2, "removeDrawerView");
    }
    if ((this.jdField_b_of_type_AndroidViewView == null) && (this.jdField_c_of_type_AndroidViewView == null)) {
      QLog.d("DrawerFrame", 1, "drawer view is empty!");
    }
    do
    {
      do
      {
        return;
        d();
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          removeView(this.jdField_b_of_type_AndroidViewView);
          this.jdField_b_of_type_AndroidViewView = null;
          if (QLog.isColorLevel()) {
            QLog.d("DrawerFrame", 2, "remove left drawer");
          }
        }
      } while (this.jdField_c_of_type_AndroidViewView == null);
      removeView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView = null;
    } while (!QLog.isColorLevel());
    QLog.d("DrawerFrame", 2, "remove right drawer");
  }
  
  @TargetApi(11)
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, 2);
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt1 != 0) {
        break label86;
      }
      f1 = paramInt2 / this.jdField_b_of_type_Int;
      if (paramInt1 != 0) {
        break label99;
      }
      f2 = this.h * (f1 - 1.0F);
      label42:
      if (paramInt1 != 0) {
        break label114;
      }
    }
    label86:
    label99:
    label114:
    for (View localView = this.jdField_b_of_type_AndroidViewView;; localView = this.jdField_c_of_type_AndroidViewView)
    {
      if (localView != null) {
        localView.setTranslationX(f2);
      }
      if (this.jdField_a_of_type_Bcma != null) {
        this.jdField_a_of_type_Bcma.a(this.j, f1);
      }
      return;
      f1 = -paramInt2 / this.jdField_c_of_type_Int;
      break;
      f2 = -this.h * (f1 - 1.0F);
      break label42;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int k = 300;
    if ((!b()) || (!c())) {
      return;
    }
    this.j = paramInt;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_Bfob.removeMessages(1);
      this.jdField_a_of_type_Bfob.removeMessages(2);
      this.jdField_a_of_type_Bfob.removeMessages(4);
      this.jdField_a_of_type_Bfob.removeMessages(3);
      label63:
      if (this.j != 0) {
        break label162;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bcma != null) {
        this.jdField_a_of_type_Bcma.b(this.j);
      }
      switch (paramInt)
      {
      default: 
        if (this.jdField_a_of_type_Bcma != null) {
          this.jdField_a_of_type_Bcma.e();
        }
        this.jdField_a_of_type_Bfob.sendEmptyMessage(1);
        return;
        if (!this.jdField_c_of_type_Boolean) {
          break label63;
        }
        return;
        label162:
        if (this.j == 1) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
        break;
      }
    }
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    paramInt = this.jdField_a_of_type_Int;
    int m = this.jdField_b_of_type_Int;
    int n = this.jdField_a_of_type_Int;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(paramInt, 0, m - n, 0, k);
      break;
      k = 1;
    }
    localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    paramInt = this.jdField_a_of_type_Int;
    m = -this.jdField_c_of_type_Int;
    n = this.jdField_a_of_type_Int;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(paramInt, 0, m - n, 0, k);
      break;
      k = 1;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((paramView == null) || (this.jdField_b_of_type_AndroidViewView != null) || (this.jdField_c_of_type_AndroidViewView != null)) {
      QLog.d("DrawerFrame", 1, "drawer view has exist");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DrawerFrame", 2, "addDrawerView, side: " + paramInt);
      }
      if (paramInt == 0)
      {
        this.jdField_b_of_type_AndroidViewView = paramView;
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramView = new FrameLayout.LayoutParams(-1, -1, 19);
        addView(this.jdField_b_of_type_AndroidViewView, paramView);
        this.j = 0;
        this.jdField_f_of_type_Boolean = false;
        this.jdField_g_of_type_Boolean = false;
        return;
      }
    } while (paramInt != 1);
    this.jdField_c_of_type_AndroidViewView = paramView;
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramView = new FrameLayout.LayoutParams(-2, -1, 21);
    addView(this.jdField_c_of_type_AndroidViewView, paramView);
    this.j = 1;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!b()) || (!c())) {
      return;
    }
    Scroller localScroller;
    int m;
    int n;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_Bfob.removeMessages(1);
      this.jdField_a_of_type_Bfob.removeMessages(2);
      this.jdField_a_of_type_Bfob.removeMessages(4);
      this.jdField_a_of_type_Bfob.removeMessages(3);
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bcma != null) {
        this.jdField_a_of_type_Bcma.b(this.j);
      }
      if (this.jdField_a_of_type_Bcma != null) {
        this.jdField_a_of_type_Bcma.f();
      }
      localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
      m = this.jdField_a_of_type_Int;
      n = -this.jdField_a_of_type_Int;
      if (!paramBoolean) {
        break label150;
      }
    }
    label150:
    for (int k = 300;; k = 0)
    {
      localScroller.startScroll(m, 0, n, 0, k);
      this.jdField_a_of_type_Bfob.sendEmptyMessage(2);
      return;
      if (this.jdField_c_of_type_Boolean) {
        break;
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    a(0, true);
  }
  
  public void c()
  {
    a(1, true);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bfob.removeMessages(1);
    this.jdField_a_of_type_Bfob.removeMessages(2);
    this.jdField_a_of_type_Bfob.removeMessages(4);
    this.jdField_a_of_type_Bfob.removeMessages(3);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bcma = null;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidViewView != null) {}
    for (this.j = 0;; this.j = 1)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewView.getLeft());
      }
      a(this.j, this.jdField_a_of_type_Int);
      postInvalidate();
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Bfob.sendEmptyMessage(4);
      }
      b(this.j, 1);
      return;
    }
  }
  
  public void e()
  {
    a(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 0;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      boolean bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      k = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      int m = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(k - m);
        a(this.j, this.jdField_a_of_type_Int);
      }
      postInvalidate();
      if (!bool)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_Bfob.sendEmptyMessage(3);
        return true;
      }
      this.jdField_a_of_type_Bfob.sendEmptyMessage(1);
      return true;
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      k = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      m = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(k - m);
        a(this.j, this.jdField_a_of_type_Int);
      }
      postInvalidate();
      if (!bool)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_Bfob.sendEmptyMessage(4);
        return true;
      }
      this.jdField_a_of_type_Bfob.sendEmptyMessage(2);
      return true;
      if (!this.jdField_d_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Bcma != null) {
          this.jdField_a_of_type_Bcma.h();
        }
        if (this.jdField_b_of_type_AndroidViewView != null) {}
        for (this.j = 0;; this.j = 1)
        {
          b(this.j, 1);
          return true;
        }
        if (!this.jdField_d_of_type_Boolean)
        {
          b(this.j, 0);
          if (this.jdField_a_of_type_Bcma != null)
          {
            this.jdField_a_of_type_Bcma.g();
            return true;
            if (a())
            {
              if (this.j == 0)
              {
                k = this.jdField_b_of_type_Int - this.jdField_a_of_type_Int;
                this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
              }
              while ((this.jdField_a_of_type_AndroidViewView != null) && (k != 0))
              {
                this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(k);
                a(this.j, this.jdField_a_of_type_Int);
                postInvalidate();
                return true;
                if (this.j == 1)
                {
                  k = -this.jdField_c_of_type_Int - this.jdField_a_of_type_Int;
                  this.jdField_a_of_type_Int = (-this.jdField_c_of_type_Int);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!b()) {}
    int k;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!this.jdField_a_of_type_Boolean);
        k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        m = (int)(paramMotionEvent.getX() + 0.5F);
        n = (int)(paramMotionEvent.getY() + 0.5F);
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        default: 
          return false;
        case 0: 
          this.jdField_e_of_type_Int = m;
          this.jdField_d_of_type_Int = m;
          this.jdField_g_of_type_Int = n;
          this.jdField_f_of_type_Int = n;
          if (a(m)) {
            this.jdField_e_of_type_Boolean = true;
          }
          break;
        }
      } while ((!this.jdField_d_of_type_Boolean) || (((this.j != 0) || (this.jdField_d_of_type_Int <= this.jdField_a_of_type_Int)) && ((this.j != 1) || (this.jdField_d_of_type_Int >= this.h + this.jdField_a_of_type_Int))));
      this.jdField_e_of_type_Boolean = true;
      return true;
    } while (!this.jdField_e_of_type_Boolean);
    if ((!this.jdField_c_of_type_Boolean) && ((m > this.jdField_e_of_type_Int) || (m > this.jdField_d_of_type_Int)))
    {
      this.jdField_e_of_type_Boolean = false;
      return false;
    }
    this.jdField_e_of_type_Int = m;
    this.jdField_g_of_type_Int = n;
    int m = Math.abs(this.jdField_e_of_type_Int - this.jdField_d_of_type_Int);
    int n = Math.abs(this.jdField_g_of_type_Int - this.jdField_f_of_type_Int);
    if ((m > k) && ((n + 0.0F) / m < 0.6F))
    {
      k = 1;
      if (k != 0)
      {
        if (!this.jdField_d_of_type_Boolean) {
          break label336;
        }
        this.jdField_a_of_type_Bfob.removeMessages(1);
        this.jdField_a_of_type_Bfob.removeMessages(2);
        this.jdField_a_of_type_Bfob.removeMessages(4);
        this.jdField_a_of_type_Bfob.removeMessages(3);
      }
      label317:
      if ((k == 0) || (!c())) {
        break label422;
      }
    }
    for (;;)
    {
      return bool;
      k = 0;
      break;
      label336:
      if ((c()) || (this.jdField_a_of_type_Bcma == null)) {
        break label317;
      }
      if ((this.jdField_e_of_type_Int > this.jdField_d_of_type_Int) && (this.jdField_g_of_type_Boolean))
      {
        this.jdField_g_of_type_Boolean = false;
        this.jdField_a_of_type_Bcma.a(0);
        break label317;
      }
      if ((this.jdField_e_of_type_Int >= this.jdField_d_of_type_Int) || (!this.jdField_f_of_type_Boolean)) {
        break label317;
      }
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Bcma.a(1);
      break label317;
      label422:
      bool = false;
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = this.h;
    this.h = (paramInt3 - paramInt1);
    this.i = (paramInt4 - paramInt2);
    this.jdField_b_of_type_Int = this.h;
    this.jdField_c_of_type_Int = this.h;
    FrameLayout.LayoutParams localLayoutParams;
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8))
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      this.jdField_b_of_type_AndroidViewView.layout(localLayoutParams.leftMargin + paramInt1, localLayoutParams.topMargin + paramInt2, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8))
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      this.jdField_c_of_type_AndroidViewView.layout(localLayoutParams.leftMargin + paramInt1, localLayoutParams.topMargin + paramInt2, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getLeft() + paramInt3, this.jdField_a_of_type_AndroidViewView.getTop() + paramInt4);
    }
    if ((k != this.h) && (k != 0))
    {
      this.jdField_a_of_type_Bfob.removeMessages(5);
      this.jdField_a_of_type_Bfob.sendEmptyMessage(5);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b()) {}
    while (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    int k = (int)(paramMotionEvent.getX() + 0.5F);
    int m = (int)(paramMotionEvent.getY() + 0.5F);
    int n = k - this.jdField_e_of_type_Int;
    int i1 = this.jdField_g_of_type_Int;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.jdField_e_of_type_Int = k;
    this.jdField_g_of_type_Int = m;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    case 0: 
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_Bfob.removeMessages(1);
        this.jdField_a_of_type_Bfob.removeMessages(2);
        this.jdField_a_of_type_Bfob.removeMessages(4);
        this.jdField_a_of_type_Bfob.removeMessages(3);
      }
    case 2: 
      boolean bool = this.jdField_d_of_type_Boolean;
      this.jdField_d_of_type_Boolean = true;
      if ((!bool) && (this.jdField_a_of_type_Bcma != null)) {
        this.jdField_a_of_type_Bcma.b(this.j);
      }
      if ((this.j == 0) && (this.jdField_a_of_type_Int + n > this.jdField_b_of_type_Int)) {
        if (this.jdField_a_of_type_Int != this.jdField_b_of_type_Int)
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          a(this.j, this.jdField_a_of_type_Int);
          invalidate();
        }
      }
      for (;;)
      {
        return true;
        if ((this.j == 0) && (this.jdField_a_of_type_Int + n < 0))
        {
          if (this.jdField_a_of_type_Int != 0)
          {
            this.jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewView.getLeft());
            this.jdField_a_of_type_Int = 0;
            a(this.j, this.jdField_a_of_type_Int);
            invalidate();
          }
        }
        else if ((this.j == 1) && (this.jdField_a_of_type_Int + n < -this.jdField_c_of_type_Int))
        {
          if (this.jdField_a_of_type_Int != -this.jdField_c_of_type_Int)
          {
            this.jdField_c_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(-this.jdField_c_of_type_Int - this.jdField_a_of_type_Int);
            this.jdField_a_of_type_Int = (-this.jdField_c_of_type_Int);
            a(this.j, this.jdField_a_of_type_Int);
            invalidate();
          }
        }
        else if ((this.j == 1) && (this.jdField_a_of_type_Int + n > 0))
        {
          if (this.jdField_a_of_type_Int != 0)
          {
            this.jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewView.getLeft());
            this.jdField_a_of_type_Int = 0;
            a(this.j, this.jdField_a_of_type_Int);
            invalidate();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(n);
          this.jdField_a_of_type_Int += n;
          a(this.j, this.jdField_a_of_type_Int);
          invalidate();
        }
      }
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    if (Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity()) > localViewConfiguration.getScaledMinimumFlingVelocity()) {
      if (this.j == 0) {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() > 0.0F)
        {
          this.jdField_c_of_type_Boolean = false;
          b();
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_c_of_type_Boolean = true;
      e();
      continue;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() < 0.0F)
      {
        this.jdField_c_of_type_Boolean = false;
        c();
      }
      else
      {
        this.jdField_c_of_type_Boolean = true;
        e();
        continue;
        if (this.j == 0)
        {
          if ((this.jdField_a_of_type_Int > this.h / 3.0D * 2.0D) || ((this.jdField_a_of_type_Int > this.h / 3.0D) && (n <= 0)))
          {
            this.jdField_c_of_type_Boolean = false;
            b();
          }
          else
          {
            this.jdField_c_of_type_Boolean = true;
            e();
          }
        }
        else if (this.jdField_a_of_type_Int < -(this.jdField_c_of_type_Int / 3.0D * 1.0D))
        {
          this.jdField_c_of_type_Boolean = false;
          c();
        }
        else
        {
          this.jdField_c_of_type_Boolean = true;
          e();
        }
      }
    }
  }
  
  public void setDrawerCallbacks(bcma parambcma)
  {
    this.jdField_a_of_type_Bcma = parambcma;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setSlideAreaScale(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */