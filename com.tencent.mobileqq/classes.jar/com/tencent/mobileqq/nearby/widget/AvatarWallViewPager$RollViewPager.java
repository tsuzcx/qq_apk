package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;

public class AvatarWallViewPager$RollViewPager
  extends ViewPager
{
  int jdField_a_of_type_Int;
  
  public AvatarWallViewPager$RollViewPager(AvatarWallViewPager paramAvatarWallViewPager, Context paramContext)
  {
    this(paramAvatarWallViewPager, paramContext, null);
  }
  
  public AvatarWallViewPager$RollViewPager(AvatarWallViewPager paramAvatarWallViewPager, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter == null) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.c);
    float f4 = Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.d);
    boolean bool2;
    switch (paramMotionEvent.getAction())
    {
    case 4: 
    default: 
      return false;
    case 0: 
    case 5: 
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a();
      requestDisallowInterceptTouchEvent(true);
      AvatarWallViewPager localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.c = f1;
      localAvatarWallViewPager.jdField_a_of_type_Float = f1;
      localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.d = f2;
      localAvatarWallViewPager.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.b();
      try
      {
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
        return bool1;
      }
      catch (Exception paramMotionEvent)
      {
        QLog.i("AvatarWallViewPager", 1, "MotionEvent.ACTION_DOWN|MotionEvent.ACTION_POINTER_DOWN,e=" + paramMotionEvent.toString());
        return false;
      }
    case 2: 
      if (this.jdField_a_of_type_Int <= 1) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.c = f1;
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.d = f2;
        return bool1;
        if ((f3 < f4) && (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_b_of_type_Float) > this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Int)) {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        for (;;)
        {
          for (;;)
          {
            if ((f3 <= f4) || (Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Float) <= this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Int)) {
              break label379;
            }
            try
            {
              bool2 = super.dispatchTouchEvent(paramMotionEvent);
              bool1 = bool2;
            }
            catch (Exception paramMotionEvent)
            {
              QLog.i("AvatarWallViewPager", 1, "MotionEvent.ACTION_MOVE,e=" + paramMotionEvent.toString());
            }
          }
          getParent().requestDisallowInterceptTouchEvent(true);
          continue;
          break;
        }
        label379:
        requestDisallowInterceptTouchEvent(false);
      }
    }
    requestDisallowInterceptTouchEvent(false);
    try
    {
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
      bool2 = bool1;
      if (Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Int)
      {
        bool2 = bool1;
        if (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_b_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Int)
        {
          bool2 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_b_of_type_Boolean)
          {
            requestDisallowInterceptTouchEvent(false);
            this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.performClick();
            bool2 = false;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.a();
      return bool2;
    }
    catch (Exception paramMotionEvent)
    {
      for (;;)
      {
        QLog.i("AvatarWallViewPager", 1, "MotionEvent.ACTION_UP|MotionEvent.ACTION_POINTER_UP|MotionEvent.ACTION_CANCEL,e=" + paramMotionEvent.toString());
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.RollViewPager
 * JD-Core Version:    0.7.0.1
 */