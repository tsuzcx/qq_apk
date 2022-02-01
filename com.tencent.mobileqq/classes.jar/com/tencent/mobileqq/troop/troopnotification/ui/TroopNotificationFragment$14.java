package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.mobileqq.msg.api.IMessageHandler;
import mqq.app.AppRuntime;

class TroopNotificationFragment$14
  implements Runnable
{
  TroopNotificationFragment$14(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void run()
  {
    if (TroopNotificationFragment.f(this.this$0) != null)
    {
      IMessageHandler localIMessageHandler = (IMessageHandler)TroopNotificationFragment.f(this.this$0).getRuntimeService(IMessageHandler.class, "");
      if (localIMessageHandler != null) {
        localIMessageHandler.sendGroupSystemMsgReadedReport();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.14
 * JD-Core Version:    0.7.0.1
 */