package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class OnlineStatusPermissionManager$1
  implements Runnable
{
  OnlineStatusPermissionManager$1(OnlineStatusPermissionManager paramOnlineStatusPermissionManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    boolean bool2 = false;
    String str = "online_status_file_" + this.a.getCurrentAccountUin();
    if (OnlineStatusPermissionManager.a(this.this$0) == null)
    {
      OnlineStatusPermissionManager.a(this.this$0, (OnlineStatusFriendsPermissionItem)FileUtils.a(str));
      if (QLog.isColorLevel()) {
        if (OnlineStatusPermissionManager.a(this.this$0) != null) {
          break label190;
        }
      }
    }
    label190:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "initFriendPermissionFromFile mLocalPermission is empty:", Boolean.valueOf(bool1) });
      if (QLog.isColorLevel())
      {
        bool1 = bool2;
        if (OnlineStatusPermissionManager.a(this.this$0) == null) {
          bool1 = true;
        }
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "initFriendPermissionFromFile init mLocalPermission", Boolean.valueOf(bool1) });
      }
      if (OnlineStatusPermissionManager.a(this.this$0) == null) {
        OnlineStatusPermissionManager.a(this.this$0, new OnlineStatusFriendsPermissionItem(true, null));
      }
      OnlineStatusPermissionManager.a(this.this$0, 1);
      OnlineStatusPermissionManager.a(this.this$0).runOnUiThread(new OnlineStatusPermissionManager.1.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.1
 * JD-Core Version:    0.7.0.1
 */