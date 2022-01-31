package com.tencent.mobileqq.widget;

import akin;
import akio;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class SlideDetectListView
  extends XListView
  implements MotionViewSetter
{
  float jdField_a_of_type_Float = 0.0F;
  public int a;
  protected GestureDetector.SimpleOnGestureListener a;
  protected GestureDetector a;
  public View a;
  private SlideDetectListView.OnSlideListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  public int b;
  private AbsListView.OnScrollListener b;
  public boolean b;
  public int c;
  public boolean c;
  protected int d;
  public boolean d;
  protected int e;
  protected boolean e;
  public int f;
  
  public SlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new akin(this);
    super.setOnScrollListener(new akio(this));
    this.f = (ViewConfiguration.getTouchSlop() + 2);
  }
  
  public int a(int paramInt)
  {
    int k = -1;
    int m = getChildCount();
    int i = k;
    View localView;
    if (m > 0)
    {
      if (!isStackFromBottom()) {
        j = 0;
      }
    }
    else {
      for (;;)
      {
        i = k;
        if (j < m)
        {
          localView = getChildAt(j);
          if (paramInt > localView.getBottom()) {
            break label94;
          }
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(localView.hashCode()))) {
            break label74;
          }
          i = k;
        }
        label74:
        do
        {
          return i;
          paramInt = getFirstVisiblePosition() + j;
          i = paramInt;
        } while (!isOverscrollHeadVisiable());
        return paramInt - 1;
        label94:
        j += 1;
      }
    }
    int j = m - 1;
    for (;;)
    {
      i = k;
      if (j < 0) {
        break;
      }
      localView = getChildAt(j);
      if (paramInt >= localView.getTop())
      {
        i = k;
        if (this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(localView.hashCode()))) {
          break;
        }
        paramInt = getFirstVisiblePosition() + j;
        i = paramInt;
        if (!isOverscrollHeadVisiable()) {
          break;
        }
        return paramInt - 1;
      }
      j -= 1;
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt != -1) {
      try
      {
        View localView = getChildAt(paramInt - getFirstVisiblePosition());
        return localView;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramView.hashCode()));
    super.addFooterView(paramView, paramObject, paramBoolean);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramView.hashCode()));
    super.addHeaderView(paramView, paramObject, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean == true)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener.b(this, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int - getHeaderViewsCount());
        }
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362723);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    b();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector == null)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener, new Handler(Looper.getMainLooper()));
      this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        if (this.jdField_e_of_type_Boolean == true)
        {
          label96:
          return false;
          this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
          this.jdField_e_of_type_Boolean = false;
          i = a(this.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_AndroidViewView != null) && (a(i) == this.jdField_a_of_type_AndroidViewView))
          {
            if (paramMotionEvent.getX() < this.jdField_a_of_type_AndroidViewView.getWidth() - this.jdField_d_of_type_Int) {
              continue;
            }
            if ((this.jdField_e_of_type_Int <= 0) || (this.jdField_a_of_type_AndroidViewView.getHeight() <= 0)) {
              break label351;
            }
            i = this.jdField_a_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_AndroidViewView.getHeight() / 2;
            int j = this.jdField_e_of_type_Int / 2;
            int k = this.jdField_e_of_type_Int / 2;
            if ((this.jdField_a_of_type_Int <= j + i) && (this.jdField_a_of_type_Int >= i - k)) {
              break label351;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SlideDetectListView", 2, "accurate in delete:ycenter:" + i + ",motionheight:" + this.jdField_a_of_type_AndroidViewView.getHeight() + "deleareaHeight:" + this.jdField_e_of_type_Int);
            }
          }
        }
      }
    }
    label351:
    for (int i = 0; i != 0; i = 1)
    {
      this.jdField_e_of_type_Boolean = true;
      return false;
      if (this.jdField_a_of_type_Boolean != true) {
        break;
      }
      return true;
      this.jdField_b_of_type_Boolean = false;
      break;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Boolean == true)) {
        return true;
      }
      if (this.jdField_b_of_type_Boolean) {
        break label96;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Boolean == true))
    {
      setPressed(false);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
      }
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.setPressed(false);
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener.b(this, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int - getHeaderViewsCount());
          }
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewView = null;
        return false;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean removeFooterView(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeFooterView(paramView);
  }
  
  public boolean removeHeaderView(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeHeaderView(paramView);
  }
  
  public void setCanSlide(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setCheckStateWhenSlide(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void setDeleteAreaDim(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
  }
  
  public void setDeleteAreaWidth(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setMotionView(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_Int = (getHeaderViewsCount() + paramInt);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void setOnScrollGroupFloatingListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {}
  
  public void setOnScrollToTopListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setOnSlideListener(SlideDetectListView.OnSlideListener paramOnSlideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener = paramOnSlideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDetectListView
 * JD-Core Version:    0.7.0.1
 */