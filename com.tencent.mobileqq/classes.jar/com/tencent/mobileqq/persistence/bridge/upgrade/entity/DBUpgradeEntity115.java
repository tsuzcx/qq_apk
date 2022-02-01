package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity115
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 115;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.dropSQLStatement(TroopAppInfo.class.getSimpleName()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity115
 * JD-Core Version:    0.7.0.1
 */