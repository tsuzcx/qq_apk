package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.config.GameCenterMsgBean;
import com.tencent.mobileqq.gamecenter.config.GameCenterMsgConfigProcessor;
import com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class GameMsgManagerServiceImpl$2
  implements Runnable
{
  GameMsgManagerServiceImpl$2(GameMsgManagerServiceImpl paramGameMsgManagerServiceImpl) {}
  
  public void run()
  {
    QLog.i(GameMsgManagerServiceImpl.access$300(), 1, "init task starts.");
    if (((IVasDepTemp)QRoute.api(IVasDepTemp.class)).isBelongServiceAccountFolderInner("2747277822"))
    {
      QLog.i(GameMsgManagerServiceImpl.access$300(), 1, " qqgame public account detail not exist, try to get it.");
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(GameMsgManagerServiceImpl.access$400(this.this$0), GameMsgManagerServiceImpl.access$400(this.this$0).getApplication(), "2747277822");
    }
    Object localObject1 = GameCenterMsgConfigProcessor.a();
    if (localObject1 != null)
    {
      if (GameMsgManagerServiceImpl.access$500(this.this$0) == null) {
        GameMsgManagerServiceImpl.access$502(this.this$0, new GameCenterMsgBean());
      }
      GameMsgManagerServiceImpl.access$500(this.this$0).a((GameCenterMsgBean)localObject1);
      localObject1 = GameMsgManagerServiceImpl.access$300();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("graySwitch:");
      ((StringBuilder)localObject2).append(GameMsgManagerServiceImpl.access$500(this.this$0).a);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    GameMsgManagerServiceImpl.access$600(this.this$0);
    GameMsgManagerServiceImpl.access$700(this.this$0);
    GameMsgManagerServiceImpl.access$800(this.this$0);
    GameMsgManagerServiceImpl.access$900(this.this$0);
    GameMsgManagerServiceImpl.access$1000(this.this$0).a();
    GameMsgManagerServiceImpl.access$400(this.this$0).addObserver(GameMsgManagerServiceImpl.access$1100(this.this$0));
    this.this$0.getSessionInfoList(0, "-10000");
    localObject1 = GameMsgManagerServiceImpl.access$400(this.this$0).getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sp_enter_pub");
    ((StringBuilder)localObject2).append(GameMsgManagerServiceImpl.access$400(this.this$0).getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    GameMsgManagerServiceImpl.access$1202(this.this$0, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
    localObject2 = (IMessageFacade)GameMsgManagerServiceImpl.access$400(this.this$0).getRuntimeService(IMessageFacade.class, "");
    if (localObject2 != null) {
      ((IMessageFacade)localObject2).addObserver(this.this$0);
    }
    GameMsgManagerServiceImpl.access$1302(this.this$0, ((SharedPreferences)localObject1).getInt("sp_pubacc_msg_redpoint", 0));
    localObject1 = GameMsgManagerServiceImpl.access$300();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mPubMsgRedPointSwitch:");
    ((StringBuilder)localObject2).append(GameMsgManagerServiceImpl.access$1300(this.this$0));
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    GameMsgManagerServiceImpl.access$1402(this.this$0, true);
    if (this.this$0.getUnshowedUnreadCnt() > 0)
    {
      localObject1 = ((IRecentUserProxyService)GameMsgManagerServiceImpl.access$400(this.this$0).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      localObject2 = ((RecentUserProxy)localObject1).b("2747277822", 1008);
      if ((localObject2 != null) && (this.this$0.isGrayOpen())) {
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
      }
    }
    ((ITempApi)QRoute.api(ITempApi.class)).updateRecentList(GameMsgManagerServiceImpl.access$400(this.this$0));
    localObject1 = GameMsgManagerServiceImpl.access$300();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("init task ends. unreadCnt = ");
    ((StringBuilder)localObject2).append(GameMsgManagerServiceImpl.access$1200(this.this$0));
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */