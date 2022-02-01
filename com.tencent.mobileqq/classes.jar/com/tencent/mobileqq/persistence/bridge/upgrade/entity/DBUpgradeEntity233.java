package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity233
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 233;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(MayKnowRecommend.class)), TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(PushRecommend.class)), TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(MayKnowExposure.class)) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity233
 * JD-Core Version:    0.7.0.1
 */