package com.tencent.mobileqq.onlinestatus.manager;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.utils.FileUtils;

class OnlineStatusPermissionManager$2
  implements Runnable
{
  OnlineStatusPermissionManager$2(OnlineStatusPermissionManager paramOnlineStatusPermissionManager, OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("online_status_file_");
    localStringBuilder.append(OnlineStatusPermissionManager.a(this.this$0).getCurrentAccountUin());
    FileUtils.writeObject(localStringBuilder.toString(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.2
 * JD-Core Version:    0.7.0.1
 */