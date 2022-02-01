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
  protected int a;
  protected long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  protected Interpolator a;
  protected ISlidePanelListener a;
  protected boolean a;
  protected float b;
  protected int b;
  protected Interpolator b;
  protected boolean b;
  protected float c;
  protected int c;
  protected boolean c;
  protected float d;
  protected int d;
  protected boolean d;
  protected float e;
  protected int e;
  protected boolean e;
  protected float f;
  protected int f;
  protected float g;
  private int g;
  protected float h;
  private int h;
  protected float i;
  private int i;
  protected float j;
  protected float k;
  private float l;
  
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateInterpolator();
    this.jdField_b_of_type_AndroidViewAnimationInterpolator = new AccelerateInterpolator();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.l = getResources().getDisplayMetrics().density;
    paramContext = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_h_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
    this.jdField_a_of_type_Int = paramContext.getScaledMinimumFlingVelocity();
    this.jdField_d_of_type_Float = paramContext.getScaledTouchSlop();
    paramContext = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    paramAttributeSet = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(paramAttributeSet);
    this.jdField_i_of_type_Int = paramAttributeSet.heightPixels;
    this.jdField_i_of_type_Float = (this.jdField_i_of_type_Int - a(60));
    float f1 = a(84);
    this.j = f1;
    jdField_a_of_type_Float = f1;
    this.k = a(30);
    this.jdField_c_of_type_Int = 250;
    this.jdField_b_of_type_Int = this.jdField_i_of_type_Int;
    if (a(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_d_of_type_Int = a(30);
      this.jdField_e_of_type_Int = ((int)(this.j - this.jdField_d_of_type_Int + QQUIDelegate.a(this.jdField_a_of_type_AndroidContentContext)));
    }
    else
    {
      this.jdField_d_of_type_Int = a(51);
      this.jdField_e_of_type_Int = ((int)(this.j - this.jdField_d_of_type_Int));
    }
    this.jdField_f_of_type_Int = a(5);
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt * this.l + 0.5F);
  }
  
  private boolean a(Context paramContext)
  {
    return QQUIDelegate.a(paramContext);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void g()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.clear();
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  protected double a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  protected int a()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      int m;
      int n;
      if (a(this.jdField_a_of_type_AndroidContentContext))
      {
        m = this.jdField_b_of_type_Int - this.jdField_d_of_type_Int;
        n = QQUIDelegate.a(this.jdField_a_of_type_AndroidContentContext);
      }
      else
      {
        m = this.jdField_b_of_type_Int;
        n = this.jdField_d_of_type_Int;
      }
      return m - n;
    }
    return (int)(this.jdField_b_of_type_Int - this.j);
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      Object localObject = findViewWithTag(Integer.valueOf(1));
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { ((View)localObject).getY(), this.jdField_b_of_type_Int - this.jdField_i_of_type_Float }).setDuration(this.jdField_c_of_type_Int);
      localValueAnimator.setTarget(localObject);
      localValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      localValueAnimator.addUpdateListener(new SlideBottomPanel.4(this, (View)localObject));
      localValueAnimator.addListener(new SlideBottomPanel.5(this));
      localValueAnimator.start();
      this.jdField_b_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener;
      if (localObject != null) {
        ((ISlidePanelListener)localObject).displayPanel();
      }
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    f();
    if (Math.abs(this.jdField_b_of_type_Float) > Math.abs(this.jdField_c_of_type_Float)) {
      return;
    }
    View localView = findViewWithTag(Integer.valueOf(1));
    if ((!this.jdField_c_of_type_Boolean) && (Math.abs(paramMotionEvent.getY() - this.jdField_f_of_type_Float) > this.jdField_d_of_type_Float))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_g_of_type_Float = paramMotionEvent.getY();
      localView.addOnLayoutChangeListener(new SlideBottomPanel.1(this));
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_h_of_type_Float = (paramMotionEvent.getY() - this.jdField_g_of_type_Float);
      this.jdField_g_of_type_Float = paramMotionEvent.getY();
      float f1 = localView.getY();
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener;
      if (paramMotionEvent != null)
      {
        m = this.jdField_b_of_type_Int;
        if (f1 > m - this.jdField_i_of_type_Float)
        {
          f2 = m;
          f3 = this.j;
          if (f1 < f2 - f3) {
            paramMotionEvent.fadeBackground(1.0F - f1 / (m - f3));
          }
        }
      }
      float f2 = this.jdField_h_of_type_Float;
      int m = this.jdField_b_of_type_Int;
      float f3 = m;
      float f4 = this.jdField_i_of_type_Float;
      if (f1 + f2 <= f3 - f4)
      {
        localView.offsetTopAndBottom((int)(m - f4 - f1));
        return;
      }
      if (f1 + f2 >= a())
      {
        if (this.jdField_e_of_type_Boolean) {
          return;
        }
        f1 = this.jdField_h_of_type_Float;
        m = this.jdField_e_of_type_Int;
        if (f1 > m) {
          this.jdField_h_of_type_Float = m;
        }
        localView.offsetTopAndBottom((int)this.jdField_h_of_type_Float);
        return;
      }
      localView.offsetTopAndBottom((int)this.jdField_h_of_type_Float);
    }
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Float = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    this.jdField_g_of_type_Float = f1;
    this.jdField_f_of_type_Float = f1;
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Float > a()))
    {
      this.jdField_d_of_type_Boolean = true;
      return true;
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Float <= a()))
    {
      this.jdField_d_of_type_Boolean = false;
    }
    else
    {
      if (this.jdField_b_of_type_Boolean)
      {
        f1 = this.jdField_g_of_type_Float;
        int m = this.jdField_b_of_type_Int;
        float f2 = m;
        float f3 = this.jdField_i_of_type_Float;
        if ((f1 > f2 - f3) && (f1 <= m - f3 + this.j))
        {
          this.jdField_d_of_type_Boolean = true;
          break label180;
        }
      }
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Float < this.jdField_b_of_type_Int - this.jdField_i_of_type_Float))
      {
        b();
        this.jdField_d_of_type_Boolean = false;
      }
    }
    label180:
    return false;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = findViewWithTag(Integer.valueOf(1));
    int m = (int)(this.jdField_b_of_type_Int - this.j);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { ((View)localObject).getY(), this.jdField_b_of_type_Int - this.j });
    localValueAnimator.setInterpolator(this.jdField_b_of_type_AndroidViewAnimationInterpolator);
    localValueAnimator.setTarget(localObject);
    localValueAnimator.addUpdateListener(new SlideBottomPanel.2(this, (View)localObject, m));
    localValueAnimator.addListener(new SlideBottomPanel.3(this));
    localValueAnimator.start();
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener;
    if (localObject != null) {
      ((ISlidePanelListener)localObject).hidePanel();
    }
  }
  
  protected void b(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    f();
    float f1;
    if ((this.jdField_b_of_type_Boolean) || (paramMotionEvent.getY() - this.jdField_f_of_type_Float >= 0.0F) || (Math.abs(paramMotionEvent.getY() - this.jdField_f_of_type_Float) <= this.k))
    {
      f1 = this.jdField_c_of_type_Float;
      if ((f1 >= 0.0F) || (Math.abs(f1) <= Math.abs(this.jdField_b_of_type_Float)) || (Math.abs(this.jdField_c_of_type_Float) <= this.jdField_a_of_type_Int)) {}
    }
    else
    {
      a();
      break label330;
    }
    float f2;
    if ((!this.jdField_b_of_type_Boolean) && (l1 - l2 < 300L))
    {
      f1 = paramMotionEvent.getY();
      f2 = this.jdField_f_of_type_Float;
      if ((f1 - f2 < 0.0F) && (a(this.jdField_e_of_type_Float, f2, paramMotionEvent.getX(), paramMotionEvent.getY()) < jdField_a_of_type_Float))
      {
        a();
        break label330;
      }
    }
    int m;
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      m = (int)(paramMotionEvent.getY() - this.jdField_f_of_type_Float);
      if (((!this.jdField_e_of_type_Boolean) && (m > this.jdField_f_of_type_Int)) || ((this.jdField_e_of_type_Boolean) && (m < 0) && (Math.abs(m) < this.k))) {
        c();
      }
      if ((!this.jdField_e_of_type_Boolean) && (m < 0) && (Math.abs(m) < this.k))
      {
        paramMotionEvent = findViewWithTag(Integer.valueOf(1));
        ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { paramMotionEvent.getY(), this.jdField_b_of_type_Int - this.j }).setDuration(this.jdField_c_of_type_Int).start();
      }
    }
    label330:
    if (this.jdField_b_of_type_Boolean)
    {
      paramMotionEvent = findViewWithTag(Integer.valueOf(1));
      f1 = paramMotionEvent.getY();
      m = this.jdField_b_of_type_Int;
      float f3 = m;
      f2 = this.jdField_i_of_type_Float;
      if (f1 >= f3 - f2)
      {
        f3 = m;
        float f4 = this.k;
        if (f1 >= f3 - f2 + f4)
        {
          if (f1 <= m - f2 + f4) {
            break label460;
          }
          b();
          break label460;
        }
      }
      ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { f1, this.jdField_b_of_type_Int - this.jdField_i_of_type_Float }).setDuration(this.jdField_c_of_type_Int).start();
    }
    label460:
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Float = 0.0F;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    View localView = findViewWithTag(Integer.valueOf(1));
    float f1 = localView.getY();
    int m;
    if (a(this.jdField_a_of_type_AndroidContentContext)) {
      m = this.jdField_b_of_type_Int - this.jdField_d_of_type_Int + QQUIDelegate.a(this.jdField_a_of_type_AndroidContentContext);
    } else {
      m = this.jdField_b_of_type_Int - this.jdField_d_of_type_Int;
    }
    ObjectAnimator.ofFloat(localView, "y", new float[] { f1, m }).setDuration(this.jdField_c_of_type_Int).start();
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void d()
  {
    View localView = findViewWithTag(Integer.valueOf(1));
    ObjectAnimator.ofFloat(localView, "y", new float[] { localView.getY(), this.jdField_b_of_type_Int - this.j }).setDuration(this.jdField_c_of_type_Int).start();
    this.jdField_e_of_type_Boolean = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    c(paramMotionEvent);
    ISlidePanelListener localISlidePanelListener = this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener;
    if (localISlidePanelListener != null) {
      localISlidePanelListener.cancelAnimator();
    }
    int m = paramMotionEvent.getAction();
    boolean bool2 = true;
    boolean bool1;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m == 2) {
          a(paramMotionEvent);
        }
      }
      else
      {
        b(paramMotionEvent);
        g();
      }
      bool1 = false;
    }
    else
    {
      bool1 = a(paramMotionEvent);
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
  
  public void e()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    b();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_h_of_type_Int);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_g_of_type_Int = getChildCount();
    paramInt2 = (int)(this.jdField_b_of_type_Int - this.j);
    paramInt1 = 0;
    while (paramInt1 < this.jdField_g_of_type_Int)
    {
      View localView = getChildAt(paramInt1);
      localView.layout(0, paramInt2, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
      localView.setTag(Integer.valueOf(1));
      paramInt1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Boolean);
  }
  
  public void setSlidePanelListener(ISlidePanelListener paramISlidePanelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetISlidePanelListener = paramISlidePanelListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */