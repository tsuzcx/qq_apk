package com.tencent.mobileqq.systemmsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class GroupSystemMsgController$4
  implements Runnable
{
  GroupSystemMsgController$4(GroupSystemMsgController paramGroupSystemMsgController, AppInterface paramAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("group_system_msg_nomore_msg", this.b).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController.4
 * JD-Core Version:    0.7.0.1
 */