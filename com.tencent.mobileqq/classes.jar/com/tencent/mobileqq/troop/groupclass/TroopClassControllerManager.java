package com.tencent.mobileqq.troop.groupclass;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class TroopClassControllerManager
  implements Manager
{
  private long a;
  public TroopAioClassController a;
  
  public TroopClassControllerManager(QQAppInterface paramQQAppInterface) {}
  
  public TroopAioClassController a(long paramLong, boolean paramBoolean, TroopChatPie paramTroopChatPie, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "updateTroopAioClassUI troopClassType" + paramLong + ", currentTroopClassType" + this.jdField_a_of_type_Long);
    }
    if ((paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController.a(false, paramTroopChatPie, paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController = a(paramTroopChatPie, paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController.a(true, paramTroopChatPie, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
      if (QLog.isColorLevel()) {
        QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
      }
    }
  }
  
  public TroopAioClassController a(TroopChatPie paramTroopChatPie, String paramString)
  {
    TroopManager localTroopManager = (TroopManager)paramTroopChatPie.a.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager.o(paramString))
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController instanceof HomeworkTroopController)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController = new HomeworkTroopController(paramTroopChatPie.a, paramTroopChatPie.a(), paramTroopChatPie);
      }
      this.jdField_a_of_type_Long = 32L;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
      if (localTroopManager.p(paramString))
      {
        this.jdField_a_of_type_Long = 27L;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController = null;
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("TroopClassControllerMan", 2, "getControllerByTroopUin null " + paramString);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController instanceof HomeworkTroopController)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController.a(HWTroopUtils.b(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController.b(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager
 * JD-Core Version:    0.7.0.1
 */