package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public final class TroopAioNotifyManager$2
  implements Runnable
{
  public TroopAioNotifyManager$2(QQAppInterface paramQQAppInterface, TroopAIONotifyItem paramTroopAIONotifyItem) {}
  
  public void run()
  {
    try
    {
      try
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        int i = localEntityManager.delete(this.jdField_a_of_type_ComTencentMobileqqDataTroopAIONotifyItem.getTableName(), "id=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopAIONotifyItem.id });
        localEntityManager.close();
        if (QLog.isColorLevel()) {
          QLog.d(".troop.notify_feeds.data", 2, "setNotifyItemReaded, id=" + this.jdField_a_of_type_ComTencentMobileqqDataTroopAIONotifyItem.id + ", ret=" + i);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.notify_feeds.data", 2, "setNotifyItemReaded, exp:" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.2
 * JD-Core Version:    0.7.0.1
 */