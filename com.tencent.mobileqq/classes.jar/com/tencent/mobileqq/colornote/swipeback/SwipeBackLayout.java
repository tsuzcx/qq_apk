package com.tencent.mobileqq.colornote.swipeback;

import amkk;
import amkl;
import amkm;
import amkq;
import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Scroller;
import bawz;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SwipeBackLayout
  extends FrameLayout
{
  public static int g;
  public static int h;
  protected int a;
  private amkl jdField_a_of_type_Amkl;
  public final amkm a;
  public amkq a;
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Context a;
  protected GestureDetector a;
  protected View a;
  protected Scroller a;
  private List<ViewPager> jdField_a_of_type_JavaUtilList = new LinkedList();
  public boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  public volatile boolean c;
  protected int d;
  protected boolean d;
  protected int e;
  private boolean e;
  protected int f;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public SwipeBackLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Amkm = new amkm(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_f_of_type_Int = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new amkk(this));
    jdField_g_of_type_Int = bawz.a(paramContext, 90.0F);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = ((View)paramView.getParent());
  }
  
  private void a(List<ViewPager> paramList, ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewPager)) {
        paramList.add((ViewPager)localView);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof ViewGroup)) {
          a(paramList, (ViewGroup)localView);
        }
      }
    }
  }
  
  protected ViewPager a(List<ViewPager> paramList, MotionEvent paramMotionEvent)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Rect localRect = new Rect();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ViewPager localViewPager = (ViewPager)paramList.next();
      localViewPager.getHitRect(localRect);
      if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        return localViewPager;
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    Object localObject = paramActivity.getTheme().obtainStyledAttributes(new int[] { 16842836 });
    int i = ((TypedArray)localObject).getResourceId(0, 0);
    ((TypedArray)localObject).recycle();
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    localObject = paramActivity.getChildAt(0);
    ((View)localObject).setBackgroundResource(i);
    paramActivity.removeView((View)localObject);
    addView((View)localObject);
    a((View)localObject);
    paramActivity.addView(this);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
      if ((this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) && (this.jdField_f_of_type_Boolean)) {
        d();
      }
    }
  }
  
  public void d()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    int i = this.jdField_a_of_type_Int + this.jdField_a_of_type_AndroidViewView.getScrollX();
    int j = (int)(i * 1.0D / this.jdField_a_of_type_Int * 700.0D);
    try
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidViewView.getScrollX(), 0, -i + 1, 0, Math.abs(j));
      label66:
      if (QLog.isColorLevel()) {
        QLog.i("SwipeBackLayout", 2, "SwipeBackLayout scrollRight viewwithd=" + this.jdField_a_of_type_Int + "  startx+ " + this.jdField_a_of_type_AndroidViewView.getScrollX() + "  left width = " + -i + "  duration=" + j);
      }
      this.jdField_a_of_type_Amkm.sendEmptyMessageDelayed(1, 200L);
      postInvalidate();
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
  
  public void e()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void f()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  protected void g()
  {
    try
    {
      int i = this.jdField_a_of_type_AndroidViewView.getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidViewView.getScrollX(), 0, -i, 0, Math.abs(i));
      postInvalidate();
      if (this.jdField_a_of_type_Amkq != null) {
        this.jdField_a_of_type_Amkq.b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void h()
  {
    try
    {
      int i = this.jdField_a_of_type_AndroidViewView.getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, -i, 0, Math.abs(i) / 2);
      postInvalidate();
      if (this.jdField_a_of_type_Amkq != null) {
        this.jdField_a_of_type_Amkq.b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewPager localViewPager = a(this.jdField_a_of_type_JavaUtilList, paramMotionEvent);
    if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null))
    {
      return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Boolean = false;
      int i = (int)paramMotionEvent.getRawX();
      this.jdField_e_of_type_Int = i;
      this.c = i;
      this.jdField_d_of_type_Int = ((int)paramMotionEvent.getRawY());
      if (this.c < jdField_g_of_type_Int)
      {
        this.jdField_a_of_type_Boolean = true;
        continue;
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && ((int)paramMotionEvent.getRawX() - this.c > this.jdField_b_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.jdField_d_of_type_Int) < this.jdField_b_of_type_Int)) {
          return true;
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = getWidth();
      a(this.jdField_a_of_type_JavaUtilList, this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null))
    {
      return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return true;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = this.jdField_e_of_type_Int - i;
        if ((i - this.c > this.jdField_b_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.jdField_d_of_type_Int) < this.jdField_b_of_type_Int))
        {
          if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Amkl != null)) {
            this.jdField_a_of_type_Amkl.a(true);
          }
          this.jdField_b_of_type_Boolean = true;
        }
        if (this.jdField_e_of_type_Boolean)
        {
          this.jdField_e_of_type_Int = i;
          if ((i - this.c > 0) && (this.jdField_b_of_type_Boolean))
          {
            if (QLog.isColorLevel()) {
              QLog.i("SwipeBackLayout", 2, "moveX:" + i + "downX:" + this.c + "deltaX:" + j);
            }
            i = j;
            if (this.jdField_a_of_type_AndroidViewView.getScrollX() + j > 0) {
              i = -this.jdField_a_of_type_AndroidViewView.getScrollX();
            }
            this.jdField_a_of_type_AndroidViewView.scrollBy(i, 0);
            continue;
            if ((this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
            {
              this.jdField_b_of_type_Boolean = false;
              if (QLog.isColorLevel()) {
                QLog.i("SwipeBackLayout", 2, "event.getRawX():" + paramMotionEvent.getRawX() + "screenWidth:" + this.jdField_f_of_type_Int + "mViewWidth:" + this.jdField_a_of_type_Int);
              }
              if (paramMotionEvent.getRawX() - this.c >= this.jdField_f_of_type_Int / 2)
              {
                this.jdField_f_of_type_Boolean = true;
                if (this.jdField_a_of_type_AndroidViewView.getScrollX() != 0) {
                  d();
                }
                if (this.jdField_a_of_type_Amkl != null) {
                  this.jdField_a_of_type_Amkl.a(false);
                }
              }
              else
              {
                postDelayed(new SwipeBackLayout.1(this), 100L);
                this.jdField_f_of_type_Boolean = false;
              }
            }
          }
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = paramGestureDetector;
  }
  
  public void setOnSwipeListener(amkl paramamkl)
  {
    this.jdField_a_of_type_Amkl = paramamkl;
  }
  
  public void setReadyToSlide(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setTransitionAnim(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator = paramAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */