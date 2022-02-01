package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="grpID,mId")
public class GrpMemberInfo
  extends Entity
{
  public String grpID;
  public String mId;
  public String name;
  public byte nature;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.GrpMemberInfo
 * JD-Core Version:    0.7.0.1
 */