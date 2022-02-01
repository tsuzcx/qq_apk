package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;

public class ScrollStateDetector
  implements Handler.Callback, ScrollListener
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  ScrollStateDetector.OnScrollListener jdField_a_of_type_ComTencentMobileqqWidgetScrollStateDetector$OnScrollListener = null;
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 10;
  boolean jdField_b_of_type_Boolean = false;
  
  public ScrollStateDetector(ScrollStateDetector.OnScrollListener paramOnScrollListener, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollStateDetector$OnScrollListener = paramOnScrollListener;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    if (paramInt != i)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollStateDetector$OnScrollListener != null)
      {
        Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (View)((WeakReference)localObject).get();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollStateDetector$OnScrollListener.a((View)localObject, i, paramInt);
      }
    }
  }
  
  void a(View paramView)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (View)((WeakReference)localObject).get();
    }
    if (localObject != paramView) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    }
  }
  
  public void fling(View paramView, int paramInt)
  {
    a(paramView);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    a(2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_Boolean = false;
      a(0);
    }
    return true;
  }
  
  public void onFingerDown(View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramView);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onFingerUpOrCancel(View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramView);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
  }
  
  public void onScrollChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView);
    paramInt3 = Math.abs(paramInt2 - paramInt4);
    if ((paramInt3 != 0) && (paramInt2 != 0)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if ((paramInt1 != 0) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      a(0);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt3 <= this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 50L);
      }
      a(2);
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) && (paramInt3 <= this.jdField_b_of_type_Int)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 50L);
    }
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollStateDetector
 * JD-Core Version:    0.7.0.1
 */