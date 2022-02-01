package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity99
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 99;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.dropSQLStatement(DatingInfo.class.getSimpleName()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity99
 * JD-Core Version:    0.7.0.1
 */