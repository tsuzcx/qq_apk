package com.tencent.mobileqq.troop.essencemsg;

import bedw;
import bedx;
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
  
  public TroopEssenceMsgItem(bedw parambedw, bedx parambedx)
  {
    if (parambedw != null)
    {
      this.troopUin = parambedw.jdField_a_of_type_Long;
      this.msgSeq = parambedw.jdField_b_of_type_Long;
      this.msgRandom = parambedw.jdField_a_of_type_Int;
    }
    if (parambedx != null)
    {
      this.opType = parambedx.jdField_a_of_type_Int;
      this.msgSenderUin = parambedx.jdField_a_of_type_JavaLangString;
      this.opUin = parambedx.jdField_b_of_type_JavaLangString;
      this.opTime = parambedx.jdField_a_of_type_Long;
      this.graytipuniseq = parambedx.jdField_b_of_type_Long;
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