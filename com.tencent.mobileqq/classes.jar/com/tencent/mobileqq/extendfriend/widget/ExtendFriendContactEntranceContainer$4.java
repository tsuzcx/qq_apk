package com.tencent.mobileqq.extendfriend.widget;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import mqq.os.MqqHandler;

class ExtendFriendContactEntranceContainer$4
  implements Runnable
{
  ExtendFriendContactEntranceContainer$4(ExtendFriendContactEntranceContainer paramExtendFriendContactEntranceContainer) {}
  
  public void run()
  {
    int i = MatchChatMsgUtil.b(ExtendFriendContactEntranceContainer.c(this.this$0));
    ThreadManager.getUIHandler().post(new ExtendFriendContactEntranceContainer.4.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer.4
 * JD-Core Version:    0.7.0.1
 */