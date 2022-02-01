package com.tencent.mobileqq.nearby.widget;

import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
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
    AvatarWallViewPager localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
    int j = 1;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localAvatarWallViewPager.b = bool;
    if (!this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.b) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager.getCurrentItem();
    localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
    localAvatarWallViewPager.f = i;
    paramInt = localAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a();
    if (paramInt <= 1) {
      return;
    }
    if (i == 1) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a().instantiateItem(null, paramInt - 2);
    } else if (i == paramInt - 2) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a().instantiateItem(null, 1);
    }
    if (i == 0) {
      paramInt -= 2;
    } else if (i == paramInt - 1) {
      paramInt = j;
    } else {
      paramInt = i;
    }
    if (i != paramInt)
    {
      localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
      localAvatarWallViewPager.f = paramInt;
      localAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(paramInt, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a() <= 1)
    {
      this.jdField_a_of_type_Int = 0;
      return;
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected error, lastPos = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", pos = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", childCount = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount());
      QLog.e("AvatarWallViewPager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */