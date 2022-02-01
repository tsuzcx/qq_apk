package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import Wallet.AcsPullMsgRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.reminder.OnGetReminderListByDayListener;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class QQReminderDataServiceImpl$10
  implements OnGetReminderListByDayListener
{
  QQReminderDataServiceImpl$10(QQReminderDataServiceImpl paramQQReminderDataServiceImpl, String paramString, QQReminderDataServiceImpl.AfterPull paramAfterPull) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getReminderListByday onProcessReminderList isSucc : ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("ReminderDataManagerNew", 2, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean)
      {
        QQReminderDataServiceImpl.access$800(this.c).edit().putString("sp_key_new_fetch_reminder_list_time", this.a).apply();
        paramBundle = (AcsPullMsgRsp)paramBundle.getSerializable("rsp");
        if (paramBundle != null)
        {
          localObject = paramBundle.msgs;
          QQReminderDataServiceImpl.access$1200(this.c, (List)localObject);
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            this.c.saveReminderMsgList((List)localObject);
            paramBundle = new ArrayList();
            localObject = ((ArrayList)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              paramBundle.add(((AcsMsg)((Iterator)localObject).next()).msg_id);
            }
            localObject = (IQQReminderService)QQReminderDataServiceImpl.access$200(this.c).getRuntimeService(IQQReminderService.class, "");
            if (localObject != null) {
              ((IQQReminderService)localObject).sendAckMsgs(paramBundle, new QQReminderDataServiceImpl.10.1(this));
            }
          }
        }
      }
      if (this.b != null)
      {
        this.b.a();
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkTodayReminder throw an exception: ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.e("ReminderDataManagerNew", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.10
 * JD-Core Version:    0.7.0.1
 */