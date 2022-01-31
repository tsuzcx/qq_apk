package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.Scroller;
import bcsx;
import java.util.ArrayList;

public class Workspace
  extends FrameLayout
{
  protected static final double a;
  protected float a;
  protected int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  protected Scroller a;
  private bcsx jdField_a_of_type_Bcsx;
  protected boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  protected float b;
  protected int b;
  final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  protected int c;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_c_of_type_Boolean = true;
  protected int d;
  private boolean d;
  protected int e = 0;
  protected int f;
  private int g;
  
  static
  {
    jdField_a_of_type_Double = Math.tan(Math.toRadians(30.0D));
  }
  
  public Workspace(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Workspace(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    c();
    setDrawingCacheEnabled(true);
    setAlwaysDrawnWithCacheEnabled(true);
    setBackgroundDrawable(getResources().getDrawable(2130838514));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(false);
    this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void d()
  {
    int i = getWidth();
    a((getScrollX() + i / 2) / i);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  void a() {}
  
  public void a(int paramInt)
  {
    a();
    int i = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i != this.jdField_b_of_type_Int) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (this.jdField_c_of_type_Int != i)
      {
        this.jdField_c_of_type_Int = i;
        if (this.jdField_a_of_type_Bcsx != null) {
          this.jdField_a_of_type_Bcsx.a(i);
        }
      }
      this.jdField_d_of_type_Int = i;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.jdField_b_of_type_Int))) {
        localView.clearFocus();
      }
      paramInt = getWidth() * i - getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt));
      invalidate();
      return;
    }
  }
  
  protected boolean a(View paramView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      i = 0;
    }
    for (;;)
    {
      View localView;
      Workspace localWorkspace;
      if (i < paramView.getChildCount())
      {
        localView = paramView.getChildAt(i);
        if (!(localView instanceof Workspace)) {
          break label130;
        }
        localWorkspace = (Workspace)localView;
        localWorkspace.getGlobalVisibleRect(this.jdField_c_of_type_AndroidGraphicsRect);
        if ((localWorkspace.isShown()) && (this.jdField_c_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {}
      }
      else
      {
        return false;
      }
      if (paramBoolean)
      {
        if ((localWorkspace.a() > 0) || (a() == 0)) {
          return true;
        }
        if (localWorkspace.jdField_c_of_type_Int != this.jdField_b_of_type_Int) {
          localWorkspace.setCurrentScreen(localWorkspace.jdField_c_of_type_Int);
        }
      }
      label130:
      while (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramBoolean, paramMotionEvent)))
      {
        return true;
        if ((localWorkspace.a() < localWorkspace.getChildCount() - 1) || (a() == getChildCount() - 1)) {
          return true;
        }
        if (localWorkspace.jdField_c_of_type_Int != this.jdField_b_of_type_Int) {
          localWorkspace.setCurrentScreen(localWorkspace.jdField_c_of_type_Int);
        }
      }
      i += 1;
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt)
  {
    getChildAt(this.jdField_b_of_type_Int).addFocusables(paramArrayList, paramInt);
    if (paramInt == 17) {
      if (this.jdField_b_of_type_Int > 0) {
        getChildAt(this.jdField_b_of_type_Int - 1).addFocusables(paramArrayList, paramInt);
      }
    }
    while ((paramInt != 66) || (this.jdField_b_of_type_Int >= getChildCount() - 1)) {
      return;
    }
    getChildAt(this.jdField_b_of_type_Int + 1).addFocusables(paramArrayList, paramInt);
  }
  
  void b() {}
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_d_of_type_Int == -1);
      int i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = Math.max(0, Math.min(this.jdField_d_of_type_Int, getChildCount() - 1));
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_d_of_type_Int = -1;
      b();
    } while (this.jdField_a_of_type_Bcsx == null);
    this.jdField_a_of_type_Bcsx.b(this.jdField_b_of_type_Int);
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (a() > 0)
      {
        a(a() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (a() < getChildCount() - 1))
    {
      a(a() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramMotionEvent.getAction() == 2) {
      if (paramMotionEvent.getX() - this.jdField_a_of_type_Float > 0.0F)
      {
        bool1 = true;
        if (!a(getChildAt(this.jdField_c_of_type_Int), bool1, paramMotionEvent)) {
          break label58;
        }
        bool1 = false;
      }
    }
    label58:
    int i;
    do
    {
      return bool1;
      bool1 = false;
      break;
      i = paramMotionEvent.getAction();
      if (i != 2) {
        break label81;
      }
      bool1 = bool2;
    } while (this.e != 0);
    label81:
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      Object localObject = getChildAt(this.jdField_c_of_type_Int);
      if ((this.e != 0) && (!a((View)localObject, true, paramMotionEvent)))
      {
        bool1 = bool2;
        if (!a((View)localObject, false, paramMotionEvent)) {
          break;
        }
      }
      return false;
      int k = (int)Math.abs(f1 - this.jdField_a_of_type_Float);
      int m = (int)Math.abs(f2 - this.jdField_b_of_type_Float);
      int j = this.f;
      if (k > j)
      {
        i = 1;
        label211:
        if (m <= j) {
          break label318;
        }
      }
      label318:
      for (j = 1;; j = 0)
      {
        double d1 = m / k;
        if (((i == 0) && (j == 0)) || (d1 >= jdField_a_of_type_Double)) {
          break;
        }
        if (i != 0)
        {
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
          this.e = 1;
          this.jdField_a_of_type_Float = f1;
          a();
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_Boolean = false;
        getChildAt(this.jdField_b_of_type_Int).cancelLongPress();
        break;
        i = 0;
        break label211;
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.e = i;
        break;
      }
      b();
      this.e = 0;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = localView.getMeasuredWidth();
        if ((!this.jdField_d_of_type_Boolean) || (paramInt1 == this.jdField_b_of_type_Int)) {
          localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
        }
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    paramInt1 = this.g;
    if (paramInt1 > j) {}
    for (float f1 = (k * j - paramInt1) / ((k - 1) * j);; f1 = 1.0F)
    {
      this.jdField_c_of_type_Float = f1;
      if (this.jdField_b_of_type_Boolean)
      {
        scrollTo(this.jdField_b_of_type_Int * j, 0);
        this.jdField_b_of_type_Boolean = false;
      }
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (this.jdField_d_of_type_Int != -1) {}
    for (int i = this.jdField_d_of_type_Int;; i = this.jdField_b_of_type_Int)
    {
      int j = i;
      if (i >= getChildCount()) {
        j = getChildCount() - 1;
      }
      if (getChildAt(j) != null) {
        getChildAt(j).requestFocus(paramInt, paramRect);
      }
      return false;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Workspace.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.currentScreen != -1) {
      this.jdField_b_of_type_Int = paramParcelable.currentScreen;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Workspace.SavedState localSavedState = new Workspace.SavedState(super.onSaveInstanceState());
    localSavedState.currentScreen = this.jdField_b_of_type_Int;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {}
    for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = false)
    {
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      }
      scrollTo(this.jdField_c_of_type_Int * paramInt1, 0);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getChildCount() < 0) {}
    int i;
    do
    {
      do
      {
        do
        {
          float f1;
          do
          {
            return true;
            if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
              this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
            }
            this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
            i = paramMotionEvent.getAction();
            f1 = paramMotionEvent.getX();
            switch (i)
            {
            default: 
              return true;
            case 0: 
              if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
                this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
              }
              paramMotionEvent = getParent();
              if (paramMotionEvent != null) {
                paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              }
              this.jdField_a_of_type_Float = f1;
              return true;
            }
          } while (this.e != 1);
          i = (int)(this.jdField_a_of_type_Float - f1);
          if ((i > 0) && (!this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Int == getChildCount() - 1))
          {
            this.jdField_a_of_type_Bcsx.b(getChildCount());
            return true;
          }
          this.jdField_a_of_type_Float = f1;
          paramMotionEvent = getParent();
          if (paramMotionEvent != null) {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          }
          if (i >= 0) {
            break;
          }
          if (getScrollX() > 0)
          {
            scrollBy(Math.max(-getScrollX(), i), 0);
            return true;
          }
        } while (!this.jdField_c_of_type_Boolean);
        scrollBy(i / 3, 0);
        return true;
      } while (i <= 0);
      int j = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
      if (j > 0)
      {
        scrollBy(Math.min(j, i), 0);
        return true;
      }
    } while (!this.jdField_c_of_type_Boolean);
    scrollBy(i / 3, 0);
    return true;
    if (this.e == 1)
    {
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i = (int)paramMotionEvent.getXVelocity();
      if ((i <= 350) || (this.jdField_b_of_type_Int <= 0)) {
        break label374;
      }
      a(this.jdField_b_of_type_Int - 1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      this.e = 0;
      return true;
      label374:
      if ((i < -350) && (this.jdField_b_of_type_Int < getChildCount() - 1)) {
        a(this.jdField_b_of_type_Int + 1);
      } else {
        d();
      }
    }
    this.e = 0;
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    paramView1 = new Rect();
    paramView2.getDrawingRect(paramView1);
    paramView2.requestRectangleOnScreen(paramView1);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i = indexOfChild(paramView);
    if ((i != this.jdField_b_of_type_Int) || (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()))
    {
      a(i);
      return true;
    }
    return false;
  }
  
  public void setAllowLongPress(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setAlloweffect(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setCurrentScreen(int paramInt)
  {
    this.jdField_b_of_type_Int = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    scrollTo(this.jdField_b_of_type_Int * getWidth(), 0);
  }
  
  public void setDefaultScreen(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).setOnLongClickListener(paramOnLongClickListener);
      i += 1;
    }
  }
  
  public void setOnScreenChangeListener(bcsx parambcsx)
  {
    this.jdField_a_of_type_Bcsx = parambcsx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.Workspace
 * JD-Core Version:    0.7.0.1
 */