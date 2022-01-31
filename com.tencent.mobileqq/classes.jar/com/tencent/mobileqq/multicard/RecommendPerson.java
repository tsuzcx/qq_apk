package com.tencent.mobileqq.multicard;

import awge;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="troopUin,cardTypeID,uin")
public class RecommendPerson
  extends awge
  implements Serializable
{
  public int addedIndex;
  public String cardMainTitle;
  public int cardMaxDisplayPersonNum;
  public String cardSubTitle;
  public int cardTypeID;
  public String recommendALghrithm;
  public String recommendKeyword;
  public String recommendReason;
  public String recommendRecall;
  public String troopUin;
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.RecommendPerson
 * JD-Core Version:    0.7.0.1
 */