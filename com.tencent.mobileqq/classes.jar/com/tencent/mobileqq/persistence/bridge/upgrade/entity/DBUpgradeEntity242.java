package com.tencent.mobileqq.persistence.bridge.upgrade.entity;

import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.persistence.TableBuilder;

public class DBUpgradeEntity242
  implements DBUpgradeEntity
{
  public int maxVersion()
  {
    return 242;
  }
  
  public String[] sqlStatement()
  {
    return new String[] { TableBuilder.createSQLStatement(new AppletsAccountInfo()), TableBuilder.createSQLStatement(new OcrRecogResult()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.upgrade.entity.DBUpgradeEntity242
 * JD-Core Version:    0.7.0.1
 */