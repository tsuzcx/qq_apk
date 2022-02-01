package com.tencent.mobileqq.profile;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class VipProfileCardPreviewActivity$2
  implements ViewPager.OnPageChangeListener
{
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  VipProfileCardPreviewActivity$2(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageScrollStateChanged state = " + paramInt);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.b();
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.x);
      this.b = true;
    }
    if (paramInt == 2) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.x);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.a();
      }
      if (this.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.a();
        this.b = false;
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageScrolled pos = " + paramInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.b();
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageSelected pos = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.a();
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.d(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.x = paramInt;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.app, "CliOper", "", "", "card_mall", "0X8004C26", 0, 0, "", "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.app, this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.app.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */