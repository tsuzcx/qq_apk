package com.tencent.mobileqq.qwallet.transaction.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

final class NotifyMsgApiImpl$1
  implements Runnable
{
  public void run()
  {
    synchronized (NotifyMsgApiImpl.gDbHelperLock)
    {
      if (NotifyMsgApiImpl.gDbHelper == null) {
        NotifyMsgApiImpl.gDbHelper = new NotifyMsgDBHelper(MobileQQ.sMobileQQ);
      }
      ??? = QWalletTools.b();
      if (??? == null) {
        return;
      }
      if (NotifyMsgApiImpl.gDbHelper != null) {
        NotifyMsgApiImpl.gDbHelper.a(((BaseQQAppInterface)???).getCurrentUin(), NotifyMsgApiImpl.gList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgApi", 2, "loadFromDb completed");
      }
      Object localObject2 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      while (i < NotifyMsgApiImpl.gWaitNotifyRecords.size())
      {
        NotifyMsgRecord localNotifyMsgRecord1 = (NotifyMsgRecord)NotifyMsgApiImpl.gWaitNotifyRecords.get(i);
        if (localNotifyMsgRecord1 != null)
        {
          NotifyMsgRecord localNotifyMsgRecord2 = NotifyMsgApiImpl.getRecord(NotifyMsgApiImpl.gList, localNotifyMsgRecord1.c, localNotifyMsgRecord1.d);
          if (localNotifyMsgRecord2 != null)
          {
            ((ArrayList)localObject4).add(NotifyMsgApiImpl.onMergeMsg(localNotifyMsgRecord1, localNotifyMsgRecord2));
          }
          else
          {
            NotifyMsgApiImpl.gList.add(localNotifyMsgRecord1);
            ((ArrayList)localObject2).add(localNotifyMsgRecord1);
          }
        }
        i += 1;
      }
      NotifyMsgApiImpl.gWaitNotifyRecords.clear();
      if (((ArrayList)localObject2).size() > 0) {
        NotifyMsgApiImpl.updateOrCreateToDb((ArrayList)localObject2, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        NotifyMsgApiImpl.updateOrCreateToDb((ArrayList)localObject4, false);
      }
      NotifyMsgApiImpl.gLoadDbState = 2;
      NotifyMsgApiImpl.updateToMessageRecord(NotifyMsgApiImpl.gWaitRecords);
      localObject2 = NotifyMsgApiImpl.gWaitRecords.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (NotifyMsgApiImpl.WaitRecord)((Iterator)localObject2).next();
        if (localObject4 != null) {
          NotifyMsgApiImpl.notifyUI((NotifyMsgApiImpl.WaitRecord)localObject4);
        }
      }
      NotifyMsgApiImpl.gWaitRecords.clear();
      long l1 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getLong(((BaseQQAppInterface)???).getCurrentUin(), "qwallet_last_clear_notify_time_", 0L);
      long l2 = NetConnInfoCenter.getServerTime();
      if ((NotifyMsgApiImpl.gDbHelper != null) && ((l1 > l2) || (l2 - l1 > 172800L)))
      {
        NotifyMsgApiImpl.gDbHelper.a(2592000L, null);
        if (NotifyMsgApiImpl.gDbHelper != null) {
          NotifyMsgApiImpl.gDbHelper.a(172800L, new int[] { 2 });
        }
        ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putLong(((BaseQQAppInterface)???).getCurrentUin(), "qwallet_last_clear_notify_time_", l2);
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.1
 * JD-Core Version:    0.7.0.1
 */