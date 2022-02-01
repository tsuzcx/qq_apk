package com.tencent.mobileqq.extendfriend.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.SchoolInfo;

final class ExtendFriendSendMsgHelper$6
  implements DialogInterface.OnClickListener
{
  ExtendFriendSendMsgHelper$6(BaseActivity paramBaseActivity, boolean paramBoolean, SchoolInfo paramSchoolInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = ExtendFriendSendMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    if (this.jdField_a_of_type_Boolean) {
      CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.b, this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.6
 * JD-Core Version:    0.7.0.1
 */