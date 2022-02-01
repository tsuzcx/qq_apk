package com.tencent.mobileqq.qqexpand.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

final class ExtendFriendSendMsgHelper$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() instanceof QQAppInterface))
    {
      String str = ExtendFriendSendMsgHelper.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
      if (this.jdField_a_of_type_Boolean) {
        CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.b, this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.jdField_a_of_type_JavaLangString);
      } else {
        CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, str);
      }
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper.5
 * JD-Core Version:    0.7.0.1
 */