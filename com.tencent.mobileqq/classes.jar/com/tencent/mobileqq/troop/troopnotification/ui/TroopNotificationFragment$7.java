package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.ITroopNotificationLoadDBListener;
import mqq.os.MqqHandler;

class TroopNotificationFragment$7
  implements ITroopNotificationService.ITroopNotificationLoadDBListener
{
  TroopNotificationFragment$7(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new TroopNotificationFragment.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.7
 * JD-Core Version:    0.7.0.1
 */