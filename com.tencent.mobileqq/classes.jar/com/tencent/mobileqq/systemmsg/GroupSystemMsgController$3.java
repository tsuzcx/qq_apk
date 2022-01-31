package com.tencent.mobileqq.systemmsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aydd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class GroupSystemMsgController$3
  implements Runnable
{
  public GroupSystemMsgController$3(aydd paramaydd, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if ((localSharedPreferences != null) && (!localSharedPreferences.getString("group_display", "").equals(this.jdField_a_of_type_JavaLangString))) {
      localSharedPreferences.edit().putString("group_display", this.jdField_a_of_type_JavaLangString).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController.3
 * JD-Core Version:    0.7.0.1
 */