package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;

class OnlineStatusPermissionManager$2
  implements Runnable
{
  OnlineStatusPermissionManager$2(OnlineStatusPermissionManager paramOnlineStatusPermissionManager, OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem) {}
  
  public void run()
  {
    FileUtils.a("online_status_file_" + OnlineStatusPermissionManager.a(this.this$0).getCurrentAccountUin(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.2
 * JD-Core Version:    0.7.0.1
 */