package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
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
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = 0;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private DrawerFrame.IDrawerCallbacks jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private Set<DrawerFrame.TouchEventConsumer> jdField_a_of_type_JavaUtilSet = new HashSet();
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
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
    if (paramContext != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DrawerFrame.SmoothInterpolator());
      a(paramViewGroup);
      return;
    }
    throw new NullPointerException("context is null");
  }
  
  public DrawerFrame(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, @NonNull boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DrawerFrame.SmoothInterpolator());
    this.jdField_a_of_type_AndroidViewView = paramViewGroup;
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidViewViewGroup = this;
    }
  }
  
  private void a(int paramInt)
  {
    int k;
    int m;
    if (this.j == 0)
    {
      k = this.jdField_a_of_type_Int;
      m = this.jdField_b_of_type_Int;
      if (k + paramInt > m)
      {
        if (k == m) {
          return;
        }
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(m - k);
        this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        a(this.j, this.jdField_a_of_type_Int);
        invalidate();
        return;
      }
    }
    View localView;
    if (this.j == 0)
    {
      k = this.jdField_a_of_type_Int;
      if (k + paramInt < 0)
      {
        if (k == 0) {
          return;
        }
        this.jdField_c_of_type_Boolean = false;
        localView = this.jdField_a_of_type_AndroidViewView;
        localView.offsetLeftAndRight(0 - localView.getLeft());
        this.jdField_a_of_type_Int = 0;
        a(this.j, this.jdField_a_of_type_Int);
        invalidate();
        return;
      }
    }
    if (this.j == 1)
    {
      k = this.jdField_a_of_type_Int;
      m = this.jdField_c_of_type_Int;
      if (k + paramInt < -m)
      {
        if (k == -m) {
          return;
        }
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(-m - k);
        this.jdField_a_of_type_Int = (-this.jdField_c_of_type_Int);
        a(this.j, this.jdField_a_of_type_Int);
        invalidate();
        return;
      }
    }
    if (this.j == 1)
    {
      k = this.jdField_a_of_type_Int;
      if (k + paramInt > 0)
      {
        if (k == 0) {
          return;
        }
        this.jdField_c_of_type_Boolean = false;
        localView = this.jdField_a_of_type_AndroidViewView;
        localView.offsetLeftAndRight(0 - localView.getLeft());
        this.jdField_a_of_type_Int = 0;
        a(this.j, this.jdField_a_of_type_Int);
        invalidate();
        return;
      }
    }
    this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(paramInt);
    this.jdField_a_of_type_Int += paramInt;
    a(this.j, this.jdField_a_of_type_Int);
    invalidate();
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
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new DrawerFrame.1(this));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    return (localRect != null) && (localRect.contains(paramInt1, paramInt2));
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext()) {
        if (((DrawerFrame.TouchEventConsumer)localIterator.next()).a(paramMotionEvent)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    if (Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity()) > localViewConfiguration.getScaledMinimumFlingVelocity())
    {
      if (this.j == 0)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() > 0.0F)
        {
          this.jdField_c_of_type_Boolean = false;
          b();
          return;
        }
        this.jdField_c_of_type_Boolean = true;
        e();
        return;
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() < 0.0F)
      {
        this.jdField_c_of_type_Boolean = false;
        c();
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      e();
      return;
    }
    if (this.j == 0)
    {
      int k = this.jdField_a_of_type_Int;
      d1 = k;
      int m = this.h;
      d2 = m;
      Double.isNaN(d2);
      if (d1 <= d2 / 3.0D * 2.0D)
      {
        d1 = k;
        d2 = m;
        Double.isNaN(d2);
        if ((d1 <= d2 / 3.0D) || (paramInt > 0))
        {
          this.jdField_c_of_type_Boolean = true;
          e();
          return;
        }
      }
      this.jdField_c_of_type_Boolean = false;
      b();
      return;
    }
    double d1 = this.jdField_a_of_type_Int;
    double d2 = this.jdField_c_of_type_Int;
    Double.isNaN(d2);
    if (d1 < -(d2 / 3.0D * 1.0D))
    {
      this.jdField_c_of_type_Boolean = false;
      c();
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    e();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int m = 0;
    int k;
    if ((paramInt2 != 1) && (paramInt1 != 1)) {
      k = 0;
    } else {
      k = 8;
    }
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() != k)) {
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
    localView = this.jdField_c_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() != paramInt2)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt2);
    }
  }
  
  private boolean b()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    return this.jdField_a_of_type_AndroidViewView != null;
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
    if ((this.jdField_b_of_type_AndroidViewView == null) && (this.jdField_c_of_type_AndroidViewView == null))
    {
      QLog.d("DrawerFrame", 1, "drawer view is empty!");
      return;
    }
    d();
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null)
    {
      removeView(localView);
      this.jdField_b_of_type_AndroidViewView = null;
      if (QLog.isColorLevel()) {
        QLog.d("DrawerFrame", 2, "remove left drawer");
      }
    }
    localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null)
    {
      removeView(localView);
      this.jdField_c_of_type_AndroidViewView = null;
      if (QLog.isColorLevel()) {
        QLog.d("DrawerFrame", 2, "remove right drawer");
      }
    }
  }
  
  @TargetApi(11)
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, 2);
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f1;
      if (paramInt1 == 0)
      {
        f1 = paramInt2;
        paramInt2 = this.jdField_b_of_type_Int;
      }
      else
      {
        f1 = -paramInt2;
        paramInt2 = this.jdField_c_of_type_Int;
      }
      f1 /= paramInt2;
      if (paramInt1 == 0) {
        paramInt2 = this.h;
      } else {
        paramInt2 = -this.h;
      }
      float f2 = paramInt2;
      if (paramInt1 == 0) {
        localObject = this.jdField_b_of_type_AndroidViewView;
      } else {
        localObject = this.jdField_c_of_type_AndroidViewView;
      }
      if (localObject != null) {
        ((View)localObject).setTranslationX(f2 * (f1 - 1.0F));
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).a(this.j, f1);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (b())
    {
      if (!c()) {
        return;
      }
      this.j = paramInt;
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      }
      else if (this.jdField_c_of_type_Boolean)
      {
        return;
      }
      int k = this.j;
      if (k == 0) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      } else if (k == 1) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_d_of_type_Boolean = true;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).b(this.j);
      }
      int m;
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetScroller;
          k = this.jdField_a_of_type_Int;
          m = -this.jdField_c_of_type_Int;
          if (paramBoolean) {
            paramInt = 300;
          } else {
            paramInt = 1;
          }
          ((Scroller)localObject).startScroll(k, 0, m - k, 0, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidWidgetScroller;
        k = this.jdField_a_of_type_Int;
        m = this.jdField_b_of_type_Int;
        if (paramBoolean) {
          paramInt = 300;
        } else {
          paramInt = 1;
        }
        ((Scroller)localObject).startScroll(k, 0, m - k, 0, paramInt);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).f();
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((paramView != null) && (this.jdField_b_of_type_AndroidViewView == null) && (this.jdField_c_of_type_AndroidViewView == null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addDrawerView, side: ");
        localStringBuilder.append(paramInt);
        QLog.d("DrawerFrame", 2, localStringBuilder.toString());
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
      if (paramInt == 1)
      {
        this.jdField_c_of_type_AndroidViewView = paramView;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        paramView = new FrameLayout.LayoutParams(-2, -1, 21);
        addView(this.jdField_c_of_type_AndroidViewView, paramView);
        this.j = 1;
        this.jdField_f_of_type_Boolean = false;
        this.jdField_g_of_type_Boolean = false;
      }
      return;
    }
    QLog.d("DrawerFrame", 1, "drawer view has exist");
  }
  
  public void a(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.jdField_a_of_type_JavaUtilSet.add(paramTouchEventConsumer);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (b())
    {
      if (!c()) {
        return;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      }
      else if (!this.jdField_c_of_type_Boolean)
      {
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).b(this.j);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).g();
      }
      localObject = this.jdField_a_of_type_AndroidWidgetScroller;
      int m = this.jdField_a_of_type_Int;
      int n = -m;
      int k;
      if (paramBoolean) {
        k = 300;
      } else {
        k = 0;
      }
      ((Scroller)localObject).startScroll(m, 0, n, 0, k);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
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
  
  public void b(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.jdField_a_of_type_JavaUtilSet.remove(paramTouchEventConsumer);
    }
  }
  
  public void c()
  {
    a(1, true);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks = null;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.j = 0;
    } else {
      this.j = 1;
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.offsetLeftAndRight(0 - localView.getLeft());
    }
    a(this.j, this.jdField_a_of_type_Int);
    postInvalidate();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
    }
    b(this.j, 1);
  }
  
  public void e()
  {
    a(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    int k = 0;
    boolean bool;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4)
          {
            if (m != 5) {
              return true;
            }
            if (a())
            {
              m = this.j;
              if (m == 0)
              {
                m = this.jdField_b_of_type_Int;
                k = m - this.jdField_a_of_type_Int;
                this.jdField_a_of_type_Int = m;
              }
              else if (m == 1)
              {
                m = this.jdField_c_of_type_Int;
                k = -m - this.jdField_a_of_type_Int;
                this.jdField_a_of_type_Int = (-m);
              }
              paramMessage = this.jdField_a_of_type_AndroidViewView;
              if ((paramMessage != null) && (k != 0))
              {
                paramMessage.offsetLeftAndRight(k);
                a(this.j, this.jdField_a_of_type_Int);
                postInvalidate();
                return true;
              }
            }
          }
          else
          {
            if (this.jdField_d_of_type_Boolean) {
              return true;
            }
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
            if (paramMessage != null) {
              paramMessage.i();
            }
            if (this.jdField_b_of_type_AndroidViewView != null) {
              this.j = 0;
            } else {
              this.j = 1;
            }
            b(this.j, 1);
            return true;
          }
        }
        else
        {
          if (this.jdField_d_of_type_Boolean) {
            return true;
          }
          b(this.j, 0);
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
          if (paramMessage != null)
          {
            paramMessage.h();
            return true;
          }
        }
      }
      else
      {
        bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
        k = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
        m = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
        paramMessage = this.jdField_a_of_type_AndroidViewView;
        if (paramMessage != null)
        {
          paramMessage.offsetLeftAndRight(k - m);
          a(this.j, this.jdField_a_of_type_Int);
        }
        postInvalidate();
        if (!bool)
        {
          this.jdField_d_of_type_Boolean = false;
          this.jdField_c_of_type_Boolean = false;
          paramMessage = this.jdField_b_of_type_AndroidViewView;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          paramMessage = this.jdField_c_of_type_AndroidViewView;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
          return true;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
        return true;
      }
    }
    else
    {
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      k = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      m = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      paramMessage = this.jdField_a_of_type_AndroidViewView;
      if (paramMessage != null)
      {
        paramMessage.offsetLeftAndRight(k - m);
        a(this.j, this.jdField_a_of_type_Int);
      }
      postInvalidate();
      if (!bool)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
        return true;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
    }
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = b();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (a(paramMotionEvent)) {
      return false;
    }
    int k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    int m = (int)(paramMotionEvent.getX() + 0.5F);
    int n = (int)(paramMotionEvent.getY() + 0.5F);
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return false;
        }
        if (!this.jdField_e_of_type_Boolean) {
          return false;
        }
        if ((!this.jdField_c_of_type_Boolean) && ((m > this.jdField_e_of_type_Int) || (m > this.jdField_d_of_type_Int)))
        {
          this.jdField_e_of_type_Boolean = false;
          return false;
        }
        this.jdField_e_of_type_Int = m;
        this.jdField_g_of_type_Int = n;
        m = Math.abs(this.jdField_e_of_type_Int - this.jdField_d_of_type_Int);
        n = Math.abs(this.jdField_g_of_type_Int - this.jdField_f_of_type_Int);
        if ((m > k) && ((n + 0.0F) / m < 0.6F)) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0) {
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
          }
          else if (!c())
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
            if (paramMotionEvent != null) {
              if ((this.jdField_e_of_type_Int > this.jdField_d_of_type_Int) && (this.jdField_g_of_type_Boolean))
              {
                this.jdField_g_of_type_Boolean = false;
                paramMotionEvent.a(0);
              }
              else if ((this.jdField_e_of_type_Int < this.jdField_d_of_type_Int) && (this.jdField_f_of_type_Boolean))
              {
                this.jdField_f_of_type_Boolean = false;
                this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks.a(1);
              }
            }
          }
        }
        bool1 = bool2;
        if (k != 0)
        {
          bool1 = bool2;
          if (c()) {
            bool1 = true;
          }
        }
        return bool1;
      }
      this.jdField_e_of_type_Boolean = false;
      this.jdField_e_of_type_Int = -1;
      this.jdField_d_of_type_Int = -1;
      this.jdField_g_of_type_Int = -1;
      this.jdField_f_of_type_Int = -1;
      return false;
    }
    this.jdField_e_of_type_Int = m;
    this.jdField_d_of_type_Int = m;
    this.jdField_g_of_type_Int = n;
    this.jdField_f_of_type_Int = n;
    if (a(m, n)) {
      this.jdField_e_of_type_Boolean = true;
    }
    if ((this.jdField_d_of_type_Boolean) && (((this.j == 0) && (this.jdField_d_of_type_Int > this.jdField_a_of_type_Int)) || ((this.j == 1) && (this.jdField_d_of_type_Int < this.h + this.jdField_a_of_type_Int))))
    {
      this.jdField_e_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = this.h;
    this.h = (paramInt3 - paramInt1);
    this.i = (paramInt4 - paramInt2);
    int m = this.h;
    this.jdField_b_of_type_Int = m;
    this.jdField_c_of_type_Int = m;
    if ((this.jdField_a_of_type_AndroidGraphicsRect == null) && (m > 0))
    {
      int n = this.i;
      if (n > 0) {
        setTouchableBound(0, 0, m, n);
      }
    }
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      this.jdField_b_of_type_AndroidViewView.layout(((FrameLayout.LayoutParams)localObject).leftMargin + paramInt1, ((FrameLayout.LayoutParams)localObject).topMargin + paramInt2, paramInt3 - ((FrameLayout.LayoutParams)localObject).rightMargin, paramInt4 - ((FrameLayout.LayoutParams)localObject).bottomMargin);
    }
    localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      this.jdField_c_of_type_AndroidViewView.layout(((FrameLayout.LayoutParams)localObject).leftMargin + paramInt1, ((FrameLayout.LayoutParams)localObject).topMargin + paramInt2, paramInt3 - ((FrameLayout.LayoutParams)localObject).rightMargin, paramInt4 - ((FrameLayout.LayoutParams)localObject).bottomMargin);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      ((View)localObject).layout(((View)localObject).getLeft(), this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getLeft() + paramInt3, this.jdField_a_of_type_AndroidViewView.getTop() + paramInt4);
    }
    if ((k != this.h) && (k != 0))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(5);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b()) {
      return false;
    }
    int m = (int)(paramMotionEvent.getX() + 0.5F);
    int n = (int)(paramMotionEvent.getY() + 0.5F);
    int k = m - this.jdField_e_of_type_Int;
    int i1 = this.jdField_g_of_type_Int;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.jdField_e_of_type_Int = m;
    this.jdField_g_of_type_Int = n;
    m = paramMotionEvent.getAction() & 0xFF;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2) {
          return false;
        }
      }
      else
      {
        b(k);
        return true;
      }
    }
    else if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    }
    boolean bool = this.jdField_d_of_type_Boolean;
    this.jdField_d_of_type_Boolean = true;
    if (!bool)
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks;
      if (paramMotionEvent != null) {
        paramMotionEvent.b(this.j);
      }
    }
    a(k);
    return true;
  }
  
  public void setDrawerCallbacks(DrawerFrame.IDrawerCallbacks paramIDrawerCallbacks)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks = paramIDrawerCallbacks;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTouchableBound(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    localRect.left = paramInt1;
    localRect.top = paramInt2;
    localRect.right = paramInt3;
    localRect.bottom = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */