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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class QQReminderDataServiceImpl$5
  implements Runnable
{
  QQReminderDataServiceImpl$5(QQReminderDataServiceImpl paramQQReminderDataServiceImpl, boolean paramBoolean, List paramList, OnGetReminderFromDBFinishListener paramOnGetReminderFromDBFinishListener) {}
  
  public void run()
  {
    QQReminderDataServiceImpl.access$400(this.this$0);
    Object localObject1;
    if ((QQReminderDataServiceImpl.access$900(this.this$0) != null) && (QQReminderDataServiceImpl.access$600(this.this$0).get()) && (!this.a))
    {
      localObject1 = new ArrayList(QQReminderDataServiceImpl.access$900(this.this$0).values());
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "async from cache, msg count: ", Integer.valueOf(((List)localObject1).size()) });
      }
      localObject1 = ((List)localObject1).iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ReminderEntity)((Iterator)localObject1).next();
      this.b.add(((ReminderEntity)localObject2).getAcsMsg());
      continue;
      localObject1 = QQReminderDataServiceImpl.access$500(this.this$0, NetConnInfoCenter.getServerTimeMillis());
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 1, "async from db, msg list is null");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 1, new Object[] { "async from db, msg count: ", Integer.valueOf(((List)localObject1).size()) });
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ReminderEntity)((Iterator)localObject1).next();
          this.b.add(((ReminderEntity)localObject2).getAcsMsg());
        }
      }
      if ((!QQReminderDataServiceImpl.access$600(this.this$0).get()) || (this.a))
      {
        localObject1 = this.b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AcsMsg)((Iterator)localObject1).next();
          QQReminderDataServiceImpl.access$700(this.this$0, (AcsMsg)localObject2, 1);
        }
        QQReminderDataServiceImpl.access$600(this.this$0).set(true);
        QQReminderDataServiceImpl.access$800(this.this$0).edit().putString("sp_key_cache_list_time", QQReminderUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd")).apply();
      }
    }
    this.c.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */