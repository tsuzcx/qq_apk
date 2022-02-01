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
    do
    {
      Object localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ReminderDataManagerNew", 2, "getReminderListByday onProcessReminderList isSucc : " + paramBoolean);
        }
        if (!paramBoolean) {
          continue;
        }
        QQReminderDataServiceImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqReminderApiImplQQReminderDataServiceImpl).edit().putString("sp_key_new_fetch_reminder_list_time", this.jdField_a_of_type_JavaLangString).apply();
        paramBundle = (AcsPullMsgRsp)paramBundle.getSerializable("rsp");
        if (paramBundle == null) {
          continue;
        }
        localObject = paramBundle.msgs;
        QQReminderDataServiceImpl.access$1200(this.jdField_a_of_type_ComTencentMobileqqReminderApiImplQQReminderDataServiceImpl, (List)localObject);
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqReminderApiImplQQReminderDataServiceImpl.saveReminderMsgList((List)localObject);
        paramBundle = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramBundle.add(((AcsMsg)((Iterator)localObject).next()).msg_id);
        }
        localObject = (IQQReminderService)QQReminderDataServiceImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqReminderApiImplQQReminderDataServiceImpl).getRuntimeService(IQQReminderService.class, "");
      }
      catch (Throwable paramBundle)
      {
        QLog.e("ReminderDataManagerNew", 1, "checkTodayReminder throw an exception: " + paramBundle);
        return;
      }
      if (localObject != null) {
        ((IQQReminderService)localObject).sendAckMsgs(paramBundle, new QQReminderDataServiceImpl.10.1(this));
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqReminderApiImplQQReminderDataServiceImpl$AfterPull == null);
    this.jdField_a_of_type_ComTencentMobileqqReminderApiImplQQReminderDataServiceImpl$AfterPull.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.10
 * JD-Core Version:    0.7.0.1
 */