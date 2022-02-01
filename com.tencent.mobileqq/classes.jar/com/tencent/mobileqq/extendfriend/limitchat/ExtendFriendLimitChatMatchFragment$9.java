package com.tencent.mobileqq.extendfriend.limitchat;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class ExtendFriendLimitChatMatchFragment$9
  implements Runnable
{
  ExtendFriendLimitChatMatchFragment$9(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void run()
  {
    if (ExtendFriendLimitChatMatchFragment.a(this.this$0) != null)
    {
      FriendsManager localFriendsManager = (FriendsManager)ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      ExtendFriendLimitChatMatchFragment.a(this.this$0, localFriendsManager.a(ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getCurrentAccountUin()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment.9
 * JD-Core Version:    0.7.0.1
 */