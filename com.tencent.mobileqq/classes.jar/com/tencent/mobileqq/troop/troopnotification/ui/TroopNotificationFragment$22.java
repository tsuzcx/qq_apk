package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import mqq.os.MqqHandler;

class TroopNotificationFragment$22
  extends TroopMngObserver
{
  TroopNotificationFragment$22(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {
      ThreadManager.getUIHandler().post(new TroopNotificationFragment.22.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.22
 * JD-Core Version:    0.7.0.1
 */