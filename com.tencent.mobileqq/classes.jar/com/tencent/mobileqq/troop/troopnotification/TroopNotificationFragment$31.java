package com.tencent.mobileqq.troop.troopnotification;

import com.tencent.mobileqq.msg.api.IMessageHandler;
import mqq.app.AppRuntime;

class TroopNotificationFragment$31
  implements Runnable
{
  TroopNotificationFragment$31(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void run()
  {
    IMessageHandler localIMessageHandler = (IMessageHandler)TroopNotificationFragment.a(this.this$0).getRuntimeService(IMessageHandler.class, "");
    if (localIMessageHandler != null) {
      localIMessageHandler.sendGroupSystemMsgReadedReportInner(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.31
 * JD-Core Version:    0.7.0.1
 */