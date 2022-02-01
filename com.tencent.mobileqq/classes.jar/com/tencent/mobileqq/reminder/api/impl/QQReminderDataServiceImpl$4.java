package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.reminder.OnGetReminderFromDBFinishListener;
import com.tencent.mobileqq.reminder.biz.entity.ReminderEntity;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class QQReminderDataServiceImpl$4
  implements Runnable
{
  QQReminderDataServiceImpl$4(QQReminderDataServiceImpl paramQQReminderDataServiceImpl, OnGetReminderFromDBFinishListener paramOnGetReminderFromDBFinishListener) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    QQReminderDataServiceImpl.access$400(this.this$0);
    Object localObject = QQReminderDataServiceImpl.access$500(this.this$0, NetConnInfoCenter.getServerTimeMillis());
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, "async from db, msg list is null");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "async from db, msg count: ", Integer.valueOf(((List)localObject).size()) });
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((ReminderEntity)((Iterator)localObject).next()).getAcsMsg());
      }
    }
    if (!QQReminderDataServiceImpl.access$600(this.this$0).get())
    {
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AcsMsg localAcsMsg = (AcsMsg)((Iterator)localObject).next();
        QQReminderDataServiceImpl.access$700(this.this$0, localAcsMsg, 1);
      }
      QQReminderDataServiceImpl.access$600(this.this$0).set(true);
      QQReminderDataServiceImpl.access$800(this.this$0).edit().putString("sp_key_cache_list_time", QQReminderUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd")).apply();
    }
    this.a.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */