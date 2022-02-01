package com.tencent.mobileqq.multicard;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener;
import java.lang.ref.WeakReference;

class MultiCardRootLayout$3
  implements FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener
{
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getContext()));
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float c;
  float d;
  
  MultiCardRootLayout$3(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, false);
    int i = paramMotionEvent.getActionMasked();
    float f1;
    Object localObject;
    if (i != 0)
    {
      if ((i != 1) && (i == 2))
      {
        i = this.jdField_b_of_type_Int;
        if (i != -1)
        {
          i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
          if ((i >= 0) && (i <= paramMotionEvent.getPointerCount() - 1))
          {
            float f2 = MotionEventCompat.getX(paramMotionEvent, i);
            f1 = Math.abs(f2 - this.d);
            float f3 = MotionEventCompat.getY(paramMotionEvent, i) - this.jdField_a_of_type_Float;
            float f4 = Math.abs(f3);
            if ((f4 > this.jdField_a_of_type_Int) && (f4 * 0.5F > f1))
            {
              MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, false);
              if (f3 > 0.0F) {
                f1 = this.c + this.jdField_a_of_type_Int;
              } else {
                f1 = this.c - this.jdField_a_of_type_Int;
              }
              this.jdField_a_of_type_Float = f1;
              this.jdField_b_of_type_Float = f2;
            }
            else if (f1 > this.jdField_a_of_type_Int)
            {
              MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, true);
            }
            else if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onInterceptTouchEvent() called with: ev = [");
              ((StringBuilder)localObject).append(paramMotionEvent);
              ((StringBuilder)localObject).append("] do nothing");
              QLog.d("placeholder", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
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
    }
    if (MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout) != null)
    {
      localObject = (MultiCardRootLayout.MultiCardRootLayoutListener)MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout).get();
      if (localObject != null) {
        MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, ((MultiCardRootLayout.MultiCardRootLayoutListener)localObject).a(paramMotionEvent));
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInterceptTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("], intercept = ");
      ((StringBuilder)localObject).append(MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout));
      QLog.d("placeholder", 2, ((StringBuilder)localObject).toString());
    }
    return MultiCardRootLayout.a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRootLayout.3
 * JD-Core Version:    0.7.0.1
 */