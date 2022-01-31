package com.tencent.mobileqq.troop.utils;

import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
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
        atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        int i = localatmp.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopAIONotifyItem.getTableName(), "id=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopAIONotifyItem.id });
        localatmp.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.2
 * JD-Core Version:    0.7.0.1
 */