package com.tencent.mobileqq.newfriend.msg.controller;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class FriendSystemMsgController$1
  implements Runnable
{
  FriendSystemMsgController$1(FriendSystemMsgController paramFriendSystemMsgController, AppInterface paramAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("friend_system_msg_nomore_msg", this.jdField_a_of_type_Boolean).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController.1
 * JD-Core Version:    0.7.0.1
 */