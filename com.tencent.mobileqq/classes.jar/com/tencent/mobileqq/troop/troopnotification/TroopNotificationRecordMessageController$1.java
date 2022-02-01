package com.tencent.mobileqq.troop.troopnotification;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import java.util.List;
import mqq.app.AppRuntime;

class TroopNotificationRecordMessageController$1
  implements Runnable
{
  TroopNotificationRecordMessageController$1(TroopNotificationRecordMessageController paramTroopNotificationRecordMessageController) {}
  
  public void run()
  {
    Object localObject = (IMessageFacade)this.this$0.a.getRuntimeService(IMessageFacade.class, "");
    if (localObject != null)
    {
      localObject = ((IMessageFacade)localObject).getAllMessages(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null);
      TroopNotificationRecordMessageController.a(this.this$0, (List)localObject, GroupSystemMsgController.a().a(this.this$0.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationRecordMessageController.1
 * JD-Core Version:    0.7.0.1
 */