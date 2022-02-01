package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity307
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 307;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.dropSQLStatement(QQMiniManager.getDeskTopAppEntityClass().getSimpleName()), TableBuilder.createSQLStatement(QQMiniManager.createDeskTopAppEntity()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity307
 * JD-Core Version:    0.7.0.1
 */