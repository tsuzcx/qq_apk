package com.tencent.mobileqq.troop.utils;

import bgig;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAppMgr$2
  implements Runnable
{
  public TroopAppMgr$2(bgig parambgig, EntityManager paramEntityManager, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopAIOAppInfo.class);
      this.this$0.a(".troop.troop_appVASH", "before updateEntity(" + this.jdField_a_of_type_Int + ")", (List)localObject);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, localTroopAIOAppInfo);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopAIOAppInfo.class);
      this.this$0.a(".troop.troop_appVASH", "after updateEntity(" + this.jdField_a_of_type_Int + ")", (List)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.2
 * JD-Core Version:    0.7.0.1
 */