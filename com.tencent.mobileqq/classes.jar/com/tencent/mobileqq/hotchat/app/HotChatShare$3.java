package com.tencent.mobileqq.hotchat.app;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class HotChatShare$3
  implements Runnable
{
  HotChatShare$3(HotChatShare paramHotChatShare) {}
  
  public void run()
  {
    if (this.this$0.app != null) {
      ((FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatShare.3
 * JD-Core Version:    0.7.0.1
 */