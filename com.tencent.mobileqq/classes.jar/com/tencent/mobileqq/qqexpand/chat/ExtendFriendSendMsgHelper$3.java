package com.tencent.mobileqq.qqexpand.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

final class ExtendFriendSendMsgHelper$3
  implements DialogInterface.OnClickListener
{
  ExtendFriendSendMsgHelper$3(boolean paramBoolean, QBaseActivity paramQBaseActivity, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
    } else {
      CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaLangString);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper.3
 * JD-Core Version:    0.7.0.1
 */