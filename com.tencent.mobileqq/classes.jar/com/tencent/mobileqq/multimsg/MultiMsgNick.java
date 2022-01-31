package com.tencent.mobileqq.multimsg;

import aukm;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uin,uniseq")
public class MultiMsgNick
  extends aukm
{
  public String nick;
  public String uin;
  public long uniseq;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgNick
 * JD-Core Version:    0.7.0.1
 */