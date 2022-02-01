package com.tencent.mobileqq.onlinestatus;

import azcb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;

public class OnlineStatusPermissionManager$2
  implements Runnable
{
  public OnlineStatusPermissionManager$2(azcb paramazcb, OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem) {}
  
  public void run()
  {
    FileUtils.writeObject("online_status_file_" + azcb.a(this.this$0).getCurrentAccountUin(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.2
 * JD-Core Version:    0.7.0.1
 */