package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.api.observer.TroopNotificationObserver;
import java.util.List;
import mqq.os.MqqHandler;

class TroopNotificationFragment$6
  extends TroopNotificationObserver
{
  TroopNotificationFragment$6(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (paramObject == null) {
        return;
      }
      ThreadManager.getUIHandler().post(new TroopNotificationFragment.6.1(this));
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof List))) {
      this.a.a((List)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.6
 * JD-Core Version:    0.7.0.1
 */