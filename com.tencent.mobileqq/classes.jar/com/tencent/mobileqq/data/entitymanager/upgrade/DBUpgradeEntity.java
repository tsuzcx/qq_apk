package com.tencent.mobileqq.data.entitymanager.upgrade;

public abstract interface DBUpgradeEntity
{
  public abstract int maxVersion();
  
  public abstract String[] sqlStatement();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
 * JD-Core Version:    0.7.0.1
 */