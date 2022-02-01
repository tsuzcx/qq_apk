package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;

public class SlideAndOverScrollRecyclerView
  extends OverScrollRecyclerView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  
  public SlideAndOverScrollRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideAndOverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideAndOverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void d()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.clear();
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int j = ((LinearLayoutManager)getLayoutManager()).findFirstVisibleItemPosition();
    Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      localObject1 = this.jdField_a_of_type_AndroidGraphicsRect;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = getChildAt(i);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return j + i;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  public void a()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((localViewGroup != null) && (localViewGroup.getScrollX() != 0)) {
      this.jdField_a_of_type_AndroidViewViewGroup.scrollTo(0, 0);
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      invalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    a(paramMotionEvent);
    int k = paramMotionEvent.getAction();
    float f1;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k == 2)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
          f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
          float f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
          if ((Math.abs(f1) <= 600.0F) || (Math.abs(f1) <= Math.abs(f2)))
          {
            f1 = i;
            if ((Math.abs(f1 - this.jdField_b_of_type_Float) < this.jdField_a_of_type_Int) || (Math.abs(f1 - this.jdField_b_of_type_Float) <= Math.abs(j - this.jdField_c_of_type_Float))) {}
          }
          else
          {
            this.jdField_a_of_type_Boolean = true;
            return true;
          }
        }
      }
      else {
        d();
      }
    }
    else
    {
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
      f1 = i;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f1;
      this.jdField_c_of_type_Float = j;
      this.jdField_b_of_type_Int = a(i, j);
      i = this.jdField_b_of_type_Int;
      if (i != -1)
      {
        ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i - ((LinearLayoutManager)getLayoutManager()).findFirstVisibleItemPosition()));
        if ((localViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup != localViewGroup) && (localViewGroup.getScrollX() != 0)) {
          localViewGroup.scrollTo(0, 0);
        }
        if (this.jdField_a_of_type_AndroidViewViewGroup.getChildCount() == 2) {
          this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(1).getWidth();
        } else {
          this.jdField_c_of_type_Int = -1;
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != -1))
    {
      float f1 = paramMotionEvent.getX();
      a(paramMotionEvent);
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2) {
            return true;
          }
          if (this.jdField_c_of_type_Int != -1)
          {
            float f2 = this.jdField_a_of_type_Float - f1;
            if ((this.jdField_a_of_type_AndroidViewViewGroup.getScrollX() + f2 <= this.jdField_c_of_type_Int) && (this.jdField_a_of_type_AndroidViewViewGroup.getScrollX() + f2 > 0.0F)) {
              this.jdField_a_of_type_AndroidViewViewGroup.scrollBy((int)f2, 0);
            }
            this.jdField_a_of_type_Float = f1;
            return true;
          }
        }
        else
        {
          if (this.jdField_c_of_type_Int != -1)
          {
            i = this.jdField_a_of_type_AndroidViewViewGroup.getScrollX();
            this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
            int j;
            if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() < -600.0F)
            {
              paramMotionEvent = this.jdField_a_of_type_AndroidWidgetScroller;
              j = this.jdField_c_of_type_Int;
              paramMotionEvent.startScroll(i, 0, j - i, 0, Math.abs(j - i));
            }
            else if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() >= 600.0F)
            {
              this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, -i, 0, Math.abs(i));
            }
            else
            {
              j = this.jdField_c_of_type_Int;
              if (i >= j / 2) {
                this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, j - i, 0, Math.abs(j - i));
              } else {
                this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, -i, 0, Math.abs(i));
              }
            }
            invalidate();
          }
          this.jdField_c_of_type_Int = -1;
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_Int = -1;
          d();
        }
      }
      return true;
    }
    a();
    d();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.SlideAndOverScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */