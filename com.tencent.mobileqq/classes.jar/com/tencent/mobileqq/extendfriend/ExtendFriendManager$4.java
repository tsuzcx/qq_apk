package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatResourceUtil;

class ExtendFriendManager$4
  implements Runnable
{
  ExtendFriendManager$4(ExtendFriendManager paramExtendFriendManager, boolean paramBoolean) {}
  
  public void run()
  {
    ExtendFriendManager.b(this.this$0);
    ExtendFriendManager.c(this.this$0);
    if (this.a) {
      ExtendFriendLimitChatResourceUtil.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.4
 * JD-Core Version:    0.7.0.1
 */