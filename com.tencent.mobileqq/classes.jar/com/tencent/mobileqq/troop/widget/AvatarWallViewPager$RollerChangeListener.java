package com.tencent.mobileqq.troop.widget;

import android.view.View;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;

public class AvatarWallViewPager$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int jdField_a_of_type_Int = 0;
  
  protected AvatarWallViewPager$RollerChangeListener(AvatarWallViewPager paramAvatarWallViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
    AvatarWallViewPager localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
    int j = 1;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localAvatarWallViewPager.jdField_a_of_type_Boolean = bool;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.getCurrentItem();
    localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
    localAvatarWallViewPager.jdField_b_of_type_Int = i;
    paramInt = localAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.getCount();
    if (paramInt <= 1) {
      return;
    }
    if (i == 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.instantiateItem(null, paramInt - 2);
    } else if (i == paramInt - 2) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.instantiateItem(null, 1);
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
      localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
      localAvatarWallViewPager.jdField_b_of_type_Int = paramInt;
      localAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(paramInt, false);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.getCount();
    if (paramInt == 0) {
      i -= 2;
    } else if (paramInt == i - 1) {
      i = 1;
    } else {
      i = paramInt;
    }
    i -= 1;
    if ((i >= 0) && (this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ArrayOfAndroidViewView.length > i) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ArrayOfAndroidViewView.length > this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ArrayOfAndroidViewView[this.jdField_a_of_type_Int].setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ArrayOfAndroidViewView[i].setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_Int = i;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener.onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */