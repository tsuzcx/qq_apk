package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.c);
    float f4 = Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.d);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 5) {
              break label436;
            }
            if (i != 6) {
              return false;
            }
          }
        }
        else
        {
          if (this.jdField_a_of_type_Int <= 1)
          {
            getParent().requestDisallowInterceptTouchEvent(false);
          }
          else
          {
            if ((f3 < f4) && (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_b_of_type_Float) > this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Int)) {
              getParent().requestDisallowInterceptTouchEvent(false);
            } else {
              getParent().requestDisallowInterceptTouchEvent(true);
            }
            if ((f3 > f4) && (Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Float) > this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Int)) {
              try
              {
                bool2 = super.dispatchTouchEvent(paramMotionEvent);
                bool1 = bool2;
              }
              catch (Exception paramMotionEvent)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("MotionEvent.ACTION_MOVE,e=");
                ((StringBuilder)localObject).append(paramMotionEvent.toString());
                QLog.i("AvatarWallViewPager", 1, ((StringBuilder)localObject).toString());
              }
            } else {
              requestDisallowInterceptTouchEvent(false);
            }
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
          paramMotionEvent.c = f1;
          paramMotionEvent.d = f2;
          return bool1;
        }
      }
      requestDisallowInterceptTouchEvent(false);
      try
      {
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
      }
      catch (Exception paramMotionEvent)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MotionEvent.ACTION_UP|MotionEvent.ACTION_POINTER_UP|MotionEvent.ACTION_CANCEL,e=");
        ((StringBuilder)localObject).append(paramMotionEvent.toString());
        QLog.i("AvatarWallViewPager", 1, ((StringBuilder)localObject).toString());
        bool1 = false;
      }
      if ((Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Int) && (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_b_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_b_of_type_Boolean))
      {
        requestDisallowInterceptTouchEvent(false);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.performClick();
        bool1 = bool2;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.a();
      return bool1;
    }
    label436:
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a();
    requestDisallowInterceptTouchEvent(true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
    ((AvatarWallViewPager)localObject).c = f1;
    ((AvatarWallViewPager)localObject).jdField_a_of_type_Float = f1;
    ((AvatarWallViewPager)localObject).d = f2;
    ((AvatarWallViewPager)localObject).jdField_b_of_type_Float = f2;
    ((AvatarWallViewPager)localObject).b();
    try
    {
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
      return bool1;
    }
    catch (Exception paramMotionEvent)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MotionEvent.ACTION_DOWN|MotionEvent.ACTION_POINTER_DOWN,e=");
      ((StringBuilder)localObject).append(paramMotionEvent.toString());
      QLog.i("AvatarWallViewPager", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.RollViewPager
 * JD-Core Version:    0.7.0.1
 */