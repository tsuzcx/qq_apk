package com.tencent.mobileqq.nearby.widget;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class AvatarWallViewPager$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  public int a;
  
  protected AvatarWallViewPager$RollerChangeListener(AvatarWallViewPager paramAvatarWallViewPager)
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    int j = 1;
    AvatarWallViewPager localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      localAvatarWallViewPager.b = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.b) {
        break label39;
      }
    }
    label39:
    label175:
    for (;;)
    {
      return;
      bool = false;
      break;
      int i = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager.getCurrentItem();
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.f = i;
      int k = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a();
      if (k > 1)
      {
        if (i == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a().instantiateItem(null, k - 2);
          if (i != 0) {
            break label162;
          }
          paramInt = k - 2;
        }
        for (;;)
        {
          if (i == paramInt) {
            break label175;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.f = paramInt;
          this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(paramInt, false);
          return;
          if (i != k - 2) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a().instantiateItem(null, 1);
          break;
          paramInt = j;
          if (i != k - 1) {
            paramInt = i;
          }
        }
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a() <= 1) {
      this.jdField_a_of_type_Int = 0;
    }
    do
    {
      return;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a(paramInt);
      if ((this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.a(false, this.jdField_a_of_type_Int), this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.a(true, paramInt), paramInt);
        this.jdField_a_of_type_Int = paramInt;
        return;
      }
      this.jdField_a_of_type_Int = 0;
    } while (!QLog.isColorLevel());
    QLog.e("AvatarWallViewPager", 2, "onPageSelected error, lastPos = " + this.jdField_a_of_type_Int + ", pos = " + paramInt + ", childCount = " + this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */