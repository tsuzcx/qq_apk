package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;

public class HorizontalRefreshLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private HorizontalRefreshLayout.OnDraggingListener jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryHorizontalRefreshLayout$OnDraggingListener;
  private HorizontalRefreshLayout.RefreshHeader jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryHorizontalRefreshLayout$RefreshHeader;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int c;
  private int d;
  private int e;
  private int f = DisplayUtil.a(getContext(), 25.0F);
  
  public HorizontalRefreshLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.jdField_b_of_type_AndroidViewView))
        {
          this.jdField_a_of_type_AndroidViewView = localView;
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_b_of_type_AndroidViewView = paramView;
      ((FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).gravity = 8388613;
      addView(this.jdField_b_of_type_AndroidViewView, 0);
    }
  }
  
  private void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      localView.animate().translationX(0.0F).setDuration(500L).setListener(new HorizontalRefreshLayout.1(this)).start();
      this.jdField_b_of_type_AndroidViewView.animate().translationX(this.jdField_a_of_type_Int).setDuration(500L).start();
    }
  }
  
  public boolean a()
  {
    return ViewCompat.canScrollHorizontally(this.jdField_a_of_type_AndroidViewView, 1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 2)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      else
      {
        k = i - this.c;
        int m = this.d;
        this.c = i;
        this.e = i;
        if (Math.abs(k) >= Math.abs(j - m))
        {
          if ((this.jdField_b_of_type_AndroidViewView != null) && (k < 0) && (!a()))
          {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
        }
        else
        {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
      }
    }
    else
    {
      this.c = i;
      this.e = i;
      this.d = j;
      if (i > this.f) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      a();
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
    }
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setTranslationX(this.jdField_a_of_type_Int);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null)
    {
      this.jdField_a_of_type_Int = localView.getMeasuredWidth();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            break label259;
          }
        }
        else
        {
          j = this.e;
          this.e = i;
          float f1 = i - j;
          float f2 = Math.abs(this.jdField_a_of_type_Float / this.jdField_b_of_type_Int);
          this.jdField_a_of_type_Float += f1 * (1.0F - f2);
          f1 = this.jdField_a_of_type_Float;
          if (f1 >= 0.0F)
          {
            this.jdField_a_of_type_Float = 0.0F;
            this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
            return false;
          }
          i = this.jdField_b_of_type_Int;
          if (f1 <= -i)
          {
            this.jdField_a_of_type_Float = (-i);
            this.jdField_a_of_type_AndroidViewView.setTranslationX(this.jdField_a_of_type_Float);
            this.jdField_b_of_type_AndroidViewView.setTranslationX(this.jdField_a_of_type_Int + this.jdField_a_of_type_Float);
            return false;
          }
          this.jdField_a_of_type_AndroidViewView.setTranslationX(f1);
          this.jdField_b_of_type_AndroidViewView.setTranslationX(this.jdField_a_of_type_Int + this.jdField_a_of_type_Float);
          this.jdField_b_of_type_Float = Math.abs(this.jdField_a_of_type_Float / this.jdField_a_of_type_Int);
          return false;
        }
      }
      this.c = 0;
      this.e = 0;
      HorizontalRefreshLayout.OnDraggingListener localOnDraggingListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryHorizontalRefreshLayout$OnDraggingListener;
      if (localOnDraggingListener != null) {
        localOnDraggingListener.a(this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidViewView, this);
      }
      b();
    }
    else
    {
      this.e = i;
    }
    label259:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnDraggingListener(HorizontalRefreshLayout.OnDraggingListener paramOnDraggingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryHorizontalRefreshLayout$OnDraggingListener = paramOnDraggingListener;
  }
  
  public void setRefreshHeader(HorizontalRefreshLayout.RefreshHeader paramRefreshHeader)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryHorizontalRefreshLayout$RefreshHeader = paramRefreshHeader;
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryHorizontalRefreshLayout$RefreshHeader.a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.HorizontalRefreshLayout
 * JD-Core Version:    0.7.0.1
 */