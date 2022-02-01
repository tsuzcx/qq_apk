package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopSuspiciousHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class TroopNotificationFragment$13
  implements Runnable
{
  TroopNotificationFragment$13(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void run()
  {
    if (TroopNotificationFragment.f(this.this$0) == null) {
      return;
    }
    Object localObject = (IMessageFacade)TroopNotificationFragment.f(this.this$0).getRuntimeService(IMessageFacade.class, "");
    int i = 0;
    if (localObject != null) {
      this.this$0.e = ((IMessageFacade)localObject).getMsgList(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    }
    TroopSuspiciousHelper.a(this.this$0.e, TroopNotificationFragment.r(this.this$0));
    localObject = new ArrayList();
    while (i < this.this$0.e.size())
    {
      ((List)localObject).add(this.this$0.e.get(this.this$0.e.size() - i - 1));
      i += 1;
    }
    this.this$0.e = ((List)localObject);
    ThreadManager.getUIHandler().post(new TroopNotificationFragment.13.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.13
 * JD-Core Version:    0.7.0.1
 */