package com.tencent.mobileqq.troop.troopnotification;

import com.tencent.mobileqq.troop.api.ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener;
import java.util.Iterator;
import java.util.List;

class TroopNotificationShowNewEntryConfigController$1
  implements Runnable
{
  TroopNotificationShowNewEntryConfigController$1(TroopNotificationShowNewEntryConfigController paramTroopNotificationShowNewEntryConfigController, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = TroopNotificationShowNewEntryConfigController.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener)localIterator.next()).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationShowNewEntryConfigController.1
 * JD-Core Version:    0.7.0.1
 */