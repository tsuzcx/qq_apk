package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;

public class DisableSlideHorizontalListView
  extends HorizontalListView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private BezierSideBarView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView;
  private DisableSlideHorizontalListView.OnOverScrollListener jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView$OnOverScrollListener;
  private DisableSlideHorizontalListView.OnViewWindowChangedListener jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView$OnViewWindowChangedListener;
  private boolean jdField_a_of_type_Boolean;
  private float b;
  
  public DisableSlideHorizontalListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(paramContext, 18.0F));
  }
  
  public DisableSlideHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(paramContext, 18.0F));
  }
  
  private void a()
  {
    BezierSideBarView localBezierSideBarView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView;
    if (localBezierSideBarView != null) {
      localBezierSideBarView.a();
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView != null)
    {
      int i = getMeasuredHeight() / 2;
      int j = AIOUtils.b(18.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView.a(paramInt, i - j);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    StringBuilder localStringBuilder;
    if (i == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dispatchTouchEvent:ACTION_DOWN. mIsPress=");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d("DisableSlideHorizontalListView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Float = f1;
      this.b = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dispatchTouchEvent:ACTION_MOVE. mIsPress=");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d("DisableSlideHorizontalListView", 2, localStringBuilder.toString());
      }
      float f2 = this.jdField_a_of_type_Float;
      f3 -= this.b;
      if ((this.jdField_a_of_type_Boolean) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.a(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      a(getScrollX() - this.jdField_a_of_type_Int);
    }
    else if ((i == 3) || (i == 1))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dispatchTouchEvent:ACTION_CANCEL or UP. action=");
        localStringBuilder.append(i);
        localStringBuilder.append(" mIsPress=");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d("DisableSlideHorizontalListView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView$OnOverScrollListener != null) && (i == 1) && (getScrollX() > this.jdField_a_of_type_Int)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView$OnOverScrollListener.a();
      }
      a();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    DisableSlideHorizontalListView.OnViewWindowChangedListener localOnViewWindowChangedListener = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView$OnViewWindowChangedListener;
    if (localOnViewWindowChangedListener != null) {
      localOnViewWindowChangedListener.b();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    DisableSlideHorizontalListView.OnViewWindowChangedListener localOnViewWindowChangedListener = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView$OnViewWindowChangedListener;
    if (localOnViewWindowChangedListener != null) {
      localOnViewWindowChangedListener.c();
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (paramInt1 <= 2)
    {
      a();
      return;
    }
    a(paramInt1 - this.jdField_a_of_type_Int);
  }
  
  public void setOnOverScrollListener(DisableSlideHorizontalListView.OnOverScrollListener paramOnOverScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView$OnOverScrollListener = paramOnOverScrollListener;
  }
  
  public void setOnViewWindowChangedListener(DisableSlideHorizontalListView.OnViewWindowChangedListener paramOnViewWindowChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView$OnViewWindowChangedListener = paramOnViewWindowChangedListener;
  }
  
  public void setSideBarView(BezierSideBarView paramBezierSideBarView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView = paramBezierSideBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView
 * JD-Core Version:    0.7.0.1
 */