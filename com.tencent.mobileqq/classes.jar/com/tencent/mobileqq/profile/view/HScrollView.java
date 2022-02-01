package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class HScrollView
  extends HorizontalScrollView
  implements Runnable
{
  private int jdField_a_of_type_Int = -9999999;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private HScrollView.ScrollViewListener jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView$ScrollViewListener;
  private int b = 1;
  
  public HScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.b = 2;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView$ScrollViewListener.a(this.b);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
      continue;
      this.jdField_a_of_type_AndroidOsHandler.post(this);
    }
  }
  
  public void run()
  {
    if (getScrollX() == this.jdField_a_of_type_Int)
    {
      this.b = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView$ScrollViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView$ScrollViewListener.a(this.b);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
      return;
    }
    this.b = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView$ScrollViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView$ScrollViewListener.a(this.b);
    }
    this.jdField_a_of_type_Int = getScrollX();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
  
  public void setOnScrollListener(HScrollView.ScrollViewListener paramScrollViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView$ScrollViewListener = paramScrollViewListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.HScrollView
 * JD-Core Version:    0.7.0.1
 */