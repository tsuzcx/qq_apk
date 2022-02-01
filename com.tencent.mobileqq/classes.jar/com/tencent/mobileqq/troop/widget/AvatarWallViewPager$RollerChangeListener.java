package com.tencent.mobileqq.troop.widget;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.View;

public class AvatarWallViewPager$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int jdField_a_of_type_Int = 0;
  
  protected AvatarWallViewPager$RollerChangeListener(AvatarWallViewPager paramAvatarWallViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    int j = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
    AvatarWallViewPager localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      localAvatarWallViewPager.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_Boolean) {
        break label60;
      }
    }
    label60:
    label190:
    for (;;)
    {
      return;
      bool = false;
      break;
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.getCurrentItem();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_b_of_type_Int = i;
      int k = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.getCount();
      if (k > 1)
      {
        if (i == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.instantiateItem(null, k - 2);
          if (i != 0) {
            break label177;
          }
          paramInt = k - 2;
        }
        for (;;)
        {
          if (i == paramInt) {
            break label190;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_b_of_type_Int = paramInt;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(paramInt, false);
          return;
          if (i != k - 2) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.instantiateItem(null, 1);
          break;
          paramInt = j;
          if (i != k - 1) {
            paramInt = i;
          }
        }
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.getCount();
    if (paramInt == 0) {
      i -= 2;
    }
    for (;;)
    {
      i -= 1;
      if ((i >= 0) && (this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ArrayOfAndroidViewView.length > i) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ArrayOfAndroidViewView.length > this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ArrayOfAndroidViewView[this.jdField_a_of_type_Int].setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_ArrayOfAndroidViewView[i].setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_Int = i;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageSelected(paramInt);
      }
      return;
      if (paramInt == i - 1) {
        i = 1;
      } else {
        i = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */