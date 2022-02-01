package com.tencent.mobileqq.systemmsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class GroupSystemMsgController$1
  implements Runnable
{
  GroupSystemMsgController$1(GroupSystemMsgController paramGroupSystemMsgController, AppInterface paramAppInterface, int paramInt) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("unread_Group_system_msg", this.b).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController.1
 * JD-Core Version:    0.7.0.1
 */