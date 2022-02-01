package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;

public class DBUpgradeEntity327
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 327;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.createSQLStatement(new TroopEssenceMsgItem()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity327
 * JD-Core Version:    0.7.0.1
 */