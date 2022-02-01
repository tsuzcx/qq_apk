package com.tencent.mobileqq.gamecenter.message;

import android.content.SharedPreferences;
import aoxz;
import arba;
import arbb;
import avds;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import uot;
import uuc;

public class GameMsgManager$2
  implements Runnable
{
  public GameMsgManager$2(avds paramavds) {}
  
  public void run()
  {
    QLog.i(avds.e(), 1, "init task starts.");
    if (uot.b(avds.a(this.this$0), "2747277822"))
    {
      QLog.i(avds.e(), 1, " qqgame public account detail not exist, try to get it.");
      uuc.a(avds.a(this.this$0), avds.a(this.this$0).getApplication(), "2747277822");
    }
    Object localObject1 = arbb.a();
    if (localObject1 != null)
    {
      if (avds.a(this.this$0) == null) {
        avds.a(this.this$0, new arba());
      }
      avds.a(this.this$0).a((arba)localObject1);
      QLog.i(avds.e(), 1, "graySwitch:" + avds.a(this.this$0).a);
    }
    avds.a(this.this$0);
    avds.b(this.this$0);
    avds.c(this.this$0);
    avds.a(this.this$0).addObserver(avds.a(this.this$0));
    this.this$0.a();
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = "sp_enter_pub" + avds.a(this.this$0).getCurrentAccountUin();
    avds.a(this.this$0, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
    avds.a(this.this$0).getMessageFacade().addObserver(this.this$0);
    this.this$0.a = ((SharedPreferences)localObject1).getInt("sp_pubacc_msg_redpoint", 0);
    QLog.i(avds.e(), 1, "mPubMsgRedPointSwitch:" + this.this$0.a);
    avds.a(true);
    if (this.this$0.c() > 0)
    {
      localObject1 = avds.a(this.this$0).getProxyManager().a();
      localObject2 = (RecentUser)((aoxz)localObject1).findRecentUserByUin("2747277822", 1008);
      if ((localObject2 != null) && (this.this$0.c())) {
        ((aoxz)localObject1).saveRecentUser((BaseRecentUser)localObject2);
      }
    }
    this.this$0.d();
    QLog.i(avds.e(), 1, "init task ends. unreadCnt = " + avds.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.2
 * JD-Core Version:    0.7.0.1
 */