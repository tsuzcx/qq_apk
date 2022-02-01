package com.tencent.mobileqq.troop.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.app.AppRuntime;

class TroopMemberInfoServiceImpl$1
  implements Runnable
{
  TroopMemberInfoServiceImpl$1(TroopMemberInfoServiceImpl paramTroopMemberInfoServiceImpl, TroopMemberInfo paramTroopMemberInfo, Handler paramHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.getStatus() == 1000) {
      localEntityManager.persistOrReplace(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    }
    for (;;)
    {
      localEntityManager.close();
      this.jdField_a_of_type_AndroidOsHandler.post(new TroopMemberInfoServiceImpl.1.1(this));
      return;
      localEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */