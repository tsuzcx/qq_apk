package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import mqq.os.MqqHandler;

class TroopNotificationFragment$1
  implements Runnable
{
  TroopNotificationFragment$1(TroopNotificationFragment paramTroopNotificationFragment, IMessageFacade paramIMessageFacade) {}
  
  public void run()
  {
    IMessageFacade localIMessageFacade = this.a;
    if (localIMessageFacade == null) {
      return;
    }
    int i = localIMessageFacade.getUnreadMsgsNum();
    ThreadManager.getUIHandler().post(new TroopNotificationFragment.1.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.1
 * JD-Core Version:    0.7.0.1
 */