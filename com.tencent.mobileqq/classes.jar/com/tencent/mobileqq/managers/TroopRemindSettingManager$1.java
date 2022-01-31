package com.tencent.mobileqq.managers;

import asfd;
import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopRemindSettingData;

public class TroopRemindSettingManager$1
  implements Runnable
{
  public TroopRemindSettingManager$1(asfd paramasfd, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((TroopRemindSettingData)localaukn.a(TroopRemindSettingData.class, this.jdField_a_of_type_JavaLangString) == null)
    {
      TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
      localTroopRemindSettingData.troopUin = this.jdField_a_of_type_JavaLangString;
      localTroopRemindSettingData.isOpenState = 0;
      localaukn.b(localTroopRemindSettingData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopRemindSettingManager.1
 * JD-Core Version:    0.7.0.1
 */