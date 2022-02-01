package com.tencent.mobileqq.troop.troopnotification;

import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.troop.util.TroopSystemMsgUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

class TroopNotificationRecordMessageController$3
  implements Runnable
{
  TroopNotificationRecordMessageController$3(TroopNotificationRecordMessageController paramTroopNotificationRecordMessageController) {}
  
  public void run()
  {
    IMessageFacade localIMessageFacade = (IMessageFacade)this.this$0.c.getRuntimeService(IMessageFacade.class, "");
    if (localIMessageFacade != null)
    {
      List localList = TroopNotificationRecordMessageController.a(this.this$0);
      String str = String.valueOf(this.this$0.c.getAccount());
      boolean bool;
      if ((TroopSystemMsgUtils.a((ArrayList)TroopNotificationRecordMessageController.a(this.this$0))) && (this.this$0.c.isBackgroundStop)) {
        bool = true;
      } else {
        bool = false;
      }
      localIMessageFacade.addMessage(localList, str, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationRecordMessageController.3
 * JD-Core Version:    0.7.0.1
 */