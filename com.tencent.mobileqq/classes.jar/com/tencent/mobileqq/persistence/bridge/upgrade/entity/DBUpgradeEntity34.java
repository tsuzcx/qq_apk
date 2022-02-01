package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity34
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 34;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.dropSQLStatement(DiscussionInfo.class.getSimpleName()), TableBuilder.createSQLStatement(new DiscussionInfo()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity34
 * JD-Core Version:    0.7.0.1
 */