package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.tofumsg.TofuItem;

public class DBUpgradeEntity309
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 309;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.createSQLStatement(new TofuItem()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity309
 * JD-Core Version:    0.7.0.1
 */