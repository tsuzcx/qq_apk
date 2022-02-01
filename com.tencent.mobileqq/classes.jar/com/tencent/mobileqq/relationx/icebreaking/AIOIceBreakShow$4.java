package com.tencent.mobileqq.relationx.icebreaking;

import bbdh;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AIOIceBreakShow$4
  implements Runnable
{
  AIOIceBreakShow$4(AIOIceBreakShow paramAIOIceBreakShow) {}
  
  public void run()
  {
    ((bbdh)AIOIceBreakShow.a(this.this$0).app.getManager(QQManagerFactory.ICE_BREAKING_MNG)).h(AIOIceBreakShow.a(this.this$0).sessionInfo.curFriendUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.4
 * JD-Core Version:    0.7.0.1
 */