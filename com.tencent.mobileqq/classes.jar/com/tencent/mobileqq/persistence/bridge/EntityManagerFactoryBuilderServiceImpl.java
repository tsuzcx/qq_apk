package com.tencent.mobileqq.persistence.bridge;

import com.tencent.mobileqq.data.IEntityManagerFactoryBuilderService;
import com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;
import com.tencent.mobileqq.persistence.Entity;

public class EntityManagerFactoryBuilderServiceImpl
  implements IEntityManagerFactoryBuilderService
{
  public Provider<Entity[]> getDBCreateTableProvider()
  {
    return new TableCreateEntityListProvider();
  }
  
  public IAfterDBUpgradeListener getDBUpGradeFinishListener()
  {
    return new AfterDBUpgradeCallback();
  }
  
  public IOnDBUpgradeListener getDBUpGradeListener()
  {
    return new DefaultOnDBUpgradeCallback();
  }
  
  public OnDBTableVerifyFailListener getDBVerifyFailHandler()
  {
    return new DBTableVerifyFailHandler();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.EntityManagerFactoryBuilderServiceImpl
 * JD-Core Version:    0.7.0.1
 */