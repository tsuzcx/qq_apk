package com.tencent.mobileqq.config.operation;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="taskid,uin,uinType")
public class QQOperationVoipTipsTaskExcuteRecord
  extends Entity
{
  public int count;
  public int taskid;
  public long time;
  public int tipType;
  public String uin = "0";
  public int uinType;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord
 * JD-Core Version:    0.7.0.1
 */