package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="fromTinyId,toTinyId")
public class UinToTinyId
  extends Entity
{
  private static final String TABLE_NAME = "friendUin_tinyId";
  public String extString;
  public String friendUin;
  public String fromTinyId;
  public String tinyId;
  public String toTinyId;
  
  public static String getTinyTableName()
  {
    return "friendUin_tinyId";
  }
  
  public String getTableName()
  {
    return "friendUin_tinyId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.UinToTinyId
 * JD-Core Version:    0.7.0.1
 */