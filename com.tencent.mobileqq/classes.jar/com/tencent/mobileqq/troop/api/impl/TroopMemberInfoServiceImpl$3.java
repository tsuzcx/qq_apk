package com.tencent.mobileqq.troop.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.app.AppRuntime;

class TroopMemberInfoServiceImpl$3
  implements Runnable
{
  TroopMemberInfoServiceImpl$3(TroopMemberInfoServiceImpl paramTroopMemberInfoServiceImpl, TroopMemberInfo paramTroopMemberInfo, Handler paramHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.getStatus() == 1000) {
      localEntityManager.persistOrReplace(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    } else {
      localEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    }
    localEntityManager.close();
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopMemberInfoServiceImpl.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */