package com.tencent.mobileqq.extendfriend.limitchat;

import ajxn;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ExtendFriendLimitChatMatchFragment$5
  implements Runnable
{
  ExtendFriendLimitChatMatchFragment$5(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void run()
  {
    if (ExtendFriendLimitChatMatchFragment.a(this.this$0) != null)
    {
      ajxn localajxn = (ajxn)ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getManager(51);
      ExtendFriendLimitChatMatchFragment.a(this.this$0, localajxn.b(ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getCurrentAccountUin()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment.5
 * JD-Core Version:    0.7.0.1
 */