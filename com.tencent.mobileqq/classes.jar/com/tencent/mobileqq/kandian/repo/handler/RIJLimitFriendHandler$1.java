package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;

class RIJLimitFriendHandler$1
  implements Runnable
{
  RIJLimitFriendHandler$1(RIJLimitFriendHandler paramRIJLimitFriendHandler, String paramString1, int paramInt, oidb_cmd0xbd6.RspBody paramRspBody, String paramString2) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJLimitFriendHandler.1
 * JD-Core Version:    0.7.0.1
 */