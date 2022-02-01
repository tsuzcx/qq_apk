package com.tencent.mobileqq.onlinestatus;

import aypo;
import bgmg;
import com.tencent.mobileqq.app.QQAppInterface;

public class OnlineStatusPermissionManager$2
  implements Runnable
{
  public OnlineStatusPermissionManager$2(aypo paramaypo, OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem) {}
  
  public void run()
  {
    bgmg.a("online_status_file_" + aypo.a(this.this$0).getCurrentAccountUin(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.2
 * JD-Core Version:    0.7.0.1
 */