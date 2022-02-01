package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AioFriendTitleHelper$1
  implements Runnable
{
  AioFriendTitleHelper$1(AioFriendTitleHelper paramAioFriendTitleHelper) {}
  
  public void run()
  {
    RichStatus localRichStatus = ((StatusManager)AioFriendTitleHelper.a(this.this$0).d.getManager(QQManagerFactory.STATUS_MANAGER)).a(AioFriendTitleHelper.a(this.this$0).ah.b, true);
    AioFriendTitleHelper.a(this.this$0).f.runOnUiThread(new AioFriendTitleHelper.1.1(this, localRichStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.1
 * JD-Core Version:    0.7.0.1
 */