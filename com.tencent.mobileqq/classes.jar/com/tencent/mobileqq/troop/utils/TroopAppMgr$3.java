package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopAppMgr$3
  implements Runnable
{
  TroopAppMgr$3(TroopAppMgr paramTroopAppMgr, ArrayList paramArrayList, EntityManager paramEntityManager, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Object localObject1 = TableBuilder.getTableNameSafe(TroopAIOAppInfo.class);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopAIOAppInfo.class);
        this.this$0.a(".troop.troop_appVASH", "before delete type:" + this.jdField_a_of_type_Int, (List)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete((String)localObject1, "groupType=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopAIOAppInfo.class);
        this.this$0.a(".troop.troop_appVASH", "before update after delete type:" + this.jdField_a_of_type_Int, (List)localObject1);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopAIOAppInfo)((Iterator)localObject1).next();
        ((TroopAIOAppInfo)localObject2).setStatus(1000);
        this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (Entity)localObject2);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopAIOAppInfo.class);
        this.this$0.a(".troop.troop_appVASH", "after update type:" + this.jdField_a_of_type_Int, (List)localObject1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.3
 * JD-Core Version:    0.7.0.1
 */