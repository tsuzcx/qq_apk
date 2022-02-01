package com.tencent.mobileqq.richstatus;

import anvk;
import bbss;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class AioFriendTitleHelper$4
  implements Runnable
{
  public AioFriendTitleHelper$4(bbss parambbss) {}
  
  public void run()
  {
    ((anvk)bbss.a(this.this$0).app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(bbss.a(this.this$0).sessionInfo.curFriendUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.4
 * JD-Core Version:    0.7.0.1
 */