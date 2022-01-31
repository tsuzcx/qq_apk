package com.tencent.mobileqq.extendfriend.limitchat;

import alto;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ExtendFriendLimitChatMatchFragment$6
  implements Runnable
{
  ExtendFriendLimitChatMatchFragment$6(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void run()
  {
    if (ExtendFriendLimitChatMatchFragment.a(this.this$0) != null)
    {
      alto localalto = (alto)ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getManager(51);
      ExtendFriendLimitChatMatchFragment.a(this.this$0, localalto.b(ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getCurrentAccountUin()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment.6
 * JD-Core Version:    0.7.0.1
 */