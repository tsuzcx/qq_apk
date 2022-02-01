package com.tencent.mobileqq.systemmsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bdzh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FriendSystemMsgController$1
  implements Runnable
{
  public FriendSystemMsgController$1(bdzh parambdzh, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("friend_system_msg_nomore_msg", this.jdField_a_of_type_Boolean).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.FriendSystemMsgController.1
 * JD-Core Version:    0.7.0.1
 */