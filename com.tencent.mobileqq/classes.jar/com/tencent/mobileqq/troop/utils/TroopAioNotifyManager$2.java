package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.data.TroopAIONotifyItem;
import com.tencent.qphone.base.util.QLog;

final class TroopAioNotifyManager$2
  implements Runnable
{
  TroopAioNotifyManager$2(QQAppInterface paramQQAppInterface, TroopAIONotifyItem paramTroopAIONotifyItem) {}
  
  public void run()
  {
    try
    {
      try
      {
        Object localObject1 = this.a.getEntityManagerFactory().createEntityManager();
        int i = ((EntityManager)localObject1).delete(this.b.getTableName(), "id=?", new String[] { this.b.id });
        ((EntityManager)localObject1).close();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setNotifyItemReaded, id=");
          ((StringBuilder)localObject1).append(this.b.id);
          ((StringBuilder)localObject1).append(", ret=");
          ((StringBuilder)localObject1).append(i);
          QLog.d(".troop.notify_feeds.data", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      finally {}
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setNotifyItemReaded, exp:");
        localStringBuilder.append(localException.toString());
        QLog.e(".troop.notify_feeds.data", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.2
 * JD-Core Version:    0.7.0.1
 */