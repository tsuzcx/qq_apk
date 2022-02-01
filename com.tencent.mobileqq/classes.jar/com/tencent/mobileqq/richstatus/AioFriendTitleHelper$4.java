package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AioFriendTitleHelper$4
  implements Runnable
{
  AioFriendTitleHelper$4(AioFriendTitleHelper paramAioFriendTitleHelper) {}
  
  public void run()
  {
    ((FriendsManager)AioFriendTitleHelper.a(this.this$0).d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(AioFriendTitleHelper.a(this.this$0).ah.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.4
 * JD-Core Version:    0.7.0.1
 */