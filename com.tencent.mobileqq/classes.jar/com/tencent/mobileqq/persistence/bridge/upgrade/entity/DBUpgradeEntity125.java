package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloPandora;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity125
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 125;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.createSQLStatement(new ApolloBaseInfo()), TableBuilder.createSQLStatement(new ApolloPandora()), TableBuilder.dropSQLStatement("t_qqcard_item") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity125
 * JD-Core Version:    0.7.0.1
 */