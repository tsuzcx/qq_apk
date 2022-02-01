package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

public class PullToZoomListView
  extends XListView
{
  private static final Interpolator a;
  protected float a;
  protected int a;
  protected View a;
  protected FrameLayout a;
  protected PullToZoomListView.ScalingRunnalable a;
  protected boolean a;
  protected float b;
  protected int b;
  protected boolean b;
  protected float c;
  protected int c;
  protected int d;
  
  static
  {
    jdField_a_of_type_AndroidViewAnimationInterpolator = new PullToZoomListView.1();
  }
  
  public PullToZoomListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  public PullToZoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  public PullToZoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() >= this.jdField_b_of_type_Int) && (QLog.isColorLevel())) {
      QLog.d("PullToZoomListView", 2, "endScraling");
    }
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView$ScalingRunnalable.a(200L);
  }
  
  private void a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.d = localDisplayMetrics.heightPixels;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView$ScalingRunnalable = new PullToZoomListView.ScalingRunnalable(this);
  }
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PullToZoomListView", 2, "initHeaderView");
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void addHeaderView(View paramView)
  {
    a(paramView);
    super.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    a(paramView);
    super.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramObject, paramBoolean);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if (!this.jdField_a_of_type_ComTencentWidgetPullToZoomListView$ScalingRunnalable.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetPullToZoomListView$ScalingRunnalable.a();
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
      this.jdField_c_of_type_Float = (this.d * 1.0F / this.jdField_b_of_type_Int);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() / this.jdField_b_of_type_Int);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_Int == 0)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if ((localObject != null) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        this.jdField_b_of_type_Int = ((FrameLayout)localObject).getHeight();
        this.jdField_c_of_type_Int = (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidViewView.getHeight());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mHeaderHeight:");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject).append(" mHeaderBottomHeight:");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
          QLog.d("PullToZoomListView", 2, ((StringBuilder)localObject).toString());
        }
        if (this.jdField_b_of_type_Int > 0) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            i = paramMotionEvent.getActionIndex();
            this.jdField_a_of_type_Float = paramMotionEvent.getY(i);
            this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(i);
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
          Object localObject;
          if (i == -1)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Invalid pointerId=");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
              ((StringBuilder)localObject).append(" in onTouchEvent");
              QLog.d("PullToZoomListView", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            if (this.jdField_a_of_type_Float == -1.0F) {
              this.jdField_a_of_type_Float = paramMotionEvent.getY(i);
            }
            if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() >= this.jdField_b_of_type_Int)
            {
              localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
              ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
              float f1 = paramMotionEvent.getY(i);
              float f2 = this.jdField_a_of_type_Float;
              float f3 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom();
              int j = this.jdField_b_of_type_Int;
              f2 = (f1 - f2 + f3) / j;
              f1 = this.jdField_b_of_type_Float;
              f2 = (f2 - f1) / 2.0F + f1;
              if ((f1 <= 1.0D) && (f2 < f1))
              {
                ((ViewGroup.LayoutParams)localObject).height = j;
                localLayoutParams.height = (j - this.jdField_c_of_type_Int);
                this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
                this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
                return super.onTouchEvent(paramMotionEvent);
              }
              this.jdField_b_of_type_Float = Math.min(Math.max(f2, 1.0F), this.jdField_c_of_type_Float);
              ((ViewGroup.LayoutParams)localObject).height = ((int)(this.jdField_b_of_type_Int * this.jdField_b_of_type_Float));
              localLayoutParams.height = (((ViewGroup.LayoutParams)localObject).height - this.jdField_c_of_type_Int);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("new height:");
                localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
                localStringBuilder.append(" imgHeight:");
                localStringBuilder.append(localLayoutParams.height);
                localStringBuilder.append(" mLastScale:");
                localStringBuilder.append(this.jdField_b_of_type_Float);
                QLog.d("PullToZoomListView", 2, localStringBuilder.toString());
              }
              if (((ViewGroup.LayoutParams)localObject).height < this.d)
              {
                this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
                this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
              }
              this.jdField_a_of_type_Float = paramMotionEvent.getY(i);
            }
            else
            {
              this.jdField_a_of_type_Float = paramMotionEvent.getY(i);
            }
          }
        }
      }
      else
      {
        b();
        a();
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setHeaderImage(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.PullToZoomListView
 * JD-Core Version:    0.7.0.1
 */