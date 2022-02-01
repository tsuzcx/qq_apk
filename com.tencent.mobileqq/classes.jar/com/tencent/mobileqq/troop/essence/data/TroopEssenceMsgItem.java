package com.tencent.mobileqq.troop.essence.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="troopUin,msgSeq,msgRandom")
@KeepClassConstructor
public class TroopEssenceMsgItem
  extends Entity
  implements Serializable
{
  public static final int OPTYPE_ADD = 1;
  public static final int OPTYPE_BATCH_ADD = 3;
  public static final int OPTYPE_CANCEL = 2;
  public static final String TAG = "TroopEssenceMsgItem";
  public long graytipuniseq;
  public int msgRandom;
  public String msgSenderUin;
  public long msgSeq;
  @notColumn
  public int msgType;
  public long opTime;
  public int opType;
  public String opUin;
  public long troopUin;
  
  public TroopEssenceMsgItem() {}
  
  public TroopEssenceMsgItem(TroopEssenceMsgItem.TroopEssenceMsgItemKey paramTroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue paramTroopEssenceMsgItemValue)
  {
    if (paramTroopEssenceMsgItemKey != null)
    {
      this.troopUin = paramTroopEssenceMsgItemKey.jdField_a_of_type_Long;
      this.msgSeq = paramTroopEssenceMsgItemKey.jdField_b_of_type_Long;
      this.msgRandom = paramTroopEssenceMsgItemKey.jdField_a_of_type_Int;
    }
    if (paramTroopEssenceMsgItemValue != null)
    {
      this.opType = paramTroopEssenceMsgItemValue.jdField_a_of_type_Int;
      this.msgSenderUin = paramTroopEssenceMsgItemValue.jdField_a_of_type_JavaLangString;
      this.opUin = paramTroopEssenceMsgItemValue.jdField_b_of_type_JavaLangString;
      this.opTime = paramTroopEssenceMsgItemValue.jdField_a_of_type_Long;
      this.graytipuniseq = paramTroopEssenceMsgItemValue.jdField_b_of_type_Long;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopUin:");
    localStringBuilder.append(this.troopUin);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgSeq:");
    localStringBuilder.append(this.msgSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgRandom:");
    localStringBuilder.append(this.msgRandom);
    localStringBuilder.append(" ");
    localStringBuilder.append("opType:");
    localStringBuilder.append(this.opType);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgSenderUin:");
    localStringBuilder.append(this.msgSenderUin);
    localStringBuilder.append(" ");
    localStringBuilder.append("opUin:");
    localStringBuilder.append(this.opUin);
    localStringBuilder.append(" ");
    localStringBuilder.append("opTime:");
    localStringBuilder.append(this.opTime);
    localStringBuilder.append(" ");
    localStringBuilder.append("graytipuniseq:");
    localStringBuilder.append(this.graytipuniseq);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem
 * JD-Core Version:    0.7.0.1
 */