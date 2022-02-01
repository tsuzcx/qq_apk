package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity41
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 41;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.dropSQLStatement(Card.class.getSimpleName()), TableBuilder.createSQLStatement(new Card()), TableBuilder.dropSQLStatement(ResourcePluginInfo.class.getSimpleName()), TableBuilder.createSQLStatement(new ResourcePluginInfo()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity41
 * JD-Core Version:    0.7.0.1
 */