package com.tencent.mobileqq.troop.essencemsg;

import bfkz;
import bfla;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="troopUin,msgSeq,msgRandom")
public class TroopEssenceMsgItem
  extends Entity
  implements Serializable
{
  public static final int OPTYPE_ADD = 1;
  public static final int OPTYPE_CANCEL = 2;
  public static final String TAG = "TroopEssenceMsgItem";
  public long graytipuniseq;
  public int msgRandom;
  public String msgSenderUin;
  public long msgSeq;
  public long opTime;
  public int opType;
  public String opUin;
  public long troopUin;
  
  public TroopEssenceMsgItem() {}
  
  public TroopEssenceMsgItem(bfkz parambfkz, bfla parambfla)
  {
    if (parambfkz != null)
    {
      this.troopUin = parambfkz.jdField_a_of_type_Long;
      this.msgSeq = parambfkz.jdField_b_of_type_Long;
      this.msgRandom = parambfkz.jdField_a_of_type_Int;
    }
    if (parambfla != null)
    {
      this.opType = parambfla.jdField_a_of_type_Int;
      this.msgSenderUin = parambfla.jdField_a_of_type_JavaLangString;
      this.opUin = parambfla.jdField_b_of_type_JavaLangString;
      this.opTime = parambfla.jdField_a_of_type_Long;
      this.graytipuniseq = parambfla.jdField_b_of_type_Long;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopUin:").append(this.troopUin).append(" ");
    localStringBuilder.append("msgSeq:").append(this.msgSeq).append(" ");
    localStringBuilder.append("msgRandom:").append(this.msgRandom).append(" ");
    localStringBuilder.append("opType:").append(this.opType).append(" ");
    localStringBuilder.append("msgSenderUin:").append(this.msgSenderUin).append(" ");
    localStringBuilder.append("opUin:").append(this.opUin).append(" ");
    localStringBuilder.append("opTime:").append(this.opTime).append(" ");
    localStringBuilder.append("graytipuniseq:").append(this.graytipuniseq).append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem
 * JD-Core Version:    0.7.0.1
 */