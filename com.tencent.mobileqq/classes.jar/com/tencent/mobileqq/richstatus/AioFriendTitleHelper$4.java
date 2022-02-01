package com.tencent.mobileqq.richstatus;

import amsw;
import bamd;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class AioFriendTitleHelper$4
  implements Runnable
{
  public AioFriendTitleHelper$4(bamd parambamd) {}
  
  public void run()
  {
    ((amsw)bamd.a(this.this$0).app.getManager(51)).e(bamd.a(this.this$0).sessionInfo.curFriendUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.4
 * JD-Core Version:    0.7.0.1
 */