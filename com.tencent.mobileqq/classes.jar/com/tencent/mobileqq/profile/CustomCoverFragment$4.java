package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class CustomCoverFragment$4
  implements QQPermissionCallback
{
  CustomCoverFragment$4(CustomCoverFragment paramCustomCoverFragment, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CustomCoverFragment.a(this.jdField_a_of_type_ComTencentMobileqqProfileCustomCoverFragment, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.4
 * JD-Core Version:    0.7.0.1
 */