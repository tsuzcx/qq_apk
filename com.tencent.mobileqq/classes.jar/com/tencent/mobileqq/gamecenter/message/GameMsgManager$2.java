package com.tencent.mobileqq.gamecenter.message;

import android.content.SharedPreferences;
import anuz;
import apxx;
import apxy;
import atyd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import uaw;
import ugf;

public class GameMsgManager$2
  implements Runnable
{
  public GameMsgManager$2(atyd paramatyd) {}
  
  public void run()
  {
    QLog.i(atyd.e(), 1, "init task starts.");
    if (uaw.b(atyd.a(this.this$0), "2747277822"))
    {
      QLog.i(atyd.e(), 1, " qqgame public account detail not exist, try to get it.");
      ugf.a(atyd.a(this.this$0), atyd.a(this.this$0).getApplication(), "2747277822");
    }
    Object localObject1 = apxy.a();
    if (localObject1 != null)
    {
      if (atyd.a(this.this$0) == null) {
        atyd.a(this.this$0, new apxx());
      }
      atyd.a(this.this$0).a((apxx)localObject1);
      QLog.i(atyd.e(), 1, "graySwitch:" + atyd.a(this.this$0).a);
    }
    atyd.a(this.this$0);
    atyd.b(this.this$0);
    atyd.c(this.this$0);
    atyd.a(this.this$0).addObserver(atyd.a(this.this$0));
    this.this$0.a();
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = "sp_enter_pub" + atyd.a(this.this$0).getCurrentAccountUin();
    atyd.a(this.this$0, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
    atyd.a(this.this$0).getMessageFacade().addObserver(this.this$0);
    this.this$0.a = ((SharedPreferences)localObject1).getInt("sp_pubacc_msg_redpoint", 0);
    QLog.i(atyd.e(), 1, "mPubMsgRedPointSwitch:" + this.this$0.a);
    atyd.a(true);
    if (this.this$0.c() > 0)
    {
      localObject1 = atyd.a(this.this$0).getProxyManager().a();
      localObject2 = (RecentUser)((anuz)localObject1).findRecentUserByUin("2747277822", 1008);
      if ((localObject2 != null) && (this.this$0.c())) {
        ((anuz)localObject1).saveRecentUser((BaseRecentUser)localObject2);
      }
    }
    this.this$0.d();
    QLog.i(atyd.e(), 1, "init task ends. unreadCnt = " + atyd.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.2
 * JD-Core Version:    0.7.0.1
 */