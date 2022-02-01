package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity29
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 29;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.createSQLStatement(new Ability()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity29
 * JD-Core Version:    0.7.0.1
 */