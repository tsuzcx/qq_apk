package com.tencent.mobileqq.systemmsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class GroupSystemMsgController$2
  implements Runnable
{
  GroupSystemMsgController$2(GroupSystemMsgController paramGroupSystemMsgController, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("unread_Group_suspicious_msg", this.jdField_a_of_type_Int).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController.2
 * JD-Core Version:    0.7.0.1
 */