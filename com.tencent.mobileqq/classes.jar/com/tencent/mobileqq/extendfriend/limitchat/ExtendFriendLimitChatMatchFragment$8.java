package com.tencent.mobileqq.extendfriend.limitchat;

import android.support.v4.app.FragmentActivity;
import anyw;
import com.tencent.mobileqq.app.QQAppInterface;

class ExtendFriendLimitChatMatchFragment$8
  implements Runnable
{
  ExtendFriendLimitChatMatchFragment$8(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void run()
  {
    if (ExtendFriendLimitChatMatchFragment.a(this.this$0) != null)
    {
      anyw localanyw = (anyw)ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getManager(51);
      ExtendFriendLimitChatMatchFragment.a(this.this$0, localanyw.b(ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getCurrentAccountUin()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment.8
 * JD-Core Version:    0.7.0.1
 */