package com.tencent.mobileqq.gamecenter.message;

import android.content.SharedPreferences;
import apaw;
import areh;
import arei;
import avld;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import tug;
import tzq;

public class GameMsgManager$2
  implements Runnable
{
  public GameMsgManager$2(avld paramavld) {}
  
  public void run()
  {
    QLog.i(avld.e(), 1, "init task starts.");
    if (tug.b(avld.a(this.this$0), "2747277822"))
    {
      QLog.i(avld.e(), 1, " qqgame public account detail not exist, try to get it.");
      tzq.a(avld.a(this.this$0), avld.a(this.this$0).getApplication(), "2747277822");
    }
    Object localObject1 = arei.a();
    if (localObject1 != null)
    {
      if (avld.a(this.this$0) == null) {
        avld.a(this.this$0, new areh());
      }
      avld.a(this.this$0).a((areh)localObject1);
      QLog.i(avld.e(), 1, "graySwitch:" + avld.a(this.this$0).a);
    }
    avld.a(this.this$0);
    avld.b(this.this$0);
    avld.c(this.this$0);
    avld.a(this.this$0).addObserver(avld.a(this.this$0));
    this.this$0.a();
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = "sp_enter_pub" + avld.a(this.this$0).getCurrentAccountUin();
    avld.a(this.this$0, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
    avld.a(this.this$0).a().addObserver(this.this$0);
    avld.a(true);
    if (this.this$0.c() > 0)
    {
      localObject1 = avld.a(this.this$0).a().a();
      localObject2 = (RecentUser)((apaw)localObject1).findRecentUserByUin("2747277822", 1008);
      if ((localObject2 != null) && (this.this$0.c())) {
        ((apaw)localObject1).saveRecentUser((BaseRecentUser)localObject2);
      }
    }
    this.this$0.c();
    QLog.i(avld.e(), 1, "init task ends. unreadCnt = " + avld.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.2
 * JD-Core Version:    0.7.0.1
 */