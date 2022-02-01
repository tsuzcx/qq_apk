package com.tencent.mobileqq.troop.troopapps.api.impl;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopAppServiceImpl$2
  implements Runnable
{
  TroopAppServiceImpl$2(TroopAppServiceImpl paramTroopAppServiceImpl, EntityManager paramEntityManager, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopAIOAppInfo.class);
      localObject2 = this.this$0;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("before updateEntity(");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(")");
      TroopAppServiceImpl.access$000((TroopAppServiceImpl)localObject2, ".troop.troop_appVASH", localStringBuilder.toString(), (List)localObject1);
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TroopAIOAppInfo)((Iterator)localObject1).next();
      TroopAppServiceImpl.access$100(this.this$0, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (Entity)localObject2);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopAIOAppInfo.class);
      localObject2 = this.this$0;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("after updateEntity(");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(")");
      TroopAppServiceImpl.access$000((TroopAppServiceImpl)localObject2, ".troop.troop_appVASH", localStringBuilder.toString(), (List)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */