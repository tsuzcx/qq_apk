package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;

class ExtendFriendManager$3
  implements Runnable
{
  ExtendFriendManager$3(ExtendFriendManager paramExtendFriendManager) {}
  
  public void run()
  {
    ExpandFriendChatUtil.a(ExtendFriendManager.a(this.this$0));
    this.this$0.c();
    ExtendFriendManager.b(this.this$0);
    ExtendFriendManager.c(this.this$0);
    ExtendFriendManager.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.3
 * JD-Core Version:    0.7.0.1
 */