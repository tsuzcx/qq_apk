package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;

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
    boolean bool2 = false;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.c);
    float f4 = Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.d);
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
    case 261: 
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a();
      requestDisallowInterceptTouchEvent(true);
      AvatarWallViewPager localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.c = f1;
      localAvatarWallViewPager.jdField_a_of_type_Float = f1;
      localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.d = f2;
      localAvatarWallViewPager.b = f2;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.f();
      return super.dispatchTouchEvent(paramMotionEvent);
    case 2: 
      if (this.jdField_a_of_type_Int <= 1)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        bool1 = bool2;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.c = f1;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.d = f2;
        return bool1;
        if ((f3 < f4) && (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.b) > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_Int)) {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        for (;;)
        {
          if ((f3 <= f4) || (Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_Float) <= this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_Int)) {
            break label312;
          }
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
          break;
          getParent().requestDisallowInterceptTouchEvent(true);
        }
        label312:
        requestDisallowInterceptTouchEvent(false);
        bool1 = bool2;
      }
    }
    requestDisallowInterceptTouchEvent(false);
    bool2 = super.dispatchTouchEvent(paramMotionEvent);
    if ((Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_Int) && (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.b) < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_Boolean))
    {
      requestDisallowInterceptTouchEvent(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.performClick();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.e();
      return bool1;
      bool1 = bool2;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      TroopTechReportUtils.a("avatarWallViewPager", "ote_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      TroopTechReportUtils.a("avatarWallViewPager", "te_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager.RollViewPager
 * JD-Core Version:    0.7.0.1
 */