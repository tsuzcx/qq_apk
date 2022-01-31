package com.tencent.mobileqq.managers;

import atwf;
import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopRemindSettingData;

public class TroopRemindSettingManager$1
  implements Runnable
{
  public TroopRemindSettingManager$1(atwf paramatwf, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((TroopRemindSettingData)localawbw.a(TroopRemindSettingData.class, this.jdField_a_of_type_JavaLangString) == null)
    {
      TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
      localTroopRemindSettingData.troopUin = this.jdField_a_of_type_JavaLangString;
      localTroopRemindSettingData.isOpenState = 0;
      localawbw.b(localTroopRemindSettingData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopRemindSettingManager.1
 * JD-Core Version:    0.7.0.1
 */