package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import com.tencent.imcore.message.QQMessageFacade;
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
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class AppShortcutBarProcessor$3
  extends MessageObserver
{
  AppShortcutBarProcessor$3(AppShortcutBarProcessor paramAppShortcutBarProcessor) {}
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (AppShortcutBarProcessor.b(this.a) == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AppShortcutBarProcessor", 2, "onGetSystemMsgFin.success");
      }
      paramList = ((QQAppInterface)AppShortcutBarProcessor.b(this.a)).getMessageFacade().h(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
      if ((paramList != null) && (paramList.size() - 1 >= 0)) {
        paramList = (MessageRecord)paramList.get(paramList.size() - 1);
      } else {
        paramList = null;
      }
      if (paramList != null)
      {
        if (!(paramList instanceof MessageForSystemMsg)) {
          return;
        }
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList.msg_type.get() == 2) && (paramList.msg.get() != null))
        {
          int i = paramList.msg.group_msg_type.get();
          if ((i == 3) || (i == 15))
          {
            long l = paramList.msg.group_code.get();
            paramList = AppShortcutBarProcessor.c(this.a);
            Object localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(l);
            if (paramList.equalsIgnoreCase(((StringBuilder)localObject1).toString()))
            {
              paramList = ((TroopManager)AppShortcutBarProcessor.b(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).f(AppShortcutBarProcessor.c(this.a));
              if (paramList == null) {
                return;
              }
              try
              {
                Object localObject2 = (TroopShortcutBarManager)AppShortcutBarProcessor.b(this.a).getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
                localObject1 = (TroopShortcutBarHandler)((QQAppInterface)AppShortcutBarProcessor.b(this.a)).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
                localObject2 = ((TroopShortcutBarManager)localObject2).a(Long.valueOf(AppShortcutBarProcessor.a(this.a)));
                if (localObject2 != null)
                {
                  ((TroopShortcutBarInfo)localObject2).c(0);
                  ((TroopShortcutBarInfo)localObject2).d(0);
                  ((TroopShortcutBarInfo)localObject2).b(0L);
                  ((TroopShortcutBarHandler)localObject1).a(AppShortcutBarProcessor.a(this.a), (int)paramList.dwGroupClassExt, null);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor.3
 * JD-Core Version:    0.7.0.1
 */