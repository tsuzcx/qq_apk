package com.tencent.mobileqq.onlinestatus.manager;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class OnlineStatusPermissionManager$1
  implements Runnable
{
  OnlineStatusPermissionManager$1(OnlineStatusPermissionManager paramOnlineStatusPermissionManager, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("online_status_file_");
    ((StringBuilder)localObject).append(this.a.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    OnlineStatusFriendsPermissionItem localOnlineStatusFriendsPermissionItem = OnlineStatusPermissionManager.a(this.this$0);
    boolean bool2 = false;
    boolean bool1;
    if (localOnlineStatusFriendsPermissionItem == null)
    {
      OnlineStatusPermissionManager.a(this.this$0, (OnlineStatusFriendsPermissionItem)FileUtils.readObject((String)localObject));
      if (QLog.isColorLevel())
      {
        if (OnlineStatusPermissionManager.a(this.this$0) == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "initFriendPermissionFromFile mLocalPermission is empty:", Boolean.valueOf(bool1) });
      }
    }
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
    OnlineStatusPermissionManager.c(this.this$0).runOnUiThread(new OnlineStatusPermissionManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.1
 * JD-Core Version:    0.7.0.1
 */