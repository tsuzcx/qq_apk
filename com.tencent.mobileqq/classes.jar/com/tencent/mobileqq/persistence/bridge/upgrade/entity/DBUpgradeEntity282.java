package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity282
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 282;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.createSQLStatement(new ColorNote()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity282
 * JD-Core Version:    0.7.0.1
 */