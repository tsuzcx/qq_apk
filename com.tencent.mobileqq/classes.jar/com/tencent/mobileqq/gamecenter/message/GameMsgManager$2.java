package com.tencent.mobileqq.gamecenter.message;

import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.business.GameCenterMsgBean;
import com.tencent.mobileqq.config.business.GameCenterMsgConfigProcessor;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class GameMsgManager$2
  implements Runnable
{
  GameMsgManager$2(GameMsgManager paramGameMsgManager) {}
  
  public void run()
  {
    QLog.i(GameMsgManager.g(), 1, "init task starts.");
    if (ServiceAccountFolderManager.b(GameMsgManager.a(this.this$0), "2747277822"))
    {
      QLog.i(GameMsgManager.g(), 1, " qqgame public account detail not exist, try to get it.");
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(GameMsgManager.a(this.this$0), GameMsgManager.a(this.this$0).getApplication(), "2747277822");
    }
    Object localObject1 = GameCenterMsgConfigProcessor.a();
    if (localObject1 != null)
    {
      if (GameMsgManager.a(this.this$0) == null) {
        GameMsgManager.a(this.this$0, new GameCenterMsgBean());
      }
      GameMsgManager.a(this.this$0).a((GameCenterMsgBean)localObject1);
      QLog.i(GameMsgManager.g(), 1, "graySwitch:" + GameMsgManager.a(this.this$0).a);
    }
    GameMsgManager.a(this.this$0);
    GameMsgManager.b(this.this$0);
    GameMsgManager.c(this.this$0);
    GameMsgManager.a(this.this$0).addObserver(GameMsgManager.a(this.this$0));
    this.this$0.a();
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = "sp_enter_pub" + GameMsgManager.a(this.this$0).getCurrentAccountUin();
    GameMsgManager.a(this.this$0, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
    GameMsgManager.a(this.this$0).getMessageFacade().addObserver(this.this$0);
    this.this$0.a = ((SharedPreferences)localObject1).getInt("sp_pubacc_msg_redpoint", 0);
    QLog.i(GameMsgManager.g(), 1, "mPubMsgRedPointSwitch:" + this.this$0.a);
    GameMsgManager.a(true);
    if (this.this$0.c() > 0)
    {
      localObject1 = GameMsgManager.a(this.this$0).getProxyManager().a();
      localObject2 = ((RecentUserProxy)localObject1).a("2747277822", 1008);
      if ((localObject2 != null) && (this.this$0.d())) {
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
      }
    }
    this.this$0.d();
    QLog.i(GameMsgManager.g(), 1, "init task ends. unreadCnt = " + GameMsgManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.2
 * JD-Core Version:    0.7.0.1
 */