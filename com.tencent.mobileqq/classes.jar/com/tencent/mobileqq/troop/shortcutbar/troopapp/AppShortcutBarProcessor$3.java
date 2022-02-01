package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class AppShortcutBarProcessor$3
  extends MessageObserver
{
  AppShortcutBarProcessor$3(AppShortcutBarProcessor paramAppShortcutBarProcessor) {}
  
  public void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    TroopShortcutBarHandler localTroopShortcutBarHandler = null;
    if ((AppShortcutBarProcessor.a(this.a) == null) || (AppShortcutBarProcessor.a(this.a).a == null) || (AppShortcutBarProcessor.a(this.a).I))
    {
      break label39;
      break label39;
      break label39;
      break label39;
    }
    for (;;)
    {
      label39:
      return;
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AppShortcutBarProcessor", 2, "onGetSystemMsgFin.success");
        }
        Object localObject = AppShortcutBarProcessor.a(this.a).a.getMessageFacade().b(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
        paramList = localTroopShortcutBarHandler;
        if (localObject != null)
        {
          paramList = localTroopShortcutBarHandler;
          if (((List)localObject).size() - 1 >= 0) {
            paramList = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
          }
        }
        if ((paramList == null) || (!(paramList instanceof MessageForSystemMsg))) {
          break;
        }
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList.msg_type.get() != 2) || (paramList.msg.get() == null)) {
          break;
        }
        int i = paramList.msg.group_msg_type.get();
        if ((i != 3) && (i != 15)) {
          break;
        }
        long l = paramList.msg.group_code.get();
        if (!AppShortcutBarProcessor.a(this.a).equalsIgnoreCase("" + l)) {
          break;
        }
        paramList = ((TroopManager)AppShortcutBarProcessor.a(this.a).a.getManager(QQManagerFactory.TROOP_MANAGER)).b(AppShortcutBarProcessor.a(this.a));
        if (paramList == null) {
          break;
        }
        try
        {
          localObject = (TroopShortcutBarManager)AppShortcutBarProcessor.a(this.a).a.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
          localTroopShortcutBarHandler = (TroopShortcutBarHandler)AppShortcutBarProcessor.a(this.a).a.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
          localObject = ((TroopShortcutBarManager)localObject).a(Long.valueOf(AppShortcutBarProcessor.a(this.a)));
          if (localObject != null)
          {
            ((TroopShortcutBarInfo)localObject).c(0);
            ((TroopShortcutBarInfo)localObject).d(0);
            ((TroopShortcutBarInfo)localObject).a(0L);
            localTroopShortcutBarHandler.a(AppShortcutBarProcessor.a(this.a), (int)paramList.dwGroupClassExt, null);
            return;
          }
        }
        catch (Exception paramList)
        {
          QLog.e("AppShortcutBarProcessor", 1, paramList.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor.3
 * JD-Core Version:    0.7.0.1
 */