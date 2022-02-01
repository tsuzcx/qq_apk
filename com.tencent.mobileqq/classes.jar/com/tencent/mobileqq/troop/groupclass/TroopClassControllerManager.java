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
  public TroopAioClassController a;
  private long b;
  
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
      ((StringBuilder)localObject).append(this.b);
      QLog.d("TroopClassControllerMan", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong != this.b)
    {
      localObject = this.a;
      if (localObject != null) {
        ((TroopAioClassController)localObject).a(false, paramTroopChatPie, paramBoolean);
      }
    }
    this.a = a(paramTroopChatPie, paramString);
    paramString = this.a;
    if (paramString != null) {
      paramString.a(true, paramTroopChatPie, paramBoolean);
    } else if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
    }
    this.b = paramLong;
    return this.a;
  }
  
  public TroopAioClassController a(TroopChatPie paramTroopChatPie, String paramString)
  {
    TroopManager localTroopManager = (TroopManager)paramTroopChatPie.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager.aa(paramString))
    {
      if (!(this.a instanceof HomeworkTroopController)) {
        this.a = new HomeworkTroopController(paramTroopChatPie.d, paramTroopChatPie.aX(), paramTroopChatPie);
      }
      this.b = 32L;
    }
    else if (localTroopManager.ab(paramString))
    {
      this.b = 27L;
    }
    else
    {
      this.a = null;
      this.b = 0L;
      if (QLog.isColorLevel())
      {
        paramTroopChatPie = new StringBuilder();
        paramTroopChatPie.append("getControllerByTroopUin null ");
        paramTroopChatPie.append(paramString);
        QLog.d("TroopClassControllerMan", 2, paramTroopChatPie.toString());
      }
    }
    return this.a;
  }
  
  public void a()
  {
    TroopAioClassController localTroopAioClassController = this.a;
    if (localTroopAioClassController != null) {
      localTroopAioClassController.c();
    }
  }
  
  public void a(int paramInt)
  {
    TroopAioClassController localTroopAioClassController = this.a;
    if ((localTroopAioClassController instanceof HomeworkTroopController)) {
      localTroopAioClassController.a(HWTroopUtils.a(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TroopAioClassController localTroopAioClassController = this.a;
    if (localTroopAioClassController != null) {
      localTroopAioClassController.b(paramBoolean);
    }
  }
  
  public void b()
  {
    TroopAioClassController localTroopAioClassController = this.a;
    if (localTroopAioClassController != null) {
      localTroopAioClassController.b();
    }
    this.a = null;
  }
  
  public void c()
  {
    TroopAioClassController localTroopAioClassController = this.a;
    if (localTroopAioClassController != null) {
      localTroopAioClassController.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager
 * JD-Core Version:    0.7.0.1
 */