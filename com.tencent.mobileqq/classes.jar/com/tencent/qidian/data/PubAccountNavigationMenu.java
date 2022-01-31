package com.tencent.qidian.data;

import auko;
import aumc;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="puin")
public class PubAccountNavigationMenu
  extends auko
{
  @aumc
  public long puin;
  public int version;
  public String xml = "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.data.PubAccountNavigationMenu
 * JD-Core Version:    0.7.0.1
 */