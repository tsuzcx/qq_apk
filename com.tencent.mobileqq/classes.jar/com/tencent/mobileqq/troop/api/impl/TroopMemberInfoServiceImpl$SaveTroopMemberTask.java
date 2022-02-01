package com.tencent.mobileqq.troop.api.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class TroopMemberInfoServiceImpl$SaveTroopMemberTask
  implements Runnable
{
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  boolean jdField_a_of_type_Boolean;
  volatile boolean b = false;
  
  TroopMemberInfoServiceImpl$SaveTroopMemberTask(TroopMemberInfoServiceImpl paramTroopMemberInfoServiceImpl, TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = paramTroopMemberInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    this.b = true;
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.getStatus() == 1000) {
      localEntityManager.persistOrReplace(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    } else {
      localEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    }
    localEntityManager.close();
    new Handler(Looper.getMainLooper()).post(new TroopMemberInfoServiceImpl.SaveTroopMemberTask.1(this));
    if (this.jdField_a_of_type_Boolean) {
      ((ITroopNameHelperService)this.this$0.app.getRuntimeService(ITroopNameHelperService.class, "")).updateTroopName(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin);
    }
    this.b = false;
    TroopMemberInfoServiceImpl.access$200(this.this$0).remove(this);
    this.this$0.runNextSaveTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.SaveTroopMemberTask
 * JD-Core Version:    0.7.0.1
 */