package com.tencent.mobileqq.data;

import com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;
import com.tencent.mobileqq.persistence.Entity;

public abstract interface IEntityManagerFactoryBuilderService
{
  public abstract Provider<Entity[]> getDBCreateTableProvider();
  
  public abstract IAfterDBUpgradeListener getDBUpGradeFinishListener();
  
  public abstract IOnDBUpgradeListener getDBUpGradeListener();
  
  public abstract OnDBTableVerifyFailListener getDBVerifyFailHandler();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IEntityManagerFactoryBuilderService
 * JD-Core Version:    0.7.0.1
 */