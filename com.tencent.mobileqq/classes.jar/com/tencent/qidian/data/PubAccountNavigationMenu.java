package com.tencent.qidian.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="puin")
public class PubAccountNavigationMenu
  extends Entity
{
  @unique
  public long puin = 0L;
  public int version = 0;
  public String xml = "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.data.PubAccountNavigationMenu
 * JD-Core Version:    0.7.0.1
 */