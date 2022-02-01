package com.tencent.mobileqq.relationx.icebreaking;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;

class AIOIceBreakShow$6
  implements Runnable
{
  AIOIceBreakShow$6(AIOIceBreakShow paramAIOIceBreakShow) {}
  
  public void run()
  {
    ((IceBreakingMng)AIOIceBreakShow.e(this.this$0).d.getManager(QQManagerFactory.ICE_BREAKING_MNG)).p(AIOIceBreakShow.e(this.this$0).ah.b);
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.bi, "1", "145", "920", "92005", "208982", "", "", "20", "5");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.6
 * JD-Core Version:    0.7.0.1
 */