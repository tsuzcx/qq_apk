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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTroopAioClassUI troopClassType");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", currentTroopClassType");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      QLog.d("TroopClassControllerMan", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong != this.jdField_a_of_type_Long)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
      if (localObject != null) {
        ((TroopAioClassController)localObject).a(false, paramTroopChatPie, paramBoolean);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController = a(paramTroopChatPie, paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
    if (paramString != null) {
      paramString.a(true, paramTroopChatPie, paramBoolean);
    } else if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
    }
    this.jdField_a_of_type_Long = paramLong;
    return this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
  }
  
  public TroopAioClassController a(TroopChatPie paramTroopChatPie, String paramString)
  {
    TroopManager localTroopManager = (TroopManager)paramTroopChatPie.a.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager.n(paramString))
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController instanceof HomeworkTroopController)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController = new HomeworkTroopController(paramTroopChatPie.a, paramTroopChatPie.a(), paramTroopChatPie);
      }
      this.jdField_a_of_type_Long = 32L;
    }
    else if (localTroopManager.o(paramString))
    {
      this.jdField_a_of_type_Long = 27L;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController = null;
      this.jdField_a_of_type_Long = 0L;
      if (QLog.isColorLevel())
      {
        paramTroopChatPie = new StringBuilder();
        paramTroopChatPie.append("getControllerByTroopUin null ");
        paramTroopChatPie.append(paramString);
        QLog.d("TroopClassControllerMan", 2, paramTroopChatPie.toString());
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
  }
  
  public void a()
  {
    TroopAioClassController localTroopAioClassController = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
    if (localTroopAioClassController != null) {
      localTroopAioClassController.c();
    }
  }
  
  public void a(int paramInt)
  {
    TroopAioClassController localTroopAioClassController = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
    if ((localTroopAioClassController instanceof HomeworkTroopController)) {
      localTroopAioClassController.a(HWTroopUtils.a(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TroopAioClassController localTroopAioClassController = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
    if (localTroopAioClassController != null) {
      localTroopAioClassController.b(paramBoolean);
    }
  }
  
  public void b()
  {
    TroopAioClassController localTroopAioClassController = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
    if (localTroopAioClassController != null) {
      localTroopAioClassController.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController = null;
  }
  
  public void c()
  {
    TroopAioClassController localTroopAioClassController = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopAioClassController;
    if (localTroopAioClassController != null) {
      localTroopAioClassController.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager
 * JD-Core Version:    0.7.0.1
 */