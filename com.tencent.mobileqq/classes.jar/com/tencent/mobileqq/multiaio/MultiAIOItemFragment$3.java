package com.tencent.mobileqq.multiaio;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener;

class MultiAIOItemFragment$3
  implements FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener
{
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment.getBaseActivity()));
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float c;
  float d;
  
  MultiAIOItemFragment$3(MultiAIOItemFragment paramMultiAIOItemFragment) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1;
    float f1;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          bool1 = bool2;
        }
        else
        {
          i = this.jdField_b_of_type_Int;
          bool1 = bool2;
          if (i != -1)
          {
            i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
            bool1 = bool2;
            if (i >= 0) {
              if (i > paramMotionEvent.getPointerCount() - 1)
              {
                bool1 = bool2;
              }
              else
              {
                float f2 = MotionEventCompat.getX(paramMotionEvent, i);
                f1 = Math.abs(f2 - this.d);
                float f3 = MotionEventCompat.getY(paramMotionEvent, i) - this.jdField_a_of_type_Float;
                float f4 = Math.abs(f3);
                i = this.jdField_a_of_type_Int;
                if ((f4 > i) && (f4 * 0.5F > f1))
                {
                  if (f3 > 0.0F) {
                    f1 = this.c + i;
                  } else {
                    f1 = this.c - i;
                  }
                  this.jdField_a_of_type_Float = f1;
                  this.jdField_b_of_type_Float = f2;
                  bool2 = bool3;
                }
                else if (f1 > this.jdField_a_of_type_Int)
                {
                  bool2 = true;
                }
                else
                {
                  bool2 = bool3;
                  if (QLog.isColorLevel())
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("onInterceptTouchEvent() called with: ev = [");
                    ((StringBuilder)localObject).append(paramMotionEvent);
                    ((StringBuilder)localObject).append("] do nothing");
                    QLog.d("MultiAIOItemFragment", 2, ((StringBuilder)localObject).toString());
                    bool2 = bool3;
                  }
                }
                localObject = MultiAIOItemFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment);
                bool1 = bool2;
                if (localObject != null)
                {
                  bool1 = bool2;
                  if (((MultiAIOBaseViewPager)localObject).a() == MultiAIOItemFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment)) {}
                }
              }
            }
          }
        }
      }
      else {
        bool1 = true;
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      this.d = f1;
      this.jdField_b_of_type_Float = f1;
      f1 = paramMotionEvent.getY();
      this.c = f1;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      bool1 = bool2;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInterceptTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("], intercept = ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("MultiAIOItemFragment", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment.3
 * JD-Core Version:    0.7.0.1
 */