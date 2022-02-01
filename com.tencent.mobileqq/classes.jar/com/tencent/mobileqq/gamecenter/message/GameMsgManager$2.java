package com.tencent.mobileqq.gamecenter.message;

import android.content.SharedPreferences;
import aong;
import aqoz;
import aqpa;
import autd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class GameMsgManager$2
  implements Runnable
{
  public GameMsgManager$2(autd paramautd) {}
  
  public void run()
  {
    QLog.i(autd.e(), 1, "init task starts.");
    Object localObject1 = aqpa.a();
    if (localObject1 != null)
    {
      if (autd.a(this.this$0) == null) {
        autd.a(this.this$0, new aqoz());
      }
      autd.a(this.this$0).a((aqoz)localObject1);
      QLog.i(autd.e(), 1, "graySwitch:" + autd.a(this.this$0).a);
    }
    autd.a(this.this$0);
    autd.b(this.this$0);
    autd.c(this.this$0);
    autd.a(this.this$0).addObserver(autd.a(this.this$0));
    this.this$0.a();
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = "sp_enter_pub" + autd.a(this.this$0).getCurrentAccountUin();
    autd.a(this.this$0, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
    autd.a(this.this$0).a().addObserver(this.this$0);
    autd.a(true);
    if (autd.a(this.this$0) > 0)
    {
      localObject1 = autd.a(this.this$0).a().a();
      localObject2 = (RecentUser)((aong)localObject1).findRecentUserByUin("2747277822", 1008);
      if ((localObject2 != null) && (this.this$0.c())) {
        ((aong)localObject1).saveRecentUser((BaseRecentUser)localObject2);
      }
    }
    this.this$0.c();
    QLog.i(autd.e(), 1, "init task ends. unreadCnt = " + autd.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.2
 * JD-Core Version:    0.7.0.1
 */