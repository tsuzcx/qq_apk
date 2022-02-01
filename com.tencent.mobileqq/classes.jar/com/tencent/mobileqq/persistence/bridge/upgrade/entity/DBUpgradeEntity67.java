package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity67
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 67;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.createSQLStatement(new SearchHistory()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity67
 * JD-Core Version:    0.7.0.1
 */